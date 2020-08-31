package net.torrypubrepo.Factories;

import net.torrypubrepo.Course.Courses;
import net.torrypubrepo.Course.PostGradCourse;
import net.torrypubrepo.Course.UnderGradCourse;

/*
 Created by Toriola in 2020
 */
public class CourseRegistrationFactory
{
    public static Courses selectCourse(String courseCategory)
    {
        if (courseCategory == null)
            throw new RuntimeException("Choose a Valid Course");
        else if(courseCategory.equalsIgnoreCase("UnderGrad"))
            return new UnderGradCourse();
        else if (courseCategory.equalsIgnoreCase("PostGrad"))
            return new PostGradCourse();
        else
            return null;
    }

}
