import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private Image background;
    private Image[] markers;


    private TicTacToe game;


    private final int NUM_MARKERS = 2;

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 822;

    private final String[] MARKER_NAMES = {"O", "X"}
    private final String[] AXIS_NAMES = {"0", "1", "2"};

    public TicTacToeViewer(TicTacToe game){
        this.game = game;

        background = new ImageIcon("Tic-tac-toe.png").getImage();
        markers = new Image[NUM_MARKERS];
        markers[0] = new ImageIcon("O.png").getImage();
        markers[1] = new ImageIcon("X.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TIC TAC TOE");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawRect(0, 22, WINDOW_WIDTH, WINDOW_HEIGHT);
        drawBackground(g);
        for (int i = 0; i < game.getBoard().length; i++){
            for (int j = 0; j < game.getBoard().length; j++){
                game.getBoard();
            }
        }
    }

    public void drawBackground(Graphics g){
        g.drawImage(background, WINDOW_WIDTH / 5, (WINDOW_HEIGHT - 22) / 5 + 22, WINDOW_WIDTH * 4 / 5, (WINDOW_HEIGHT - 22) * 4 / 5 + 22, this);
        for (int i = 0; i < 3; i++){
            g.drawString(AXIS_NAMES[i], WINDOW_WIDTH / 15 * (i + 4), WINDOW_HEIGHT / 6);
        }
        for (int i = 0; i < 3; i++){
            g.drawString(AXIS_NAMES[i], WINDOW_WIDTH / 6, (WINDOW_HEIGHT - 22) / 5 * (i + 4) + 22);
        }
    }
}

