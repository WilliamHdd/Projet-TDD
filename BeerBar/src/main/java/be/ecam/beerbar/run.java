package be.ecam.beerbar;

import java.util.Scanner;

/**
 * This is the runnable class of the project.
 */
public class run {
        
    private static final String MENU_MAIN = "\n"
            + "What do you want to do?     \n\t"
            + "(1) Manage stock            \n\t"
            + "(2) Select beer             \n\t"
            + "(3) See previous selection  \n\t"
            + "(0) Close                     \n"
            + "Enter your selection [0-3]: ";
 
    private static final String MENU_STOCK = "\n"
            + "What do you want to do?      \n\t"
            + "(1) Add beer                 \n\t"
            + "(2) Remove beer              \n\t"
            + "(3) See critic quantities      \n"
            + "Enter your selection [1-3]: ";

    private static final String MENU_BEER = "\n"
            + "What do you want to do?     \n\t"
            + "(1) By color                \n\t"
            + "(2) By volume               \n\t"
            + "(3) By brasserie              \n"
            + "Enter your selection [1-3]: ";
    
    private static final Stock STOCK = new Stock();
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print(MENU_MAIN);
        
        int selection = Integer.parseInt(sc.nextLine());
        while (selection < 0 || selection > 3) {
            System.out.print(MENU_MAIN);
            selection = Integer.parseInt(sc.nextLine());
        }
        
        switch (selection) {
            case 1:
                System.out.print(MENU_STOCK);
                Stock.manage(STOCK, sc);
                break;
                
            case 2:
                System.out.print(MENU_BEER);
                break;
                
            case 3:
                System.out.println("menu3");
        }
        
        STOCK.printList();
    }
}
