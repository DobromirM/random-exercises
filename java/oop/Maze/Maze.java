package oop.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created on: 22/Apr/2017
 *
 * @author Dobromir
 */
public class Maze extends JComponent implements KeyListener, ActionListener
{
    public static final String MAZE_FILE_PATH = "./java/oop/resources/maze21.txt";
    public static final int FIELD_SIZE = 15;
    public static final int CIRCLE_SIZE = FIELD_SIZE - 2;
    public static boolean[][] maze;
    public static int[] playerPos = {1, 1};
    public static int[] exitPos;
    public static JButton resetButton = new JButton();
    public static JFrame frame = new JFrame("Maze");

    public Maze()
    {
        addKeyListener(this);
        setFocusable(true);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        maze = mazeToArray(MAZE_FILE_PATH);
        displayMaze(maze);
        int mazeSize = maze.length;
        exitPos = new int[]{mazeSize - 2, mazeSize - 2};

        frame.setSize(FIELD_SIZE * mazeSize + 15, FIELD_SIZE * mazeSize + 65);
        frame.add(new Maze());
        resetButton.setText("Reset");
        frame.add(resetButton, BorderLayout.PAGE_END);
        resetButton.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Draw the maze
     *
     * @param graphics
     */
    @Override
    public void paintComponent(Graphics graphics)
    {
        Graphics2D g = (Graphics2D) graphics;

        g.setColor(Color.BLACK);
        paintMaze(maze, g);
        int mazeSize = maze.length;

        g.setColor(Color.BLUE);
        g.fillOval(FIELD_SIZE * playerPos[0], FIELD_SIZE * playerPos[1], CIRCLE_SIZE, CIRCLE_SIZE);
        g.setColor(Color.RED);
        g.fillOval(FIELD_SIZE * (mazeSize - 2), FIELD_SIZE * (mazeSize - 2), CIRCLE_SIZE, CIRCLE_SIZE);
    }


    /**
     * Paint a maze from a given boolean array
     *
     * @param mazeArray - The boolean array
     */
    public static void paintMaze(boolean mazeArray[][], Graphics2D g)
    {
        for (int y = 0; y < mazeArray.length; y++)
        {
            for (int x = 0; x < mazeArray[y].length; x++)
            {
                int[] fieldPos = {FIELD_SIZE * x, FIELD_SIZE * y};

                if (mazeArray[y][x] == true)
                {
                    g.setColor(Color.BLACK);
                    g.fillRect(fieldPos[0], fieldPos[1], FIELD_SIZE, FIELD_SIZE);
                }
                else
                {
                    g.setColor(Color.WHITE);
                }
            }
        }
    }

    /**
     * Read a maze from a file and transform it into a boolean array
     *
     * @param path - The path of the file
     * @return - The boolean array
     * @throws FileNotFoundException
     */
    public static boolean[][] mazeToArray(String path) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(path));
        int mazeDimension = mazeSize(path);
        boolean[][] array = new boolean[mazeDimension][mazeDimension];
        int rowNum = 0;

        while (sc.hasNextLine())
        {

            String line = sc.nextLine();

            for (int i = 0; i < line.length(); i++)
            {
                if (line.charAt(i) == ' ')
                {
                    array[rowNum][i] = false;
                }

                if (line.charAt(i) == '#')
                {
                    array[rowNum][i] = true;
                }
            }

            rowNum++;
        }

        return array;
    }

    /**
     * Display a maze from a given boolean array in the console
     *
     * @param mazeArray - The boolean array
     */
    public static void displayMaze(boolean mazeArray[][])
    {
        for (boolean[] row : mazeArray)
        {
            for (boolean item : row)
            {
                if (item == true)
                {
                    System.out.print("#");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Get the size of the maze
     *
     * @param path - Path to the maze file
     * @return - The size of the maze
     * @throws FileNotFoundException
     */
    public static int mazeSize(String path) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(path));
        int mazeDimension = sc.nextLine().length();
        return mazeDimension;
    }

    /**
     * Return true if the player move is Illegal
     *
     * @return - boolean
     */
    public static boolean isIllegalMove()
    {
        return maze[playerPos[1]][playerPos[0]];
    }

    /**
     * Key Bindings
     */
    @Override
    public void keyPressed(KeyEvent k)
    {
        if (k.getKeyCode() == KeyEvent.VK_UP)
        {
            playerPos[1]--;

            if (isIllegalMove())
            {
                playerPos[1]++;
            }

        }
        else if (k.getKeyCode() == KeyEvent.VK_DOWN)
        {
            playerPos[1]++;

            if (isIllegalMove())
            {
                playerPos[1]--;
            }
        }
        else if (k.getKeyCode() == KeyEvent.VK_LEFT)
        {
            playerPos[0]--;

            if (isIllegalMove())
            {
                playerPos[0]++;
            }
        }
        else if (k.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            playerPos[0]++;

            if (isIllegalMove())
            {
                playerPos[0]--;
            }
        }

        repaint();

        if (playerPos[0] == exitPos[0] && playerPos[1] == exitPos[1])
        {
            JOptionPane.showMessageDialog(frame, "Congratulations, you solved the maze!");
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    /**
     * Reset Button Functionality
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String action = actionEvent.getActionCommand();
        if (action.equals("Reset"))
        {
            playerPos = new int[]{1, 1};
            repaint();
        }
    }

}
