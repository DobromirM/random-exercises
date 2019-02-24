package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 12/Oct/2017
 */
public class ColorfulSquare
{
    public static void main(String[] args)
    {
        FilledFrame frame = new FilledFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class FilledFrame extends JFrame
{
    //Initial size of Square panel (Also used for window size)
    int size = 400;
    
    //Initial color of Square panel
    Color color = Color.green;
    
    //Constructor
    public FilledFrame()
    {
        //Initialization of buttons
        JButton butSmall = new JButton("Small");
        JButton butMedium = new JButton("Medium");
        JButton butLarge = new JButton("Large");
        JButton butMessage = new JButton("Say Hi!");
        JButton butColor = new JButton("Change Color");
    
        //Adding action Listeners to the buttons for size
        butSmall.addActionListener(new ButtonHandlerSquare(this, 100));
        butMedium.addActionListener(new ButtonHandlerSquare(this, 250));
        butLarge.addActionListener(new ButtonHandlerSquare(this, 400));
        
        //Initialization of the panel for the green square
        SquarePanel panel = new SquarePanel(this);
    
        //Initialization of the panel for the buttons
        JPanel butPanel = new JPanel();
        
        //Adding the buttons to the panel
        butPanel.add(butSmall);
        butPanel.add(butMedium);
        butPanel.add(butLarge);
        butPanel.add(butMessage);
        butPanel.add(butColor);
        
        //Specifying the layout
        add(butPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        
        //Setting the size of the app window
        setSize(size + 100, size + 100);
        
        
        //Action listener for message button
        butMessage.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Hiiii");
            }
        });
    
        //Action listener for change color button
        butColor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                color = randomColor();
            }
        });
    }
    
    /**
     * Generates a random color
     *
     * @return - Random Color
     */
    private Color randomColor()
    {
        Integer red = (int)(Math.random()*256);
        Integer green = (int)(Math.random()*256);
        Integer blue = (int)(Math.random()*256);
        return new Color(red,green,blue);
    }
}


class SquarePanel extends JPanel
{
    //Reference to the main FilledFrame
    private FilledFrame theApp;
    
    //Constructor
    SquarePanel(FilledFrame app)
    {
        theApp = app;
    }
    
    //Paint the square on the screen using the size and color from the FilledFrame reference
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(theApp.color);
        g.fillRect(20, 20, theApp.size, theApp.size);
        theApp.repaint();
    }
}

class ButtonHandlerSquare implements ActionListener
{
    //Reference to the main FilledFrame
    private FilledFrame theApp;
    //Size of the square and window
    private Integer size;
    
    //Constructor
    ButtonHandlerSquare(FilledFrame app, Integer size)
    {
        theApp = app;
        this.size = size;
    }
    
    /**
     * Changes the size of the square and window
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        theApp.size = size;
    }
}