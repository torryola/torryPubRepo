package net.torrypubrepo;

/*
 Created by Toriola in 2020

 NOTE ==>> This is called Static or Eager Approach and it is the simplest way of creating singleton.
            The downside of this approach is that singleton object is created even when it is not needed, thus
            it is not suitable for singleton that uses a lot of resources.
 */
public class StaticSingleton
{
    //Private Static reference to this singleton so it is not accessible outside of this class
    private static final StaticSingleton instance = new StaticSingleton(); // The name is arbitrary but instance is just common

    // Private Constructor is most for Singleton
    private StaticSingleton(){}

    // Instance Variables
    private int total;

    // factory method to create the instance
    public static StaticSingleton getInstance()
    {
        // It is already create
        return instance;

    }//End getInstance()

    // Setters and Getters

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

}//End LazySingleton
