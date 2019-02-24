package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 26/Oct/2017
 */

public class ColorfulName
{
    public static void main(String[] args)
    {
        DetailsApplication frame = new DetailsApplication();
        frame.setTitle("Colorful Name");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class DetailsApplication extends JFrame
{
    //JLabel for displaying the message in the middle panel
    private JLabel messageLabel;
    //The default color of the message
    private Color defaultColor = Color.blue;
    //The default text for the message
    private String defaultMessage = "Welcome!";
    
    //Text fields for Red, Green and Blue
    private JTextField textFieldRed = new JTextField(10);
    private JTextField textFieldGreen = new JTextField(10);
    private JTextField textFieldBlue = new JTextField(10);
    
    //Actions for the buttons
    private static final Integer INVALID = -1;
    private static final Integer SET_COLOR = 1;
    private static final Integer RESET = 2;
    
    DetailsApplication()
    {
        
        messageLabel = new JLabel(defaultMessage);
        
        messageLabel.setForeground(defaultColor);
        
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        add(topPanel, BorderLayout.NORTH);
        middlePanel.setLayout(new GridBagLayout());
        add(middlePanel);
        add(bottomPanel, BorderLayout.SOUTH);
        
        JButton butSetColor = new JButton("Set Color");
        JButton butReset = new JButton("Reset");
        
        butSetColor.addActionListener(new ButtonHandler(this, SET_COLOR));
        butReset.addActionListener(new ButtonHandler(this, RESET));
        
        topPanel.add(butReset);
        middlePanel.add(messageLabel);
        bottomPanel.add(textFieldRed);
        bottomPanel.add(textFieldGreen);
        bottomPanel.add(textFieldBlue);
        bottomPanel.add(butSetColor);
        
        Integer appSize = 500;
        setSize(appSize, appSize);
    }
    
    class ButtonHandler implements ActionListener
    {
        //References to the app
        private DetailsApplication theApp;
        //Current action
        private Integer action;
        
        ButtonHandler(DetailsApplication app, Integer action)
        {
            theApp = app;
            this.action = action;
        }
        
        /**
         * Handle button actions
         *
         * @param e - Action event
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (Objects.equals(action, SET_COLOR))
            {
                Integer red = convertInput(theApp.textFieldRed);
                Integer green = convertInput(theApp.textFieldGreen);
                Integer blue = convertInput(theApp.textFieldBlue);
                
                if (isValidColor(red, green, blue))
                {
                    messageLabel.setForeground(new Color(red, green, blue));
                    messageLabel.setText("Dobromir Marinov");
                }
                else
                {
                    messageLabel.setText("Please enter integers only!");
                }
                
                theApp.repaint();
            }
            if (Objects.equals(action, RESET))
            {
                messageLabel.setForeground(defaultColor);
                messageLabel.setText(defaultMessage);
                textFieldRed.setText("");
                textFieldGreen.setText("");
                textFieldBlue.setText("");
                theApp.repaint();
            }
        }
        
        //-----------------UTILITIES-------------------
        
        /**
         * Fix the integer to be in the range between 0 and 255
         * Set 200 for less than 0 and 255 for anything above 255
         *
         * @param integer - Initial integer
         *
         * @return - Fixed integer
         */
        private Integer fixRange(Integer integer)
        {
            if (integer < 0)
            {
                return 200;
            }
            if (integer > 255)
            {
                return 255;
            }
            return integer;
        }
        
        /**
         * Handle the user input converting it to an integer after validation
         *
         * @param textField - User input
         *
         * @return - The integer if it is correct, -1 if it is invalid
         */
        private Integer convertInput(JTextField textField)
        {
            try
            {
                Integer value = fixRange(Integer.parseInt(textField.getText()));
                textField.setText(value.toString());
                return value;
            }
            catch (Exception e)
            {
                textField.setText("");
                return INVALID;
            }
        }
        
        /**
         * Check if the integers correspond to valid color
         *
         * @param r - value of red
         * @param g - value of green
         * @param b - value of blue
         *
         * @return - Boolean result
         */
        private Boolean isValidColor(Integer r, Integer g, Integer b)
        {
            return r != -1 && g != -1 && b != -1;
        }
    }
}
