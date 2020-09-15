package net.torrypubrepo.FileExplorer_Demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/*
 Created by Toriola Sep
 */
// This is th composite - can contains other member
public class Folders implements FileOperations_Interface
{
    // Basic Folder Details
    private String folderName;
    private String dateCreate;
    // Sub Folders
    private Supplier<List<FileOperations_Interface>> memberSupplier = ArrayList::new;
    private List<FileOperations_Interface> memberList = memberSupplier.get();
    // Constructor
    public Folders(String name)
    {
        folderName = name; dateCreate = LocalDateTime.now().toString();
    }

    // Add Member
    public void add_SubMember(FileOperations_Interface member)
    {
        memberList.add(member);
    }

    // Remove Member
    public boolean delete_SubMember(FileOperations_Interface member)
    {
        return memberList.remove(member);
    }

    @Override
    public void show_FileDetails()
    {
       // System.out.println("************** Folder Details ******************");
        System.out.println("\tName : "+folderName +" Size : "+memberList.size()+ " Date Created : "+dateCreate);
        System.out.println("\t\t ************ Contents ***************");
        for (FileOperations_Interface member : memberList) {
            //System.out.print("\t");
            member.show_FileDetails();
        }
    }
}
