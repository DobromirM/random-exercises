package oop.Shop;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 08/Dec/2017
 */

public class Manager implements Runnable
{
    private String item;
    
    /**
     * Add the item to be restocked
     *
     * @param item - Item to be restocked
     */
    public void restock(String item)
    {
        this.item = item;
    }
    
    /**
     * Add an item to the inventory using a new thread
     */
    @Override
    public void run()
    {
        synchronized (Warehouse.stock)
        {
            if (item != null)
            {
                Warehouse.addItem(this.item);
            }
        }
    }
}
