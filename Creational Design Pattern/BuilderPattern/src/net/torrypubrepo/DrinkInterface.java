package net.torrypubrepo;

/*
 Created by Toriola in 2020
 */
public abstract class DrinkInterface implements Items
{
    private String type;
    private String size;
    private float price;

    public DrinkInterface(String type, String size)
    {
        this.type = type; this.size = size;
        price = size.equalsIgnoreCase("Large")? 3.00f : 2.00f;
    }

    public String getItem()
    {
        return this.size+" "+this.type + " Drink price :"+this.price;
    }

    public float getPrice()
    {
        return this.price;
    }
}
