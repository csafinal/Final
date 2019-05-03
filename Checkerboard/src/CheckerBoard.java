import Gamepieces.Gamepiece;

import java.awt.*;
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
        System.out.println("Blue goes first...");
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(this);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        array();
        rules(locations);


    }

    static String[][] locations;

    public static void array() {
        // This array sets the values of the board with 1 being red, 2 being blue, 0 being empty space, and 9 being the unplayable area
        String[][] displayArray = {
                {"0", "1", "2", "3", "4", "5", "6", "7", "8"},
                {"1", "X", "R", "X", "R", "X", "R", "X", "R"},
                {"2", "R", "X", "R", "X", "R", "X", "R", "X"},
                {"3", "X", "R", "X", "R", "X", "R", "X", "R"},
                {"4", "0", "X", "0", "X", "0", "X", "0", "X"},
                {"5", "X", "0", "X", "0", "X", "0", "X", "0"},
                {"6", "B", "X", "B", "X", "B", "X", "B", "X"},
                {"7", "X", "B", "X", "B", "X", "B", "X", "B"},
                {"8", "B", "X", "B", "X", "B", "X", "B", "X"}};



        locations = displayArray;


    }

    public static void rules(String[][] locations) {
        String entry;
        String entry2;
        int x;
        int y;
        int x2;
        int y2;
        int moves = 1;

        while (3 < 4) {
            print2D(locations);
            if (moves % 2 == 0) {
                entry = JOptionPane.showInputDialog(null, "(1) Enter the row number:");
                x = Integer.parseInt(entry);
                entry = JOptionPane.showInputDialog(null, "(1) Enter the column letter:");
                y = Integer.parseInt(entry);

                entry2 = JOptionPane.showInputDialog(null, "(1) Enter the row to replace:");
                x2 = Integer.parseInt(entry2);
                entry2 = JOptionPane.showInputDialog(null, "(1) Enter the column to replace:");
                y2 = Integer.parseInt(entry2);
            }
            else {
                entry = JOptionPane.showInputDialog(null, "(2) Enter the row number:");
                x = Integer.parseInt(entry);
                entry = JOptionPane.showInputDialog(null, "(2) Enter the column letter:");
                y = Integer.parseInt(entry);

                entry2 = JOptionPane.showInputDialog(null, "(2) Enter the row to replace:");
                x2 = Integer.parseInt(entry2);
                entry2 = JOptionPane.showInputDialog(null, "(2) Enter the column to replace:");
                y2 = Integer.parseInt(entry2);
            }

            if (x2 != x - 1 && moves % 2 != 0) {
                System.out.println("Invalid Number!");
                array();

            }
            else if (x2 != x + 1 && moves % 2 == 0) {
                System.out.println("Invalid Number!");
                array();

            }

            if (moves % 2 == 0 && locations[x][y].equals("R")) {
                JOptionPane.showMessageDialog(null, "Cheater");
                System.exit(0);
            }
            if (moves % 2 == 1 && !locations[x][y].equals("R")) {
                JOptionPane.showMessageDialog(null, "Cheater");
                System.exit(0);
            }
            else {
                locations[x][y] = "0";
                if (moves % 2 == 0) {
                    locations[x2][y2] = "R";
                }
                else locations[x2][y2] = "B";

                moves = moves + 1;
                System.out.print("Move " + moves);
                if (moves % 2 == 0) {
                    System.out.println("(Red's Turn)");
                }
                else System.out.println("(Blue's Turn)");
            }
        }
    }

    public static void print2D(String locations[][])
    {
        for (String[] row : locations)
            System.out.println(Arrays.toString(row));
    }
}