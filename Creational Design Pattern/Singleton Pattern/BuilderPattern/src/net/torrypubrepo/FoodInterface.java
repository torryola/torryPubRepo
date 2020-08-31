package net.torrypubrepo;

/*
 Created by Toriola in 2020
 */
public abstract class FoodInterface implements Items
{
    private String type;
    private String size;
    private float price;

    public FoodInterface(String type, String size)
    {
        this.type = type; this.size = size;
    }

    public String getItem()
    {
        return this.size+" "+this.type +" Burger price :"+this.price;
    }
    public abstract float getPrice();
}
