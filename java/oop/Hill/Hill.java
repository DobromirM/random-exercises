package oop.Hill;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created on: 23/Apr/2017
 *
 * @author Dobromir
 */
public class Hill
{
    Integer number;
    String name;
    String country;
    Double height;
    Double latitude;
    Double longitude;
    
    public Hill(Integer number, String name, String country, Double height, Double latitude, Double longitude)
    {
        this.number = number;
        this.name = name;
        this.country = country;
        this.height = height;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Create a list of hills from a csv file
     *
     * @return - The list of hills
     *
     * @throws FileNotFoundException
     */
    public static List<Hill> readHills() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("./java/oop/resources/hills.csv"));
        sc.nextLine();
        
        List<Hill> hills = new ArrayList<>();
        
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] fieldNames = line.split(",");
            
            Hill hill = new Hill(Integer.parseInt(fieldNames[0]), fieldNames[1], fieldNames[2], Double.parseDouble(fieldNames[3]), Double.parseDouble(fieldNames[4]), Double.parseDouble(fieldNames[5]));
            
            hills.add(hill);
        }
        
        return hills;
    }
    
    /**
     * Create a map with countries as keys and a set of hills as values
     *
     * @param hills - A list of hills data
     *
     * @return - The hills to country map
     */
    public static Map<String, Set<Hill>> hillsByCounty(List<Hill> hills)
    {
        hills.sort(Hill.getCountryComparator());
        Map<String, Set<Hill>> hillsToCountry = new LinkedHashMap<>();
        Set<Hill> hillSet;
        
        for (Hill hill : hills)
        {
            if (hillsToCountry.get(hill.country) == null)
            {
                hillSet = new TreeSet<>(getNameComparator());
                hillsToCountry.put(hill.country, hillSet);
            }
            hillsToCountry.get(hill.country).add(hill);
        }
        
        return hillsToCountry;
    }
    
    /**
     * Format: number,name,country,height,latitude,longitude
     */
    @Override
    public String toString()
    {
        return number + "," + name + "," + country + "," + height + "," + latitude + "," + longitude;
    }
    
    static Comparator<Hill> getNameComparator()
    {
        return Comparator.comparing(o -> o.name);
    }
    
    static Comparator<Hill> getHeightComparator()
    {
        return Comparator.comparing(o -> o.height);
    }
    
    static Comparator<Hill> getCountryComparator()
    {
        return Comparator.comparing(o -> o.country);
    }
}
