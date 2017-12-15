package be.ecam.beerbar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class handle a virtual stock of beers.
 */
public class Stock {
    
    private final LinkedList<AbstractMap.SimpleEntry<Bottle,Integer>> beerList;
    
    public Stock() {
        this.beerList = new LinkedList();
        readCSV("BeerList.csv");
    }

    private void readCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] elem = line.split(",");
                int vol = 0;
                int alc = 0;
                try {
                    vol = Integer.parseInt(elem[1]);
                    alc = Integer.parseInt(elem[2]);
                } catch (NumberFormatException nfe) {
                    System.err.println(nfe);
                }
                this.beerList.add(
                    new AbstractMap.SimpleEntry (
                        new Bottle(elem[0], vol, alc,
                                BeerColor.valueOf(elem[3]), Brewery.valueOf(elem[4])), 1)
                );
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public Bottle findBeerByName(String query) {
        for (AbstractMap.SimpleEntry<Bottle, Integer> beerList : this.beerList) {
            Bottle bottle = beerList.getKey();
            if (bottle.getName().equals(query)) {
                return bottle;
            }
        }
        return null;
    }
    
    public LinkedList<Bottle> findBeerByColor(BeerColor query) {
        Iterator<AbstractMap.SimpleEntry<Bottle,Integer>> iterBeerList = beerList.iterator();
        LinkedList<Bottle> answer = new LinkedList<>();
        while (iterBeerList.hasNext()) {
            Bottle bottle = iterBeerList.next().getKey();
            if (bottle.getColor().equals(query)){
                answer.add(bottle);
            }
        }
        return answer;
    }
    
    public LinkedList<Bottle> findBeerByVolume(int query) {
        Iterator<AbstractMap.SimpleEntry<Bottle,Integer>> iterBeerList = beerList.iterator();
        LinkedList<Bottle> answer = new LinkedList<>();
        while (iterBeerList.hasNext()) {
            Bottle bottle = iterBeerList.next().getKey();
            if (bottle.getVolume() == (query)){
                answer.add(bottle);
            }
        }
        return answer;
    }

    /**
     * Add a bottle to the list of beer.
     * The function takes no arguments because it reads every field from stdin.
     */
    public void addBottle(String name, int volume, int alcRate, BeerColor color, Brewery brewery, int quantity) {
        this.beerList.add(
            new AbstractMap.SimpleEntry (
                new Bottle(name, volume, alcRate,
                    color, brewery),
                quantity)
        );
        System.out.println("Beer added");
    }

    public Iterator<AbstractMap.SimpleEntry<Bottle, Integer>> getBeerList() {
        return this.beerList.iterator();
    }
    
    /**
     * Edit the quantity or remove a bottle from the beer list.
     * The function takes no arguments because it reads every field from stdin.
     */
    public void editBottle(int quantity, int ID) {
        // delete a bottle
        if (quantity == 0) {
            this.beerList.remove(ID-1);
            System.out.println(String.format("Beer %d deleted", ID));
            return;
        }
        // add the quantity
        this.beerList.get(ID-1).setValue(quantity);
        System.out.println(String.format("Beer %d updated", ID));
    }
    
    /**
     * Print a list of beer with 10 bottles or less in the stock.
     */
    public void listCriticQuantities() {
        for (AbstractMap.SimpleEntry<Bottle, Integer> pair : this.beerList) {
            Bottle bottle = pair.getKey();
            Integer quantity = pair.getValue();

            if (quantity <= 10) {
                System.out.println(String.format("qte:%d, %s", quantity, bottle));
            }
        }
    }
}
