package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class TriangleShape extends Shapes
{
    private static final String TRIANGLE_SHAPE = "Triangle";

    public TriangleShape()
    {
        super(TRIANGLE_SHAPE);
    }
    @Override
    public String getShape() {
        return TRIANGLE_SHAPE;
    }
}
