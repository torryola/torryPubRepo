package net.torrypubrepo.Departmental_Hierarchy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Supplier;

/*
 Created by Toriola Sep
 */
public class Department implements UniversityDepartment_Dir_Interface
{
    private String departmentName;
    private final List<DepartmentalMember> DEPARTMENTAL_MEMBER_LIST = new ArrayList<>();
    private static final Supplier<TreeMap<String, String>> SET_OF_DEPT = TreeMap<String, String>::new;
    private TreeMap<String, String> COLLECTIONS_OF_DEPT = SET_OF_DEPT.get();

    public void addMember(DepartmentalMember member)
    {
        DEPARTMENTAL_MEMBER_LIST.add(member);
    }

    public void removeMember(DepartmentalMember member)
    {
        DEPARTMENTAL_MEMBER_LIST.remove(member);
    }

    @Override
    public void set_Dept(String dept)
    {
        COLLECTIONS_OF_DEPT.put(dept, dept+" Department");
    }

    @Override
    public String getDepartment(String dept)
    {
       return COLLECTIONS_OF_DEPT.get(dept);
    }

    @Override
    public boolean deleteDept(String dept)
    {
        COLLECTIONS_OF_DEPT.remove(dept);
        // check if removed successfully;
        return COLLECTIONS_OF_DEPT.containsKey(dept);
    }

    @Override
    public void getDepartment_Details()
    {
        System.out.println("************** Welcome to "+departmentName+" **********************");
        DEPARTMENTAL_MEMBER_LIST.forEach(member -> member.getStaffDetails());

    }
}
