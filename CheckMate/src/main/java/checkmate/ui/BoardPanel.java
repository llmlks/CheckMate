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
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author llmlks
 */
public class BoardPanel extends JPanel implements MouseListener {

    private final ChessGame chess;
    private final HashMap<Piece, String> pieces;
    private Piece chosen;
    private ArrayList<Square> possibleMoves = new ArrayList<>();

    public BoardPanel(ChessGame game) {
        this.chess = game;
        this.pieces = initPieces();
        possibleMoves.add(new Square(3, 2));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / 75;
        int y = e.getY() / 75;
        Square clicked = this.chess.findSquareByCoordinates(x + 1, y + 1);
        if (chosen != null && possibleMoves.contains(clicked)) {
            chosen.move(clicked);
            chosen = null;
            possibleMoves.removeAll(possibleMoves);
            repaint();
        } else if (clicked.isOccupied()) {
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
        }
        repaint();
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

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square s = this.chess.findSquareByCoordinates(i + 1, j + 1);
                g2.setColor(new Color(255, 206, 158));
                if ((i + j) % 2 == 0) {
                    g2.setColor(new Color(209, 139, 71));
                }
                g2.fillRect(i * 75, j * 75, 75, 75);
                if (possibleMoves.contains(s)) {
                    g2.setColor(Color.green);
                    g2.setStroke(new BasicStroke(4));
                    g2.drawRect(i * 75 + 2, j * 75 + 2, 71, 71);
                }
                if (s.isOccupied()) {
                    Image img = Toolkit.getDefaultToolkit().getImage(pieces.get(s.getPiece()));
                    g2.drawImage(img, i * 75 + 5, j * 75 + 5, this);
                }
            }
        }
        if (chosen != null) {
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(4));
            g2.drawRect((chosen.getSquare().getX() - 1) * 75 + 2, (chosen.getSquare().getY() - 1) * 75 + 2, 71, 71);
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
