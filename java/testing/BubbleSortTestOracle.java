package testing;

import java.util.Arrays;

/**
 * <br><br>
 *
 * @author Dobromir Marinov
 * Created on: 01/Dec/2017
 */

public class BubbleSortTestOracle
{
    public static boolean report_case_1(int[] output)
    {
        int[] expected = new int[]{};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    public static boolean report_case_2(int[] output)
    {
        int[] expected = new int[]{1};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    public static boolean report_case_3(int[] output)
    {
        int[] expected = new int[]{1, 2, 3};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    public static boolean report_case_4(int[] output)
    {
        int[] expected = new int[]{1, 2, 3};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    public static boolean report_case_5(int[] output)
    {
        int[] expected = new int[]{1, 2, Integer.MAX_VALUE};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    public static boolean report_case_6(int[] output)
    {
        int[] expected = new int[]{1, 2, Integer.MAX_VALUE - 1};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    public static boolean report_case_7(int[] output)
    {
        int[] expected = new int[]{1, 2, Integer.MAX_VALUE + 1};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    public static boolean report_case_8(int[] output)
    {
        int[] expected = new int[]{Integer.MIN_VALUE, 1, 2};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    public static boolean report_case_9(int[] output)
    {
        int[] expected = new int[]{Integer.MIN_VALUE + 1, 1, 2};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    public static boolean report_case_10(int[] output)
    {
        int[] expected = new int[]{Integer.MIN_VALUE - 1, 1, 2};
        displayArrays(output, expected);
        return Arrays.equals(output, expected);
    }
    
    private static void displayArrays(int[] result, int[] expected)
    {
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Expected: " + Arrays.toString(expected));
    }
}
