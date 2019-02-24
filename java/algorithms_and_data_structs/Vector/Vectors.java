package algorithms_and_data_structs.Vector;

import java.util.*;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 02/Nov/2017
 */

class Vectors
{
    /**
     * Find the position of the smallest item in a list
     * NOTE: If the smallest items are more than one return the position of the first one
     *
     * @param l   - List of items
     * @param <T> - Data type
     *
     * @return - Position of the smallest item as int
     */
    private static <T extends Comparable<T>> int smallest(List<T> l)
    {
        if (l.size() == 0)
        {
            return -1;
        }
        else
        {
            Iterator<T> it = l.iterator();
            T smallestSoFar = it.next();
            T temp;
            int smallestPos = 0;
            int i = 1;
            while (it.hasNext())
            {
                temp = it.next();
                if (smallestSoFar.compareTo(temp) > 0)
                {
                    smallestSoFar = temp;
                    smallestPos = i;
                }
                i++;
            }
            return smallestPos;
        }
    }
    
    /**
     * Delete the smallest item from a list
     *
     * @param l   - List of items
     * @param <T> - Data type
     */
    private static <T extends Comparable<T>> void deleteSmallest(List<T> l)
    {
        if (l.size() > 0)
        {
            l.remove(smallest(l));
        }
    }
    
    /**
     * Replace all negative integers in a list with their positive versions
     *
     * @param l - List of integers
     */
    private static void replaceNegList(List<Integer> l)
    {
        for (int i = 0; i < l.size(); i++)
        {
            Integer number = l.get(i);
            
            if (number < 0)
            {
                l.set(i, Math.abs(number));
            }
        }
    }
    
    /**
     * Replace all positive integers in a list with their negative versions
     *
     * @param l - List of integers
     */
    private static void replacePosList(List<Integer> l)
    {
        for (int i = 0; i < l.size(); i++)
        {
            Integer number = l.get(i);
            
            if (number > 0)
            {
                l.set(i, -number);
            }
        }
    }
    
    /**
     * Remove all integers from a list that are smaller than the minimum or bigger than the maximum
     *
     * @param l   - List of integers
     * @param min - Minimum
     * @param max - Maximum
     */
    public static void limitToRange(List<Integer> l, Integer min, Integer max)
    {
        for (int i = 0; i < l.size(); i++)
        {
            Integer number = l.get(i);
            
            if (number < min || number > max)
            {
                l.remove(number);
                i--;
            }
        }
    }
    
    public static void main(String[] args)
    {
        //Test with strings
        Vector<String> vec1 = new Vector<>();
        vec1.add("Hello");
        vec1.add("world");
        vec1.add("xxxx");
        vec1.add("aardvark");
        
        int smallPos = smallest(vec1);
        if (smallPos != -1)
        {
            System.out.println("Smallest entry is " + vec1.elementAt(smallPos) + " at position " + smallPos);
            System.out.println();
        }
        
        //Test with double and duplicate
        Vector<Double> vecDouble = new Vector<>();
        vecDouble.add(47.6);
        vecDouble.add(23.5);
        vecDouble.add(11.8);
        vecDouble.add(11.8);
        
        smallPos = smallest(vecDouble);
        if (smallPos != -1)
        {
            System.out.println("Smallest entry is " + vecDouble.elementAt(smallPos) + " at position " + smallPos);
            System.out.println();
        }
        
        //Test with empty
        Vector<Float> vecFloat = new Vector<>();
        
        smallPos = smallest(vecFloat);
        if (smallPos != -1)
        {
            System.out.println("Smallest entry is " + vecFloat.elementAt(smallPos) + " at position " + smallPos);
            System.out.println();
        }
        
        //Test with float
        vecFloat.add(44.2f);
        vecFloat.add(44.1f);
        smallPos = smallest(vecFloat);
        
        if (smallPos != -1)
        {
            System.out.println("Smallest entry is " + vecFloat.elementAt(smallPos) + " at position " + smallPos);
            System.out.println();
        }
        
        //Test with integers
        Vector<Integer> vec2 = new Vector<>();
        vec2.add(47);
        vec2.add(17);
        vec2.add(399);
        vec2.add(247);
        
        smallPos = smallest(vec2);
        if (smallPos != -1)
        {
            System.out.println("Smallest entry is " + vec2.elementAt(smallPos) + " at position " + smallPos);
        }
        
        //Test delete smallest
        deleteSmallest(vec2);
        System.out.println("The smallest entry from vec2 was deleted");
        
        if (smallPos != -1)
        {
            System.out.println("Smallest entry is " + vec2.elementAt(smallPos) + " at position " + smallPos);
            System.out.println();
        }
        
        //Test positive number replacement
        System.out.println("Numbers in vec2 before replacing positive numbers");
        System.out.println(vec2);
        replacePosList(vec2);
        System.out.println("Numbers in vec2 after replacing positive numbers");
        System.out.println(vec2);
        System.out.println();
        
        //Test negative number replacement
        vec2.add(-200);
        vec2.add(-23);
        vec2.add(-50);
        vec2.add(0);
        
        System.out.println("Numbers in vec2 before replacing negative numbers");
        System.out.println(vec2);
        replaceNegList(vec2);
        System.out.println("Numbers in vec2 after replacing negative numbers");
        System.out.println(vec2);
        System.out.println();
        
        //Test limiting the range of the list
        System.out.println("Numbers in vec2 before limiting the range to 20-200");
        System.out.println(vec2);
        limitToRange(vec2, 20, 200);
        System.out.println("Numbers in vec2 after limiting the range to 20-200");
        System.out.println(vec2);
        System.out.println();
    }
}
