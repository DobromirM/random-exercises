package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * <br><br>
 *
 * @author Dobromir
 * Created on: 27/Oct/2017
 */

public class Dictionary
{
    public static void main(String[] args)
    {
        WordApplication frame = new WordApplication();
        frame.setTitle("swing.Dictionary");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class WordApplication extends JFrame
{
    //User input field
    JTextField userInput = new JTextField(20);
    //Message displayed on the middle panel
    JLabel messageLabel = new JLabel();
    //List of words
    LinkedList<String> words = new LinkedList<>();
    
    /**
     * Enumeration defining the main actions of the buttons
     */
    public enum Action
    {ADD_WORD, LAST_LETTER, FIND_WORD, REMOVE_LAST, REMOVE_ALL, CLEAR_LIST}
    
    WordApplication()
    {
        String defaultMessage = "Dobromir Marinov";
        messageLabel.setText(Utils.responsiveMessage(defaultMessage));
        messageLabel.setFont(new Font("Serif", Font.BOLD, 30));
        messageLabel.setPreferredSize(new Dimension(800, 500));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        userInput.setFont(new Font("Serif", Font.BOLD, 22));
        
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        add(topPanel, BorderLayout.NORTH);
        middlePanel.setLayout(new GridBagLayout());
        add(middlePanel);
        add(bottomPanel, BorderLayout.SOUTH);
        
        JButton butAdd = new JButton("Add Word");
        JButton butLastLetter = new JButton("Search by last letter");
        JButton butFindWord = new JButton("Search by word");
        JButton butRemoveLast = new JButton("Remove last occurrence");
        JButton butRemoveAll = new JButton("Remove all occurrences");
        JButton butClear = new JButton("Clear list");
        
        butAdd.addActionListener(new ButtonHandler(this, Action.ADD_WORD));
        butLastLetter.addActionListener(new ButtonHandler(this, Action.LAST_LETTER));
        butFindWord.addActionListener(new ButtonHandler(this, Action.FIND_WORD));
        butRemoveLast.addActionListener(new ButtonHandler(this, Action.REMOVE_LAST));
        butRemoveAll.addActionListener(new ButtonHandler(this, Action.REMOVE_ALL));
        butClear.addActionListener(new ButtonHandler(this, Action.CLEAR_LIST));
        
        topPanel.add(butAdd);
        topPanel.add(butLastLetter);
        topPanel.add(butFindWord);
        topPanel.add(butRemoveLast);
        topPanel.add(butRemoveAll);
        topPanel.add(butClear);
        
        middlePanel.add(messageLabel);
        
        bottomPanel.add(userInput);
        
        Integer appSize = 900;
        setSize(appSize, appSize);
    }
}

class ButtonHandler implements ActionListener
{
    //References to the variables of the app
    private JLabel messageLabel;
    private JTextField userInput;
    private LinkedList<String> words;
    //Current action
    private WordApplication.Action action;
    
    ButtonHandler(WordApplication app, WordApplication.Action action)
    {
        messageLabel = app.messageLabel;
        userInput = app.userInput;
        words = app.words;
        this.action = action;
    }
    
    /**
     * Handle button actions
     *
     * @param e - Action event
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String text = userInput.getText();
        
        if (Utils.isEmpty(text) && action != WordApplication.Action.FIND_WORD && action != WordApplication.Action.CLEAR_LIST)
        {
            messageLabel.setText(Utils.responsiveMessage("Please type your input text in the field at the bottom!"));
        }
        else
        {
            switch (action)
            {
                case ADD_WORD:
                    addWord(text);
                    break;
                
                case LAST_LETTER:
                    lastLetter(text);
                    break;
                
                case FIND_WORD:
                    findWord(text);
                    break;
                
                case REMOVE_LAST:
                    removeLast(text);
                    break;
                
                case REMOVE_ALL:
                    removeAll(text);
                    break;
                
                case CLEAR_LIST:
                    clearList();
                    break;
            }
        }
    }
    
    /**
     * Add a word to the list if it is valid
     *
     * @param word - The word to be added
     */
    private void addWord(String word)
    {
        if (Utils.isWord(word))
        {
            words.add(word);
            messageLabel.setText(Utils.responsiveMessage("The word '" + word + "' was added to the list!"));
        }
        else
        {
            messageLabel.setText(Utils.responsiveMessage("Please enter a valid word! <br> A word must start with a letter and contain only alphanumerics and hyphens!"));
        }
    }
    
    /**
     * Display all words ending with a specific letter
     *
     * @param letter - The ending letter
     */
    private void lastLetter(String letter)
    {
        if (Utils.isLetter(letter))
        {
            String matchedWords = Utils.findMatches(words, letter);
            
            if (Utils.isEmpty(matchedWords))
            {
                messageLabel.setText(Utils.responsiveMessage("The list does not contain any words ending with '" + letter.toLowerCase() + "'"));
            }
            else
            {
                messageLabel.setText(Utils.responsiveMessage("All words in the list ending with '" + letter.toLowerCase() + "': " + matchedWords));
            }
        }
        else
        {
            messageLabel.setText(Utils.responsiveMessage("Please enter a single letter character!"));
        }
    }
    
    /**
     * Display the number of occurrences and position of the specific word in the list
     * If the parameter is blank display the total number of words in the list
     *
     * @param word - The word to search for
     */
    private void findWord(String word)
    {
        if (Utils.isEmpty(word))
        {
            messageLabel.setText(Utils.responsiveMessage("The total number of words in the list is: " + words.size()));
        }
        else
        {
            Integer count = Collections.frequency(words, word);
            String message = "";
            
            if (count == 0)
            {
                message = "The list does not contain the word '" + word + "'";
            }
            else
            {
                String positions = Utils.findPositions(words, word);
                
                if (count == 1)
                {
                    message = "The list contains " + count + " instance of the word '" + word + "' in position " + positions;
                }
                else if (count > 1)
                {
                    message = "The list contains " + count + " instances of the word '" + word + "' in positions " + positions;
                }
            }
            messageLabel.setText(Utils.responsiveMessage(message));
        }
    }
    
    /**
     * Remove the last occurrence of a word in the list
     *
     * @param word - The word to be removed
     */
    private void removeLast(String word)
    {
        Boolean isRemoved = words.removeLastOccurrence(word);
        if (isRemoved)
        {
            messageLabel.setText(Utils.responsiveMessage("The last occurrence of the word '" + word + "' was removed from the list!"));
        }
        else
        {
            messageLabel.setText(Utils.responsiveMessage("The list does not contain the word '" + word + "'"));
        }
    }
    
    /**
     * Remove all occurrences of a word in the list
     *
     * @param word - The word to be removed
     */
    private void removeAll(String word)
    {
        Boolean isRemoved = words.removeAll(Collections.singleton(word));
        if (isRemoved)
        {
            messageLabel.setText(Utils.responsiveMessage("All occurrences of the word '" + word + "' were removed from the list!"));
        }
        else
        {
            messageLabel.setText(Utils.responsiveMessage("The list does not contain the word '" + word + "'"));
        }
    }
    
    /**
     * Clear all words from the list
     */
    private void clearList()
    {
        if (words.size() > 0)
        {
            words.clear();
            messageLabel.setText(Utils.responsiveMessage("All words form the list were removed!"));
        }
        else
        {
            messageLabel.setText(Utils.responsiveMessage("The list is already empty!"));
        }
    }
}

class Utils
{
    /**
     * Check if given string is a word
     * Note: A word must start with a letter and contain only alphanumerics and hyphens
     *
     * @param s - String to be evaluated
     *
     * @return - Boolean result
     */
    static Boolean isWord(String s)
    {
        return isLetter(s.substring(0, 1)) && hasAlphanumericsOnly(s.replace('-', 'z'));
    }
    
    /**
     * Check if a given character is a single letter
     *
     * @param s - String to be evaluated
     *
     * @return - Boolean result
     */
    static Boolean isLetter(String s)
    {
        return s.length() == 1 && Character.isLetter(s.charAt(0));
    }
    
    /**
     * Check if given string is empty
     *
     * @param s - String to be evaluated
     *
     * @return - Boolean result
     */
    static Boolean isEmpty(String s)
    {
        return Objects.equals(s, "");
    }
    
    /**
     * Check if a given string contains only alphanumeric characters
     *
     * @param message - String to be checked
     *
     * @return - Boolean result
     */
    static boolean hasAlphanumericsOnly(String message)
    {
        if (message == null)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < message.length(); ++i)
            {
                if (!Character.isLetterOrDigit(message.charAt(i)))
                {
                    return false;
                }
            }
            
            return true;
        }
    }
    
    /**
     * Find the positions of all occurrences of a word in a list
     *
     * @param words - List of words
     * @param w     - The word to search for
     *
     * @return - String of comma separated positions representing the positions of the occurrences
     */
    static String findPositions(LinkedList<String> words, String w)
    {
        StringBuilder positions = new StringBuilder();
        
        for (int i = 0; i < words.size(); i++)
        {
            if (Objects.equals(words.get(i), w))
            {
                positions.append(i).append(", ");
            }
        }
        
        return positions.length() > 0 ? positions.substring(0, positions.length() - 2) : "";
    }
    
    /**
     * Find all words from a list that end with specific letter
     * NOTE: This method is case INSENSITIVE!
     *
     * @param words  - List of words
     * @param letter - Ending letter
     *
     * @return - String of comma separated words ending with the given letter
     */
    static String findMatches(LinkedList<String> words, String letter)
    {
        letter = letter.toLowerCase();
        StringBuilder matchedWords = new StringBuilder();
        
        for (String w : words)
        {
            if (Objects.equals((w.toLowerCase().substring(w.length() - 1)), letter))
            {
                matchedWords.append(w).append(", ");
            }
        }
        
        return matchedWords.length() > 0 ? matchedWords.substring(0, matchedWords.length() - 2) : "";
    }
    
    /**
     * Format the given message to html with style so it is responsive
     *
     * @param message - Message to be formatted
     *
     * @return - Correctly formatted HTML
     */
    static String responsiveMessage(String message)
    {
        return "<html><center>" + message + "</center></html>";
    }
}

