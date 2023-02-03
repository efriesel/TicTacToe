import javax.swing.*;
import java.awt.*;


public class TicTacToeViewer extends JFrame {
    private Image[] markers;

    public final Font HEADER_FONT = new Font("Sans-Serif", 1, 36);

    public final Font ENDING_FONT = new Font("Sans-Serif", 1, 50);

    TicTacToe game;

    private final int HEADER_HEIGHT = 22;
    public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 822;

    public final int MARKER_SIZE = WINDOW_WIDTH / 5;

    private final String[] AXIS_NAMES = {"0", "1", "2"};

    private int[] markerX;

    private int[] markerY;

    public TicTacToeViewer(TicTacToe game){
        this.game = game;

        markers = new Image[2];
        markers[0] = new ImageIcon("Resources/O.png").getImage();
        markers[1] = new ImageIcon("Resources/X.png").getImage();
        markerX = new int[3];
        markerY = new int[3];
        for (int i = 0; i < 3; i++){
            markerX[i] = WINDOW_WIDTH / 5 * (i + 1);
            markerY[i] = (WINDOW_HEIGHT - 22) / 5 * (i + 1) + 22;
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TIC TAC TOE");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public int[] getMarkerX() {
        return markerX;
    }

    public int[] getMarkerY() {
        return markerY;
    }
    public Image[] getMarkers() {
        return markers;
    }

    public void paint(Graphics g) {
        g.drawRect(0, 22, WINDOW_WIDTH, WINDOW_HEIGHT);
        drawBackground(g);
        for (Square[] row  : game.getBoard()){
            for (Square s : row){
                s.Draw(this, MARKER_SIZE, g);
            }
        }
        if (game.getGameOver()){
            g.setFont(ENDING_FONT);
            g.setColor(Color.BLACK);
            if (game.checkTie()){
                g.drawString("It's a Tie!", WINDOW_WIDTH / 15 * 5,(WINDOW_HEIGHT - HEADER_HEIGHT) / 15 * 14 + HEADER_HEIGHT);
            }
            else {
                g.drawString(game.getWinner() + " Wins", WINDOW_WIDTH / 15 * 6,(WINDOW_HEIGHT - HEADER_HEIGHT) / 15 * 14 + HEADER_HEIGHT);
            }
        }
    }

    public void drawBackground(Graphics g){
        g.setFont(HEADER_FONT);
        g.setColor(Color.BLACK);
        for (int i = 0; i < 4; i++){
            g.drawLine(WINDOW_WIDTH / 5 * (i + 1), (WINDOW_HEIGHT - HEADER_HEIGHT) / 5 + HEADER_HEIGHT, WINDOW_WIDTH / 5 * (i + 1), (WINDOW_HEIGHT - HEADER_HEIGHT) / 5 * 4 + HEADER_HEIGHT);
            g.drawLine(WINDOW_WIDTH / 5, (WINDOW_HEIGHT - HEADER_HEIGHT) / 5 * (i + 1) + 22, WINDOW_WIDTH / 5 * 4, (WINDOW_HEIGHT - HEADER_HEIGHT) / 5 * (i + 1) + HEADER_HEIGHT);
            if (i != 3) {
                g.drawString(AXIS_NAMES[i], WINDOW_WIDTH / 15 * (i * 3 + 4), WINDOW_HEIGHT / 15 * 2 + HEADER_HEIGHT);
                g.drawString(AXIS_NAMES[i], WINDOW_WIDTH / 15, (WINDOW_HEIGHT - HEADER_HEIGHT) / 15 * (i * 3 + 5) + HEADER_HEIGHT);
            }
        }
    }


}

