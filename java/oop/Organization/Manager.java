package oop.Organization;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public class Manager extends Employee
{
    private String department;
    private Integer numOfSubordinates;
    private static final String MANAGER = "Manager";
    
    public Manager(String name, BigDecimal salary, Date dateOfBirth, String email, String phoneNumber, String department, Integer numOfSubordinates)
    {
        setName(name);
        setSalary(salary);
        setDateOfBirth(dateOfBirth);
        setPosition(MANAGER);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setDepartment(department);
        setNumOfSubordinates(numOfSubordinates);
    }
    
    /**
     * Displays information about the employee and manager specific information (Department and number of subordinates)
     */
    @Override
    public void information()
    {
        Utils.displayBasicInfo(this);
        System.out.println("Department: " + getDepartment());
        System.out.println("Number of Subordinates: " + getNumOfSubordinates());
    }
    
    //------------------------- ACCESSORS -------------------------
    
    public String getDepartment()
    {
        return department;
    }
    
    public void setDepartment(String department)
    {
        this.department = department;
    }
    
    public Integer getNumOfSubordinates()
    {
        return numOfSubordinates;
    }
    
    public void setNumOfSubordinates(Integer numOfSubordinates)
    {
        this.numOfSubordinates = numOfSubordinates;
    }
}
