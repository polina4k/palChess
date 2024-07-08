package main;
import javax.swing.JFrame;
import java.awt.*;
//currently gameGUI is a mess, half of it is in the board class
public class GameGUI {
    private JFrame frame;
    private int width;
    private int height;
    private GridBagConstraints gbc = new GridBagConstraints();

    public GameGUI(int width, int height){
        frame = new JFrame();
        this.width = width;
        this.height = height;
    }


    public void setUpGUI () {
        this.frame.setSize(width,height);
        this.frame.setLayout(new GridBagLayout());
        this.frame.setTitle("palChess");
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//exit out of application
        this.frame.setVisible(true);//sets visibility to true
    }

    public void add(Board board) {
        this.frame.add(board);
    }
}

