package testing;

/**
 * <br><br>
 *
 * @author Dobromir Marinov
 * Created on: 01/Dec/2017
 */

public class BubbleSortTestDriver
{
    private static int total = 0;
    private static int failed = 0;
    
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("#####Bubble_Sort_Test#####");
        displayResult(test_case_1(), 1);
        displayResult(test_case_2(), 2);
        displayResult(test_case_3(), 3);
        displayResult(test_case_4(), 4);
        displayResult(test_case_5(), 5);
        displayResult(test_case_6(), 6);
        displayResult(test_case_7(), 7);
        displayResult(test_case_8(), 8);
        displayResult(test_case_9(), 9);
        displayResult(test_case_10(), 10);
        
        System.out.println("POFOD: " + failureProbability(total, failed));
    }
    
    private static boolean test_case_1()
    {
        int[] input = new int[]{};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_1(output);
    }
    
    private static boolean test_case_2()
    {
        int[] input = new int[]{1};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_2(output);
    }
    
    private static boolean test_case_3()
    {
        int[] input = new int[]{1, 2, 3};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_3(output);
    }
    
    private static boolean test_case_4()
    {
        int[] input = new int[]{2, 1, 3};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_4(output);
    }
    
    private static boolean test_case_5()
    {
        int[] input = new int[]{Integer.MAX_VALUE, 1, 2};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_5(output);
    }
    
    private static boolean test_case_6()
    {
        int[] input = new int[]{Integer.MAX_VALUE - 1, 1, 2};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_6(output);
    }
    
    private static boolean test_case_7()
    {
        int[] input = new int[]{Integer.MAX_VALUE + 1, 1, 2};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_7(output);
    }
    
    private static boolean test_case_8()
    {
        int[] input = new int[]{1, 2, Integer.MIN_VALUE};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_8(output);
    }
    
    private static boolean test_case_9()
    {
        int[] input = new int[]{1, 2, Integer.MIN_VALUE + 1};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_9(output);
    }
    
    private static boolean test_case_10()
    {
        int[] input = new int[]{1, 2, Integer.MIN_VALUE - 1};
        int[] output = BubbleSort.bubble_sort(input);
        
        return BubbleSortTestOracle.report_case_10(output);
    }
    
    private static float failureProbability(int total, int failed)
    {
        return (float) failed / total;
    }
    
    private static void displayResult(boolean result, int test_case)
    {
        total++;
        
        if (result)
        {
            System.out.println("Test " + test_case + " passed!");
        }
        else
        {
            System.out.println("Test " + test_case + " failed!");
            failed++;
        }
        
        System.out.println();
    }
}
