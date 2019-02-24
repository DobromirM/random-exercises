package oop.StudentMarks;

import java.util.Iterator;
import java.util.Map;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 14/Nov/2017
 */

class Marks
{
    /**
     * Display all the marks with names from a map
     *
     * @param marks - The map of marks and names
     *
     * @throws InvalidNumberException - If the map contains negative marks
     */
    static void displayMarks(Map<String, Integer> marks) throws InvalidNumberException
    {
        Iterator<Map.Entry<String, Integer>> iterator = marks.entrySet().iterator();
        
        while (iterator.hasNext())
        {
            Map.Entry<String, Integer> current = iterator.next();
            
            if (current.getValue() < 0)
            {
                throw new InvalidNumberException();
            }
            
            System.out.println(current.getKey() + ": " + current.getValue());
        }
    }
    
    /**
     * Calculate the average of all the marks in a map
     *
     * @param marks - The map of marks and names
     *
     * @return - The average value
     *
     * @throws InvalidNumberException - If the map contains negative marks
     */
    static Float averageMarks(Map<String, Integer> marks) throws InvalidNumberException
    {
        Iterator<Map.Entry<String, Integer>> iterator = marks.entrySet().iterator();
        
        Integer sum = 0;
        Integer size = marks.size();
        
        while (iterator.hasNext())
        {
            Map.Entry<String, Integer> current = iterator.next();
            
            if (current.getValue() < 0)
            {
                throw new InvalidNumberException();
            }
            
            sum = sum + current.getValue();
        }
        
        return size > 0 ? (float) sum / size : null;
    }
    
    /**
     * Find the highest mark in a map
     *
     * @param marks - The map of marks and names
     *
     * @return - StudentMarks entry containing the name of the person with the highest mark and the mark
     *
     * @throws InvalidNumberException - If the map contains negative marks
     */
    static Map.Entry<String, Integer> highestMark(Map<String, Integer> marks) throws InvalidNumberException
    {
        Iterator<Map.Entry<String, Integer>> iterator = marks.entrySet().iterator();
        
        Map.Entry<String, Integer> highest = null;
        
        while (iterator.hasNext())
        {
            Map.Entry<String, Integer> current = iterator.next();
            
            if (current.getValue() < 0)
            {
                throw new InvalidNumberException();
            }
            
            if (highest == null || current.getValue() > highest.getValue())
            {
                highest = current;
            }
        }
        
        return highest;
    }
    
    /**
     * Change the mark of an existing person using his name in a map of marks and names
     *
     * @param marks - The map of marks and names
     * @param name  - The name of the person
     * @param mark  - The new value of his mark
     */
    static void amendMark(Map<String, Integer> marks, String name, Integer mark)
    {
        if (marks.get(name) != null)
        {
            marks.put(name, mark);
        }
        else
        {
            System.out.println("The person does not exist in the system!");
        }
    }
    
    /**
     * Change the name of an existing person using his old name in a map of marks and names
     *
     * @param marks   - The map of marks and names
     * @param oldName - The old name of the person
     * @param newName - The new name of the person
     */
    static void amendName(Map<String, Integer> marks, String oldName, String newName)
    {
        if (marks.get(oldName) != null)
        {
            Integer mark = marks.get(oldName);
            marks.remove(oldName);
            marks.put(newName, mark);
        }
        else
        {
            System.out.println("The person does not exist in the system!");
        }
    }
}
