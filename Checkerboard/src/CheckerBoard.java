import Gamepieces.Gamepiece;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.swing.*;


public class CheckerBoard extends JPanel {

    Graphics graphics;

    // Graphics for the board
    public void paint(Graphics g) {
        //Fill in the checkerboard design
        Graphics2D g2 = (Graphics2D)g;
        g.fillRect(100, 100, 400, 400);
        for(int i = 100; i <= 400; i+=100) {
            for(int j = 100; j <= 400; j+=100) {
                g.clearRect(i, j, 50, 50);
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(i, j, 50, 50);
            }
            Gamepiece.paint(g);
        }

        // Sets font for the text
        Font font = new Font("Serif", Font.PLAIN, 55);
        g2.setFont(font);
        g2.setColor(Color.orange);

        // This displays the letters and numbers for choosing
        g.drawString("1  2  3  4 5  6  7 8", 100, 95);
        g.drawString("1", 70, 145);
        g.drawString("2", 70, 195);
        g.drawString("3", 70, 245);
        g.drawString("4", 70, 295);
        g.drawString("5", 70, 345);
        g.drawString("6", 70, 395);
        g.drawString("7", 70, 445);
        g.drawString("8", 70, 495);

        //Builds the board
        for(int i = 150; i <= 450; i+=100) {
            for(int j = 150; j <= 450; j+=100) {
                g.clearRect(i, j, 50, 50);
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(i, j, 50, 50);

            }
        }

        this.graphics = g;


    }



    public CheckerBoard() {
        //Creates the frame for the board
        System.out.println("Blue goes first...");
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(this);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // This array sets the values of the board with 1 being red, 2 being blue, 0 being empty space, and 9 being the unplayable area
        int[][] locations = {
                {0, 1, 2, 3, 4, 5, 6, 7, 8},
                {1, 9, 1, 9, 1, 9, 1, 9, 1},
                {2, 1, 9, 1, 9, 1, 9, 1, 9},
                {3, 9, 1, 9, 1, 9, 1, 9, 1},
                {4, 0, 9, 0, 9, 0, 9, 0, 9},
                {5, 9, 0, 9, 0, 9, 0, 9, 0},
                {6, 2, 9, 2, 9, 2, 9, 2, 9},
                {7, 9, 2, 9, 2, 9, 2, 9, 2},
                {8, 2, 9, 2, 9, 2, 9, 2, 9}};


        rules(locations);
    }

    // Prints the board
    public static void print2D(int locations[][])
    {
        for (int[] row : locations)
            System.out.println(Arrays.toString(row));
    }

    public static void rules(int[][] locations) {
        String entry;
        String entry2;
        int x;
        int y;
        int x2;
        int y2;
        int moves = 1;
        // Allows for user input and moves pieces if they follow the rules
        while (3 < 4) {
            print2D(locations);
            if (moves % 2 == 0) {
                entry = JOptionPane.showInputDialog(null, "(R) Enter the row number:");
                x = Integer.parseInt(entry);
                entry = JOptionPane.showInputDialog(null, "(R) Enter the column letter:");
                y = Integer.parseInt(entry);

                entry2 = JOptionPane.showInputDialog(null, "(R) Enter the row to replace:");
                x2 = Integer.parseInt(entry2);
                entry2 = JOptionPane.showInputDialog(null, "(R) Enter the column to replace:");
                y2 = Integer.parseInt(entry2);
            }
            else {
                entry = JOptionPane.showInputDialog(null, "(B) Enter the row number:");
                x = Integer.parseInt(entry);
                entry = JOptionPane.showInputDialog(null, "(B) Enter the column letter:");
                y = Integer.parseInt(entry);

                entry2 = JOptionPane.showInputDialog(null, "(B) Enter the row to replace:");
                x2 = Integer.parseInt(entry2);
                entry2 = JOptionPane.showInputDialog(null, "(B) Enter the column to replace:");
                y2 = Integer.parseInt(entry2);
            }

            // Rules for moving the game pieces

            if (x2 != x - 1 && x2 != x - 2 && moves % 2 != 0) {
                JOptionPane.showMessageDialog(null, "Invalid Number!1\n");
                System.out.println("");
                rules(locations);

            }
            else if (x2 != x + 1 && x2 != x + 2 && moves % 2 == 0) {
                JOptionPane.showMessageDialog(null, "Invalid Number!2\n");
                System.out.println("");
                rules(locations);

            }
            if (y2 != y - 1 && y2 != y - 2 && y2 != y + 1 && y2 != y + 2) {
                JOptionPane.showMessageDialog(null, "Invalid Number! X is too far!\n");
                System.out.println("");
                rules(locations);

            }

            if (moves % 2 == 0 && locations[x][y] == 2) {
                JOptionPane.showMessageDialog(null, "Invalid Number!3\n");
                System.out.println("");
                rules(locations);
            }
            if (moves % 2 == 1 && locations[x][y] != 2) {
                JOptionPane.showMessageDialog(null, "Invalid Number!4\n");
                System.out.println("");
                rules(locations);
            }
            else {
                locations[x][y] = 0;

                if (moves % 2 == 0) {
                    locations[x2][y2] = 1;
                }
                else locations[x2][y2] = 2;

                moves = moves + 1;

                //Prints the moves to a text document
                PrintWriter out = null;
                try {
                    out = new PrintWriter("moves.txt");
                    out.println("You Made " + moves + " Moves");
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                }

                System.out.print("Move " + moves);
                if (moves % 2 == 0) {
                    System.out.println("(Red's Turn)");
                }
                else System.out.println("(Blue's Turn)");
            }



        }
    }
}