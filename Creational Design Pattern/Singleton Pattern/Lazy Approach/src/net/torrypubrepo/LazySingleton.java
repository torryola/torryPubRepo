package net.torrypubrepo;

/*
 Created by Toriola in 2020

 NOTE ==>> This approach is not thread-safe but still useful and widely used e.g. in most OS or IDE
           Classes or Object is created only when it is firstly requested hence it improve performance by using less
           resources at the start of OS or IDE etc.
 */
public class LazySingleton
{
    //Private Static reference to this singleton so it is not accessible outside of this class
    private static LazySingleton instance; // The name is arbitrary but instance is just common

    // Private Constructor is most for Singleton
    private LazySingleton(){}

    // Instance Variables
    private int total;

    // factory method to create the instance
    public static LazySingleton getInstance()
    {
        // Check null
        if (instance == null)
            instance = new LazySingleton();
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
