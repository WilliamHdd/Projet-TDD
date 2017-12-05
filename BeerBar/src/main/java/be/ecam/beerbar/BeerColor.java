package be.ecam.beerbar;

/**
 * This class sole purpose is to serve a predefined set of beer color.
 */
public enum BeerColor {
    
    ROSE("Rose"),
    AMBRE("Ambre"),
    BRUNE("Brune"),
    ROUGE("Rouge"),
    BLONDE("Blonde"),
    BLANCHE("Blanche");

    private final String color;
    
    private BeerColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return this.color;
    }
    
}
