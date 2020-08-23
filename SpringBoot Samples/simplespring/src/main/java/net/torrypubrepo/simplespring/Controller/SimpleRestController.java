package net.torrypubrepo.simplespring.Controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*
 Demo on Get and Post rest controller in Spring Boot.
 */
@RestController
public class SimpleRestController
{
    private static List<String> userLists = new ArrayList<>();
    
    /* Get Method - Note that the parameter in the Url doesn't necessarily need to be same as the method Parameter name
    In this method url param is named name and the method param is named yourName
    */
    @RequestMapping(value="/welcome",method=RequestMethod.GET)
    public String getWelcomeMsg(@RequestParam(value = "name", required = false)
                                        String yourName)
    {
        return String.format(" Hello %s Welcome to Spring-Boot Controller Simple Demo ", Optional.of(yourName).orElse("Enter Your Name Please"));
    }//End getWelcomeMsg

    @RequestMapping(value = "/newUser", method=RequestMethod.POST)
    public Optional<List<String>> saveNewUser(@RequestParam(value = "user", required = true)
                                                      String sUser)
    {
        userLists.add(sUser);
        return Optional.ofNullable(userLists);
    }//End saveNewUser

}//End SimpleRestController
