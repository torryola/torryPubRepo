package net.torrypubrepo.FileExplorer_Demo;

/*
 Created by Toriola Sep
 */
public class Client_Explorer
{
    public static void main(String[] args)
    {
        // Text Files
        FileOperations_Interface file1 = new SimpleFile("Hello.java");
        FileOperations_Interface file2 = new SimpleFile("SimpleText.txt");
        FileOperations_Interface file3 = new SimpleFile("Pojo.json");
        // Music Files
        FileOperations_Interface music1 = new SimpleFile("Hello.mp3");
        FileOperations_Interface music2 = new SimpleFile("Love.mp3");
        // Picture Files
        FileOperations_Interface pic1 = new SimpleFile("Holiday.jpeg");
        FileOperations_Interface pic2 = new SimpleFile("Car.jpeg");

        // Create Folders
        Folders home = new Folders("Home");
        Folders documentsFolder = new Folders("Documents");
        Folders musicFolder = new Folders("Music");
        Folders picFolder = new Folders("Picture");

        // Add Files to Matching Folders
        documentsFolder.add_SubMember(file1);
        documentsFolder.add_SubMember(file2);
        documentsFolder.add_SubMember(file3);

        musicFolder.add_SubMember(music1);
        musicFolder.add_SubMember(music2);

        picFolder.add_SubMember(pic1);
        picFolder.add_SubMember(pic2);

        // Create Sub Folders in Home Folder
        home.add_SubMember(documentsFolder);
        home.add_SubMember(musicFolder);
        home.add_SubMember(picFolder);

        // Show Home Folder Contents
        home.show_FileDetails();


    }
}
