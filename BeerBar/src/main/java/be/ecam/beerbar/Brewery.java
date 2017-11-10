package be.ecam.beerbar;

public enum Brewery {
    
    SAINT_SIXTE("Brasserie de l'abbaye de Saint-Sixte"),
    JUPILER("Brasserie Jupiler");

    private final String name;
    
    private Brewery(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
