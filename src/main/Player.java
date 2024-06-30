package main;

public enum Player {
    WHITE,
    BLACK;

    Player toChar(char c){
        Character ch = Character.toUpperCase(c);
        switch(ch){
            case 'W'-> {
                return WHITE;
            }
            case 'B' -> {
                return BLACK;
            }
            default -> throw new IllegalArgumentException("Invalid character: " + c);



         }


    }


}
