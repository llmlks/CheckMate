/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.ui;

import checkmate.logic.game.ChessGame;
import checkmate.logic.game.Square;
import checkmate.logic.pieces.King;
import checkmate.logic.pieces.Knight;
import checkmate.logic.pieces.Pawn;
import checkmate.logic.pieces.Piece;
import checkmate.logic.pieces.Queen;
import checkmate.logic.pieces.Rook;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author llmlks
 */
public class BoardPanel extends JPanel implements MouseListener {

    private final ChessGame chess;
    private final HashMap<Piece, String> pieces;
    private Piece chosen;
    private ArrayList<Square> possibleMoves;

    public BoardPanel(ChessGame game) {
        this.chess = game;
        this.pieces = initPieces();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / 75;
        int y = e.getY() / 75;
        Square clicked = this.chess.findSquareByCoordinates(y + 1, x + 1);
        Component c = this.findComponentAt(e.getX(), e.getY());
        if (chosen != null && possibleMoves.contains(clicked)) {
            chosen.move(clicked);
            chosen = null;
            repaint();
        } else {
            if (c instanceof JLabel && clicked.isOccupied()) {
                this.chosen = clicked.getPiece();

                switch (this.chosen.getType()) {
                    case "pawn":
                        chosen = (Pawn) chosen;
                        break;
                    case "rook":
                        chosen = (Rook) chosen;
                        break;
                    case "knight":
                        chosen = (Knight) chosen;
                        break;
                    case "queen":
                        chosen = (Queen) chosen;
                        break;
                    case "king":
                        chosen = (King) chosen;

                }
                possibleMoves = this.chess.getValidator().validMoves(chosen);
                Container parent = c.getParent();
                parent.setBackground(new Color(255, 121, 77));
            }
        }
    }


@Override
        public void mousePressed(MouseEvent e) {
    }

    @Override
        public void mouseReleased(MouseEvent e) {
    }

    @Override
        public void mouseEntered(MouseEvent e) {
    }

    @Override
        public void mouseExited(MouseEvent e) {
    }

    public void createComponents() {
        for (Square square : this.chess.getBoard().getSquares()) {
            int i = square.getX() - 1;
            int j = square.getY() - 1;
            JPanel sqr = new JPanel();
            sqr.setSize(75, 75);
            sqr.setBackground(new Color(209, 139, 71));
            if ((i + j) % 2 == 0) {
                sqr.setBackground(new Color(255, 206, 158));
            }
            if (square.isOccupied()) {
                try {
                    JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File(pieces.get(square.getPiece())))));
                    sqr.add(label);
                } catch (IOException ex) {
                    JLabel label = new JLabel("Missing file.");
                    sqr.add(label);
                }
            }
            this.add(sqr);
        }

    }

    private HashMap<Piece, String> initPieces() {
        HashMap<Piece, String> pieceIcons = new HashMap<>();
        for (Piece piece : this.chess.getBoard().getPieces()) {
            String icon = "icons/" + piece.getType() + "_" + piece.getColour() + ".png";
            pieceIcons.put(piece, icon);
        }
        return pieceIcons;
    }
}
