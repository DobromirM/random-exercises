package swing.Shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 20/Oct/2017
 */
class DrawCalc extends JFrame
{
    //Create variables for square, circle, and a shape
    Square square;
    Circle circle;
    Shape shape;
    
    //Create a text field 
    JTextField textField = new JTextField(10);
    
    public DrawCalc()
    {
        //Initialize the square and circle and set the default shape to square
        square = new Square(10, 10, 0);
        circle = new Circle(10, 10, 0);
        shape = square;
        
        //Create the two panels
        JPanel firstPanel = new JPanel()
        {
            public void paintComponent(Graphics graph)
            {
                shape.draw(graph);
            }
        };
        
        JPanel secondPanel = new JPanel();
        
        //Add the panels to the frame
        add(firstPanel, BorderLayout.CENTER);
        add(secondPanel, BorderLayout.SOUTH);
        
        //Create the buttons
        JButton butSquareSet = new JButton("set square");
        JButton butCircleSet = new JButton("set circle");
        JButton calcArea = new JButton("calc area");
        JButton butClear = new JButton("clear");
        
        //Add the action listener to the buttons
        butSquareSet.addActionListener(new ButtonHandler(this, 1));
        butCircleSet.addActionListener(new ButtonHandler(this, 2));
        calcArea.addActionListener(new ButtonHandler(this, 3));
        butClear.addActionListener(new ButtonHandler(this, 4));
        
        //Add the elements to the second panel
        secondPanel.add(textField);
        secondPanel.add(butSquareSet);
        secondPanel.add(butCircleSet);
        secondPanel.add(calcArea);
        secondPanel.add(butClear);
        
        //Size of the app window
        setSize(700, 700);
    }
}

class ButtonHandler implements ActionListener
{
    private DrawCalc theApp;
    private Integer action;
    
    //Constructor
    ButtonHandler(DrawCalc app, Integer action)
    {
        theApp = app;
        this.action = action;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            //Sets the parameters of the square and sets the shape reference to the square
            if (action == 1)
            {
                Integer length = Integer.parseInt(theApp.textField.getText());
                theApp.square.setSideLength(length);
                theApp.shape = theApp.square;
                theApp.repaint();
            }
            //Sets the parameters of the circle and sets the shape reference to the circle
            if (action == 2)
            {
                Integer length = Integer.parseInt(theApp.textField.getText());
                theApp.circle.setRadius(length);
                theApp.shape = theApp.circle;
                theApp.repaint();
            }
            //Displays the area of the current shape in a new window
            if (action == 3)
            {
                String area = theApp.shape.calcArea().toString();
                JOptionPane.showMessageDialog(theApp, area, "Area", JOptionPane.INFORMATION_MESSAGE);
            }
            //Clears the text field
            if (action == 4)
            {
                theApp.textField.setText("");
            }
        }
        //If there is an NumberFormatException clear the text field
        catch (NumberFormatException numE)
        {
            theApp.textField.setText("");
        }
    }
}
