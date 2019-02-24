package oop.Shapes;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public class Circle extends Shape
{
    protected int centerX;
    protected int centerY;
    protected int radius;
    
    /**
     * Constructor for the class Circle
     *
     * @param centerX - X coordinate of the center of the circle
     * @param centerY - Y coordinate of the center of the circle
     * @param radius - The radius of the circle
     */
    public Circle(int centerX, int centerY, int radius)
    {
        this.name = "circle";
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
    
    /**
     * Displays information about the circle, coordinates of the center and length of radius
     */
    @Override
    public void draw()
    {
        System.out.println("This is a circle with center (" + centerX + "," + centerY + ") and radius " + radius);
    }
}
