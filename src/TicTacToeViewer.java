import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private Image background;



    private Image[] markers;

    public final Font HEADER_FONT = new Font("Sans-Serif", 1, 36);


    private Square[][] board;

    private final int HEADER_HEIGHT = 22;
    private final int NUM_MARKERS = 2;
    public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 822;

    private final String[] AXIS_NAMES = {"0", "1", "2"};

    public TicTacToeViewer(Square[][] board){
        this.board = board;

        background = new ImageIcon("Resources/Tic-tac-toe.png").getImage();
        markers = new Image[NUM_MARKERS];
        markers[0] = new ImageIcon("O.png").getImage();
        markers[1] = new ImageIcon("X.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TIC TAC TOE");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public Image[] getMarkers() {
        return markers;
    }

    public void paint(Graphics g) {
        g.drawRect(0, 22, WINDOW_WIDTH, WINDOW_HEIGHT);
        drawBackground(g);
    }

    public void drawBackground(Graphics g){
        g.setFont(HEADER_FONT);
        for (int i = 0; i < 3; i++){
            if (i != 0){
                g.drawLine(WINDOW_WIDTH / 5 * (i + 1), (WINDOW_HEIGHT - HEADER_HEIGHT) / 5 + HEADER_HEIGHT, WINDOW_WIDTH / 5 * (i + 1), (WINDOW_HEIGHT - HEADER_HEIGHT) / 5 * 4 + HEADER_HEIGHT);
                g.drawLine(WINDOW_WIDTH / 5, (WINDOW_HEIGHT - HEADER_HEIGHT) / 5 * (i + 1) + 22, WINDOW_WIDTH / 5 * 4, (WINDOW_HEIGHT - HEADER_HEIGHT) / 5 * (i + 1) + HEADER_HEIGHT);
            }
            g.drawString(AXIS_NAMES[i], WINDOW_WIDTH / 15 * (i * 3 + 4), WINDOW_HEIGHT / 15 * 2 + HEADER_HEIGHT);
            g.drawString(AXIS_NAMES[i], WINDOW_WIDTH / 15, (WINDOW_HEIGHT - HEADER_HEIGHT) / 15 * (i * 3 + 5) + HEADER_HEIGHT);
        }
    }
}

