package be.ecam.beerbar;

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
        populateList();
    }
    
    private void populateList() {
        beerList.add(new Pair(
                new Bottle("West Vleteren", 33, 8, BeerColor.BRUNE, Brewery.SAINT_SIXTE), 0));
        beerList.add(new Pair(
                new Bottle("Jupiler", 33, 5, BeerColor.BLONDE, Brewery.JUPILER), 0));
        beerList.add(new Pair(
                new Bottle("Jupiler Blue", 25, 3, BeerColor.BLONDE, Brewery.JUPILER), 0));
    }

    public void printList() {
        Iterator<Pair<Bottle,Integer>> iterBeerList = beerList.iterator();
        while (iterBeerList.hasNext()) {
            System.out.println(iterBeerList.next().getKey());
        }
    }
    
    private LinkedList<Bottle> findBeerByName(String query) {
        //TODO
        return null;
    }
    
    private LinkedList<Bottle> findBeerByColor(BeerColor query) {
        //TODO
        return null;
    }
    
    private LinkedList<Bottle> findBeerByVolume(int query) {
        //TODO
        return null;
    }
    
    /**
     * Management interface of the beer stock.
     */
    public void manage() {
        int select = Integer.parseInt(sc.nextLine());
        if (select < 0 || select > 3) return;

        switch (select) {
            case 1: // add beer
                this.addBottle();
                break;
            case 2: // remove beer
                this.editBottle();
                break;
            case 3: // list critics
                this.listCritics();
        }
    }
    
    /**
     * Add a bottle to the list of beer.
     * The function takes no arguments because it reads every field from stdin.
     */
    public void addBottle() {
        String notice = "Type the following bottle informations."
            + "\n\t Beer name: ";
        System.out.print(notice);
        String inName = sc.nextLine();
        if (inName.length() < 3 || inName.length() > 80) {
            System.err.println("Invalid input");
            return;
        }
        
        System.out.print("\t Beer volume: ");
        int inVolume = Integer.parseInt(sc.nextLine());
        if (inVolume < 1 || inVolume > 200) {
            System.err.println("Invalid input");
            return;
        }
        
        System.out.print("\t Beer alcool rate: ");
        int inAlcRate = Integer.parseInt(sc.nextLine());
        if (inAlcRate < 0 || inAlcRate > 99) {
            System.err.println("Invalid input");
            return;
        }
        
        System.out.print("\t Select the beer color\n");
        BeerColor choiceBC[] = BeerColor.values();
        for (int i = 0; i < choiceBC.length; i++)
            System.out.println(String.format("%d) %s", i+1, choiceBC[i]));
        
        int inChoiceBC = Integer.parseInt(sc.nextLine());
        if (inChoiceBC < 0 || inChoiceBC > choiceBC.length) {
            System.err.println("Invalid input");
            return;
        }
        
        System.out.print("\t Select the brewery\n");
        Brewery choiceBR[] = Brewery.values();
        for (int i = 0; i < choiceBR.length; i++)
            System.out.println(String.format("%d) %s", i+1, choiceBR[i]));
        
        int inChoiceBR = Integer.parseInt(sc.nextLine());
        if (inChoiceBR < 0 || inChoiceBR > choiceBR.length) {
            System.err.println("Invalid input");
            return;
        }
        
        System.out.print("\t Type the quantity: ");
        int inQte = Integer.parseInt(sc.nextLine());
        if (inQte < 1 || inQte > 100) {
            System.err.println("Invalid input");
            return;
        }
        
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
        int inID = Integer.parseInt(sc.nextLine());
        if (inID < 1 || inID > counter-1) {
            System.err.println("Invalid input");
            return;
        }
        
        System.out.print("Type the new quantity of the beer (0 to remove): ");
        int inQte = Integer.parseInt(sc.nextLine());
        if (inQte < 0 || inQte > 100) {
            System.err.println("Invalid input");
            return;
        }
        
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
    public void listCritics() {
        Iterator<Pair<Bottle, Integer>> iterList = this.beerList.iterator();
        while (iterList.hasNext()) {
            Pair<Bottle, Integer> pair = iterList.next();
            Bottle  bottle   = pair.getKey();
            Integer quantity = pair.getValue();
            
            if (quantity <= 10) {
                System.out.println(String.format("qte: %d, %s", quantity, bottle));
            }
        }
    }
}
