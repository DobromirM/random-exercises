package swing.Shapes;

import java.awt.*;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 20/Oct/2017
 */
public class Circle extends Shape
{
    private Integer radius;
    
    Circle(Integer posX, Integer posY, Integer radius)
    {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }
    
    /**
     * Calculates the area of the circle
     * @return - the area of the circle as type Double
     */
    public Double calcArea()
    {
        return Math.PI * radius * radius;
    }
    
    /**
     * Draws the circle on the screen
     * @param g - Graphics object
     */
    public void draw( Graphics g)
    {
        g.setColor(Color.PINK);
        g.fillOval(getPosX(), getPosY(), getRadius(), getRadius());
    }
    
    //------------------------- ACCESSORS -------------------------
    public Integer getRadius()
    {
        return radius;
    }
    
    public void setRadius(Integer radius)
    {
        this.radius = radius;
    }
}
