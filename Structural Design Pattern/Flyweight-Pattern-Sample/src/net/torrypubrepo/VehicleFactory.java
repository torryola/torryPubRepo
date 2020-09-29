package net.torrypubrepo;

import java.util.HashMap;

/*
 Created by Toriola Sep

 This will keep track of Objects creation
 */
public class VehicleFactory
{
    // Mapping Object Creation
    private static final HashMap<String, VehicleInterface> lastObjectCreated = new HashMap<>();

    // Factory Method for Creating and Managing Objects
    public static VehicleInterface produceVehicle(String type)
    {
            // check if already created
            VehicleInterface vehicleInterface = null;
            if (type == null || type.isEmpty())
                throw new UnsupportedOperationException("Vehicle Type not Recognised");

            if (lastObjectCreated.containsKey(type))
            {
                vehicleInterface = lastObjectCreated.get(type);

            }
            else
            {
                // Create new object, store and return it
                switch (type)
                {
                    case SaloonCar.VEHICLE_TYPE:
                        SaloonCar saloonCar = new SaloonCar();
                        lastObjectCreated.put(SaloonCar.VEHICLE_TYPE, saloonCar);
                        vehicleInterface = saloonCar;
                        break;
                    case EstateCar.VEHICLE_TYPE:
                        EstateCar estateCar = new EstateCar();
                        lastObjectCreated.put(EstateCar.VEHICLE_TYPE, estateCar);
                        vehicleInterface = estateCar;
                        break;
                }// End switch
            }

            return vehicleInterface;
    }//End VehicleInterface

    // Total Object Created
    public static int getTotalVehicleCreated()
    {
        return lastObjectCreated.size();
    }
}
