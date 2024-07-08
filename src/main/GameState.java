package main;

public class GameState {
    protected boolean isPlayerSelected = false;
    protected Player curPlayer;
    protected boolean kingPinned;

    public GameState(Player curPlayer ) {
        this.curPlayer = curPlayer;
        isPlayerSelected = true;
    }

    /*public boolean checkKingPin (){
        if
    }*/


}
