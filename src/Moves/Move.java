package Moves;

import Pieces.King;
import Pieces.Piece;
import Pieces.Rook;
import main.Board;
import main.GameState;

public class Move {
    public int oldCol;
    public int oldRow;
    public int newCol;
    public int newRow;
    Board board;
    public Piece piece;
    public Piece capture;
    public int captureCol, captureRow; //capture position
    public GameState gameState;
    private Move next; //Moves stored as linked list


    public Move(Board board, Piece piece, int newCol, int newRow, GameState gameState){
        this.oldCol = piece.col;
        this.oldRow = piece.row;
        this.newCol = newCol;
        this.newRow = newRow;
        this.board = board;
        this.gameState = gameState;

        this.piece = piece;
        this.capture = board.getPiece(newCol, newRow); //might have problems with en passant here
        this.next = null;

    }

    /*
    Validation of move and move subclasses:
     */

    public boolean isValidMove(){
        return piece.isValidMove(this);
    }

    /*
    Note: "Regular" move validation will not include "special" moves (i.e castling, promotion, en passant)
     */

    public boolean validCastleMove () {
        if(gameState.kingInCheck()){
            return false;
        }
        Piece rook = new Rook();
        Piece king = new King();
        if (piece instanceof King && capture instanceof Rook) {
            king = piece;
            rook = capture;

        }
        else if (piece instanceof Rook && capture instanceof King){
            rook = piece;
            king = capture;
        }

            if ((king.isWhite == rook.isWhite) && (king.isFirstMove && rook.isFirstMove)) {
                if(!linearCollision()){
                    return true;
                    };
                }

            return false;
    }

    public void makeMove(){

            board.changePiecePosition(board.selectedPiece, newCol, newRow);

            if (capture != null) {
                board.removePiece(capture);
            }
            if (piece.isFirstMove) {
                piece.isFirstMove = false;

        }

    }

    private void executeCastle() {
        Piece rook = null;
        Piece king = null;

        if (piece instanceof King) {
            king = piece;
            rook = capture; // In castling, capture holds the rook reference
        } else if (piece instanceof Rook) {
            rook = piece;
            king = capture;
        }

        // Determine the specific castling type and execute
        if (king != null && rook != null) {
            // Assume board setup with initial position check
            if (king.col == 4 && king.row == (king.isWhite ? 7 : 0)) {
                if (rook.col == 0 && rook.row == king.row) {
                    // Long castle
                    board.changePiecePosition(king, 2, king.row);
                    board.changePiecePosition(rook, 3, king.row);
                } else if (rook.col == 7 && rook.row == king.row) {
                    // Short castle
                    board.changePiecePosition(king, 6, king.row);
                    board.changePiecePosition(rook, 5, king.row);
                }
            }

            king.isFirstMove = false;
            rook.isFirstMove = false;
        }
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

    public boolean queenCollision(){
        int colDiff = newCol - oldCol;
        int rowDiff = newRow - oldRow;

        if(Math.abs(colDiff) == Math.abs(rowDiff)){
            if(diagonalCollision()){
                return true;
            }
        }

        if(Math.abs(colDiff) == 0 ||  Math.abs(rowDiff) == 0 ){
            if(linearCollision()){
                return true;
            }
        }
        return false;
    }

}
