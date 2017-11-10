package be.ecam.beerbar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class run {
    
    private static LinkedList<Bottle> beerList = new LinkedList<Bottle>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do ? (Manage stock(1) - " +
                "Select beer(2) - See previous selection(3) - Close(0)");
        String answer = sc.nextLine();
        int answerInt = Integer.parseInt(answer);
        while (answerInt < 0 || answerInt > 3) {
            System.err.println("Mauvais choix bouffon! Recommence!");
            answerInt = Integer.parseInt(sc.nextLine());
        }
        switch(answerInt){
            case 1:
                System.out.println("t'es dans le menu 1");
                break;
            case 2:
                System.out.println("menu2");
                break;
            case 3:
                System.out.println("menu3");
                break;
            default:
                System.out.println("Bouffon!");
        }

        beerList.add(new Bottle("West Vleteren", 33, 8, BeerColor.BRUNE, Brewery.SAINT_SIXTE));
        beerList.add(new Bottle("Jupiler", 33, 5, BeerColor.BLONDE, Brewery.JUPILER));
        beerList.add(new Bottle("Jupiler Blue", 25, 3, BeerColor.BLONDE, Brewery.JUPILER));
        
        Iterator<Bottle> iterBeerList = beerList.iterator();
        while (iterBeerList.hasNext()) {
            System.out.println(iterBeerList.next());
        }
    }
}
