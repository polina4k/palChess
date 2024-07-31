package Moves;

import Pieces.King;
import Pieces.Piece;
import Pieces.Rook;
import main.Board;

import main.GameState;


public class Castle extends Move {
    public final CastleType castleType;

    public Castle (Board board, Piece piece, int newCol, int newRow, GameState gameState){
        super(board,piece,newCol,newRow, gameState);
        castleType = CastleType.castleType(this);

    }

    @Override
    public void makeMove(){
        Piece rook = null;
        Piece king = null;

        /*
        Theoretically this should work since castle can only be instantiated via the validcastle checking method?
        however could cause problems....
         */
        if (piece instanceof King) {
            king = piece;
            rook = capture;
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


}







