package net.dsignpattern.samples;

import java.util.ArrayList;
import java.util.List;

/*
 Double-Checked Locking Approach is considered to be better option.
 Other options are:
 - Static Initialization
 - Lazy Initialization -> This is not thread-safe

 This sample uses Double-Checked locking Approach
 */

public class SingletonObjectSample
{
    // Private Fields
    private List<String> stringList = new ArrayList<>();
    // Instance must be private and final
    // The use of volatile keyword is for Compiler Optimization.
    private static volatile SingletonObjectSample instance; // new SingletonObjectSample();

    // Constructor must be Private
    private SingletonObjectSample(){}

    // Method to return the singleton
    public static SingletonObjectSample getInstance()
    {
        if (instance == null)
        {
            // Acquire Lock on this Class
            synchronized (SingletonObjectSample.class)
            {
                // Check Again
                if (instance == null)
                    instance = new SingletonObjectSample();
            }
        }
        return instance;
    }

    // Method to populate List
    public synchronized void set_StringList(String val)
    {
        stringList.add(val);
        System.out.println("Value Added to List :"+val);
    }

    public synchronized String get_StringVal(int index)
    {
        String val = stringList.get(index);
        // Remove Element from list
        return val != null ? val : "Waiting for List";
    }

    public synchronized void remove_ListItem(int index)
    {
        stringList.remove(index);
    }
    public synchronized int get_ListSize()
    {
        return stringList.size();
    }

}// SingletonObjectSample
