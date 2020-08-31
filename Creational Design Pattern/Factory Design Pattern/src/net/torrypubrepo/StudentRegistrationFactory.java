package net.torrypubrepo;

/*
 Created by Toriola in 2020
 */
public class StudentRegistrationFactory
{
    public static Students getStudent(String studentType)
    {
        if (studentType == null)
            throw new RuntimeException("You must specify your student category");
        else if (studentType.equalsIgnoreCase("Undergraduate"))
            return new UnderGraduateStudent();
        else if (studentType.equalsIgnoreCase("Postgraduate"))
            return new PostGraduateStudent();
        else if (studentType.equalsIgnoreCase("Researcher"))
            return new ResearchStudent();
        else
            return null;
    }
}
