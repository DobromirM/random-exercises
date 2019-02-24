package oop.Organization;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public class Salesperson extends Employee
{
    private Integer numOfSales;
    private Integer numOfClients;
    private static final String SALESPERSON = "Salesperson";
    
    public Salesperson(String name, BigDecimal salary, Date dateOfBirth, String email, String phoneNumber, Integer numOfSales, Integer numOfClients)
    {
        setName(name);
        setSalary(salary);
        setDateOfBirth(dateOfBirth);
        setPosition(SALESPERSON);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setNumOfSales(numOfSales);
        setNumOfClients(numOfClients);
    }
    
    /**
     * Displays information about the employee and salesperson specific information (Number of sales and clients)
     */
    @Override
    public void information()
    {
        Utils.displayBasicInfo(this);
        System.out.println("Number of sales: " + getNumOfSales());
        System.out.println("Number of clients: " + getNumOfClients());
    }
    
    //------------------------- ACCESSORS -------------------------
    
    public Integer getNumOfSales()
    {
        return numOfSales;
    }
    
    public void setNumOfSales(Integer numOfSales)
    {
        this.numOfSales = numOfSales;
    }
    
    public Integer getNumOfClients()
    {
        return numOfClients;
    }
    
    public void setNumOfClients(Integer numOfClients)
    {
        this.numOfClients = numOfClients;
    }
}
