package oop.Shop;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 08/Dec/2017
 */

public class Customer implements Runnable
{
    private String item;
    
    /**
     * Buy an item from the shop
     *
     * @param item - Item to buy
     */
    public void buy(String item)
    {
        this.item = item;
    }
    
    /**
     * Buy an item from the shop using a new thread
     */
    @Override
    public void run()
    {
        synchronized (Warehouse.stock)
        {
            if (item != null)
            {
                Warehouse.removeItem(this.item);
            }
        }
    }
}
