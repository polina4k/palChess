package main;
import javax.swing.*;
import java.awt.*;
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
        Player curPlayer = Player.toChar(scanner.next().charAt(0));








    }
}
