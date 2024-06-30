package Pieces;
import main.Board;
import main.Move;

import java.awt.image.BufferedImage;


public class Knight extends Piece {
    public Knight(Board board, int col, int row, boolean isWhite) {
        this.board = board;
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "Knight";
        this.value = 3.0;
        this.isFirstMove = true;

        this.sprite = sheet.getSubimage(3 * scale, isWhite ? 0 : scale , scale, scale).getScaledInstance(scale,scale, BufferedImage.SCALE_SMOOTH);

    }

    @Override
    public boolean isValidMove(Move move) {

        int dy = Math.abs(move.newRow - move.oldRow); //absolute values in change of y and x
        int dx = Math.abs(move.newCol - move.oldCol);
        //from the way move class works, there is no need to check if the move is made outside of the board
        if(!((dy == 1 && dx == 2) || (dy == 2 && dx == 1))){ // checks if the move is NOT in the valid L shape
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