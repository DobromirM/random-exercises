package algorithms_and_data_structs.ExpressionEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * <br> <br>
 *
 * @author DMarinov
 * Created on: 09/Mar/2018
 */
public class ExpTree
{
    private int kind;
    private Object value;
    private ExpTree left, right;
    private Integer precedence;
    private Map<Character, Integer> identifiers;
    
    //Node Types
    public static final int NUMBER_NODE = 0;
    public static final int ID_NODE = 1;
    public static final int OP_NODE = 2;
    public static final int LET_NODE = 3;
    public static final int AND_NODE = 4;
    public static final int EQUALS_NODE = 5;
    
    //Additional constants
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int OFFSET = 36;
    
    /**
     * Public constructor
     *
     * @param kind  - The type of the node
     * @param value - The value of the node
     * @param left  - Left child of the node
     * @param right - Right child of the node
     */
    public ExpTree(int kind, Object value, ExpTree left, ExpTree right)
    {
        this.kind = kind;
        this.value = value;
        this.left = left;
        this.right = right;
        
        if (kind == OP_NODE)
        {
            switch ((Character) value)
            {
                case '+':
                    this.precedence = 1;
                    break;
                
                case '-':
                    this.precedence = 1;
                    break;
                
                case '*':
                    this.precedence = 2;
                    break;
                
                case '/':
                    this.precedence = 2;
                    break;
                
                case '%':
                    this.precedence = 2;
                    break;
                
                case '^':
                    this.precedence = 3;
                    break;
            }
        }
    }
    
    /**
     * Return a string representation of the tree using post-order traversal
     *
     * @return - String representation of the tree
     */
    public String postOrderString()
    {
        return postOrder(this);
    }
    
    /**
     * Evaluate the expression in the tree and return the result
     *
     * @return - Result of the expression as an Integer
     */
    public Integer evaluate()
    {
        return calculate(this);
    }
    
    /**
     * Return a string representation of the tree using in-order traversal
     *
     * @return - String representation of the tree
     */
    @Override
    public String toString()
    {
        return inOrder(this);
    }
    
    /**
     * Recursive method for creating a string representation of the tree using post-order traversal
     *
     * @param root - Root of the tree
     *
     * @return - String representation of the tree
     */
    private String postOrder(ExpTree root)
    {
        String content = "";
        
        if (root != null)
        {
            if (root.kind == LET_NODE)
            {
                content = content + postOrder(root.right);
            }
            else
            {
                
                content = content + postOrder(root.left);
                content = content + postOrder(root.right);
                content = content + " " + root.value.toString();
            }
        }
        
        return content;
    }
    
    /**
     * Calculate the value of the expression in the tree
     * Note: The method uses recursion when calculating expression in nodes of type 'AND'
     *
     * @param root - Root of the tree to be evaluated
     *
     * @return - Integer value of the expression
     *
     * @throws ArithmeticException - Exception thrown in the cases of division by 0 or negative exponent
     */
    private Integer calculate(ExpTree root) throws ArithmeticException
    {
        switch (root.kind)
        {
            case NUMBER_NODE:
                return (Integer) root.value;
            
            case ID_NODE:
                return resolveID(root);
            
            case OP_NODE:
                return applyOperation(root);
            
            case LET_NODE:
                return evaluateLetExpression(root);
            
            case AND_NODE:
                calculate(root.left);
                calculate(root.right);
                return null;
            
            case EQUALS_NODE:
                addIdentifier(root);
                return null;
            
            default:
                return null;
        }
    }
    
    /**
     * Resolve the value of an identifier in the expression
     *
     * If the map of 'identifier -> value' is initialized it is used to obtain the value
     * if the identifier is missing, a default value of 0 is used.
     *
     * If the map is not initialized the identifiers are given the values A=26, B=25, C=24 .... Z=1
     *
     * @param root - Node of type 'ID'
     *
     * @return - Integer value of the node
     */
    private Integer resolveID(ExpTree root)
    {
        Integer value;
        
        if (identifiers == null)
        {
            value = OFFSET - (Character.getNumericValue((Character) root.value));
        }
        else
        {
            value = identifiers.get(root.value);
            
            if (value == null)
            {
                System.out.println("Value for identifier " + root.value + " is missing, the default value 0 will be used!");
                value = 0;
            }
        }
        
        return value;
    }
    
    /**
     * Apply the operation node to its left and right children
     *
     * @param root - Node of type 'OP'
     *
     * @return - The value of the result after the operation
     *
     * @throws ArithmeticException - Exception thrown in the cases of division by 0 or negative exponent
     */
    private Integer applyOperation(ExpTree root) throws ArithmeticException
    {
        Integer leftValue = calculate(root.left);
        Integer rightValue = calculate(root.right);
        
        switch ((Character) root.value)
        {
            case '+':
                return leftValue + rightValue;
            
            case '-':
                return leftValue - rightValue;
            
            case '*':
                return leftValue * rightValue;
            
            case '/':
                return leftValue / rightValue;
            
            case '%':
                return leftValue % rightValue;
            
            case '^':
                if (rightValue < 0)
                {
                    throw new ArithmeticException("Negative exponent");
                }
                else
                {
                    
                    return (int) Math.pow(leftValue, rightValue);
                }
            
            default:
                return null;
        }
    }
    
    /**
     * Create a map for the identifiers and evaluate the left branch of the tree first
     * in order to resolve all values of the identifiers and populate the map with them.
     *
     * Calculate the right branch of the tree using the map and return the
     * result of the whole 'let' expression
     *
     * @param root - Root of the tree of type 'let'
     *
     * @return - Value of the expression in the tree
     */
    private Integer evaluateLetExpression(ExpTree root)
    {
        identifiers = new HashMap<>();
        calculate(root.left);
        return calculate(root.right);
    }
    
    /**
     * Add a pair of identifier -> value to the map of identifiers after the value is calculated
     *
     * @param root - Node of type 'ID'
     */
    private void addIdentifier(ExpTree root)
    {
        identifiers.put((Character) root.left.value, calculate(root.right));
    }
    
    /**
     * Recursive method for creating a string representation of the tree using in-order traversal
     * Note: All unnecessary parentheses are removed when the string is generated
     *
     * @param root - Root of the tree
     *
     * @return - String representation of the tree
     */
    private String inOrder(ExpTree root)
    {
        String content = "";
        
        if (root != null)
        {
            switch (root.kind)
            {
                case LET_NODE:
                    content = "let ";
                    content = content + inOrder(root.left);
                    content = content + " in ";
                    content = content + inOrder(root.right);
                    return content;
                
                case AND_NODE:
                    content = content + inOrder(root.left) + " and " + inOrder(root.right);
                    return content;
                
                case EQUALS_NODE:
                    content = content + root.left.value.toString() + " = " + inOrder(root.right);
                    return content;
            }
            
            if (needsBrackets(root, root.left, LEFT))
            {
                content = content + "(" + inOrder(root.left) + ")";
            }
            else
            {
                content = content + inOrder(root.left);
            }
            
            content = content + root.value.toString();
            
            if (needsBrackets(root, root.right, RIGHT))
            {
                content = content + "(" + inOrder(root.right) + ")";
            }
            else
            {
                content = content + inOrder(root.right);
            }
        }
        
        return content;
    }
    
    /**
     * Return a boolean answer if the child expression needs parentheses around it or not
     *
     * @param root     - parent node
     * @param child    - child node
     * @param position - position of the child node (Left or Right)
     *
     * @return - Answer if the child expression needs parentheses as a boolean value
     */
    private Boolean needsBrackets(ExpTree root, ExpTree child, Integer position)
    {
        if (root.kind != OP_NODE || child.kind != OP_NODE)
        {
            return false;
        }
        
        if (child.hasLowerPrecedence(root))
        {
            return true;
        }
        
        if ((Character) root.value == '^')
        {
            return (Character) child.value == '^' && position.equals(LEFT);
        }
        else
        {
            return child.hasSamePrecedence(root) && position.equals(RIGHT);
        }
    }
    
    /**
     * Compare if the current node has a lower precedence than the given node
     *
     * @param comp - Node to be compared to
     *
     * @return - Boolean answer
     */
    private Boolean hasLowerPrecedence(ExpTree comp)
    {
        return this.precedence < comp.precedence;
    }
    
    /**
     * Compare if the current node has the same precedence than the given node
     *
     * @param comp - Node to be compared to
     *
     * @return - Boolean answer
     */
    private Boolean hasSamePrecedence(ExpTree comp)
    {
        return this.precedence.equals(comp.precedence);
    }
}
