package net.torrypubrepo;

import sun.awt.FontDescriptor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        // Place Order
        MealBuilder mealBuilder = new MealBuilder();
        // Prepare Burger
        mealBuilder.prepareFood("Veggie", "Medium");
        mealBuilder.prepareDrink("Pepsi", "Medium");

        FoodInterface foodInterface = mealBuilder.getFood();
        DrinkInterface drinkInterface = mealBuilder.getDrink();

        List<String> order = new ArrayList<>();
        order.add(foodInterface.getItem());
        order.add(drinkInterface.getItem());

        float total = foodInterface.getPrice() + drinkInterface.getPrice();

        System.out.println(" Your meal order is :"+order.toString());
        System.out.println("Amount to pay : "+total);

    }
}
