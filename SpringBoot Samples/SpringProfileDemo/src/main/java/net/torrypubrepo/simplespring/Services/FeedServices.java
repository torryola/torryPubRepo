package net.torrypubrepo.simplespring.Services;

/*
 Created by Toriola in 2020
 */

import net.torrypubrepo.simplespring.DataModel.Feeds;
import net.torrypubrepo.simplespring.DataModel.Feeds_CRUD_Interface;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Service
public class FeedServices implements Feeds_CRUD_Interface
{
    private static HashMap<Integer, Object> feedMaps = new HashMap<>();

    @Override
    public int addNew_Feed(Feeds feeds)
    {
        // Check for null
        if (feeds == null)
            throw new RuntimeException("Post Something Interesting");
        int id = feeds.getId();
        feeds.setId(id);
        feedMaps.put(id, feeds);
        return id;
    }

    @Override
    public String findFeed_By_Id(int id) {
        return feedMaps.get(id).toString();
    }

    @Override
    public String updateFeed_By_Id(Feeds feeds)
    {
        return feedMaps.replace(feeds.getId(),feeds).toString();
    }

    @Override
    public String delete_Feed_By_Id(int id) {
        return feedMaps.remove(id).toString();
    }

    @Override
    public HashMap<Integer, Object> readAllFeeds()
    {
        //BiConsumer<Integer, Object> allFeeds = (id, obj) -> System.out.println(obj.toString());
        //feedMaps.forEach(allFeeds);
        return feedMaps;
    }
}//End FeedServices
