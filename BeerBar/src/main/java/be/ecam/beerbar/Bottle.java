package be.ecam.beerbar;

/**
 * This class represents a bottle in the inventory.
 */
public class Bottle {

    private final String name;
    private final int volume;
    private final int alcRate;
    private final BeerColor color;
    private final Brewery brewery;
    
    public Bottle(String name, int volume, int alcRate, BeerColor color, Brewery brewery) {
        this.name    = name;
        this.volume  = volume;
        this.alcRate = alcRate;
        this.color   = color;
        this.brewery = brewery;
    }
    
    @Override
    public String toString() {
        // ex: 1) Jupiler, 33cl, Blonde @ 7% d'alcool de Brasserie Jupiler
        return String.format("%s, %dcl, %s @ %d%% d'alcool de %s",
            this.name, this.volume, this.color, this.alcRate, this.brewery);
    }
}
