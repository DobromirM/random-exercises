package algorithms;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 27/Jan/2018
 */

public class QueueException extends RuntimeException
{
    public QueueException(String method)
    {
        super("Tried to apply " + method + " to an empty deque!");
    }
}
