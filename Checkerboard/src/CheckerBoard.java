import Gamepieces.Gamepiece;

import java.awt.*;
import javax.swing.*;


public class CheckerBoard extends JPanel {
    Gamepiece[][] white = new Gamepiece[3][4];
    Gamepiece[][] blueforchase = new Gamepiece[3][4];
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



        for (int i = 0; i < white.length; i++) {
            for (int x = 0; x < white[i].length; x++) {
                white[i][x] = new Gamepiece();
                white[i][x].setCoordinates((150 + (x * 100)) - (i == 1 ? 50 : 0),100 + (i * 50));
            }
        }

        for (Gamepiece[] row : white) {
            for (Gamepiece piece : row) {
                g.setColor(Color.red);
                g.fillOval(piece.getX(),piece.getY(),50,50);
            }
        }

        for (int i = 0; i < blueforchase.length; i++) {
            for (int x = 0; x < blueforchase[i].length; x++) {
                blueforchase[i][x] = new Gamepiece();
                blueforchase[i][x].setCoordinates((100 + (x * 100)) + (i == 1 ? 50 : 0),450 - (i * 50));
            }
        }

        for (Gamepiece[] row : blueforchase) {
            for (Gamepiece piece : row) {
                g.setColor(Color.blue);
                g.fillOval(piece.getX(),piece.getY(),50,50);
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
        int[][] locations = {{0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 2, 0, 2, 0, 2, 0},
                {0, 2, 0, 2, 0, 2, 0, 2},
                {2, 0, 2, 0, 2, 0, 2, 0}};

        String entry;
        String entry2;
        int x;
        int y;
        int x2;
        int y2;
        int moves = 1;

        while (3 < 4) {
            entry = JOptionPane.showInputDialog(null, "Enter the column number:");
            x = Integer.parseInt(entry);
            entry = JOptionPane.showInputDialog(null, "Enter the row letter:");
            y = Integer.parseInt(entry);

            entry2 = JOptionPane.showInputDialog(null, "Enter the row to replace:");
            x2 = Integer.parseInt(entry2);
            entry2 = JOptionPane.showInputDialog(null, "Enter the column to replace:");
            y2 = Integer.parseInt(entry2);

            JOptionPane.showMessageDialog(null, locations[x][y]);
            locations[x][y] = 0;
            locations[x2][y2] = 5;
            moves = moves + 1;
            System.out.print("Move " + moves);
            if (moves % 2 == 0) {
                System.out.println("(Blue's Turn)");
            }
            else System.out.println("(Red's Turn)");
        }




    }

    public static void test() {

    }
}