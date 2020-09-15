package net.torrypubrepo;

import java.util.List;

/*
 Created by Toriola Sep
 */
public abstract class MenuDecorator extends MenuComponent
{
    // This will point to the component to add functionality to
    private MenuComponent menuComponent;

    public MenuDecorator(MenuComponent component)
    {
        menuComponent = component;
    }

    @Override
    public abstract List<String> getMenu();
}
