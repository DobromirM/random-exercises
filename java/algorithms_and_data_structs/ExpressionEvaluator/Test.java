package algorithms_and_data_structs.ExpressionEvaluator;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 27/Jan/2018
 */

public class Test
{
    public static void main(String[] args)
    {
        Deque deque = new Deque<>();
        
        System.out.println("Queue contents: " + deque.toString());
        
        Integer n = 5;
        System.out.println("Adding " + n + " to left");
        deque.addLeft(n);
        System.out.println("Queue contents: " + deque.toString());
        
        n = 11;
        System.out.println("Adding " + n + " to left");
        deque.addLeft(n);
        System.out.println("Queue contents: " + deque.toString());
        
        n = 25;
        System.out.println("Adding " + n + " to right");
        deque.addRight(n);
        System.out.println("Queue contents: " + deque.toString());
        
        n = 13;
        System.out.println("Adding " + n + " to right");
        deque.addRight(n);
        System.out.println("Queue contents: " + deque.toString());
        
        n = 7;
        System.out.println("Adding " + n + " to left");
        deque.addLeft(n);
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Removing rightmost element");
        deque.removeRight();
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Leftmost element: " + deque.left());
        System.out.println("Rightmost element: " + deque.right());
        
        n = 37;
        System.out.println("Adding " + n + " to left");
        deque.addLeft(n);
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Leftmost element: " + deque.left());
        
        n = 25;
        System.out.println("Adding " + n + " to right");
        deque.addRight(n);
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Removing leftmost element");
        deque.removeLeft();
        System.out.println("Queue contents: " + deque.toString());
        
        n = 11;
        System.out.println("Adding " + n + " to right");
        deque.addRight(n);
        System.out.println("Queue capacity has been increased!");
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Rightmost element: " + deque.right());
        
        System.out.println("Removing rightmost element");
        deque.removeRight();
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Removing rightmost element");
        deque.removeRight();
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Removing leftmost element");
        deque.removeLeft();
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Removing leftmost element");
        deque.removeLeft();
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Removing leftmost element");
        deque.removeLeft();
        System.out.println("Queue contents: " + deque.toString());
        
        System.out.println("Removing leftmost element");
        deque.removeLeft();
        System.out.println("Queue contents: " + deque.toString());
        
        try
        {
            System.out.println("Removing leftmost element");
            deque.removeLeft();
        }
        catch (QueueException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            System.out.println("Removing rightmost element");
            deque.removeRight();
        }
        catch (QueueException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            System.out.println("Leftmost element:");
            deque.left();
        }
        catch (QueueException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            System.out.println("Rightmost element:");
            deque.right();
        }
        catch (QueueException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
