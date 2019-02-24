package algorithms;

import java.util.StringJoiner;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 27/Jan/2018
 */

public class Deque <T>
{
    //Set to 5 so it is easier to demonstrate the automatic expanding in the tests
    private static final int INITIAL_CAPACITY = 5;
    
    private T[] array;
    private int left;
    private int right;
    private int size;
    
    public Deque()
    {
        array = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        left = -1;
        right = -1;
    }
    
    /**
     * Check if the deque has any items inside it
     * Return 'true' if the deque is empty and 'false' otherwise
     *
     * @return - Boolean
     */
    public Boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * Return the leftmost element in the deque
     *
     * @return - The leftmost element
     */
    public T left()
    {
        if (isEmpty())
        {
            throw new QueueException("left");
        }
        
        return array[left];
    }
    
    /**
     * Return the rightmost element in the deque
     *
     * @return - The rightmost element
     */
    public T right()
    {
        if (isEmpty())
        {
            throw new QueueException("right");
        }
        
        return array[right];
    }
    
    /**
     * Add element to the left of the deque
     *
     * @param item - element to add
     */
    public void addLeft(T item)
    {
        if (isFull())
        {
            expand();
        }
        
        if (isEmpty())
        {
            left = 0;
            right = 0;
        }
        else
        {
            left--;
        }
        
        if (left < 0)
        {
            left = array.length - 1;
        }
        
        array[left] = item;
        size++;
    }
    
    /**
     * Add element to the right of the deque
     *
     * @param item - element to add
     */
    public void addRight(T item)
    {
        if (isFull())
        {
            expand();
        }
        
        if (isEmpty())
        {
            left = 0;
            right = 0;
        }
        else
        {
            right++;
        }
        
        if (right > array.length - 1)
        {
            right = 0;
        }
        
        array[right] = item;
        size++;
    }
    
    /**
     * Remove the leftmost element from the deque
     */
    public void removeLeft()
    {
        if (isEmpty())
        {
            throw new QueueException("removeLeft");
        }
        
        if (size == 1)
        {
            left = -1;
            right = -1;
        }
        
        left++;
        
        if (left > array.length - 1)
        {
            left = 0;
        }
        
        size--;
    }
    
    /**
     * Remove the rightmost element from the deque
     */
    public void removeRight()
    {
        if (isEmpty())
        {
            throw new QueueException("removeRight");
        }
        
        if (size == 1)
        {
            left = -1;
            right = -1;
        }
        
        right--;
        
        if (right < 0)
        {
            right = array.length - 1;
        }
        
        size--;
    }
    
    /**
     * Check if the deque is full
     * Return 'true' if the deque is full and 'false' otherwise
     *
     * @return - Boolean
     */
    private Boolean isFull()
    {
        return size == array.length;
    }
    
    private void expand()
    {
        T[] newArray = (T[]) new Object[array.length * 2];
        
        int position = left;
        int index = 0;
        
        for (int i = 0; i < size; i++)
        {
            if (position == array.length)
            {
                position = 0;
            }
            
            newArray[index] = array[position];
            
            position++;
            index++;
        }
        
        array = newArray;
        left = 0;
        right = index - 1;
    }
    
    /**
     * Display the deque as string in the format -> <5,1,3,6>
     * For empty deque -> <>
     *
     * @return - String representation of the deque
     */
    @Override
    public String toString()
    {
        StringJoiner contents = new StringJoiner(",");
        int position = left;
        
        for (int i = 0; i < size; i++)
        {
            if (position == array.length)
            {
                position = 0;
            }
            
            if (array[position] != null)
            {
                contents.add(array[position].toString());
            }
            else
            {
                contents.add(null);
            }
            
            position++;
        }
        
        if (contents.length() > 0)
        {
            return "<" + contents.toString() + ">";
        }
        else
        {
            return "<>";
        }
    }
}
