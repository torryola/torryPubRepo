package net.torrypubrepo;

public class MenuClient {

    public static void main(String[] args)
    {
        // Create Basic Menu
        MenuComponent basicMenu = new BasicMenu();
        // Silver - Add more Functionality to Basic Menu
        MenuDecorator silverMenu = new SilverMenu(basicMenu);
        // Gold - Add more Functionality to Silver Menu
        MenuDecorator goldMenu = new GoldMenu(silverMenu);

        // Prints out Menus
        System.out.println("************* Decorator Pattern ***************");
        System.out.println("************* Menu Decorator Demo ***************");
        // Basic Menu
        System.out.println("************* Basic Menu ***************");
        basicMenu.getMenu().forEach(System.out::println);

        // Silver Menu
        System.out.println("************* Silver Menu ***************");
        silverMenu.getMenu().forEach(System.out::println);

        // Gold Menu
        System.out.println("************* Gold Menu ***************");
        goldMenu.getMenu().forEach(System.out::println);


    }
}
