package main;

import Moves.Move;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        System.out.println("Type W to play White, B to play Black");
        Scanner scanner = new Scanner(System.in);
        Player player = Player.toChar(scanner.next().charAt(0));
        /*
        * currently only working on move alternation, later will implement single player vs ai
        * */
        Player curPlayer = player;
        GameState gameState = new GameState(curPlayer);

        GameGUI frame = new GameGUI(800, 800);
        Board board = new Board(gameState);
        frame.add(board);
        frame.setUpGUI();



        //let first move be e4 if player chooses to play black for now
        if(player == Player.BLACK) {
            board.selectedPiece = board.getPiece(4,6);
            Move e4 = new Move(board, board.getPiece(4,6), 4,4);
            board.makeMove(e4);
        }



    }
}
