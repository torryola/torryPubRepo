package net.torrypubrepo;

import java.util.Random;

/*
 Created by Toriola Sep
 */
public class Check_Car_Engine
{
    private int oil_Liter = new Random().nextInt(5);
    // Check Radiator
    public void check_Radiator()
    {
        System.out.println("Top-up radiator");
    }
    // Check oil
    public void check_Oil()
    {
        System.out.println(" Oil is :"+(oil_Liter <= 3? "Low" : "Good"));
    }
    // Check Battery
    public void check_Battery()
    {
        System.out.println("Battery is Good ");
    }
}
