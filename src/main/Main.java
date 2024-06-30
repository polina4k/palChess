package main;
import javax.swing.*;
import java.awt.*;
import Pieces.*;

public class Main {
    public static void main(String[] args) {

        TestFrame frame = new TestFrame(800, 800); //can just use a regular JFrame, TestFrame class is redundant
        Board board = new Board();
        frame.add(board);
        frame.setUpGUI();






    }
}
