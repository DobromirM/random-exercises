package testing;

/**
 * <br><br>
 *
 * @author Dobromir Marinov
 * Created on: 01/Dec/2017
 */

public class BubbleSort
{
    private static Screener screener = new Screener();
    
    // logic to sort the elements
    public static int[] bubble_sort(int array[])
    {
        int n = array.length;
        int k, temp;
        screener.printNumbers(array);
        for (int m = n; m > 0; m--)
        {
            for (int i = 0; i < n - 1; i++)
            {
                k = i + 1;
                if (array[i] > array[k])
                {
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
        screener.printNumbers(array);
        return array;
    }
    
    private static class Screener
    {
        private void printNumbers(int array[])
        {
//            System.out.println(Arrays.toString(array));
        }
    }
}