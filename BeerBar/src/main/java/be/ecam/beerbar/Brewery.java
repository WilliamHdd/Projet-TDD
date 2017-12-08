package be.ecam.beerbar;

/**
 * This class sole purpose is to serve a predefined set of Brewery.
 */
public enum Brewery {
    
    SAINT_SIXTE("Brasserie de l'abbaye de Saint-Sixte"),
    JUPILER("Brasserie Jupiler"),
    ALVINNE("Brasserie Alvinne"),
    SAMBRE("Brasserie du Val de Sambre"),
    BONCHOISE("Brasserie La Bonchoise"),
    BRUNEHAUT("Brasserie de Brunehaut"),
    HAACHT("Brasserie Haacht");

    private final String name;
    
    Brewery(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

}
