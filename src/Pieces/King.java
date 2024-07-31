package Pieces;
import Moves.Move;
import main.Board;

import java.awt.image.BufferedImage;
public class King extends Piece {
    public King(Board board, int col, int row, boolean isWhite) {
        this.board = board;
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "King";
        this.isFirstMove = true;

        this.sprite = sheet.getSubimage(0, isWhite ? 0 : scale, scale, scale).getScaledInstance(scale, scale, BufferedImage.SCALE_SMOOTH);

    }
    public King (){

    }

    @Override
    public boolean isValidMove(Move move) {
        int dy = Math.abs(move.newRow - move.oldRow);
        int dx = Math.abs(move.newCol - move.oldCol);

        //castling check
        /*
        if(move.capture instanceof Rook && (move.capture.isWhite == this.isWhite)){

        }*/
        if(!((dy == 1 && dx == 0) || (dx == 1 && dy == 0) || (dx == 1 && dy == 1))){
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