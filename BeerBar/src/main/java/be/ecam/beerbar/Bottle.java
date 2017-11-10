package be.ecam.beerbar;

public class Bottle {
    
    private static int counter = 0;
    
    private final int id;
    private final String name;
    private final int volume;
    private final float alcoholLevel;
    private final BeerColor color;
    private final Brewery brewery;
    
    public Bottle(String name, int volume, float alcoholLevel,
            BeerColor color, Brewery brewery) {
        this.id         = Bottle.counter++;
        this.name       = name;
        this.volume     = volume;
        this.alcoholLevel = alcoholLevel;
        this.color      = color;
        this.brewery    = brewery;
    }
    
}
