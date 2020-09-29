package net.torrypubrepo;

public class Facade_Client {

    public static void main(String[] args)
    {
        // Auto-Check the Car Before Travelling
        Car_Facade car_facade = new Car_Facade();
        // Start the Car and do Basic Checking
        car_facade.start_Car();
        System.out.println("\n");
        // Stop the Car and Turn of the Dash Board Light
        car_facade.stop_Car();
    }
}
