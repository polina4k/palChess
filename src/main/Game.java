package main;

import Moves.Move;

/*
Game driver
 */
public class Game {
    private Player whitePlayer;
    private Player blackPlayer;

    private Board board;

    Game (Player curPlayer){
        if(curPlayer == Player.WHITE){
            this.whitePlayer = curPlayer;
        }
        else{
            this.blackPlayer = curPlayer;
        }
        GameState gameState = new GameState(curPlayer);
        GameGUI frame = new GameGUI(800, 800);
        this.board = new Board(gameState);
        gameState.board = board;
        frame.add(board);
        frame.setUpGUI();

        if(curPlayer == Player.BLACK) {
            board.selectedPiece = board.getPiece(4,6);
            Move e4 = new Move(board, board.getPiece(4,6), 4,4,gameState);
            e4.makeMove();
            board.selectedPiece=null;
        }

    }

}
