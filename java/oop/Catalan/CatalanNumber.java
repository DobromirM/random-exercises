package oop.Catalan;

import java.util.Objects;
import java.util.Scanner;

/**
 * Created on: 22/Apr/2017
 *
 * @author Dobromir
 */
public class CatalanNumber
{
    public static void main(String[] args)
    {
        exercise3a();
        exercise3b();
    }

    public static void exercise3a()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {

            System.out.print("Please enter an integer n (0<=n<=30) or 'quit' to exit:");
            String input = scanner.next();

            if (Objects.equals(input, "quit"))
            {
                System.out.println("Bye!");
                break;
            }

            int term = Integer.parseInt(input);
            long catalanNum = catalan(term);
            System.out.println("Your Catalan number is: " + catalanNum);
        }
    }

    public static void exercise3b()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {

            System.out.print("Please enter an integer n (0<=n<=30) or 'quit' to exit:");
            String input = scanner.next();

            if (Objects.equals(input, "quit"))
            {
                System.out.println("Bye!");
                break;
            }

            int term = Integer.parseInt(input);
            try
            {
                long catalanNum = catalan(term);
                System.out.println("Your Catalan number is: " + catalanNum);
            } catch (IllegalArgumentException ex)
            {
                System.out.println("The number must be between 0 and 30");
            }

        }
    }

    /**
     * Calculate the n'th Catalan number
     *
     * @param n - Term number
     * @return - The n'th Catalan number
     */
    public static long catalan(int n)
    {
        if (n < 0 || n > 30)
        {
            throw new IllegalArgumentException();
        }

        if (n == 0)
        {
            return 1;
        }

        return 2 * (2 * n - 1) * catalan(n - 1) / (n + 1);
    }
}
