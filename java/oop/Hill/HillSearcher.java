package oop.Hill;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created on: 23/Apr/2017
 *
 * @author Dobromir
 */
public class HillSearcher
{
    public static void main(String[] args) throws FileNotFoundException
    {
        exercise5a();
        exercise5b();
        exercise5c();
        exercise5d();
        exercise5e();
    }

    public static void exercise5a()
    {
        Hill benNevis = new Hill(255, "Ben Nevis", "Highland", 1344.5, 56.796849, -5.003525);
        System.out.println(benNevis);
    }

    public static void exercise5b() throws FileNotFoundException
    {
        List<Hill> hills = Hill.readHills();

        for (int i = 0; i < 20; i++)
        {
            System.out.println(hills.get(i));
        }
    }

    public static void exercise5c() throws FileNotFoundException
    {
        List<Hill> hills = Hill.readHills();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {

            System.out.print("Please enter a hill name or 'quit' to exit:");
            String input = scanner.next();

            if (Objects.equals(input, "quit"))
            {
                System.out.println("Bye!");
                break;
            }

            for(Hill hill: hills)
            {
                if(hill.name.toLowerCase().startsWith(input.toLowerCase()))
                {
                    System.out.println(hill);
                }
            }
        }
    }

    public static void exercise5d() throws FileNotFoundException
    {
        List<Hill> hills = Hill.readHills();

        hills.sort(Hill.getNameComparator());
        for (int i = 0; i < 20; i++)
        {
        System.out.println(hills.get(i));
        }

        System.out.println();

        hills.sort(Hill.getHeightComparator().reversed());
        for (int i = 0; i < 20; i++)
        {
            System.out.println(hills.get(i));
        }
    }

    public static void exercise5e() throws FileNotFoundException
    {
        List<Hill> hills = Hill.readHills();
        Map<String, Set<Hill>> hillsToCountry = Hill.hillsByCounty(hills);

        for (int i = 0; i < 3; i++)
        {
            String country = hillsToCountry.keySet().toArray()[i].toString();
            System.out.println("### Country: " + country);

            for (int j = 0; j < 3; j++)
            {
                String hill[] = hillsToCountry.get(country).toArray()[j].toString().split(",");
                System.out.println(hill[1] + " " + hill[3]);
            }
        }
    }

}

