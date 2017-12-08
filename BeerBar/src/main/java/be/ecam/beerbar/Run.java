package be.ecam.beerbar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This is the runnable class of the project.
 */
public class Run {
        
    private static final String MENU_MAIN = ""
            + "What do you want to do?       \n"
            + "(1) Manage stock              \n"
            + "(2) Select beer               \n"
            + "(3) See previous selection    \n"
            + "(0) Close                     \n"
            + "Enter your selection [0-3]: ";
 
    private static final String MENU_STOCK = ""
            + "What do you want to do?        \n"
            + "(1) Add beer                   \n"
            + "(2) Change qte or remove       \n"
            + "(3) See critic quantities      \n"
            + "Enter your selection [1-3]: ";

    private static final String MENU_BEER = ""
            + "What do you want to do?       \n"
            + "(1) By name                   \n"
            + "(2) By color                  \n"
            + "(3) By volume                 \n"
            + "Enter your selection [1-3]: ";
    
    private static final Stock STOCK = new Stock();
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Console t = new Console();
        Console.Menu currentMenu = t.createMenuSystem();
        while(currentMenu != null)
        {
            System.out.println(currentMenu);
            System.out.print(">>> ");
            String inp = "";
            try
            {
                inp = br.readLine();
                currentMenu = currentMenu.doOption(Integer.parseInt(inp));
            }
            catch(Exception ex)
            {
                System.out.println("Didn't understand " + inp);
            }
        }
    }

    public static int inputCheck(Scanner sc, int lower, int upper, String errorStr) {
        int iinput = -1;
        String notice = errorStr != null ? errorStr : "Invalid input, please retry:";

        while (true) {
            try {
                iinput = Integer.parseInt(sc.nextLine());
                while (iinput < lower || iinput > upper) {
                    System.err.print(notice);
                    iinput = Integer.parseInt(sc.nextLine());
                }
                break;
            } catch(NumberFormatException e) {
                System.err.println(notice);
            }
        }

        return iinput;
    }
}
