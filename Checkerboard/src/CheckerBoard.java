import Gamepieces.Gamepiece;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;


public class CheckerBoard extends JPanel {

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
        g.drawString("A B C D E F G H", 100, 100);
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




    }




    public static void main(String[] args) {
        System.out.println("Blue goes first...");
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new CheckerBoard());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // This code replaces one tile with another (The original tile is replaced with a zero, while the tile replaced becomes a 5)
        int[][] locations = {
                {0, 1, 2, 3, 4, 5, 6, 7, 8},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {2, 1, 0, 1, 0, 1, 0, 1, 0},
                {3, 0, 1, 0, 1, 0, 1, 0, 1},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 2, 0, 2, 0, 2, 0, 2, 0},
                {7, 0, 2, 0, 2, 0, 2, 0, 2},
                {8, 2, 0, 2, 0, 2, 0, 2, 0}};

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
                entry = JOptionPane.showInputDialog(null, "(R) Enter the row number:");
                x = Integer.parseInt(entry);
                entry = JOptionPane.showInputDialog(null, "(R) Enter the column letter:");
                y = Integer.parseInt(entry);

                entry2 = JOptionPane.showInputDialog(null, "(R) Enter the column to replace:");
                x2 = Integer.parseInt(entry2);
                entry2 = JOptionPane.showInputDialog(null, "(R) Enter the row to replace:");
                y2 = Integer.parseInt(entry2);
            }
            else {
                entry = JOptionPane.showInputDialog(null, "(B) Enter the row number:");
                x = Integer.parseInt(entry);
                entry = JOptionPane.showInputDialog(null, "(B) Enter the column letter:");
                y = Integer.parseInt(entry);

                entry2 = JOptionPane.showInputDialog(null, "(B) Enter the column to replace:");
                x2 = Integer.parseInt(entry2);
                entry2 = JOptionPane.showInputDialog(null, "(B) Enter the row to replace:");
                y2 = Integer.parseInt(entry2);
            }
            if (moves % 2 == 0 && locations[x][y] != 1) {
                JOptionPane.showMessageDialog(null, "Cheater");
                System.exit(0);
            }
            if (moves % 2 == 1 && locations[x][y] != 2) {
                JOptionPane.showMessageDialog(null, "Cheater");
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(null, locations[x][y]);
                locations[x][y] = 0;
                if (moves % 2 == 0) {
                    locations[x2][y2] = 1;
                }
                else locations[x2][y2] = 2;

                moves = moves + 1;
                System.out.print("Move " + moves);
                if (moves % 2 == 0) {
                    System.out.println("(Red's Turn)");
                }
                else System.out.println("(Blue's Turn)");
            }


        }




    }

    public static void print2D(int locations[][])
    {
        for (int[] row : locations)
        System.out.println(Arrays.toString(row));
    }
}