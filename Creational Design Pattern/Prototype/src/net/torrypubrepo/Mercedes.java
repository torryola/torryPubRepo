package net.torrypubrepo;

/*
 Created by Toriola in 2020
 */
public class Mercedes extends CloneableCars
{
    private String type;
    private float price;

    public Mercedes(String id)
    {
        super(id);
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public String getType()
    {
        return this.type;
    }

    @Override
    public void setType(String type)
    {
        this.type = type;
    }
}
