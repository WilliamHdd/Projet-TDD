package be.ecam.beerbar;

import java.util.Scanner;

/**
 * This is the runnable class of the project.
 */
public class run {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        final String menuMain = "\n"
                + "What do you want to do ?"
                + "\n\t (1) Manage stock"
                + "\n\t (2) Select beer"
                + "\n\t (3) See previous selection"
                + "\n\t (0) Close"
                + "\n Enter your selection [0-3]: ";
        System.out.print(menuMain);
        
        int selection = Integer.parseInt(sc.nextLine());
        while (selection < 0 || selection > 3) {
            System.out.print(menuMain);
            selection = Integer.parseInt(sc.nextLine());
        }
        
        switch (selection) {
            case 1:
                System.out.println("t'es dans le menu 1");
                break;
            case 2:
                System.out.println("menu2");
                break;
            case 3:
                System.out.println("menu3");
        }
    }
}
