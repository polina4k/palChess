package Moves;

import Pieces.King;
import Pieces.Piece;
import Pieces.Rook;

/*
    Return type of castle for move recording purpose, is this convoluted? I don't know!
 */
public enum CastleType
{
    WHITE_LONG_CASTLE(0,7),
    WHITE_SHORT_CASTLE(7,7),
    BLACK_LONG_CASTLE(0,0),
    BLACK_SHORT_CASTLE(7,0);
    final int rookCol;
    final int rookRow;


    CastleType(int rookCol, int rookRow) {
        this.rookCol = rookCol;
        this.rookRow = rookRow;
    }

    static public CastleType castleType(Castle castle) {

        Piece rook = new Rook();
        Piece king = new King();

            if (castle.piece instanceof King && castle.capture instanceof Rook) {
                king = castle.piece;
                rook = castle.capture;

            }
            else if (castle.piece instanceof Rook && castle.capture instanceof King){
                rook = castle.piece;
                king = castle.capture;
            }

            if ((king.isWhite == rook.isWhite) && (king.isFirstMove && rook.isFirstMove)) {
                switch (rook.col) {
                    case 0 -> {
                        switch (rook.row) {
                            case 7 -> {
                                return WHITE_LONG_CASTLE;
                            }
                            case 0 -> {
                                return BLACK_LONG_CASTLE;
                            }
                        }
                    }
                    case 7 -> {
                        switch (rook.row) {
                            case 0 -> {
                                return BLACK_SHORT_CASTLE;
                            }
                            case 7 -> {
                                return WHITE_SHORT_CASTLE;
                            }
                        }
                    }
                }
            }
        throw new IllegalArgumentException("Illegal Castle");
    }


}
