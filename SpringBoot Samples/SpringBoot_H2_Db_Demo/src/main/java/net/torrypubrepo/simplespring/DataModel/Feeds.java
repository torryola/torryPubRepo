package net.torrypubrepo.simplespring.DataModel;

import org.springframework.stereotype.Component;

/*
 Mock Obj for our Demo
 */
@Component
public class Feeds
{
    private int id; // Feed Id
    private String userId;
    private String feedTitle; // Title for a feed
    private String feedContent; // Body/Content of the Feed
    private String feedDateTime; // Date and Time Posted

    public Feeds()
    {

    }

    // Constructor
    public Feeds(String uID, String feedTitle, String feedContent)
    {
        this.userId = uID; this.feedTitle = feedTitle;
        this.feedContent = feedContent; //this.feedDateTime = feedDateTime;

    }//End Constructor

    // Constructor
    public Feeds(String uID, String feedTitle, String feedContent, String feedDateTime)
    {
        this.userId = uID; this.feedTitle = feedTitle;
        this.feedContent = feedContent; this.feedDateTime = feedDateTime;

    }//End Constructor

    public String getUserId() {
        return userId;
    }

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
                ", userId='" + userId + '\'' +
                ", feedTitle='" + feedTitle + '\'' +
                ", feedContent='" + feedContent + '\'' +
                ", feedDateTime='" + feedDateTime + '\'' +
                '}';

    }// End toString()

}//End Feeds
