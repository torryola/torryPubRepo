package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class SquareShape extends Shapes
{
    private static final String SQUARE_SHAPE = "Square";

    public SquareShape()
    {
        super(SQUARE_SHAPE);
    }

    @Override
    public String getShape() {
        return SQUARE_SHAPE;
    }
}
