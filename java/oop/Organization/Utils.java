package oop.Organization;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public class Utils
{
    /**
     * Displays the basic information of an employee
     *
     * @param employee - The employee object
     */
    static void displayBasicInfo(Employee employee)
    {
        System.out.println("Name: " + employee.getName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Date of birth: " + dateToString(employee.getDateOfBirth()));
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Phone number: " + employee.getPhoneNumber());
    }
    
    /**
     * Converts a string to date in the format dd/MM/yyyy
     *
     * @param string - input string in the format dd/MM/yyyy
     * @return - object of type date
     * @throws ParseException - throws an exception if the input string invalid
     */
    static Date stringToDate(String string) throws ParseException
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(string);
    }
    
    /**
     * Converts a date to a string in the format dd/MM/yyyy
     *
     * @param date - input date
     * @return - string in the format dd/MM/yyyy
     */
    static String dateToString(Date date)
    {
        DateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
        return outputFormatter.format(date);
    }
}
