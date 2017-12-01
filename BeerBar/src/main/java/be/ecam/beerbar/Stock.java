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
    public static void manage(Scanner sc) {
        int select = Integer.parseInt(sc.nextLine());
        if (select < 0 || select > 3) return;

        switch (select) {
            case 1: // add beer
                break;
            case 2: // remove beer
                break;
            case 3: // list critics
                break;
        }
        
    }
}
