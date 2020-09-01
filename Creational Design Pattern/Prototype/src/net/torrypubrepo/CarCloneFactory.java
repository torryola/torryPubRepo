package net.torrypubrepo;

import java.util.HashMap;

/*
 Created by Toriola in 2020
 */
public class CarCloneFactory
{
    private static final HashMap<String, CloneableCars> cars = new HashMap<>();

    public static void makeCars()
    {
        BMW bmw = new BMW("BMW");
        bmw.setType("BMW M5");
        bmw.setPrice(56000.00f);
        cars.put(bmw.getId(), bmw);

        Mercedes mercedes = new Mercedes("Mercedes");
        mercedes.setType("Mercedes C63 AMG");
        mercedes.setPrice(60000.00f);
        cars.put(mercedes.getId(), mercedes);
    }

    public static CloneableCars getCar(String carId)
    {
        return (CloneableCars) cars.get(carId).clone();
    }
}
