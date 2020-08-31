package net.torrypubrepo;

/*
 Created by Toriola in 2020

 NOTE ==>> Bill Pugh Singleton approach is one of the widely used approach.
            It is thread-safe and doesn't require synchronisation thus improves performance.

            This approach leverage the power of Nested class(i.e. static inner class) to instance the singleton obj
            and it isn't loaded on to the memory until is called

            Most importantly, it is neat!
 */
public class Singleton
{

    // Private Constructor is most for Singleton
    private Singleton(){}

    // Instance Variables
    private int total;

    // Nest Class here
    private static class SingletonInitializer
    {
        //Private Static reference to this singleton so it is not accessible outside of this class
        private static final Singleton instance = new Singleton(); // The name is arbitrary but instance is just common
    }
    // factory method to create the instance
    public static Singleton getInstance()
    {
        return SingletonInitializer.instance;

    }//End getInstance()

    // Setters and Getters

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

}//End LazySingleton
