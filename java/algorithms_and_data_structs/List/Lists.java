package algorithms_and_data_structs.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on: 20/Feb/2017
 *
 * @author DMarinov
 */
public class Lists
{
    @SafeVarargs
    public static <E> List<E> mkList(E... elements)
    {
        List<E> result = new ArrayList<>();
        for (E element : elements) result.add(element);
        return result;
    }

    /**
     * Calculate the product from a list of integers
     *
     * @param list - List of integers
     * @return - Product
     */
    public static int product(List<Integer> list)
    {
        //Return 0 if the list is empty
        if (list.size() == 0)
        {
            return 0;
        }

        //Calculate the product
        int product = 1;
        for (int number : list)
        {
            product = product * number;
        }
        return product;
    }

}
