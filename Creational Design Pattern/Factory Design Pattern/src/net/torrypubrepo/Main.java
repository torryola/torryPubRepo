package net.torrypubrepo;

public class Main {

    public static void main(String[] args)
    {
        Students underGrad = StudentRegistrationFactory.getStudent("Undergraduate");
        underGrad.registerStudent();

        Students postGrad = StudentRegistrationFactory.getStudent("Postgraduate");
        postGrad.registerStudent();

        Students researchGrad = StudentRegistrationFactory.getStudent("Researcher");
        researchGrad.registerStudent();
    }
}
