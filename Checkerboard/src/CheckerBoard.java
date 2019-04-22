import Gamepieces.Gamepiece;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CheckerBoard extends JPanel {
    Gamepiece[][] white = new Gamepiece[3][4];
    Gamepiece[][] blueforchase = new Gamepiece[3][4];
// Graphics for the board
    public void paint(Graphics g) {
        //Fill in the checkerboard design
        g.fillRect(100, 100, 400, 400);
        for(int i = 100; i <= 400; i+=100) {
            for(int j = 100; j <= 400; j+=100) {
                g.clearRect(i, j, 50, 50);
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(i, j, 50, 50);
            }
        }



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
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new CheckerBoard());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}