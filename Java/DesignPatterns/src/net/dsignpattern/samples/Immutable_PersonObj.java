package net.dsignpattern.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
 Immutable object are implicitly thread-safe.
 It is another Creational design pattern approach to creating read-only object
 that can be shared and/or used by multiple classes
 */

public class Immutable_PersonObj
{
    public static void main(String[] args)
    {

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");

       System.out.println(new Immutable_PersonObj("John", "Max", 23, hobbies).toString());

        // Build New Person Using Builder Pattern
        List<String > hobbies2 = new ArrayList<>();
        hobbies2.add("Boxing"); hobbies2.add("Cars");

        Immutable_PersonObj immutable_personObj = new PersonObj_Builder().setAge(34).setFirstName("John")
                .setLastName("Wicks").setHobbies(hobbies2).build();

        // Using Consumer and Method Referencing
        Consumer<Immutable_PersonObj> consumer = System.out::println; // Lambda : person -> System.out.println(person);
        consumer.accept(immutable_personObj);

        //System.out.println(immutable_personObj.toString());

    }

    private final String firstName;
    private final String lastName;
    private final int Age;
    private final List<String> Hobbies;

    // Constructor
    public Immutable_PersonObj(String firstName, String lastName, int age, List<String> hobbies)
    {
        if (firstName == null)
            throw new IllegalArgumentException("First Name cannot be null");
        this.firstName = firstName;

        if (lastName == null)
            throw new IllegalArgumentException("Last Name cannot be null");
        this.lastName = lastName;

        if (age <= 0)
            throw new IllegalArgumentException("Age must be greater than 0");
        this.Age = age;
        if (hobbies == null)
            throw new IllegalArgumentException("At least 1 Hobby must be entred");
        this.Hobbies = new ArrayList<>(hobbies);
    // NOTE ==>  Do not return reference to Mutable object like List. Instead retrun the Immutable copy i.e. String or create new Ref
    }//End Constructor

    // No Setter for Immutable Object

    // Getters
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge()
    {
        return Age;
    }
    public String getHobbies()
    {
        return Hobbies.toString();
    }

    @Override
    public String toString()
    {
        return "Name :"+firstName+" "+lastName+", Age :"+Age+", Hobbies :"+Hobbies.toString();
    }

}// End Immutable_PersonObj
