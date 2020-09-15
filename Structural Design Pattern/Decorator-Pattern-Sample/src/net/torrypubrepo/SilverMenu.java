package net.torrypubrepo;

import java.util.ArrayList;
import java.util.List;

/*
 Created by Toriola Sep
 */
public class SilverMenu extends MenuDecorator
{
    // Reference to Component to Add more functionality to e.g. Basic Menu
    private MenuComponent component;
    private List<String> silverMenu;

    public SilverMenu(MenuComponent component)
    {
        super(component);
        this.component = component;
    }

    @Override
    public List<String> getMenu()
    {
        if (component != null)
        {
            silverMenu = new ArrayList<>(component.getMenu());
            // Add More Menu Items
            silverMenu.add("Comment");
            silverMenu.add("DeActivate");
        }
        return silverMenu;
    }
}
