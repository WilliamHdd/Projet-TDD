package be.ecam.beerbar;

/**
 * This class represents a beer color / type
 */
public class BeerColor {
    
//    ROSE("Rose"),
//    AMBRE("Ambre"),
//    BRUNE("Brune"),
//    ROUGE("Rouge"),
//    BLONDE("Blonde"),
//    BLANCHE("Blanche");

    private String color;
    
    BeerColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return this.color;
    }
    
}
