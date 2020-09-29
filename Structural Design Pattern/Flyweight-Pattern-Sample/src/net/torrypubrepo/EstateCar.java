package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class EstateCar implements VehicleInterface
{
    public static final String VEHICLE_TYPE = "Estate Car";
    private int numOfDoors;
    private String sColour;
    private String engineSize;

    public EstateCar(){}


    @Override
    public void getVehicle()
    {
        System.out.println(VEHICLE_TYPE + " "+this.toString());

    }

    @Override
    public void setNumberOfDoors(int doors)
    {
        this.numOfDoors = doors;
    }

    @Override
    public void setColour(String colour) {

        this.sColour = colour;
    }

    @Override
    public void setEngine(String engine) {
        this.engineSize = engine;
    }

    @Override
    public String toString()
    {
        return "EstateCar{" +
                "numOfDoors=" + numOfDoors +
                ", sColour='" + sColour + '\'' +
                ", engineSize='" + engineSize + '\'' +
                '}';
    }
}
