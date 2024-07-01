package main;
import Moves.Move;
import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel{
    public int tileSize = 85;
    int cols = 8;
    int rows = 8;
    ArrayList<Piece> pieceList = new ArrayList<>();
    Piece selectedPiece;

        public Board(){
            this.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
            addPieces();
            Input inputPanel =  new Input(this);
            this.addMouseListener(inputPanel);
            this.addMouseMotionListener(inputPanel);
        }
        public void addPieces(){
            pieceList.add(new Knight(this, 1, 0, false));
            pieceList.add(new Knight(this, 6, 0, false));
            pieceList.add(new Knight(this, 1, 7, true));
            pieceList.add(new Knight(this, 6, 7, true));

            pieceList.add(new Rook(this, 0, 0, false));
            pieceList.add(new Rook(this, 7, 0, false));
            pieceList.add(new Rook(this, 0, 7, true));
            pieceList.add(new Rook(this, 7, 7, true));

            pieceList.add(new Bishop(this, 2, 0, false));
            pieceList.add(new Bishop(this, 5, 0, false));
            pieceList.add(new Bishop(this, 2, 7, true));
            pieceList.add(new Bishop(this, 5, 7, true));

            pieceList.add(new King(this, 4, 0, false));
            pieceList.add(new King(this, 4, 7, true));
            pieceList.add(new Queen(this, 3, 0, false));
            pieceList.add(new Queen(this, 3, 7, true));

            for(int i = 0; i < 8; i++){
                pieceList.add(new Pawn(this, i, 1, false));
                pieceList.add(new Pawn(this, i, 6, true));
            }

        }

        public Piece getPiece (int col, int row){
            for (Piece piece : pieceList) {
                if (piece.col == col && piece.row == row) {
                    return piece;
                }
            }
            return null;
        }

        public void removePiece(Piece piece){
            pieceList.remove(piece);
        }

        public void makeMove(Move move){
            selectedPiece.col = move.newCol;
            selectedPiece.row = move.newRow;
            selectedPiece.xPos = move.newCol * tileSize;
            selectedPiece.yPos = move.newRow * tileSize;

            if(move.capture!= null){
                removePiece(move.capture);
            }
            if(move.piece.isFirstMove){
                move.piece.isFirstMove = false;
            }

        }

        public void paintComponent (Graphics g){
            Graphics2D g2D = (Graphics2D) g;
            Color white = new Color(235,236,208);
            Color black = new Color(115,149,82);
            for(int i =  0; i<cols; i++){
                for(int j = 0; j<rows;j++ ){
                    g2D.setColor((i+j) % 2 == 0 ? white : black );  //condition ? valueIfTrue : valueIfFalse
                    g2D.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
                }
            }
            if(selectedPiece != null){
                for(int c = 0; c < cols; c++){
                    for(int r = 0; r < rows; r++){
                        if(selectedPiece.isValidMove(new Move(this, selectedPiece, c, r))){
                            g2D.setColor(new Color(248, 58, 78, 81));
                            g2D.fillRect(c*tileSize, r*tileSize, tileSize, tileSize);
                        }
                    }
                }
            }



            for(Piece piece: pieceList){
                piece.paint(g2D);

            }

        }

}
