package net.torrypubrepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Created by Toriola Sep
 */
public class BasicMenu extends MenuComponent
{
    private List<String> basicMenuList = new ArrayList<>(Arrays.asList("Login", "Edit Profile", "Log Out"));

    @Override
    public List<String> getMenu()
    {
        return basicMenuList;
    }
}
