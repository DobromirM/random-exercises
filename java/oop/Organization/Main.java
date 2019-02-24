package oop.Organization;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public class Main
{
    public static void main(String args[]) throws ParseException
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Manager("John Doe", new BigDecimal(70000), Utils.stringToDate("29/11/1992"), "jonDoe@fake.com", "0123456789", "Sales", 13));
        employees.add(new Salesperson("Jane Doe", new BigDecimal(50000), Utils.stringToDate("01/06/1999"), "janeDoe@fake.com", "9876543210", 50, 17));
        employees.add(new Developer("Foo Bar", new BigDecimal(85000), Utils.stringToDate("13/09/1997"), "fooBar@fake.com", "1313131313", "Teaching pigs how to fly", "Contoso"));
        
        for(Employee employee : employees)
        {
            employee.information();
            System.out.println("-----------------------------------------");
            System.out.println();
        }
    }
}
