package algorithms_and_data_structs.List;

import java.util.ArrayList;
import java.util.List;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 09/Nov/2017
 */

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> listLeft = new ArrayList<>();
        listLeft.add(13);
        listLeft.add(23);
        listLeft.add(12);
        listLeft.add(44);
        listLeft.add(55);
        
        List<Integer> listRight = new ArrayList<>();
        listRight.add(23);
        listRight.add(44);
        
        System.out.println("Initial list");
        System.out.println(listLeft);
        System.out.println();
        
        System.out.println("Results from methods using iterators");
        System.out.println("Maximum: " + Statistics.maximum(listLeft));
        System.out.println("Minimum: " + Statistics.minimum(listLeft));
        System.out.println("Arithmetic mean: " + Statistics.average(listLeft));
        System.out.println();
        
        System.out.println("Results from methods using for loops");
        System.out.println("Maximum: " + Statistics.maximumFor(listLeft));
        System.out.println("Minimum: " + Statistics.minimumFor(listLeft));
        System.out.println("Arithmetic mean: " + Statistics.averageFor(listLeft));
        System.out.println();
        
        try
        {
            System.out.println("List of shared integers");
            System.out.println("Shared integers: " + ListUtils.sharedItems(listLeft, listRight));
            System.out.println();
            
            listRight.clear();
            
            System.out.println("List of shared integers (Exception)");
            ListUtils.sharedItems(listLeft, listRight);
        }
        catch (NoCommonItemsException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println();
        
        System.out.println("The list after bubble sort");
        System.out.println(Statistics.bubbleSort(listLeft));
        System.out.println();
        
        System.out.println("The list after a shuffle");
        System.out.println(Statistics.collectionShuffle(listLeft));
        System.out.println();
        
        System.out.println("The list after sort using `Collections` method");
        System.out.println(Statistics.collectionSort(listLeft));
        System.out.println();
        
        System.out.println("Geometric mean: " + Statistics.geometricMean(listLeft));
    }
}
