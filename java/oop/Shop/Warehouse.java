package oop.Shop;

import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 08/Dec/2017
 */

public class Warehouse
{
    public static final Map<String, Integer> stock = new HashMap<>();
    
    /**
     * Add an item to the inventory, if it exist increment the count for the item in the inventory
     *
     * @param item - Item to be added
     */
    public static void addItem(String item)
    {
        Integer count = stock.get(item);
        count = count == null ? 1 : count + 1;
        stock.put(item, count);
    }
    
    /**
     * Remove an item from the inventory, if it has more than one decrement the count
     *
     * @param item - Item to be removed
     */
    public static void removeItem(String item)
    {
        Integer count = stock.get(item);
        if (count != null)
        {
            if (count == 1)
            {
                stock.remove(item);
            }
            else
            {
                count--;
                stock.put(item, count);
            }
        }
    }
}
