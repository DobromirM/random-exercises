package oop.PizzaOrder;

import java.util.*;

/**
 * Created on: 18/Apr/2017
 *
 * @author Dobromir
 */

public class PizzaOrder
{
    
    public static void main(String[] args)
    {
        System.out.println("\nExecuting pizzaServiceA()...");
        pizzaServiceA();
        System.out.println("\nExecuting pizzaServiceB()...");
        pizzaServiceB();
    }
    
    public static void pizzaServiceA()
    {
        Map<Character, Map> menu = new HashMap<>();
        setUpMenu(menu);
        Scanner scanner = new Scanner(System.in);
        
        while (true)
        {
            
            System.out.print("Please enter your order:");
            String order = scanner.next();
            
            if (Objects.equals(order, "quit"))
            {
                System.out.println("Hope to see you again!");
                break;
            }
            
            if (verifyOrder(order, false))
            {
                displayOrder(menu, order);
            }
        }
    }
    
    public static void pizzaServiceB()
    {
        Map<Character, Map> menu = new HashMap<>();
        setUpMenu(menu);
        Scanner scanner = new Scanner(System.in);
        
        while (true)
        {
            
            System.out.print("Please enter your order:");
            String order = scanner.next();
            
            if (Objects.equals(order, "quit"))
            {
                System.out.println("Hope to see you again!");
                break;
            }
            
            if (verifyOrder(order, true))
            {
                displayOrder(menu, order);
            }
        }
    }
    
    /**
     * Set up the main menu with items and prices
     */
    private static void setUpMenu(Map<Character, Map> menu)
    {
        
        Map<Character, Double> medium = new HashMap<>();
        medium.put('h', 1.40);
        medium.put('m', 1.00);
        medium.put('o', 0.80);
        medium.put('p', 1.00);
        medium.put('s', 0.80);
        
        menu.put('m', medium);
        
        Map<Character, Double> large = new HashMap<>();
        large.put('h', 2.10);
        large.put('m', 1.50);
        large.put('o', 1.20);
        large.put('p', 1.50);
        large.put('s', 1.20);
        
        menu.put('l', large);
        
        Map<Character, String> names = new HashMap<>();
        names.put('h', "ham");
        names.put('m', "mozzarella");
        names.put('o', "olives");
        names.put('p', "pineapple");
        names.put('s', "spinach");
        
        menu.put('n', names);
    }
    
    /**
     * Verify if the order is correct
     *
     * @param order            - String with the order
     * @param restrictToppings - Boolean, set to true if you want a topping to appear twice at most
     *
     * @return - boolean
     */
    private static boolean verifyOrder(String order, boolean restrictToppings)
    {
        List<Character> validToppings = new ArrayList<>();
        validToppings.add('h');
        validToppings.add('m');
        validToppings.add('o');
        validToppings.add('p');
        validToppings.add('s');
        
        if (order.charAt(0) != 'm' && order.charAt(0) != 'l')
        {
            System.out.println("Please enter valid size for your pizza!");
            return false;
        }
        else if (order.length() > 5)
        {
            System.out.println("Please enter 4 toppings at most!");
            return false;
        }
        else
        {
            int totalCount = 0;
            for (Character c : validToppings)
            {
                int toppingCount = 0;
                
                for (int i = 1; i < order.length(); i++)
                {
                    if (c == order.charAt(i))
                    {
                        toppingCount = toppingCount + 1;
                    }
                }
                
                totalCount = totalCount + toppingCount;
                
                if (toppingCount > 2 && restrictToppings)
                {
                    System.out.println("You cannot select the same topping more than twice!");
                    return false;
                }
            }
            
            if (totalCount != order.length() - 1)
            {
                System.out.println("Please enter only valid toppings!");
                return false;
            }
            
            return true;
        }
    }
    
    /**
     * Construct the full order and calculate the price
     *
     * @param order - String with the order
     */
    private static Order constructOrder(String order, Map<Character, Map> menu)
    {
        String toppings = "";
        Double toppingsPrice = 0.00;
        
        if (order.length() == 1)
        {
            toppings = "no toppings ";
        }
        else
        {
            Character size = order.charAt(0);
            for (int i = 1; i < order.length(); i++)
            {
                Character top = order.charAt(i);
                toppings = toppings + menu.get('n').get(top) + ", ";
                toppingsPrice = toppingsPrice + (Double) menu.get(size).get(top);
            }
        }
        
        return new Order(toppings, toppingsPrice);
    }
    
    /**
     * Display the order
     *
     * @param menu  - The menu
     * @param order - The order
     */
    private static void displayOrder(Map<Character, Map> menu, String order)
    {
        Double fullPrice;
        String fullOrder;
        Order orderObj;
        
        if (order.charAt(0) == 'm')
        {
            fullOrder = "Medium pizza with ";
            fullPrice = 4.00;
            orderObj = constructOrder(order, menu);
        }
        else
        {
            fullOrder = "Large pizza with ";
            fullPrice = 5.00;
            orderObj = constructOrder(order, menu);
        }
        fullPrice = fullPrice + orderObj.price;
        fullOrder = fullOrder + orderObj.order + "£" + String.format("%.2f", fullPrice);
        
        System.out.println(fullOrder);
    }
    
    /**
     * Simple class for our order object
     */
    private static class Order
    {
        String order;
        Double price;
        
        public Order(String order, Double price)
        {
            this.order = order;
            this.price = price;
        }
    }
}
