package oop.Shop;

import java.util.Map;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 09/Dec/2017
 */

public class Utilities
{
    /**
     * Display the contents of a map in a user - friendly format
     *
     * @param inventory - Map of items to be displayed
     *
     * @return - User - friendly string of the contents
     */
    public static String displayInventory(Map<String, Integer> inventory)
    {
        StringBuilder display = new StringBuilder();
        
        for (Map.Entry<String, Integer> item : inventory.entrySet())
        {
            display.append(item.getKey()).append(": ").append(item.getValue()).append(" ");
        }
        
        return display.toString();
    }
}
