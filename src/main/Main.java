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
        */
       Game main = new Game(player);


    }
}
