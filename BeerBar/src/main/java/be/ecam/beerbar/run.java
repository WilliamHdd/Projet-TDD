package be.ecam.beerbar;

import java.util.Iterator;
import java.util.List;

public class run {
    
    private static List<Bottle> beerList;
    
    public static void main(String[] args) {
        
        beerList.add(new Bottle("West Vleteren", 33, 8, BeerColor.BRUNE, Brewery.SAINT_SIXTE));
        beerList.add(new Bottle("Jupiler", 33, 5, BeerColor.BLONDE, Brewery.JUPILER));
        beerList.add(new Bottle("Jupiler Blue", 25, 3, BeerColor.BLONDE, Brewery.JUPILER));
        
        Iterator<Bottle> iterBeerList = beerList.iterator();
        while (iterBeerList.hasNext()) {
            System.out.println(iterBeerList.next());
        }
    }
}
