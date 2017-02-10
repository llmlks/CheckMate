package checkmate.ui;

import checkmate.logic.game.ChessGame;
import checkmate.logic.game.Square;
import checkmate.logic.pieces.Piece;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author llmlks
 */
public class ChessGUI implements Runnable {

    private final ChessGame chess;
    private JFrame frame;
    private final Dimension size;
    private static final int BOARD = 8;
    private final JPanel[][] squarePanels;
    private JPanel gridPanel;
    private final ArrayList<Square> squares;
    private final HashMap<Piece, String> pieces;

    public ChessGUI() {
        this.chess = new ChessGame();
        chess.start();
        this.squares = chess.getBoard().getSquares();
        this.size = new Dimension(600, 600);
        this.pieces = initPieces();
        squarePanels = new JPanel[8][8];
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new ChessGUI());
    }

    @Override
    public void run() {

        frame = new JFrame("CheckMate");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setPreferredSize(size);

        createComponents(frame.getContentPane());
    }

    private void createComponents(Container container) {

        container.setLayout(new BorderLayout());

        gridPanel = new JPanel();
        GridLayout board = new GridLayout(BOARD, BOARD);

        gridPanel.setLayout(board);

        for (Square square : this.chess.getBoard().getSquares()) {
            int i = square.getX() - 1;
            int j = square.getY() - 1;
            squarePanels[i][j] = new JPanel();
            squarePanels[i][j].setBackground(new Color(115, 77, 38));
            if ((i + j) % 2 == 0) {
                squarePanels[i][j].setBackground(new Color(230, 204, 179));
            }
            if (square.isOccupied()) {
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(pieces.get(square.getPiece())));
                squarePanels[i][j].add(label);
            }
            gridPanel.add(squarePanels[i][j]);
        }

        container.add(gridPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private HashMap<Piece, String> initPieces() {
        HashMap<Piece, String> pieceIcons = new HashMap<>();
        for (Piece piece : this.chess.getBoard().getPieces()) {
            String icon = "icons/" + piece.getType() + "_" + piece.getColour();
            pieceIcons.put(piece, icon);
        }
        return pieceIcons;
    }

    public ChessGame getChess() {
        return chess;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Dimension getSize() {
        return size;
    }

    public JPanel[][] getSquarePanels() {
        return squarePanels;
    }

    public JPanel getGridPanel() {
        return gridPanel;
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public HashMap<Piece, String> getPieces() {
        return pieces;
    }

}
