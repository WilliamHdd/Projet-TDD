package be.ecam.beerbar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class handle a virtual stock of beers.
 */
public class Stock {
    
    private final LinkedList<Pair<Bottle,Integer>> beerList;
    private final Scanner sc;
    
    public Stock() {
        this.beerList = new LinkedList();
        this.sc = new Scanner(System.in);
        readCSV("BeerList.csv");
    }

    private void readCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] elem = line.split(",");
                int vol = 0, alc = 0;
                try {
                    vol = Integer.parseInt(elem[1]);
                    alc = Integer.parseInt(elem[2]);
                } catch (NumberFormatException nfe) {
                    System.err.println(nfe);
                }
                this.beerList.add(
                    new Pair(
                        new Bottle(elem[0], vol, alc,
                                BeerColor.valueOf(elem[3]), Brewery.valueOf(elem[4])), 1)
                );
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public void select() {
        int selection = Run.inputCheck(sc, 1, 3, null);
        if (selection == -1) return;
        
        switch (selection) {
            case 1: // find by name
                String foo = sc.nextLine();
                System.out.println(findBeerByName(foo));
                break;
            case 2: // find by color
                BeerColor choiceBC[] = BeerColor.values();
                for (int i = 0; i < choiceBC.length; i++)
                    System.out.println(String.format("%d) %s", i+1, choiceBC[i]));

                int inChoiceBC = Run.inputCheck(sc, 0, choiceBC.length, null);
                if (inChoiceBC == -1) return;
                System.out.println(findBeerByColor(choiceBC[inChoiceBC-1]));
                break;
            case 3: // find by volume
                int bar = Run.inputCheck(sc, 1, 100, null);
                if (bar == -1) return;
                System.out.println(findBeerByVolume(bar));
                break;
        }   
    }
    
    private Bottle findBeerByName(String query) {
        Iterator<Pair<Bottle,Integer>> iterBeerList = beerList.iterator();
        while (iterBeerList.hasNext()) {
            Bottle bottle = iterBeerList.next().getKey();
            if (bottle.getName().equals(query)){
                return bottle;
            }
        }
        return null;
    }
    
    private LinkedList<Bottle> findBeerByColor(BeerColor query) {
        Iterator<Pair<Bottle,Integer>> iterBeerList = beerList.iterator();
        LinkedList<Bottle> answer = new LinkedList();
        while (iterBeerList.hasNext()) {
            Bottle bottle = iterBeerList.next().getKey();
            if (bottle.getColor().equals(query)){
                answer.add(bottle);
            }
        }
        return answer;
    }
    
    private LinkedList<Bottle> findBeerByVolume(int query) {
        Iterator<Pair<Bottle,Integer>> iterBeerList = beerList.iterator();
        LinkedList<Bottle> answer = new LinkedList();
        while (iterBeerList.hasNext()) {
            Bottle bottle = iterBeerList.next().getKey();
            if (bottle.getVolume() == (query)){
                answer.add(bottle);
            }
        }
        return answer;
    }
    
    /**
     * Management interface of the beer stock.
     */
    public void manage() {
        int select = Run.inputCheck(sc, 0, 3, null);

        switch (select) {
            case 1: // add beer
                this.addBottle();
                break;
            case 2: // remove beer
                this.editBottle();
                break;
            case 3: // list critics quantities
                this.listCriticQuantities();
        }
    }
    
    /**
     * Add a bottle to the list of beer.
     * The function takes no arguments because it reads every field from stdin.
     */
    public void addBottle() {
        System.out.print("Type the following bottle informations.\nBeer name: ");
        String inName = sc.nextLine();
        if (inName.length() < 3 || inName.length() > 80) {
            System.err.println("Invalid input");
            return;
        }
        
        System.out.print("Beer volume: ");
        int inVolume = Run.inputCheck(sc, 1, 200, null);
        if (inVolume == -1) return;
        
        System.out.print("Beer alcool rate: ");
        int inAlcRate = Run.inputCheck(sc, 0, 99, null);
        if (inAlcRate == -1) return;
        
        // list the beer colors
        System.out.print("Select the beer color\n");
        BeerColor choiceBC[] = BeerColor.values();
        for (int i = 0; i < choiceBC.length; i++)
            System.out.println(String.format("%d) %s", i+1, choiceBC[i]));
        
        int inChoiceBC = Run.inputCheck(sc, 0, choiceBC.length, null);
        if (inChoiceBC == -1) return;
        
        
        // list the breweries
        System.out.print("Select the brewery\n");
        Brewery choiceBR[] = Brewery.values();
        for (int i = 0; i < choiceBR.length; i++)
            System.out.println(String.format("%d) %s", i+1, choiceBR[i]));
        
        int inChoiceBR = Run.inputCheck(sc, 0, choiceBR.length, null);
        if (inChoiceBR == -1) return;
        
        System.out.print("Type the quantity: ");
        int inQte = Run.inputCheck(sc, 1, 100, null);
        if (inQte == -1) return;
        
        this.beerList.add(
            new Pair(
                new Bottle(inName, inVolume, inAlcRate,
                    choiceBC[inChoiceBC-1], choiceBR[inChoiceBR-1]),
                inQte)
        );
    }
    
    /**
     * Edit the quantity or remove a bottle from the beer list.
     * The function takes no arguments because it reads every field from stdin.
     */
    public void editBottle() {
        Iterator<Pair<Bottle, Integer>> iterList = this.beerList.iterator();
        int counter = 1;
        while (iterList.hasNext()) {
            Pair<Bottle, Integer> pair = iterList.next();
            Bottle  bottle   = pair.getKey();
            Integer quantity = pair.getValue();
            System.out.println(String.format("%d) qte: %d, %s", counter, quantity, bottle));
            counter++;
        }
        System.out.print("Type the id of the beer to edit: ");
        int inID = Run.inputCheck(sc, 0, counter-1, null);
        if (inID == 0) return;
        
        System.out.print("Type the new quantity of the beer (0 to remove): ");
        int inQte = Run.inputCheck(sc, 0, 100, null);
        
        // delete a bottle
        if (inQte == 0) {
            this.beerList.remove(inID-1);
            return;
        }
        
        // add the quantity
        this.beerList.get(inID-1).setValue(inQte);
    }
    
    /**
     * Print a list of beer with 10 bottles or less in the stock.
     */
    public void listCriticQuantities() {
        Iterator<Pair<Bottle, Integer>> iterList = this.beerList.iterator();
        while (iterList.hasNext()) {
            Pair<Bottle, Integer> pair = iterList.next();
            Bottle  bottle   = pair.getKey();
            Integer quantity = pair.getValue();
            
            if (quantity <= 10) {
                System.out.println(String.format("qte:%d, %s", quantity, bottle));
            }
        }
    }
}
