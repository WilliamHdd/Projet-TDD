package be.ecam.beerbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Stock stock;
    private Scanner sc;

    public Console() {
        this.stock = new Stock();
        this.sc = new Scanner(System.in);
    }

    public Menu createMenuSystem() {
        MenuItem backRoot = new MenuItem("Go back", null, null);

        MenuItem stock1 = new MenuItem("Add beer", null, e -> this.stock.addBottle());
        MenuItem stock2 = new MenuItem("Change qantity or remove", null,
                e -> this.stock.editBottle());
        MenuItem stock3 = new MenuItem("See critic quantities", null,
                e -> this.stock.listCriticQuantities());
        MenuItem beer1 = new MenuItem("By name", null, e -> this.findBeerByName());
        MenuItem beer2 = new MenuItem("By color", null, e -> this.findBeerByColor());
        MenuItem beer3 = new MenuItem("By volume", null, e -> this.findBeerByVolume());

        Menu subMenu2 = new Menu("Manage stock");
        subMenu2.addItem(stock1);
        subMenu2.addItem(stock2);
        subMenu2.addItem(stock3);
        subMenu2.addItem(backRoot);
        Menu subMenu3 = new Menu("Select beer");
        subMenu3.addItem(beer1);
        subMenu3.addItem(beer2);
        subMenu3.addItem(beer3);
        subMenu3.addItem(backRoot);

        MenuItem main1 = new MenuItem("Manage stock", subMenu2, null);
        MenuItem main2 = new MenuItem("Select beer", subMenu3, null);

        Menu rootMenu = new Menu("What do you want to do?");
        rootMenu.addItem(main1);
        rootMenu.addItem(main2);

        backRoot.setSubMenu(rootMenu);

        return rootMenu;
    }

    private void findBeerByName() {
        String foo = this.sc.nextLine();
        System.out.println(this.stock.findBeerByName(foo));
    }

    private void findBeerByColor() {
        BeerColor choiceBC[] = (BeerColor[]) stock.getBeerColorList().values().toArray();
        for (int i = 0; i < choiceBC.length; i++)
            System.out.println(String.format("%d) %s", i + 1, choiceBC[i]));

        int inChoiceBC = Run.inputCheck(this.sc, 0, choiceBC.length, null);
        if (inChoiceBC == -1) return;
        System.out.println(this.stock.findBeerByColor(choiceBC[inChoiceBC - 1]));
    }

    private void findBeerByVolume() {
        int bar = Run.inputCheck(this.sc, 1, 100, null);
        if (bar == -1) return;
        System.out.println(this.stock.findBeerByVolume(bar));
    }

    class Menu {
        private List<MenuItem> items = new ArrayList<>();
        private String title;

        public Menu(String title) {
            this.title = title;
        }

        public Menu doOption(int option) {
            if (option == 0) return null;
            option--;
            if (option >= items.size()) {
                System.out.println("Unknown option " + option);
                return this;
            }
            items.get(option).select();
            Menu next = items.get(option).getSubMenu();

            return next == null ? this : next;
        }

        public Menu addItem(MenuItem item) {
            items.add(item);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(title).append("\n");
            for (int i = 0; i < title.length(); i++) {
                sb.append("-");
            }
            sb.append("\n");
            for (int i = 0; i < items.size(); i++) {
                sb.append((i + 1)).append(") ").append(items.get(i)).append("\n");
            }
            sb.append("0) Quit");
            return sb.toString();
        }
    }

    class MenuItem {
        private String title;
        private Menu submenu;
        private ActionListener onselect;

        public MenuItem(String title, Menu submenu, ActionListener onselect) {
            this.title = title;
            this.submenu = submenu;
            this.onselect = onselect;
        }

        public String getTitle() {
            return title;
        }

        public void select() {
            if (onselect != null) {
                onselect.actionPerformed(new ActionEvent(this, 0, "select"));
            }
        }

        public Menu getSubMenu() {
            return submenu;
        }

        public void setSubMenu(Menu submenu) {
            this.submenu = submenu;
        }

        public String toString() {
            return title;
        }
    }
}