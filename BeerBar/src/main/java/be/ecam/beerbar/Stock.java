package be.ecam.beerbar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class handle a virtual stock of beers.
 */
public class Stock {
    
    private final LinkedList<Pair<Bottle,Integer>> beerList;
    
    public Stock() {
        this.beerList = new LinkedList();
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
    
    /*
     * Management interface of the beer stock
     */
    public static void manage(Stock stock, Scanner sc) {
        int select = Integer.parseInt(sc.nextLine());
        if (select < 0 || select > 3) return;

        switch (select) {
            case 1: // add beer
                addBottle(stock, sc);
                break;
            case 2: // remove beer
                delBottle(stock, sc);
                break;
            case 3: // list critics
                listCritics(stock, sc);
        }
        
    }
    
    public static void addBottle(Stock stock, Scanner sc) {
        String notice = "\n"
            + "Type the following bottle informations, please:"
            + "\n\t Beer name: ";
        System.out.print(notice);
        String inName = sc.nextLine();
        if (inName.length() < 3 || inName.length() > 80) {
            System.err.println("Invalid input");
            return;
        }
        
        notice = "\t Beer volume: ";
        System.out.print(notice);
        int inVolume = Integer.parseInt(sc.nextLine());
        if (inVolume < 1 || inVolume > 200) {
            System.err.println("Invalid input");
            return;
        }
        
        notice = "\t Beer alcool rate: ";
        System.out.print(notice);
        int inAlcRate = Integer.parseInt(sc.nextLine());
        if (inAlcRate < 0 || inAlcRate > 99) {
            System.err.println("Invalid input");
            return;
        }
        
        notice = "\t Select the beer color\n";
        System.out.print(notice);
        BeerColor choiceBC[] = BeerColor.values();
        for (int i = 0; i < choiceBC.length; i++)
            System.out.println(String.format("%d) %s", i+1, choiceBC[i]));
        
        int inChoiceBC = Integer.parseInt(sc.nextLine());
        if (inChoiceBC < 0 || inChoiceBC > choiceBC.length) {
            System.err.println("Invalid input");
            return;
        }
        
        notice = "\t Select the brewery\n";
        System.out.print(notice);
        Brewery choiceBR[] = Brewery.values();
        for (int i = 0; i < choiceBR.length; i++)
            System.out.println(String.format("%d) %s", i+1, choiceBR[i]));
        
        int inChoiceBR = Integer.parseInt(sc.nextLine());
        if (inChoiceBR < 0 || inChoiceBR > choiceBR.length) {
            System.err.println("Invalid input");
            return;
        }
        
        notice = "\t Type the quantity: ";
        System.out.print(notice);
        int inQte = Integer.parseInt(sc.nextLine());
        if (inQte < 1 || inQte > 100) {
            System.err.println("Invalid input");
            return;
        }
        
        stock.beerList.add(
            new Pair(
                new Bottle(inName, inVolume, inAlcRate,
                    choiceBC[inChoiceBC-1], choiceBR[inChoiceBR-1]),
                inQte)
        );
        
        
    }
    
    public static void delBottle(Stock stock, Scanner sc) {
        //TODO
    }
    
    public static void listCritics(Stock stock, Scanner sc) {
        //TODO
    }
}
