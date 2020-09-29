package net.torrypubrepo;

import java.util.Random;

/*
 Created by Toriola Sep
 */
public class CarTyrePressure
{
    private int tyrePressure;
    // Good Pressure
    public void check_Type_Pressure()
    {
        String[] tyreLocation = {"Front-Left", "Front-Right", "Back-Left", "Back-Right"};
        //check All for Tyres
        for (int i = 0; i < 4; i++)
        {
            tyrePressure = new Random().nextInt(40)+20;

            System.out.println(tyreLocation[i] + " Tyre Pressure is :" +
                    (tyrePressure <= 30? "Low" : "Good"));
        }
    }
    // Low Pressure
}
