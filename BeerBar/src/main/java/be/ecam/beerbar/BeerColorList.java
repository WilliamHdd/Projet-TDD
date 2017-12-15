package be.ecam.beerbar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class BeerColorList {
    private HashMap<String, BeerColor> beerColors;

    public BeerColorList() {
        this.beerColors = new HashMap<>();
    }

    public static BeerColorList fromCsv(String file) {
        BeerColorList beerColorList = new BeerColorList();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                beerColorList.beerColors.put(line, new BeerColor(line));
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return beerColorList;
    }

    public void saveToCsv(String file) {
        throw new UnsupportedOperationException();
    }

    public BeerColor get(String name) {
        return beerColors.get(name);
    }

    public Collection<BeerColor> values() {
        return beerColors.values();
    }
}
