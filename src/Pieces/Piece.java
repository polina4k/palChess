package Pieces;

import Moves.Move;
import main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

//parent
public abstract class Piece {

    /*
    Values of row and columns range 0 to 7,
    Piece value uses AlphaZero value system
     */

    public int col,row;
    public int xPos, yPos;
    public boolean isWhite;
    public String name;
    public double value;
    public boolean isFirstMove;
    BufferedImage sheet;

    /*
    IIB, Try catch
     */
    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected Image sprite;
    protected int scale = sheet.getWidth() / 6;
    protected Board board;

    /*
    Piece move validation implements basic piece movements for every piece subclass, does not include special moves
     */
    public abstract boolean isValidMove(Move move);

    public void paint(Graphics2D g2D){
        g2D.drawImage(sprite, xPos, yPos, null);
    }
}
