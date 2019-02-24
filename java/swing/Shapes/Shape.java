package swing.Shapes;

import java.awt.*;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 20/Oct/2017
 */

public abstract class Shape
{
    Integer posX;
    Integer posY;
    
    /**
     * Abstract function that calculates the area of the shape
     * @return - the area as a Number
     */
    public abstract Number calcArea();
    
    /**
     * Abstract function that draws the shape on the screen
     * @param g - Graphics object
     */
    public abstract void draw(Graphics g);
    
    //------------------------- ACCESSORS -------------------------
    public Integer getPosX()
    {
        return posX;
    }
    
    public void setPosX(Integer posX)
    {
        this.posX = posX;
    }
    
    public Integer getPosY()
    {
        return posY;
    }
    
    public void setPosY(Integer posY)
    {
        this.posY = posY;
    }
}
