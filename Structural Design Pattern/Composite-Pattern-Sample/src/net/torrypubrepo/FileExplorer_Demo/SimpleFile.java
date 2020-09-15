package net.torrypubrepo.FileExplorer_Demo;

import java.time.LocalDateTime;
import java.util.Random;

/*
 Created by Toriola Sep
 */
// This is the Leaf, does not contains another member
public class SimpleFile implements FileOperations_Interface
{
    // Basic File Variables
    private String fileName;
    private String dateCreated;
    private int size;

    // Constructor
    public SimpleFile(String name)
    {
        fileName = name;
        dateCreated = LocalDateTime.now().toString();
        size = new Random().nextInt(5);
    }

    @Override
    public void show_FileDetails()
    {
        System.out.println("\t\tFile Name : "+fileName +
                " Size :"+size+"MB"+
                " Date Created : "+dateCreated);

    }
}
