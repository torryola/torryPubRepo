package net.torrypubrepo.Departmental_Hierarchy;

import net.torrypubrepo.Departmental_Hierarchy.*;

public class Main_Campus {

    public static void main(String[] args)
    {
        // Create Departments
        UniversityDepartment_Dir_Interface mathDept = new Department();
        mathDept.set_Dept("Maths");

        UniversityDepartment_Dir_Interface compDept = new Department();
        compDept.set_Dept("Computer");

        String maths = mathDept.getDepartment("Maths");
        String comp = compDept.getDepartment("Computer");
        // Maths Dept
        UniversityStaff_Interface mathStaff = new DepartmentalMember(100, "Matt", maths);
        UniversityStaff_Interface mathStaff2 = new DepartmentalMember(106, "Jason", maths);

        // Computer Dept
        UniversityStaff_Interface compStaff = new DepartmentalMember(101, "James", comp);
        UniversityStaff_Interface compStaff2 = new DepartmentalMember(105, "Malcom", comp);

        // Maths Dept Head
        Departmental_Head mathHead = new Departmental_Head(102, "Peter", maths);
        // Add member
        mathHead.add_Member(mathStaff);
        mathHead.add_Member(mathStaff2);

        // Computer Dept Head
        Departmental_Head compHead = new Departmental_Head(103, "Charles", comp);
        // Add member
        compHead.add_Member(compStaff);
        compHead.add_Member(compStaff2);

        // Dean of Tech
        Departmental_Dean deanOfTech = new Departmental_Dean(104, "Jason", "Head of Tech");
        // Add Head
        deanOfTech.add_New_DeptHead(compHead);
        deanOfTech.add_New_DeptHead(mathHead);

        deanOfTech.getStaffDetails();
    }
}
