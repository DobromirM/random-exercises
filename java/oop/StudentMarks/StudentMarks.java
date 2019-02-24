package oop.StudentMarks;

import java.util.*;
import java.io.*;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 14/Nov/2017
 */

public class StudentMarks
{
    static HashMap<String, Integer> marks = new HashMap<>();
    
    public static void main(String[] args)
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        Integer choice = -1;
        
        while (choice != 0)
        {
            System.out.println("-----Menu-----");
            System.out.println("1.Enter Marks");
            System.out.println("2.Display Marks");
            System.out.println("3.Average Mark");
            System.out.println("4.Highest Mark");
            System.out.println("5.Amend Mark");
            System.out.println("6.Amend Name");
            System.out.println("7.Test exception handler");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            
            try
            {
                choice = Integer.parseInt(buf.readLine());
            }
            catch (Exception e)
            {
                choice = 0;
            }
            
            switch (choice)
            {
                case 1:
                    enterDetails(buf);
                    break;
                
                case 2:
                    try
                    {
                        Marks.displayMarks(marks);
                    }
                    catch (InvalidNumberException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case 3:
                    try
                    {
                        if (Marks.averageMarks(marks) != null)
                        {
                            System.out.println(Marks.averageMarks(marks));
                        }
                        else
                        {
                            System.out.println("There are no records!");
                        }
                    }
                    catch (InvalidNumberException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case 4:
                    try
                    {
                        if (Marks.highestMark(marks) != null)
                        {
                            System.out.println(Marks.highestMark(marks));
                        }
                        else
                        {
                            System.out.println("There are no records!");
                        }
                    }
                    catch (InvalidNumberException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case 5:
                    amendMark(buf);
                    break;
                
                case 6:
                    amendName(buf);
                    break;
                
                case 7:
                    testExceptionHandler();
                    break;
                
                case 0:
                    choice = 0;
                    break;
            }
        }
    }
    
    /**
     * Enter details for people in a map
     *
     * @param buf - Buffer reader with the user input
     */
    private static void enterDetails(BufferedReader buf)
    {
        Boolean more = true;
        while (more)
        {
            
            System.out.println("Name: ");
            
            String name = null;
            
            try
            {
                name = buf.readLine();
            }
            catch (Exception e)
            {
            }
            
            System.out.println("Mark: ");
            int mark = 0;
            
            try
            {
                mark = Integer.parseInt(buf.readLine().trim());
            }
            catch (Exception e)
            {
                System.out.println("invalid input - using 0");
            }
            
            marks.put(name, mark);
            
            System.out.println("More? ");
            
            try
            {
                if (buf.readLine().charAt(0) != 'y')
                {
                    more = false;
                }
            }
            catch (Exception e)
            {
            }
        }
    }
    
    /**
     * Amend the mark of an existing person in the map
     *
     * @param buf - Buffer reader with the user input
     */
    private static void amendMark(BufferedReader buf)
    {
        System.out.println("Name: ");
        
        String name = null;
        
        try
        {
            name = buf.readLine();
        }
        catch (Exception e)
        {
        }
        
        System.out.println("New mark: ");
        int mark = 0;
        
        try
        {
            mark = Integer.parseInt(buf.readLine().trim());
        }
        catch (Exception e)
        {
            System.out.println("invalid input - using 0");
        }
        
        Marks.amendMark(marks, name, mark);
    }
    
    /**
     * Amend the name of an existing person in the map
     *
     * @param buf - Buffer reader with the user input
     */
    private static void amendName(BufferedReader buf)
    {
        System.out.println("Name: ");
        
        String name = null;
        
        try
        {
            name = buf.readLine();
        }
        catch (Exception e)
        {
        }
        
        System.out.println("New name: ");
        String newName = null;
        
        try
        {
            newName = buf.readLine();
        }
        catch (Exception e)
        {
        }
        
        Marks.amendName(marks, name, newName);
    }
    
    /**
     * Test the exception handler with different inputs and display its raw behaviour
     */
    private static void testExceptionHandler()
    {
        HashMap<String, Integer> testMarks = new HashMap<>();
        
        System.out.println();
        System.out.println();
        
        // Positive and negative entries
        testMarks.put("John", 50);
        testMarks.put("Jack", -25);
        testMarks.put("Adam", 25);
        testMarks.put("Eve", -50);
        
        try
        {
            System.out.println("Test for display marks with negative entries.");
            Marks.displayMarks(testMarks);
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            System.out.println("Test for average mark with negative entries.");
            System.out.println(Marks.averageMarks(testMarks));
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            System.out.println("Test for highest mark with negative entries.");
            System.out.println(Marks.highestMark(testMarks));
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println();
        System.out.println();
        
        //Only negative entries
        testMarks = new HashMap<>();
        testMarks.put("John", -50);
        testMarks.put("Jack", -25);
        testMarks.put("Adam", -25);
        testMarks.put("Eve", -50);
        
        try
        {
            System.out.println("Test for display marks with negative entries only.");
            Marks.displayMarks(testMarks);
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            System.out.println("Test for average mark with negative entries only.");
            System.out.println(Marks.averageMarks(testMarks));
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            System.out.println("Test for highest mark with negative entries only.");
            System.out.println(Marks.highestMark(testMarks));
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println();
        System.out.println();
        
        //Only positive entries
        testMarks = new HashMap<>();
        testMarks.put("John", 50);
        testMarks.put("Jack", 25);
        testMarks.put("Adam", 25);
        testMarks.put("Eve", 50);
        
        try
        {
            System.out.println("Test for display marks with positive entries only.");
            Marks.displayMarks(testMarks);
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            System.out.println("Test for average mark with positive entries only.");
            System.out.println(Marks.averageMarks(testMarks));
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            System.out.println("Test for highest mark with positive entries only.");
            System.out.println(Marks.highestMark(testMarks));
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println();
        System.out.println();
        
        //Without entries
        testMarks = new HashMap<>();
        
        try
        {
            System.out.println("Test for display marks with no entries.");
            Marks.displayMarks(testMarks);
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            System.out.println("Test for average mark with no entries.");
            System.out.println(Marks.averageMarks(testMarks));
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            System.out.println("Test for highest mark with no entries.");
            System.out.println(Marks.highestMark(testMarks));
        }
        catch (InvalidNumberException e)
        {
            System.out.println(e.getMessage());
        }
    }
}


