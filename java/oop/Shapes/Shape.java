package oop.Shapes;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public abstract class Shape
{
    protected String name = "shape";
    protected String color = "black";
    
    /**
     *  Displays the name of the shape
     */
    public void printName()
    {
        System.out.println("I am a " + color + " " + name);
    }
    
    /**
     * Displays information about the shape
     */
    public abstract void draw();
}
