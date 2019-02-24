package swing.Shapes;

import java.awt.*;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 20/Oct/2017
 */

public class Square extends Shape
{
    private Integer sideLength;
    
    Square(Integer posX, Integer posY, Integer sideLength)
    {
        this.posX = posX;
        this.posY = posY;
        this.sideLength = sideLength;
    }
    
    /**
     * Calculates the area of the square
     * @return - the area of the square as type Integer
     */
    public Integer calcArea()
    {
        return sideLength * sideLength;
    }
    
    /**
     * Draws the square on the screen
     * @param g - Graphics object
     */
    public void draw( Graphics g )
    {
        g.setColor(Color.PINK);
        g.fillRect(getPosX(), getPosY(), getSideLength(), getSideLength());
    }
    
    //------------------------- ACCESSORS -------------------------
    public Integer getSideLength()
    {
        return sideLength;
    }
    
    public void setSideLength(Integer sideLength)
    {
        this.sideLength = sideLength;
    }
    
}
