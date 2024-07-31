package main;
//store data related to players
public enum Player {
    WHITE (true),
    BLACK (false);
    final boolean isWhite;

    Player(boolean isWhite) {
        this.isWhite = isWhite;
    }
    public static Player next(Player p) {
        switch(p){
            case WHITE -> {
                return BLACK;
            }
            case BLACK -> {
                return WHITE;
            }
        }
        return null;
    }

    /*
    Player selection
     */
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
