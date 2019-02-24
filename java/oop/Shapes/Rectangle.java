package oop.Shapes;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public class Rectangle extends Shape
{
    protected int leftCornerX;
    protected int leftCornerY;
    protected int height;
    protected int width;
    
    /**
     * Constructor for the class Rectangle
     *
     * @param leftCornerX - X coordinate of the left corner of the rectangle
     * @param leftCornerY - Y coordinate of the left corner of the rectangle
     * @param height - Height of the rectangle
     * @param width - Width of the rectangle
     */
    public Rectangle(int leftCornerX, int leftCornerY, int height, int width)
    {
        this.name = "rectangle";
        this.leftCornerX = leftCornerX;
        this.leftCornerY = leftCornerY;
        this.height = height;
        this.width = width;
    }
    
    /**
     * Displays information about the rectangle, coordinates of the left corner, the height and the width of the rectangle.
     */
    @Override
    public void draw()
    {
        System.out.println("This is a rectangle with left corner at (" + leftCornerX + "," + leftCornerY + ") with height " + height + " and width " + width);
    }
}
