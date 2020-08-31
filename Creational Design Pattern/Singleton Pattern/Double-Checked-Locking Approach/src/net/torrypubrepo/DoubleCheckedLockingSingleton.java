package net.torrypubrepo;

/*
 Created by Toriola in 2020

 NOTE ==>> This is a widely used approach and a stepUp to Synchronized-Singleton.
            It solves the issue of synchronization overhead in the Synchronized-Singleton approach.
            The synchronized is applied only when it is needed hence improvement on performance

            **** This approach doesn't work is Java 1.4 or earlier, consider other approach in java 5 or earlier ******
 */
public class DoubleCheckedLockingSingleton
{
    //Private Static reference to this singleton so it is not accessible outside of this class
    private volatile static DoubleCheckedLockingSingleton instance = null; // The name is arbitrary but instance is just common

    // NOTE ==>> volatile keyword is for jvm optimisation and is required for double-checked locking approach

    // Private Constructor is most for Singleton
    private DoubleCheckedLockingSingleton(){}

    // Instance Variables
    private int total;

    // factory method to create the instance
    // synchronized keyword ensures that 2 thread cannot access this method at the same time, first come first serve
    public static DoubleCheckedLockingSingleton getInstance()
    {
        // Check null
        if (instance == null)
            synchronized (DoubleCheckedLockingSingleton.class)
            {
                if (instance == null)
                    instance = new DoubleCheckedLockingSingleton();
            }//End synchronized
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
