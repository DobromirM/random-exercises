package oop.Shapes;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public class Main
{
    
    public static void main(String[] args)
    {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(300, 100, 20);
        shapes[1] = new Rectangle(100, 100, 40, 60);
        
        for (Shape shape : shapes)
        {
            shape.printName();
            shape.draw();
        }
    }
}
