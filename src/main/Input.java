package main;

import Moves.Castle;
import Moves.CastleType;
import Moves.Move;
import Pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
Mouse event handler:
 */

public class Input extends MouseAdapter {
    Board board;
    GameState gameState;


    public Input (Board board, GameState gameState){
        this.board = board;
        this.gameState = gameState;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(gameState.isPlayerSelected) {
            int col = e.getX() / board.tileSize;
            int row = e.getY() / board.tileSize;

            Piece curPiece = board.getPiece(col, row);

            if (curPiece != null) {
                if((curPiece.isWhite && gameState.curPlayer.isWhite) || (!curPiece.isWhite && !gameState.curPlayer.isWhite)) {
                    board.selectedPiece = curPiece;
                    //ArrayList<Move> legalMoves = board.getLegalMoves(curPiece);
                }
            }
        }
        else{
            System.out.println("Please select player");
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        if(board.selectedPiece != null){
            Move move = new Move(board,board.selectedPiece, col, row, gameState);
            if(move.isValidMove()) {
                if (board.getPiece(col, row) != null) {
                    move.capture = board.getPiece(col, row);
                }

                move.makeMove();
                board.repaint();
                board.selectedPiece = null;
                gameState.curPlayer = Player.next(gameState.curPlayer);
                /*
                DEBUG:

                if (gameState.kingInCheck()) {
                    System.out.println("King in check");
                } else {
                    System.out.println("King not in check");
                }*/
            }
            else if(move.validCastleMove()) {
                Castle castleMove = new Castle(board,board.selectedPiece, col, row, gameState);
                castleMove.makeMove();
                System.out.print(castleMove.castleType);
                board.selectedPiece = null;
                board.repaint();
                gameState.curPlayer = Player.next(gameState.curPlayer);

            }
            else{

                System.out.println("Not Valid Move");

                board.selectedPiece.xPos = move.oldCol * board.tileSize;
                board.selectedPiece.yPos = move.oldRow * board.tileSize;
                board.repaint();
                board.selectedPiece = null;
            }
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        /*
        Update image position to follow the mouse cursor
         */
       if(board.selectedPiece != null){
           board.selectedPiece.xPos = e.getX() - board.tileSize/2;//center
           board.selectedPiece.yPos = e.getY() - board.tileSize/2;
           board.repaint();
       }

    }

}
