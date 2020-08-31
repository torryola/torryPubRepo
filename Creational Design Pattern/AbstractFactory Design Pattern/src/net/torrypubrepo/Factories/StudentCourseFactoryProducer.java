package net.torrypubrepo.Factories;

import net.torrypubrepo.Factories.CourseRegistrationFactory;
import net.torrypubrepo.Factories.StudentRegistrationFactory;

/*
 Created by Toriola in 2020
 */
public class StudentCourseFactoryProducer
{
    public static final String STUDENT = "Student";
    public static final String COURSE = "Course";

    public static StudentRegistrationFactory getStudentFactory()
    {
        return new StudentRegistrationFactory();
    }

    public static CourseRegistrationFactory getCourseFactory()
    {
        return new CourseRegistrationFactory();
    }
}
