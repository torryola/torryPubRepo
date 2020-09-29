package net.torrypubrepo;

/*
 Created by Toriola Sep
 This will contains Common Properties of a vehicle/Car
 Extrinsic Properties e.g. number of Doors will be changed by the client
 */
public interface VehicleInterface
{
    // Intrinsic Properties
    public abstract void getVehicle();

    // Extrinsic Properties
    public abstract void setNumberOfDoors(int doors);
    public abstract void setColour(String color);
    public abstract void setEngine(String engine);
}
