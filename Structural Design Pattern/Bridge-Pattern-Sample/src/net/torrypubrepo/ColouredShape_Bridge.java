package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class ColouredShape_Bridge implements Draw
{
    private Shapes shapes;
    private Colours colours;

    public ColouredShape_Bridge(Shapes shapes, Colours colours)
    {
        this.shapes = shapes; this.colours = colours;
    }

    @Override
    public String drawShape()
    {
        return "Drawing... :"+colours.getColor()+" "+shapes.getShape();
    }
}
