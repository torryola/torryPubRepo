package net.torrypubrepo;

import java.util.ArrayList;
import java.util.List;

/*
 Created by Toriola Sep
 */
public class GoldMenu extends MenuDecorator
{
    // Reference to Component to Add more functionality to e.g. Silver Menu
    private MenuComponent component;
    private List<String> goldMenu;

    public GoldMenu(MenuComponent component)
    {
        super(component);
        this.component = component;
    }

    @Override
    public List<String> getMenu()
    {
        if (component != null)
        {
            goldMenu = new ArrayList<>(component.getMenu());
            // Add More Menu Items
            goldMenu.add("Block Ads");
        }
        return goldMenu;
    }
}