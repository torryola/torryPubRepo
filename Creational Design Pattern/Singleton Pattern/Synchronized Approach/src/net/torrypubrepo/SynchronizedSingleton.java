package net.torrypubrepo;

/*
 Created by Toriola in 2020

 NOTE ==>> This is a tweak to the Lazy_Singleton Approach to make it Thread-safe.
            The downside of the approach is that bottleneck or starvation can occur thus performance will be affected.
            Because it is only required the 1st the instance is instantiated or required. 
 */
public class SynchronizedSingleton
{
    //Private Static reference to this singleton so it is not accessible outside of this class
    private static SynchronizedSingleton instance = null; // The name is arbitrary but instance is just common

    // Private Constructor is most for Singleton
    private SynchronizedSingleton(){}

    // Instance Variables
    private int total;

    // factory method to create the instance
    // synchronized keyword ensures that 2 thread cannot access this method at the same time, first come first serve
    public static synchronized SynchronizedSingleton getInstance()
    {
        // Check null
        if (instance == null)
            instance = new SynchronizedSingleton();
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
