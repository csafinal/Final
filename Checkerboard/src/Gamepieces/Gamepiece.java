package Gamepieces;

public class Gamepiece {
    int xPos;
    int yPos;

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
