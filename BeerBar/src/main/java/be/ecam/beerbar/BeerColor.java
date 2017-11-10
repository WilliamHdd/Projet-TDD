package be.ecam.beerbar;

public enum BeerColor {
    
    BLONDE("Blonde"),
    BRUNE("Brune"),
    ROUGE("Rouge");

    private final String color;
    
    private BeerColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return this.color;
    }   
}
