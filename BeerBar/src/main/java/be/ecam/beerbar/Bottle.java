package be.ecam.beerbar;

/**
 * This class represents a bottle in the inventory.
 */
public class Bottle {
    
    // Shared variable between all instances which purpose is to
    // define the ID of the bottle instance in the constructor
    private static int counter = 1;
    
    private final int id;
    private final String name;
    private final int volume;
    private final int alcRate;
    private final BeerColor color;
    private final Brewery brewery;
    
    public Bottle(String name, int volume, int alcRate, BeerColor color, Brewery brewery) {
        this.id      = Bottle.counter++;
        this.name    = name;
        this.volume  = volume;
        this.alcRate = alcRate;
        this.color   = color;
        this.brewery = brewery;
    }
    
    @Override
    public String toString() {
        return String.format("%1$d) %2$s, %3$dcl, %4$s @ %5$d d'alcool de %6$s",
                this.id, this.name, this.volume, this.color, this.alcRate, this.brewery);
    }
    
}
