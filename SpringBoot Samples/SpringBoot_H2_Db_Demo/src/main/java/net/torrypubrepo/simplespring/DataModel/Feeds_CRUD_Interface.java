package net.torrypubrepo.simplespring.DataModel;

/*
 Created by Toriola in 2020
 The interface will be used by our Service Class
 */

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public interface Feeds_CRUD_Interface
{
    // Create
    public abstract int addNew_Feed(Feeds feeds);
    // Read
    public abstract String findFeed_By_Id(int id);
    //Update
    public abstract String updateFeed_By_Id(Feeds feeds);
    //Delete
    public abstract String delete_Feed_By_Id(int id);
    //Read Feeds
    public abstract HashMap<Integer, Object> readAllFeeds();

}//End Feeds_CRUD_Interface
