package algorithms_and_data_structs.List;

import java.util.List;

public class TestLists
{

    public static void main(String[] args)
    {
        testProduct(Lists.mkList(1, 2, 3, 4, 5));
    }

    public static void testProduct(List<Integer> list)
    {
        System.out.println("### Test: product");
        System.out.println(list);
        System.out.println(Lists.product(list) + "\n");
    }
}