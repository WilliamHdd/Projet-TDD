package be.ecam.beerbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Console {

    private Stock stock;
    //creer console
    //creer stock
    public Console() {
        this.stock = new Stock();
    }


    public Menu createMenuSystem() {
        MenuItem backRoot = new MenuItem("Go back", null, null);

        MenuItem stock1 = new MenuItem("Add beer", null, e -> this.stock.addBottle()); //appeller stock methods
        MenuItem stock2 = new MenuItem("Change qantity or remove", null, e -> System.out.println("Change qantity or remove!"));
        MenuItem stock3 = new MenuItem("See critic quantities", null, e -> System.out.println("See critic quantities!"));
        MenuItem beer1 = new MenuItem("By name", null, e -> System.out.println("By name!"));
        MenuItem beer2 = new MenuItem("By color", null, e -> System.out.println("By color!"));
        MenuItem beer3 = new MenuItem("By volume", null, e -> System.out.println("By volume!"));

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

        // Tie the backlink up
        backRoot.setSubMenu(rootMenu);

        return rootMenu;
    }

    class Menu {
        private List < MenuItem > items = new ArrayList < >();
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

            return next == null ? this: next;
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
            if (onselect != null) onselect.actionPerformed(new ActionEvent(this, 0, "select"));
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