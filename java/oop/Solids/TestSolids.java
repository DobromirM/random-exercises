package oop.Solids;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSolids
{
    public static void main(String[] args)
    {
        List<Solid> testList = new ArrayList<>();
        System.out.println("### List before sorting");

        testList.add(new Sphere(6));
        testList.add(new Cylinder(5, 7));

        for (Solid s : testList)
            System.out.println(s + " " + s.volume());

        Collections.sort(testList);
        System.out.println("\n### List after sorting");

        for (Solid s : testList)
            System.out.println(s + " " + s.volume());
    }
}