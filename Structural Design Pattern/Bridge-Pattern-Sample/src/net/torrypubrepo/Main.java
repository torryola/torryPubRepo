package net.torrypubrepo;

public class Main {

    public static void main(String[] args)
    {
        Shapes triangleShape = new TriangleShape();
        System.out.println("Shape :"+triangleShape.getShape());

        Colours colours = new GreenColour();
        System.out.println("Colour :"+colours.getColor());

        System.out.println("------- Green Triangle Shape --------");
        Draw draw = new ColouredShape_Bridge(triangleShape, colours);
        System.out.println("Colored Shape :"+draw.drawShape());

        System.out.println("------- Red Square Shape --------");
        Shapes square = new SquareShape();
        Colours red = new RedColour();
        System.out.println("Colored Shape :"+new ColouredShape_Bridge(square, red).drawShape());
    }
}
