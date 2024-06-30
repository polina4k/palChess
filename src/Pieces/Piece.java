package Pieces;

import main.Board;
import main.Move;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

//parent
public abstract class Piece {
    public int col,row; //values of row and column between 0-7
    public int xPos, yPos; //pixel positions on screen

    public boolean isWhite;
    public String name;
    public double value; //using AlphaZero value system
    public boolean isFirstMove;


    BufferedImage sheet; //looked up how to do this lol

    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
        } catch (IOException e) {
            e.printStackTrace(); //dont understand this lol
        }
    } //IIB, try catch

    protected Image sprite;
    protected int scale = sheet.getWidth() / 6;
    protected Board board;

   public abstract boolean isValidMove(Move move);

    public void paint(Graphics2D g2D){
        g2D.drawImage(sprite, xPos, yPos, null);
    }
}
