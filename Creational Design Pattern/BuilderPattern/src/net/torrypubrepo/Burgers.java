package net.torrypubrepo;

/*
 Created by Toriola in 2020
 */
public class Burgers extends FoodInterface
{
    private String type;
    private String size;
    private float price;
    public Burgers(String type, String size)
    {
        super(type, size);
        this.type = type;
        this.size = size;
    }

    @Override
    public float getPrice()
    {
        if (type != null & size != null) {
            if (type.equalsIgnoreCase("Veggie") & size.equalsIgnoreCase("Large"))
                price = 7.00f;
            else if (type.equalsIgnoreCase("Chicken") & size.equalsIgnoreCase("Large"))
                price = 9.00f;
            else if (type.equalsIgnoreCase("Veggie") & size.equalsIgnoreCase("Medium"))
                price = 4.00f;
            else if (type.equalsIgnoreCase("Chicken") & size.equalsIgnoreCase("Medium"))
                price = 5.00f;
            else
                price = 0.00f;
        }
        else
            price = 0.00f;

        return price;
    }

    // Custom Setters and Getters
}
