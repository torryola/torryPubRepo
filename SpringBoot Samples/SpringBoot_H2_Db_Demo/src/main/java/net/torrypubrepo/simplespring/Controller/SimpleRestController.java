package net.torrypubrepo.simplespring.Controller;


import net.torrypubrepo.simplespring.DataModel.Feeds;
import net.torrypubrepo.simplespring.DbUtil.DataSourceConfig;
import net.torrypubrepo.simplespring.Services.FeedServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;



/*
    Created by Toriola in 2020
 In this Demo, we are going to demonstrate and practise basic CRUD operations in Spring Boot
 */
@RestController
public class SimpleRestController
{
    @Autowired
    private FeedServices feedServices;
    @Autowired
    private DataSourceConfig dataSourceConfig;
    
    private static List<String> userLists = new ArrayList<>();
    
    /* Get Method - Note that the parameter in the Url doesn't necessarily need to be same as the method Parameter name
    In this method url param is named name and the method param is named yourName
    */
    @RequestMapping(value="/welcome",method=RequestMethod.GET)
    public String getWelcomeMsg(@RequestParam(value = "name", required = false)
                                        String yourName)
    {
        return String.format(" Hello %s Welcome to Spring-Boot Controller Simple Demo ",
                Optional.of(yourName).orElse("Enter Your Name Please"));
    }//End getWelcomeMsg

    @RequestMapping(value = "/newUser", method=RequestMethod.POST)
    public Optional<List<String>> saveNewUser(@RequestParam(value = "user", required = true)
                                                      String sUser) {
        userLists.add(sUser);
        return Optional.ofNullable(userLists);
    }//End saveNewUser

    // Add New Feed
    @RequestMapping(value="/newFeed", method=RequestMethod.POST)
    public int addNew_Post(@RequestBody Feeds feeds)
    {
        return feedServices.addNew_Feed(feeds);
    }

    // Get Feeds
    @RequestMapping(value = "/feeds", method = RequestMethod.GET)
    public String getAllFeeds()
    {
        return feedServices.readAllFeeds().toString();
    }

    @RequestMapping(value = "/findFeed", method = RequestMethod.GET)
    public String findAFeed(@RequestParam(value = "id", required = true) int id)
    {
        return feedServices.findFeed_By_Id(id);
    }

    //Update
    @RequestMapping(value = "/updateFeed", method = RequestMethod.PUT)
    public String updateFeed(@RequestBody Feeds feeds)
    {
        return feedServices.updateFeed_By_Id(feeds);
    }

    //Delete
    @RequestMapping(value = "/delete")
    public String deleteAFeed(@RequestParam(value = "id", required = true) int id)
    {
        return feedServices.delete_Feed_By_Id(id);
    }

    // Profile Resource
    @RequestMapping(value = "/datasource")
    public String getDatasource_Profile()
    {
        String connect = null;
        try {
            connect = dataSourceConfig.getDataSource().getConnection() != null ? "Connected " : "No Connection";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //dataSourceConfig.toString();
        return String.format("Welcome to H2 Database Spring Boot Demo, You're %s", connect);
    }
    

}//End SimpleRestController
