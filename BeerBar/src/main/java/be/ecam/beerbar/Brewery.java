package be.ecam.beerbar;

public enum Brewery {
    
    SAINT_SIXTE("Brasserie de l'abbaye de Saint-Sixte");

    private final String name;
    
    private Brewery(String name) {
        this.name = name;
    }
    
    public String getBreweryName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
