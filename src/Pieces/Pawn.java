package Pieces;
import Moves.Move;
import main.Board;

import java.awt.image.BufferedImage;

public class Pawn extends Piece {

    public boolean hasEnPassantRights;
    public Pawn(Board board, int col, int row, boolean isWhite) {
        this.board = board;
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "Pawn";
        this.value = 1;
        this.isFirstMove = true;


        this.sprite = sheet.getSubimage(scale * 5, isWhite ? 0 : scale, scale, scale).getScaledInstance(scale, scale, BufferedImage.SCALE_SMOOTH);

    }

    @Override
    public boolean isValidMove(Move move) {
        int dy = (move.newRow - move.oldRow); //absolute values in change of y and x
        int dx = Math.abs(move.newCol - move.oldCol);
        //normal move for white pawn

        if(move.linearCollision()){
            return false;
        }

        if (isWhite) {
            if (dx == 0 && dy == -1 && move.capture == null) {
                return true; //normal move
            } else if (dx == 0 && dy == -2 && move.oldRow == 6 && move.capture == null) {
                return true; //first move, 2 squares
            } else if (dx == 1 && dy == -1 && !(move.capture == null)) {
                if (move.capture.isWhite == move.piece.isWhite) {
                    // check that the occupying piece is NOT the same color
                    return false;
                }
                return true;
            }
        } else {
            if (dx == 0 && dy == 1 && move.capture == null) {
                return true; //normal move
            } else if (dx == 0 && dy == 2 && isFirstMove && move.capture == null) {
                return true; //first move, 2 squares
            } else if (dx == 1 && dy == 1 && !(move.capture == null)) {
                if (move.capture.isWhite == move.piece.isWhite) {
                    // check that the occupying piece is NOT the same color
                    return false;
                }
                return true;
            }
        }


        return false;
    }

}