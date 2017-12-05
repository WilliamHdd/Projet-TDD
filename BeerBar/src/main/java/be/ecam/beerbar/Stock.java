package be.ecam.beerbar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

// imports for DB
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 * This class handle a virtual stock of beers.
 */
public class Stock {
    
    private final LinkedList<Pair<Bottle,Integer>> beerList;
    private final Scanner sc;
    
    public Stock() {
        this.beerList = new LinkedList();
        this.sc = new Scanner(System.in);
        populateList();
    }
    
    private void populateList() {
        try{
            // Connection to the DB
            String host = "jdbc:derby://localhost:1527/BeerBar";
            String uName = "admin6";
            String uPass = "admin";
            Connection con = DriverManager.getConnection( host, uName, uPass);
            // REQUEST to the DB
            Statement stmt = con.createStatement( );
            String SQL = "SELECT * FROM BEERBAR";
            ResultSet rs = stmt.executeQuery( SQL );
            while (rs.next()){
                Bottle B = new Bottle(rs.getString("BEER").replaceAll(" ",""),
                                        rs.getInt("VOLUME"),
                                        rs.getInt("alcrate"),
                                        BeerColor.valueOf(rs.getString("BEERCOLOR").replaceAll(" ","")),
                                        Brewery.valueOf(rs.getString("BREWERY").replaceAll(" ","")));
                beerList.add(new Pair(B,rs.getInt("Quantity")));
                System.out.println(B);
            }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }        
    }

    public void printList() {
        Iterator<Pair<Bottle,Integer>> iterBeerList = beerList.iterator();
        while (iterBeerList.hasNext()) {
            System.out.println(iterBeerList.next().getKey());
        }
    }
    
    private LinkedList<Bottle> findBeerByName(String query) {
        //TODO
        return null;
    }
    
    private LinkedList<Bottle> findBeerByColor(BeerColor query) {
        //TODO
        return null;
    }
    
    private LinkedList<Bottle> findBeerByVolume(int query) {
        //TODO
        return null;
    }
    
    public int input_check(int lower, int upper) {
        int iinput = Integer.parseInt(sc.nextLine());
        if (iinput < lower || iinput > upper) {
            System.err.println("Invalid input");
            return -1;
        }
        return iinput;
    }
    
    /**
     * Management interface of the beer stock.
     */
    public void manage() {
        int select = Integer.parseInt(sc.nextLine());
        if (select < 0 || select > 3) return;

        switch (select) {
            case 1: // add beer
                this.addBottle();
                break;
            case 2: // remove beer
                this.editBottle();
                break;
            case 3: // list critics
                this.listCritics();
        }
    }
    
    /**
     * Add a bottle to the list of beer.
     * The function takes no arguments because it reads every field from stdin.
     */
    public void addBottle() {
        System.out.print("Type the following bottle informations.\nBeer name: ");
        String inName = sc.nextLine();
        if (inName.length() < 3 || inName.length() > 80) {
            System.err.println("Invalid input");
            return;
        }
        
        System.out.print("Beer volume: ");
        int inVolume = input_check(1, 200);
        if (inVolume == -1) return;
        
        System.out.print("Beer alcool rate: ");
        int inAlcRate = input_check(0, 99);
        if (inAlcRate == -1) return;
        
        // list the beer colors
        System.out.print("Select the beer color\n");
        BeerColor choiceBC[] = BeerColor.values();
        for (int i = 0; i < choiceBC.length; i++)
            System.out.println(String.format("%d) %s", i+1, choiceBC[i]));
        
        int inChoiceBC = input_check(0, choiceBC.length);
        if (inChoiceBC == -1) return;
        
        
        // list the breweries
        System.out.print("Select the brewery\n");
        Brewery choiceBR[] = Brewery.values();
        for (int i = 0; i < choiceBR.length; i++)
            System.out.println(String.format("%d) %s", i+1, choiceBR[i]));
        
        int inChoiceBR = input_check(0, choiceBR.length);
        if (inChoiceBR == -1) return;
        
        System.out.print("Type the quantity: ");
        int inQte = input_check(1, 100);
        if (inQte == -1) return;
        
        this.beerList.add(
            new Pair(
                new Bottle(inName, inVolume, inAlcRate,
                    choiceBC[inChoiceBC-1], choiceBR[inChoiceBR-1]),
                inQte)
        );
    }
    
    /**
     * Edit the quantity or remove a bottle from the beer list.
     * The function takes no arguments because it reads every field from stdin.
     */
    public void editBottle() {
        Iterator<Pair<Bottle, Integer>> iterList = this.beerList.iterator();
        int counter = 1;
        while (iterList.hasNext()) {
            Pair<Bottle, Integer> pair = iterList.next();
            Bottle  bottle   = pair.getKey();
            Integer quantity = pair.getValue();
            System.out.println(String.format("%d) qte: %d, %s", counter, quantity, bottle));
            counter++;
        }
        System.out.print("Type the id of the beer to edit: ");
        int inID = Integer.parseInt(sc.nextLine());
        if (inID < 1 || inID > counter-1) {
            System.err.println("Invalid input");
            return;
        }
        
        System.out.print("Type the new quantity of the beer (0 to remove): ");
        int inQte = Integer.parseInt(sc.nextLine());
        if (inQte < 0 || inQte > 100) {
            System.err.println("Invalid input");
            return;
        }
        
        // delete a bottle
        if (inQte == 0) {
            this.beerList.remove(inID-1);
            return;
        }
        
        // add the quantity
        this.beerList.get(inID-1).setValue(inQte);
    }
    
    /**
     * Print a list of beer with 10 bottles or less in the stock.
     */
    public void listCritics() {
        Iterator<Pair<Bottle, Integer>> iterList = this.beerList.iterator();
        while (iterList.hasNext()) {
            Pair<Bottle, Integer> pair = iterList.next();
            Bottle  bottle   = pair.getKey();
            Integer quantity = pair.getValue();
            
            if (quantity <= 10) {
                System.out.println(String.format("qte:%d, %s", quantity, bottle));
            }
        }
    }
}
