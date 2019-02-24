package oop.Mean;

/**
 * Created on: 22/Apr/2017
 *
 * @author Dobromir
 */
public class ClosestToMean
{
    
    public static void main(String[] args)
    {
        testClosestToMean();
    }
    
    public static void testClosestToMean()
    {
        double[][] array = {{3, -1, -4, 0}, {5, -2, 9, 6}, {8, 2, 4, -9}};
        
        if (array.length != 0)
        {
            int[] coordinates = closestToMean(array);
            System.out.println("Result = [" + coordinates[0] + ", " + coordinates[1] + "]");
        }
        else
        {
            System.out.println("The array is empty!");
        }
    }
    
    public static int[] closestToMean(double[][] array)
    {
        double mean = calculateMean(array);
        System.out.println("Mean = " + mean);
        
        double closest = array[0][0];
        int[] coordinates = {0, 0};
        double closestDist = Double.POSITIVE_INFINITY;
        
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                double dist = Math.abs(mean - array[i][j]);
                
                if (dist < closestDist)
                {
                    closestDist = dist;
                    closest = array[i][j];
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        
        System.out.println("Closest array element = " + closest);
        return coordinates;
    }
    
    /**
     * Calculate the arithmetic mean of an array of numbers
     *
     * @param array - The array
     *
     * @return - The arithmetic mean
     */
    private static double calculateMean(double[][] array)
    {
        double sum = 0;
        double count = 0;
        
        for (double[] row : array)
        {
            for (double item : row)
            {
                sum = sum + item;
                count = count + 1;
            }
        }
        
        return sum / count;
    }
}
