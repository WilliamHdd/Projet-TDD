package be.ecam.beerbar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class handle a virtual stock of beers.
 */
public class Stock {
    
    private final LinkedList<Bottle> beerList;
    
    public Stock() {
        this.beerList = new LinkedList();
        populateList();
    }
    
    private void populateList() {
        beerList.add(new Bottle("West Vleteren", 33, 8, BeerColor.BRUNE, Brewery.SAINT_SIXTE));
        beerList.add(new Bottle("Jupiler", 33, 5, BeerColor.BLONDE, Brewery.JUPILER));
        beerList.add(new Bottle("Jupiler Blue", 25, 3, BeerColor.BLONDE, Brewery.JUPILER));
    }

    public void printList() {
        Iterator<Bottle> iterBeerList = beerList.iterator();
        while (iterBeerList.hasNext()) {
            System.out.println(iterBeerList.next());
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
        if (select < 0 || select > 3) {
            System.out.println("Ok");
        }
    }
}
