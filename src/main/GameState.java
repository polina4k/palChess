package main;

import Pieces.King;
import Pieces.Piece;
import Moves.Move;

import java.util.ArrayList;

public class GameState {
    protected Board board;
    protected boolean isPlayerSelected = false;
    protected Player curPlayer;
    protected boolean kingInCheck;

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


}
