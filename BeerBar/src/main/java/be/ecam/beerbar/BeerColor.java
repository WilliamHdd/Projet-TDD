package be.ecam.beerbar;

public enum BeerColor {
    
    BEER_BLONDE("Blonde"),
    BEER_BRUNE("Brune"),
    BEER_ROUGE("Rouge");

    private final String color;
    
    private BeerColor(String color) {
        this.color = color;
    }
    
    public String getBeerColor() {
        return this.color;
    }   
}
