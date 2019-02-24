package oop.StudentMarks;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 17/Nov/2017
 */

public class InvalidNumberException extends Exception
{
    // Empty Constructor
    public InvalidNumberException()
    {
        super("Only positive numbers are allowed!");
    }
    
    // Constructor that accepts a message
    public InvalidNumberException(String message)
    {
        super(message);
    }
}
