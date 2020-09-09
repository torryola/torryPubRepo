package net.webuildapp.torrypubrepo.swipeit;

/*
 Mock Obj for our Demo
 */

public class Feeds
{
    private int id; // Feed Id
    private String feedTitle; // Title for a feed
    private String feedContent; // Body/Content of the Feed
    private String feedDateTime; // Date and Time Posted

    public Feeds()
    {

    }

    // Constructor
    public Feeds(String feedTitle, String feedContent, String feedDateTime)
    {
        this.feedTitle = feedTitle;
        this.feedContent = feedContent; this.feedDateTime = feedDateTime;

    }//End Constructor

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFeedTitle() {
        return feedTitle;
    }

    public String getFeedContent() {
        return feedContent;
    }

    public String getFeedDateTime() {
        return feedDateTime;
    }

    @Override
    public String toString()
    {
        return "Feeds{" +
                "id=" + id +
                ", feedTitle='" + feedTitle + '\'' +
                ", feedContent='" + feedContent + '\'' +
                ", feedDateTime='" + feedDateTime + '\'' +
                '}';
    }
}//End Feeds
