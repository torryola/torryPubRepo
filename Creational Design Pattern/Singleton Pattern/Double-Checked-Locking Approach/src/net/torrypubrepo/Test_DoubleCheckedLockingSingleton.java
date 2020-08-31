package net.torrypubrepo;

public class Test_DoubleCheckedLockingSingleton {

    public static void main(String[] args)
    {
        // Get instance of Singleton
        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton = DoubleCheckedLockingSingleton.getInstance();

        // Set Value
        doubleCheckedLockingSingleton.setTotal(30);
        //Print Value
        System.out.println(" Instance Used :"+ doubleCheckedLockingSingleton);
        System.out.println("Value for doubleCheckedLockingSingleton :"+ doubleCheckedLockingSingleton.getTotal());

        // Check if it is only Instance is created
        // set Previous Instance to null
        doubleCheckedLockingSingleton =  null;

        // Create new Instance
        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton1 = DoubleCheckedLockingSingleton.getInstance();

        //Print Value
        System.out.println(" Instance Used :"+ doubleCheckedLockingSingleton1);
        System.out.println("Value for doubleCheckedLockingSingleton1 :"+ doubleCheckedLockingSingleton1.getTotal());

    }//End main

}//End Test_LazySingleton
