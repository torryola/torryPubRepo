package net.torrypubrepo;

/*
 Created by Toriola in 2020
 */
public class Customer
{
    public static void main(String[] args)
    {
       // Customer wants BMW M5
        // Make the cars
        CarCloneFactory.makeCars();
        // Return BMW
        CloneableCars bmw = CarCloneFactory.getCar("BMW");
        System.out.println("Car :"+bmw.getType()+" Price :"+bmw.getPrice());

        // Mercedes Order
        CloneableCars mercedes = CarCloneFactory.getCar("Mercedes");
        System.out.println("Car :"+mercedes.getType()+" Price :"+mercedes.getPrice());
    }
}
