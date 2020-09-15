package net.torrypubrepo.Departmental_Hierarchy;

import java.util.ArrayList;
import java.util.List;

/*
 Created by Toriola Sep
 */
//Composite Branch : this can have leaf or another branch e.g. Parent Dir can have sub folders
public class Departmental_Dean implements UniversityStaff_Interface
{
    private int staffID;
    private String staffName;
    private String position;
    private List<UniversityStaff_Interface> DEPT_HEAD_LIST = new ArrayList<>();

    public Departmental_Dean(int id, String name, String title)
    {
        staffID = id; staffName = name; position = title;
    }

    public void add_New_DeptHead(UniversityStaff_Interface head)
    {
        DEPT_HEAD_LIST.add(head);
    }

    public void remove_Dept_Head(UniversityStaff_Interface head)
    {
        DEPT_HEAD_LIST.remove(head);
    }

    @Override
    public String toString()
    {
        return  "staffID = " + staffID +
                " staffName = " + staffName +
                " position= " + position;
    }

    @Override
    public void getStaffDetails()
    {
        System.out.println("************* Dean of Tech ************** ");
        System.out.println(this.toString());
        for (int i =0; i < 3; i++)
            System.out.println("|");
        for (UniversityStaff_Interface subMember : DEPT_HEAD_LIST)
        {
            System.out.print("\t");
            subMember.getStaffDetails();

        }

    }

}
