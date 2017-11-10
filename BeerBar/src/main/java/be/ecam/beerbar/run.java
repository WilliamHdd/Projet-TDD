package be.ecam.beerbar;

public class run {
    public static void main(String[] args) {
        
        Bottle westVle = new Bottle("West Vleteren", 33, 8,
                BeerColor.BRUNE, Brewery.SAINT_SIXTE);
        
        System.out.println(westVle);
    }
}
