package net.torrypubrepo;

public class ProductionClient
{
    private static String[] COLOURS = {"Red", "Black", "Green", "Blue"};
    private static String[] ENGINES = {"2.2 V6", "1.6 Turbo", "2.0 GT"};
    private static Integer[] DOORS = {2, 4};
    private static final Integer TOTAL_NUMBER_OF_CARS = 20;
    private static final String[] CAR_TYPE = {SaloonCar.VEHICLE_TYPE, EstateCar.VEHICLE_TYPE};

    public static void main(String[] args)
    {
        VehicleInterface anyCar = null;

        // Create Saloon with Different Colour
        for (int i = 0; i < TOTAL_NUMBER_OF_CARS; i++)
        {
            anyCar = VehicleFactory.produceVehicle(getRandomVehicle());
            // Set Extrinsic Properties Randomly
            anyCar.setColour(getRandomColour());
            anyCar.setEngine(getRandomEngine());
            anyCar.setNumberOfDoors(getRandomDoor());

            anyCar.getVehicle();

        }//End for

        System.out.println("\n Total Vehicle Created :"+VehicleFactory.getTotalVehicleCreated());
    }

    private static String getRandomVehicle()
    {
        return CAR_TYPE[(int) (Math.random() * CAR_TYPE.length)];
    }

    private static String getRandomColour()
    {
        return COLOURS[(int) (Math.random() * COLOURS.length)];
    }

    private static String getRandomEngine()
    {
        return ENGINES[(int) (Math.random() * ENGINES.length)];
    }

    public static int getRandomDoor()
    {
        return DOORS[(int) (Math.random() * DOORS.length)];
    }

}//End ProductionClient
