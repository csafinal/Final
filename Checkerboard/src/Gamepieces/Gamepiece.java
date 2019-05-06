package Gamepieces;

import java.awt.*;

public class Gamepiece {
    int xPos;
    int yPos;

    public static void paint(Graphics g) {
        // Creates an array of game pieces and prints them on the board
        Gamepiece[][] white = new Gamepiece[3][4];
        Gamepiece[][] blueforchase = new Gamepiece[3][4];
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
                blueforchase[i][x].setCoordinates((100 + (x * 100)) + (i == 1 ? 50 : 0),450 - (i * 50)); // Sets the locations for the pieces
            }
        }

        for (Gamepiece[] row : blueforchase) {
            for (Gamepiece piece : row) {
                g.setColor(Color.blue);
                g.fillOval(piece.getX(),piece.getY(),50,50);
            }
        }


    }

     public Gamepiece() {
         xPos = 0;
         yPos = 0;

     }

     public void setCoordinates(int x, int y) {
         xPos = x;
         yPos = y;
     }

     public int getX() {
         return xPos;
     }

     public int getY() {
         return yPos;
     }
}
