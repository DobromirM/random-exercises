package oop.Shop;


import javax.swing.*;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 08/Dec/2017
 */

public class Main
{
    public static void main(String[] args)
    {
        Shop frame = new Shop();
        frame.setTitle("Shop");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
