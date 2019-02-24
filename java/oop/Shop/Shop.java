package oop.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 08/Dec/2017
 */

class Shop extends JFrame
{
    //JLabel for displaying the message in the middle panel
    private JLabel messageLabel;
    
    //Actions for the buttons
    private static final Integer BUY = 1;
    private static final Integer RESTOCK = 2;
    
    //Text fields for Buy and Sell
    private JTextField textFieldBuy = new JTextField(10);
    private JTextField textFieldRestock = new JTextField(10);
    
    private Manager manager = new Manager();
    private Customer customer = new Customer();
    
    Shop()
    {
        //Panels creation
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        middlePanel.setLayout(new GridBagLayout());
        
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel);
        add(bottomPanel, BorderLayout.SOUTH);
        
        //Buttons creation
        JButton butBuy = new JButton("Buy");
        JButton butRestock = new JButton("Restock");
        
        butBuy.addActionListener(new ButtonHandler(this, BUY));
        butRestock.addActionListener(new ButtonHandler(this, RESTOCK));
        
        topPanel.add(butBuy);
        topPanel.add(butRestock);
        
        bottomPanel.add(textFieldBuy);
        bottomPanel.add(textFieldRestock);
        
        messageLabel = new JLabel(Utilities.displayInventory(Warehouse.stock));
        middlePanel.add(messageLabel);
        
        //App settings
        Integer appHeight = 200;
        Integer appWidth = 500;
        setSize(appWidth, appHeight);
        
        //Repaint the frame every 20 ms
        Timer timer = new Timer(20, e -> {
            messageLabel.setText(Utilities.displayInventory(Warehouse.stock));
            repaint();
        });
        
        timer.start();
    }
    
    class ButtonHandler implements ActionListener
    {
        private Shop theApp;
        private Integer action;
        
        ButtonHandler(Shop app, Integer action)
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
            if (Objects.equals(action, BUY))
            {
                String item = theApp.textFieldBuy.getText();
                if (!item.equals(""))
                {
                    theApp.customer.buy(item);
                    new Thread(theApp.customer).start();
                }
            }
            if (Objects.equals(action, RESTOCK))
            {
                String item = theApp.textFieldRestock.getText();
                if (!item.equals(""))
                {
                    theApp.manager.restock(item);
                    new Thread(theApp.manager).start();
                }
            }
        }
    }
}
