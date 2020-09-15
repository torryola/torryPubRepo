package net.torrypubrepo.Departmental_Hierarchy;

/*
 Created by Toriola Sep
 */

// Composite Leaf; does not have another leaf or branch e.g text file
public class DepartmentalMember implements UniversityStaff_Interface
{
    private int staffID;
    private String staffName;
    private String dept;
    public DepartmentalMember(int id, String name, String dept)
    {
        staffID = id; staffName = name; this.dept = dept;
    }

    @Override
    public String toString()
    {
        return  "staffID = " + staffID + ", staffName = " + staffName + ", dept = " + dept;
    }

    @Override
    public void getStaffDetails()
    {
        System.out.println("\t\t"+this.toString());

    }

}
