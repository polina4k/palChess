package main;

import Pieces.Piece;

public class Move {
    public int oldCol;
    public int oldRow;

    public int newCol;
    public int newRow;
    Board board;
    public Piece piece;
    public Piece capture;


    public Move (Board board, Piece piece, int newCol, int newRow){
        this.oldCol = piece.col;
        this.oldRow = piece.row;
        this.newCol = newCol;
        this.newRow = newRow;
        this.board = board;

        this.piece = piece;
        this.capture = board.getPiece(newCol, newRow);

    }

    public boolean linearCollision() { // looping over squares to check rook moves, returns true if there is a piece in the way
        int colDiff = newCol - oldCol;
        int rowDiff = newRow - oldRow;


        if(colDiff < 0){
            for (int c = oldCol - 1; c != newCol; c--) {
                if(board.getPiece(c, oldRow) != null){
                    return true;
                }
            }
        }

        if(colDiff > 0){
            for (int c = oldCol + 1; c != newCol; c++) {
                if(board.getPiece(c, oldRow) != null){
                    return true;
                }
            }
        }

        if(rowDiff > 0){
            for (int r = oldRow + 1; r < newRow; r++) {
                if(board.getPiece(oldCol, r) != null){
                    return true;
                }
            }
        }

        if(rowDiff < 0){
            for (int r = oldRow - 1; r > newRow; r--) {
                if(board.getPiece(oldCol, r) != null){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean diagonalCollision() {
        int colDiff = newCol - oldCol;
        int rowDiff = newRow - oldRow;

        int d = Math.abs(colDiff);
//find a way to do this more efficiently later
        if(colDiff < 0 && rowDiff < 0){
            for (int i = 1; i != d; i++) {
                    if(board.getPiece(oldCol - i, oldRow - i) != null){
                        return true;
                    }
                }
            }

        if(colDiff > 0 && rowDiff < 0){
            for (int i = 1; i != d; i++) {
                if(board.getPiece(oldCol + i, oldRow - i) != null){
                    return true;
                }
            }
        }

        if(colDiff > 0 && rowDiff > 0){
            for (int i = 1; i != d; i++) {
                if(board.getPiece(oldCol + i, oldRow + i) != null){
                    return true;
                }
            }
        }

        if(colDiff < 0 && rowDiff > 0){
            for (int i = 1; i != d; i++) {
                if(board.getPiece(oldCol - i, oldRow + i) != null){
                    return true;
                }
            }
        }
        return false;
    }

}
