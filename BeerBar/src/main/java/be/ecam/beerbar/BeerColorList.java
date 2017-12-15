package be.ecam.beerbar;

import java.util.HashMap;

public class BeerColorList {
    private HashMap<String, BeerColor> beerColors;

    public BeerColorList() {
        this.beerColors = new HashMap<>();
    }

    public static BeerColorList fromCsv(String file) {
        throw new UnsupportedOperationException();
    }

    public void saveToCsv(String file) {
        throw new UnsupportedOperationException();
    }
}
