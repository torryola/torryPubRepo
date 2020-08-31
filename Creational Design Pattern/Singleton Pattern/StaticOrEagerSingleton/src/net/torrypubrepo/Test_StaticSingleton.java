package net.torrypubrepo;

public class Test_StaticSingleton {

    public static void main(String[] args)
    {
        // Get instance of Singleton
        StaticSingleton staticSingleton = StaticSingleton.getInstance();

        // Set Value
        staticSingleton.setTotal(30);
        //Print Value
        System.out.println(" Instance Used :"+ staticSingleton);
        System.out.println("Value for staticSingleton :"+ staticSingleton.getTotal());

        // Check if it is only Instance is created
        // set Previous Instance to null
        staticSingleton =  null;

        // Create new Instance
        StaticSingleton staticSingleton1 = StaticSingleton.getInstance();

        //Print Value
        System.out.println(" Instance Used :"+ staticSingleton1);
        System.out.println("Value for staticSingleton1 :"+ staticSingleton1.getTotal());

    }//End main

}//End Test_LazySingleton
