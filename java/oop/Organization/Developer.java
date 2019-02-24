package oop.Organization;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 11/Oct/2017
 */

public class Developer extends Employee
{
    private String projectName;
    private String teamName;
    private static final String DEVELOPER = "Developer";
    
    public Developer(String name, BigDecimal salary, Date dateOfBirth, String email, String phoneNumber,  String projectName, String teamName)
    {
        setName(name);
        setSalary(salary);
        setDateOfBirth(dateOfBirth);
        setPosition(DEVELOPER);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setProjectName(projectName);
        setTeamName(teamName);
    }
    
    /**
     * Displays information about the employee and developer specific information (Project name and Team name)
     */
    @Override
    public void information()
    {
        Utils.displayBasicInfo(this);
        System.out.println("Project Name: " + getProjectName());
        System.out.println("Team Name: " + getTeamName());
    }
    
    //------------------------- ACCESSORS -------------------------
    
    public String getProjectName()
    {
        return projectName;
    }
    
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }
    
    public String getTeamName()
    {
        return teamName;
    }
    
    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }
}
