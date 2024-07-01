package main;

import Moves.Move;
import Pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//mouse event handler
public class Input extends MouseAdapter {
    Board board;
    public Input (Board board){
        this.board = board;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;


        Piece curPiece = board.getPiece(col,row);

        if (curPiece != null){
            board.selectedPiece = curPiece;
           // System.out.println(board.selectedPiece.col);
           // System.out.println(board.selectedPiece.row);
            //System.out.println(board.selectedPiece.name);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        if(board.selectedPiece != null){
            Move move = new Move(board,board.selectedPiece, col, row);
            if(board.selectedPiece.isValidMove(move)) {
                if (board.getPiece(col, row) != null) {
                    move.capture = board.getPiece(col, row);
                }

                board.makeMove(move);
                board.repaint();
                board.selectedPiece = null;
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
        // Update image position to follow the mouse cursor
       if(board.selectedPiece != null){
           board.selectedPiece.xPos = e.getX() - board.tileSize/2;//center
           board.selectedPiece.yPos = e.getY() - board.tileSize/2;;
           board.repaint();
       }

    }

}
