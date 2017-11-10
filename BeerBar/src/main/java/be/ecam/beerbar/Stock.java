package be.ecam.beerbar;

import java.util.Iterator;
import java.util.LinkedList;

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
}
