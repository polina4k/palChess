package Pieces;
import main.Board;
import Moves.Move;

import java.awt.image.BufferedImage;
public class Bishop extends Piece {
    public Bishop(Board board, int col, int row, boolean isWhite) {
        this.board = board;
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "Bishop";
        this.value = 3.3;
        this.isFirstMove = true;
        this.sprite = sheet.getSubimage(2 * scale, isWhite ? 0 : scale, scale, scale).getScaledInstance(scale, scale, BufferedImage.SCALE_SMOOTH);

    }

    @Override
    public boolean isValidMove(Move move) {
        int dy = Math.abs(move.newRow - move.oldRow); //absolute values in change of y and x
        int dx = Math.abs(move.newCol - move.oldCol);

        if(move.diagonalCollision()){
            return false;
        }
        if(!(dy == dx)){ // for bishop, abs value of dy always equals dx
            return false;
        }


        if (move.capture != null) {
            if (move.capture.isWhite == move.piece.isWhite) {
                // check that the occupying piece is NOT the same color
                return false;
            }
        }
        return true;

    }
}