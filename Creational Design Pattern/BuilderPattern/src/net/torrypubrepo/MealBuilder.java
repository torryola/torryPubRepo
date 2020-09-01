package net.torrypubrepo;

/*
 Created by Toriola in 2020
 */
public class MealBuilder
{
    private Burgers foodInterface;
    private DrinkInterface drinkInterface;

    // Make Food
    public void prepareFood(String type, String size)
    {
        foodInterface = new Burgers(type, size);
    }
    public FoodInterface getFood()
    {
        return foodInterface;
    }

    public void prepareDrink(String type, String size)
    {
        drinkInterface = new Drinks(type, size);
    }

    public DrinkInterface getDrink()
    {
        return drinkInterface;
    }
}
