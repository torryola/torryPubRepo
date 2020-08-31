package net.torrypubrepo;

public class Test_BillPughSingleton {

    public static void main(String[] args)
    {
        // Get instance of Singleton
        Singleton singleton = Singleton.getInstance();

        // Set Value
        singleton.setTotal(30);
        //Print Value
        System.out.println(" Instance Used :"+ singleton);
        System.out.println("Value for singleton :"+ singleton.getTotal());

        // Check if it is only Instance is created
        // set Previous Instance to null
        singleton =  null;

        // Create new Instance
        Singleton singleton1 = Singleton.getInstance();

        //Print Value
        System.out.println(" Instance Used :"+ singleton1);
        System.out.println("Value for singleton1 :"+ singleton1.getTotal());

    }//End main

}//End Test_LazySingleton
