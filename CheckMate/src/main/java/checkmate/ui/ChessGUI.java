package checkmate.ui;

import checkmate.logic.game.ChessGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Graphical interface class.
 *
 * @author llmlks
 */
public class ChessGUI extends JPanel {

    private final BoardPanel board;
    private ChessGame chess;

    public ChessGUI() {
        this.chess = new ChessGame();
               
        this.board = new BoardPanel(this.chess);
        this.board.setSize(600, 600);
        this.board.setLayout(new GridLayout(8, 8));
        this.board.addMouseListener(board);
       
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(this.board);    
        newGame.setSize(new Dimension(150, 100));
        
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(200, 650));
        menuPanel.setBackground(Color.white);
        menuPanel.add(newGame);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 11));
        topPanel.setPreferredSize(new Dimension(600, 50));
        topPanel.setBounds(50, 0, 50, 650);
        topPanel.setBackground(Color.white);
        for (int i = 0; i < 11; i++) {
            JLabel file = new JLabel();
            if (i >= 1 && i < 9) {
                file.setText("" + i);
            }
            topPanel.add(file);
        }

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(8, 1));
        westPanel.setPreferredSize(new Dimension(50, 600));
        westPanel.setBackground(Color.white);
        String abc = "ABCDEFGH";
        for (int i = 0; i < 8; i++) {
            JLabel file = new JLabel();
            file.setText("    " + abc.charAt(i));
            westPanel.add(file);
        }        
        
        this.setPreferredSize(new Dimension(850, 650));
        this.setLayout(new BorderLayout());
        this.add(this.board, BorderLayout.CENTER);
        this.add(menuPanel, BorderLayout.EAST);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckMate");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new ChessGUI());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
