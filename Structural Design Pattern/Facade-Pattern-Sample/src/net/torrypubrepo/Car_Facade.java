package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class Car_Facade
{
    // Reference to Subsystems
    private CarDashBoard carDashBoard;
    private CarTyrePressure carTyrePressure;
    private Check_Car_Engine check_car_engine;

    // Constructor
    public Car_Facade()
    {
        // Initialization
        carDashBoard = new CarDashBoard();
        carTyrePressure = new CarTyrePressure();
        check_car_engine = new Check_Car_Engine();
    }//End

    // Start Car ==> Helper method that hides the checking Subsystem implementations from Client
    public void start_Car()
    {
        System.out.println("************ Starting the Car ************* ");
        // Do the Checking
        // Check turn Dash Board Light on
        carDashBoard.dashBoard_LightOn();
        // check Tyres
        carTyrePressure.check_Type_Pressure();
        // Check Engine
        check_car_engine.check_Battery();
        check_car_engine.check_Oil();
        check_car_engine.check_Radiator();
    }

    public void stop_Car()
    {
        System.out.println("************ Stopping the Car ************* ");
        // Turn off the DashBoard
        carDashBoard.dashBoard_LightOff();
    }
}
