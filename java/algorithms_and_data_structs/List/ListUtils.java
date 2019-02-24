package algorithms_and_data_structs.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 09/Nov/2017
 */

public class ListUtils
{
    /**
     * Find all the Integers that exist in both lists
     *
     * @param listLeft  - First list of Integers
     * @param listRight - Second list of Integers
     *
     * @return - New list containing all Integers that exist in both input lists
     *
     * @throws NoCommonItemsException - If there are no common Integers in the input lists
     */
    static List<Integer> sharedItems(List<Integer> listLeft, List<Integer> listRight) throws NoCommonItemsException
    {
        List<Integer> sharedList = new ArrayList<>();
        
        for (Integer l : listLeft)
        {
            for (Integer r : listRight)
            {
                if (Objects.equals(l, r))
                {
                    sharedList.add(l);
                }
            }
        }
        
        if (sharedList.isEmpty())
        {
            throw new NoCommonItemsException("The lists have no items in common!");
        }
        
        return sharedList;
    }
}

class NoCommonItemsException extends Exception
{
    // Empty Constructor
    public NoCommonItemsException()
    {
    }
    
    // Constructor that accepts a message
    public NoCommonItemsException(String message)
    {
        super(message);
    }
}