package main;

import Moves.Move;
import Pieces.King;
import Pieces.Piece;

import java.util.ArrayList;

public class GameState {
    protected Board board;
    protected boolean isPlayerSelected = false;
    protected Player curPlayer;
    protected boolean kingInCheck;
    /*
    1000 = white checkmate
    -1000 = black checkmate
    0 = equal positions between players or draw
     */
    public int gameScore;

    public GameState(Player curPlayer) {
        this.curPlayer = curPlayer;
        isPlayerSelected = true;
    }
// checking if CURRENT PLAYER'S king is in check
    public boolean kingInCheck(){
        ArrayList<Piece> oppPieces = curPlayer.isWhite ? board.getBlackPieces() : board.getWhitePieces();
            for(Piece piece : oppPieces) {
                ArrayList<Move> legalMoves = board.getLegalMoves(piece);
                for (Move move : legalMoves) {
                    if (move.capture instanceof King) {
                        kingInCheck = true;
                        return true;
                    }
                }
            }
        kingInCheck = false;
        return false;
    }
    //check if current player is in checkmate
    /*public boolean checkmateEval (){
        if(!kingInCheck){
            return false;
        }
        //iterate through all of current player's pieces
        ArrayList<Piece> pieces = curPlayer.isWhite ? board.getWhitePieces() : board.getBlackPieces();
        for(Piece piece : pieces) {
            ArrayList<Move> legalMoves = board.getLegalMoves(piece);

            for (Move move : legalMoves) {
                Board tempBoard = board;

                if (tempBoard.) {
                    kingInCheck = true;
                    return true;
                }

    }*/


}
