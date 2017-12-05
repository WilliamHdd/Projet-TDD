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
    
    public Stock() {
        this.beerList = new LinkedList();
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
    
    /*
     * Management interface of the beer stock
     */
    public static void manage(Scanner sc) {
        int select = Integer.parseInt(sc.nextLine());
        if (select < 0 || select > 3) return;

        switch (select) {
            case 1: // add beer
                break;
            case 2: // remove beer
                break;
            case 3: // list critics
                break;
        }
        
    }
}
