package main;
import javax.swing.*;
import java.awt.*;

import Moves.Move;
import Pieces.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TestFrame frame = new TestFrame(800, 800); //can just use a regular JFrame, TestFrame class is redundant
        Board board = new Board();
        frame.add(board);
        frame.setUpGUI();

        System.out.println("Type W to play White, B to play Black");
        Scanner scanner = new Scanner(System.in);
        Player player = Player.toChar(scanner.next().charAt(0));
        Player curPlayer = Player.WHITE; //initial game always starts w white

        //let first move be e4 if player chooses to play black for now
        if(player == Player.BLACK) {
            board.selectedPiece = board.getPiece(4,6);
            Move e4 = new Move(board, board.getPiece(4,6), 4,4);
            board.makeMove(e4);
        }

        int i = 0;
        while(i<10){//simulate 10 moves
                curPlayer = Player.next(curPlayer);

                i++;
        }








    }
}
