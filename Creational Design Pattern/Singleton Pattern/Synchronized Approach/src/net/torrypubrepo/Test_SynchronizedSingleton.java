package net.torrypubrepo;

public class Test_SynchronizedSingleton {

    public static void main(String[] args)
    {
        // Get instance of Singleton
        SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();

        // Set Value
        synchronizedSingleton.setTotal(30);
        //Print Value
        System.out.println(" Instance Used :"+ synchronizedSingleton);
        System.out.println("Value for synchronizedSingleton :"+ synchronizedSingleton.getTotal());

        // Check if it is only Instance is created
        // set Previous Instance to null
        synchronizedSingleton =  null;

        // Create new Instance
        SynchronizedSingleton synchronizedSingleton1 = SynchronizedSingleton.getInstance();

        //Print Value
        System.out.println(" Instance Used :"+synchronizedSingleton1);
        System.out.println("Value for synchronizedSingleton1 :"+synchronizedSingleton1.getTotal());

    }//End main

}//End Test_LazySingleton
