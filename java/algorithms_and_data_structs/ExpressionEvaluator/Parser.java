package algorithms_and_data_structs.ExpressionEvaluator;

import java.io.*;

class ParseException extends RuntimeException
{
    public ParseException(String s)
    {
        super("Invalid expression: " + s);
    }
}

public class Parser
{
    private Lexer lex;
    
    public Parser()
    {
        lex = new Lexer();
    }
    
    public String getLine()
    {
        return lex.getLine();
    }
    
    public ExpTree parseLine()
    {
        ExpTree defs = null;
        lex.init();
        lex.getToken();
        
        if (lex.token == Lexer.let)
        {
            lex.getToken();
            defs = parseDefList();
            if (lex.token != Lexer.in)
            {
                throw new ParseException("'in' expected");
            }
            lex.getToken();
        }
        
        ExpTree result = parseExp(true);
        
        if (lex.token != Lexer.semico)
        {
            throw new ParseException("semicolon expected");
        }
        
        if (defs != null)
        {
            result = makeLetTree(defs, result);
        }
        
        return result;
    }
    
    private ExpTree parseExp(boolean idsAllowed)
    {
        ExpTree result = parseTerm(idsAllowed);
        {
            while (lex.token == Lexer.plus || lex.token == Lexer.minus)
            {
                int op = lex.token;
                lex.getToken();
                
                if (op == Lexer.plus)
                {
                    result = makePlusTree(result, parseTerm(idsAllowed));
                }
                
                else
                {
                    result = makeMinusTree(result, parseTerm(idsAllowed));
                }
            }
        }
        
        return result;
    }
    
    private ExpTree parseTerm(boolean idsAllowed)
    {
        ExpTree result = parsePow(idsAllowed);
        {
            while (lex.token == Lexer.times || lex.token == Lexer.div || lex.token == Lexer.mod)
            {
                int op = lex.token;
                lex.getToken();
                if (op == Lexer.times)
                {
                    result = makeTimesTree(result, parsePow(idsAllowed));
                }
                else if (op == Lexer.div)
                {
                    result = makeDivideTree(result, parsePow(idsAllowed));
                }
                else
                {
                    result = makeModTree(result, parsePow(idsAllowed));
                }
            }
        }
        return result;
    }
    
    private ExpTree parsePow(boolean idsAllowed)
    {
        ExpTree result = parseOpd(idsAllowed);
        if (lex.token == Lexer.pow)
        {
            lex.getToken();
            result = makePowerTree(result, parsePow(idsAllowed));
        }
        return result;
    }
    
    private ExpTree parseOpd(boolean idsAllowed)
    {
        ExpTree result;
        switch (lex.token)
        {
            case Lexer.num:
                result = makeNumberLeaf(lex.numval);
                lex.getToken();
                return result;
            case Lexer.id:
                if (!idsAllowed)
                {
                    throw new ParseException("identifier not allowed in identifier definition");
                }
                result = makeIdLeaf(lex.idval);
                lex.getToken();
                return result;
            case Lexer.lp:
                lex.getToken();
                result = parseExp(idsAllowed);
                if (lex.token != Lexer.rp)
                {
                    throw new ParseException("right parenthesis expected");
                }
                lex.getToken();
                return result;
            default:
                throw new ParseException("invalid operand");
        }
    }
    
    private ExpTree parseDefList()
    {
        ExpTree result = parseDef();
        while (lex.token == Lexer.and)
        {
            lex.getToken();
            result = makeAndTree(result, parseDef());
        }
        return result;
    }
    
    private ExpTree parseDef()
    {
        if (lex.token != Lexer.id)
        {
            throw new ParseException("definition must start with identifier");
        }
        char id = lex.idval;
        lex.getToken();
        if (lex.token != Lexer.eq)
        {
            throw new ParseException("'=' expected");
        }
        lex.getToken();
        return makeDefTree(id, parseExp(false));
    }
    
    static ExpTree makeNumberLeaf(int n)
    {
        return new ExpTree(ExpTree.NUMBER_NODE, n, null, null);
    }
    
    static ExpTree makeIdLeaf(char c)
    {
        return new ExpTree(ExpTree.ID_NODE, c, null, null);
    }
    
    static ExpTree makePlusTree(ExpTree l, ExpTree r)
    {
        return new ExpTree(ExpTree.OP_NODE, '+', l, r);
    }
    
    static ExpTree makeMinusTree(ExpTree l, ExpTree r)
    {
        return new ExpTree(ExpTree.OP_NODE, '-', l, r);
    }
    
    static ExpTree makeTimesTree(ExpTree l, ExpTree r)
    {
        return new ExpTree(ExpTree.OP_NODE, '*', l, r);
    }
    
    static ExpTree makeDivideTree(ExpTree l, ExpTree r)
    {
        return new ExpTree(ExpTree.OP_NODE, '/', l, r);
    }
    
    static ExpTree makeModTree(ExpTree l, ExpTree r)
    {
        return new ExpTree(ExpTree.OP_NODE, '%', l, r);
    }
    
    static ExpTree makePowerTree(ExpTree l, ExpTree r)
    {
        return new ExpTree(ExpTree.OP_NODE, '^', l, r);
    }
    
    static ExpTree makeLetTree(ExpTree l, ExpTree r)
    {
        return new ExpTree(ExpTree.LET_NODE, null, l, r);
    }
    
    static ExpTree makeAndTree(ExpTree l, ExpTree r)
    {
        return new ExpTree(ExpTree.AND_NODE, null, l, r);
    }
    
    static ExpTree makeDefTree(char c, ExpTree t)
    {
        ExpTree l = new ExpTree(ExpTree.ID_NODE, c, null, null);
        return new ExpTree(ExpTree.EQUALS_NODE, null, l, t);
    }
}

class Lexer
{
    static final int err = 0, num = 1, id = 2, plus = 3, minus = 4, times = 5, div = 6, mod = 7, lp = 8, rp = 9, semico = 10, let = 11, and = 12, in = 13, eq = 14, pow = 15;
    int token;
    char idval;
    int numval;
    private String line = "";
    private BufferedReader buf;
    
    Lexer()
    {
        buf = new BufferedReader(new InputStreamReader(System.in));
    }
    
    String getLine()
    {
        init();
        return (line);
    }
    
    void init()
    {
        do
        {
            try
            {
                line = buf.readLine().trim();
            }
            catch (Exception e)
            {
                System.out.println("Unexpected error in input");
                System.exit(1);
            }
        } while (line.length() == 0);
    }
    
    void getToken()
    {
        if (line.length() == 0)
        {
            token = err;
        }
        else
        {
            switch (line.charAt(0))
            {
                case '+':
                    token = plus;
                    line = line.substring(1).trim();
                    break;
                case '-':
                    token = minus;
                    line = line.substring(1).trim();
                    break;
                case '*':
                    token = times;
                    line = line.substring(1).trim();
                    break;
                case '/':
                    token = div;
                    line = line.substring(1).trim();
                    break;
                case '^':
                    token = pow;
                    line = line.substring(1).trim();
                    break;
                case '%':
                    token = mod;
                    line = line.substring(1).trim();
                    break;
                case '(':
                    token = lp;
                    line = line.substring(1).trim();
                    break;
                case ')':
                    token = rp;
                    line = line.substring(1).trim();
                    break;
                case ';':
                    token = semico;
                    line = line.substring(1).trim();
                    break;
                case '=':
                    token = eq;
                    line = line.substring(1).trim();
                    break;
                default:
                    if (Character.isDigit(line.charAt(0)))
                    {
                        token = num;
                        numval = line.charAt(0) - '0';
                        int i = 1;
                        while (i < line.length() && Character.isDigit(line.charAt(i)))
                        {
                            numval = numval * 10 + line.charAt(i) - '0';
                            i++;
                        }
                        line = line.substring(i).trim();
                    }
                    else if (Character.isUpperCase(line.charAt(0)) && (line.length() == 1 || !Character.isLetter(line.charAt(1))))
                    {
                        token = id;
                        idval = line.charAt(0);
                        line = line.substring(1).trim();
                    }
                    else if (line.length() >= 3 && line.charAt(0) == 'a' && line.charAt(1) == 'n' && line.charAt(2) == 'd' && (line.length() == 3 || !Character.isLowerCase(line.charAt(3))))
                    {
                        token = and;
                        line = line.substring(3).trim();
                    }
                    else if (line.length() >= 3 && line.charAt(0) == 'l' && line.charAt(1) == 'e' && line.charAt(2) == 't' && (line.length() == 3 || !Character.isLowerCase(line.charAt(3))))
                    {
                        token = let;
                        line = line.substring(3).trim();
                    }
                    else if (line.length() >= 2 && line.charAt(0) == 'i' && line.charAt(1) == 'n' && (line.length() == 2 || !Character.isLowerCase(line.charAt(2))))
                    {
                        token = in;
                        line = line.substring(2).trim();
                    }
                    else
                    {
                        token = err;
                    }
            }
        }
    }
}