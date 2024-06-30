package main;

public enum Player {
    WHITE,
    BLACK;

    static Player toChar(char c){
        Character ch = Character.toUpperCase(c);
        switch(ch){
            case 'W'-> {
                System.out.println("Playing as White");
                return WHITE;
            }
            case 'B' -> {
                System.out.println("Playing as Black");
                return BLACK;
            }
            default -> throw new IllegalArgumentException("Invalid character: " + c);



         }


    }


}
