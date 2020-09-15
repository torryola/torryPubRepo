package net.torrypubrepo.Departmental_Hierarchy;

import java.util.ArrayList;
import java.util.List;

/*
 Created by Toriola Sep
 */
// Composite Branch : this can have leaf or another branch e.g. subFolder can have another folder
public class Departmental_Head implements UniversityStaff_Interface
{
    private int staffID;
    private String staffName;
    private String department;
    private List<UniversityStaff_Interface> MEMBER_LIST = new ArrayList<>();

    public Departmental_Head(int id, String name, String dept)
    {
        staffID = id; staffName = name; department = dept;
    }

    public void add_Member(UniversityStaff_Interface member)
    {
        MEMBER_LIST.add(member);
    }

    public void remove_Member(UniversityStaff_Interface member)
    {
        MEMBER_LIST.remove(member);
    }

    @Override
    public String toString()
    {
        return  "staffID = " + staffID +
                " staffName = " + staffName;
    }

    @Override
    public void getStaffDetails()
    {
        System.out.println("************* Chair of "+department+" ********************");
        System.out.println("\t"+this.toString());
        for (int i =0; i < 3; i++)
            System.out.println("\t|");
        System.out.println("\t\t************* Members **************** ");
        for (UniversityStaff_Interface member : MEMBER_LIST) {
            member.getStaffDetails();
        }


    }

}
