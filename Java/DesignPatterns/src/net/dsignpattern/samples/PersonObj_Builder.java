package net.dsignpattern.samples;

import java.util.List;
/*
 Builder Pattern is used mostly with Immutable Objects but can be used with mutable objects as well.
 If you observe the code, it looks like un-identical twin of immutable pattern.
 Immutable obj doesn't have setters, Builder has setters.

 Builder pattern is a go to for Anti-pattern design problems in most cases
 */
public class PersonObj_Builder
{
    private String firstName;
    private String lastName;
    private int Age;
    private List<String> Hobbies;

    public PersonObj_Builder()
    {

    }

    public PersonObj_Builder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonObj_Builder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonObj_Builder setAge(int age) {
        Age = age;
        return this;
    }

    public PersonObj_Builder setHobbies(List<String> hobbies) {
        Hobbies = hobbies;
        return this;
    }

    public Immutable_PersonObj build()
    {
        return new Immutable_PersonObj(firstName, lastName, Age, Hobbies);
    }
}// End PersonObj_Builder
