package net.torrypubrepo;


import net.torrypubrepo.Course.Courses;
import net.torrypubrepo.Course.PostGradCourse;
import net.torrypubrepo.Factories.CourseRegistrationFactory;
import net.torrypubrepo.Factories.StudentCourseAbstractFactory;
import net.torrypubrepo.Factories.StudentCourseFactoryProducer;
import net.torrypubrepo.Factories.StudentRegistrationFactory;
import net.torrypubrepo.Student.Students;

public class Main {

    public static void main(String[] args)
    {

        // Produce Student Factory
        StudentRegistrationFactory studentRegistrationFactory = StudentCourseFactoryProducer.getStudentFactory();

        // Produce Course Factory
        CourseRegistrationFactory courseRegistrationFactory = StudentCourseFactoryProducer.getCourseFactory();


        Students underGrad = studentRegistrationFactory.getStudent("Undergraduate");
        underGrad.registerStudent();

        Students postGrad = studentRegistrationFactory.getStudent("Postgraduate");
        postGrad.registerStudent();

        Students researchGrad = studentRegistrationFactory.getStudent("Researcher");
        researchGrad.registerStudent();

        Courses postGradCourse = courseRegistrationFactory.selectCourse("PostGrad");
        postGradCourse.registerForCourse();
        Courses underGradCourse = courseRegistrationFactory.selectCourse("UnderGrad");
        underGradCourse.registerForCourse();
    }
}
