package net.torrypubrepo;

public class Test_LazySingleton {

    public static void main(String[] args)
    {
        // Get instance of Singleton
        LazySingleton lazySingleton = LazySingleton.getInstance();

        // Set Value
        lazySingleton.setTotal(30);
        //Print Value
        System.out.println(" Instance Used :"+lazySingleton);
        System.out.println("Value for lazySingleton :"+lazySingleton.getTotal());

        // Check if it is only Instance is created
        // set Previous Instance to null
        lazySingleton =  null;

        // Create new Instance
        LazySingleton lazySingleton1 = LazySingleton.getInstance();

        //Print Value
        System.out.println(" Instance Used :"+lazySingleton1);
        System.out.println("Value for lazySingleton1 :"+lazySingleton1.getTotal());

    }//End main

}//End Test_LazySingleton
