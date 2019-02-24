package oop.Organization;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public abstract class Employee
{
    private String name;
    private BigDecimal salary;
    private Date dateOfBirth;
    private String position;
    private String email;
    private String phoneNumber;
    
    /**
     * Displays information about the employee
     */
    public abstract void information();
    
    //------------------------- ACCESSORS -------------------------
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public BigDecimal getSalary()
    {
        return salary;
    }
    
    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }
    
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public void setPosition(String position)
    {
        this.position = position;
    }
    
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
