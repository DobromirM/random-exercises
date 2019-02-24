package algorithms_and_data_structs.ExpressionEvaluator;

/**
 * <br> <br>
 *
 * @author DMarinov
 * Created on: 09/Mar/2018
 */
public class ExpressionEvaluator
{
    // String constants
    private static final String YES = "y";
    private static final String NO = "n";
    
    /**
     * Test method of the application
     * Prompt the user to enter expressions and evaluated them
     */
    public static void main(String[] args)
    {
        Parser parser = new Parser();
        
        System.out.println("Welcome to the expression evaluation program.");
        
        String run;
        do
        {
            System.out.println("\nPlease type an expression: ");
            
            try
            {
                ExpTree tree = parser.parseLine();
                System.out.print("Post-order:");
                System.out.println(tree.postOrderString());
                
                System.out.print("Expression: ");
                System.out.println(tree.toString());
                
                Integer value = tree.evaluate();
                System.out.print("Result: ");
                System.out.println(value);
            }
            catch (ParseException ex)
            {
                System.out.println(ex.getMessage());
            }
            catch (ArithmeticException ex)
            {
                System.out.print("Evaluation failed: ");
                System.out.println(ex.getMessage());
            }
            
            do
            {
                System.out.println("Another expression (y/n)?");
                run = parser.getLine().toLowerCase();
            } while (!run.equals(YES) && !run.equals(NO));
        } while (run.equals(YES));
    }
}
