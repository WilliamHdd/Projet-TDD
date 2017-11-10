package be.ecam.beerbar;

public class Bottle {
    
    private static int counter = 1;
    
    private final int id;
    private final String name;
    private final int volume;
    private final int alcRate;
    private final BeerColor color;
    private final Brewery brewery;
    
    public Bottle(String name, int volume, int alcRate,
            BeerColor color, Brewery brewery) {
        this.id      = Bottle.counter++;
        this.name    = name;
        this.volume  = volume;
        this.alcRate = alcRate;
        this.color   = color;
        this.brewery = brewery;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str .append(id)
            .append(") ")
            .append(this.name)
            .append(", ")
            .append(this.volume)
            .append("cl, ")
            .append(this.color)
            .append(" @ ")
            .append(this.alcRate)
            .append("% d'alcool de ")
            .append(this.brewery);
        return str.toString();
    }
    
}
