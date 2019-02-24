package algorithms_and_data_structs.List;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 09/Nov/2017
 */

public class Statistics
{
    
    /**
     * Find the maximum value in a list of Integers
     * Note: This method is using iterators
     *
     * @param list - List of integers
     *
     * @return - The maximum value
     */
    static int maximum(List<Integer> list)
    {
        Iterator<Integer> iterator = list.iterator();
        Integer max = iterator.next();
        
        while (iterator.hasNext())
        {
            
            Integer current = iterator.next();
            if (max < current)
            {
                max = current;
            }
        }
        
        return max;
    }
    
    /**
     * Find the minimum value in a list of Integers
     * Note: This method is using iterators
     *
     * @param list - List of integers
     *
     * @return - The minimum value
     */
    static int minimum(List<Integer> list)
    {
        Iterator<Integer> iterator = list.iterator();
        Integer min = iterator.next();
        
        while (iterator.hasNext())
        {
            
            Integer current = iterator.next();
            if (min > current)
            {
                min = current;
            }
        }
        
        return min;
    }
    
    /**
     * Find the arithmetic mean of the Integers in the list
     * Note: This method is using iterators
     *
     * @param list - List of integers
     *
     * @return - Arithmetic mean
     */
    static double average(List<Integer> list)
    {
        Iterator<Integer> iterator = list.iterator();
        Integer sum = 0;
        Integer count = 0;
        
        while (iterator.hasNext())
        {
            
            Integer current = iterator.next();
            sum = sum + current;
            count++;
        }
        
        return (double) sum / count;
    }
    
    /**
     * Find the maximum value in a list of Integers
     * Note: This method is using for loops
     *
     * @param list - List of integers
     *
     * @return - The maximum value
     */
    static int maximumFor(List<Integer> list)
    {
        Integer max = list.get(0);
        
        for (Integer l : list)
        {
            if (l > max)
            {
                max = l;
            }
        }
        
        return max;
    }
    
    /**
     * Find the minimum value in a list of Integers
     * Note: This method is for loops
     *
     * @param list - List of integers
     *
     * @return - The minimum value
     */
    static int minimumFor(List<Integer> list)
    {
        Integer min = list.get(0);
        
        for (Integer l : list)
        {
            if (l < min)
            {
                min = l;
            }
        }
        
        return min;
    }
    
    /**
     * Find the arithmetic mean of the Integers in the list
     * Note: This method is using for loops
     *
     * @param list - List of integers
     *
     * @return - Arithmetic mean
     */
    static double averageFor(List<Integer> list)
    {
        Integer average = 0;
        Integer count = 0;
        
        for (Integer l : list)
        {
            average = average + l;
            count++;
        }
        
        return (double) average / count;
    }
    
    /**
     * Sort (ascending) a list of Integers using bubble sort algorithm (In-place)
     *
     * @param list - List of Integers to be sorted
     *
     * @return - The sorted list
     */
    static List<Integer> bubbleSort(List<Integer> list)
    {
        Integer size = list.size();
        
        for (int i = 1; i < size; i++)
        {
            boolean isSorted = true;
            
            for (int j = 0; j < size - i; j++)
            {
                if (list.get(j) > list.get(j + 1))
                {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    isSorted = false;
                }
            }
            
            if (isSorted)
            {
                return list;
            }
        }
        return list;
    }
    
    /**
     * Sort (ascending) a list of Integers using the sort method of `Collections`
     *
     * @param list - List of Integers to be sorted
     *
     * @return - The sorted list
     */
    static List<Integer> collectionSort(List<Integer> list)
    {
        Collections.sort(list);
        return list;
    }
    
    /**
     * Shuffle the values in a list of Integers
     *
     * @param list - List of Integers to be shuffled
     *
     * @return - The shuffled list
     */
    static List<Integer> collectionShuffle(List<Integer> list)
    {
        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed));
        return list;
    }
    
    /**
     * Find the geometric mean of the Integers in the list
     * Note: This method is using iterators
     *
     * @param list - List of integers
     *
     * @return - Geometric mean
     */
    static double geometricMean(List<Integer> list)
    {
        Iterator<Integer> iterator = list.iterator();
        Integer product = 1;
        Integer count = 0;
        
        while (iterator.hasNext())
        {
            Integer current = iterator.next();
            product = product * current;
            count++;
        }
        
        return Math.pow(product, 1.0 / count);
    }
}
