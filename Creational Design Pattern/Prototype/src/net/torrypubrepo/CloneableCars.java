package net.torrypubrepo;

/*
 Created by Toriola in 2020
 */
public abstract class CloneableCars implements Cloneable
{
    protected String Id;
    private String type;
    private float price;

    public CloneableCars(String id)
    {
        this.Id = id;
    }

    public String getId()
    {
        return Id;
    }
    public abstract void setPrice(float price);
    public abstract float getPrice();
    public abstract String getType();
    public abstract void setType(String type);

    public Object clone()
    {
        Object cloneableCars = null;
        try{
            cloneableCars = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return cloneableCars;
    }
}//End CloneableCars
