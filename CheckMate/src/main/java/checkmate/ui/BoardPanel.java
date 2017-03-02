/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.ui;

import checkmate.logic.game.ChessBoard;
import checkmate.logic.game.ChessGame;
import checkmate.logic.game.Player;
import checkmate.logic.game.Square;
import checkmate.logic.pieces.King;
import checkmate.logic.pieces.Knight;
import checkmate.logic.pieces.Pawn;
import checkmate.logic.pieces.Piece;
import checkmate.logic.pieces.Queen;
import checkmate.logic.pieces.Rook;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author llmlks
 */
public class BoardPanel extends JPanel implements MouseListener, ActionListener {

    private ChessGame chess;
    private Piece chosen;
    private ArrayList<Square> possibleMoves = new ArrayList<>();
    private boolean ended = false;
    private Pawn promotion = null;
    private boolean checkmate = false;

    public BoardPanel(ChessGame game) {
        this.chess = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ChessBoard board = chess.getBoard();
        int x = e.getX() / 75;
        int y = e.getY() / 75;
        if (promotion != null) {
            if (y == 3) {
                int help = 0;
                if (promotion.getColour().equals("b")) {
                    help = 1;
                }
                Player player = chess.getPlayers()[help];
                switch (x) {
                    case 2:
                        board.promote(promotion, "rook", player);
                        promotion = null;
                        break;
                    case 3:
                        board.promote(promotion, "knight", player);
                        promotion = null;
                        break;
                    case 4:
                        board.promote(promotion, "bishop", player);
                        promotion = null;
                        break;
                    case 5:
                        board.promote(promotion, "queen", player);
                        promotion = null;
                        break;
                }
            }
        } else {
            Square clicked = this.chess.findSquareByCoordinates(x + 1, y + 1);
            if (chosen != null && possibleMoves.contains(clicked)) {
                chess.turn(chosen, clicked);
                if (chosen.getType().equals("pawn") && (y == 0 || y == 7)) {
                    promotion = (Pawn) chosen;
                }
                chosen = null;
                possibleMoves.removeAll(possibleMoves);
                ended = chess.getEnded();
                checkmate = chess.getValidator().playersInCheck();
            } else if (clicked.isOccupied()) {
                this.chosen = clicked.getPiece();

                if (chosen.getColour().equals(chess.getTurn())) {
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
                } else {
                    chosen = null;
                    possibleMoves.removeAll(possibleMoves);
                }
            } else {
                chosen = null;
                possibleMoves.removeAll(possibleMoves);
            }
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
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square s = this.chess.findSquareByCoordinates(i + 1, j + 1);
                g2.setColor(new Color(209, 139, 71));
                if (ended) {
                    g2.setColor(new Color(255, 230, 204));
                }
                if ((i + j) % 2 == 0) {
                    g2.setColor(new Color(255, 206, 158));
                    if (ended) {
                        g2.setColor(new Color(218, 166, 113));
                    }
                }
                g2.fillRect(i * 75, j * 75, 75, 75);
                if (possibleMoves.contains(s)) {
                    g2.setColor(Color.green);
                    g2.setStroke(new BasicStroke(4));
                    g2.drawRect(i * 75 + 2, j * 75 + 2, 71, 71);
                }
                if (s.isOccupied()) {
                    Piece p = s.getPiece();
                    String icon = "/icons/" + p.getType() + "_" + p.getColour() + ".png";
                    InputStream stream = getClass().getResourceAsStream(icon);
                    if (stream != null) {
                        BufferedImage img;
                        try {
                            img = ImageIO.read(stream);
                            g2.drawImage(img, i * 75 + 5, j * 75 + 5, this);
                        } catch (IOException ex) {
                            Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Color colour = p.getColour().equals("w") ? Color.white : Color.black;
                        g2.setColor(colour);
                        g2.setFont(new Font("Ubuntu", Font.BOLD, 18));
                        g2.drawString(p.getType(), i * 75 + 10, j * 75 + 35);
                    }
                }
            }
        }
        if (ended) {
            g2.setColor(new Color(255, 206, 158));
            g2.fillRect(155, 155, 290, 215);
            g2.setColor(Color.black);
            g2.setFont(new Font("Ubuntu", Font.BOLD, 30));
            if (checkmate) {
                String winner = "White";
                if (chess.getTurn().equals("w")) {
                    winner = "Black";
                }
                g2.drawString(winner + " player wins!", 160, 200);
            } else {
                g2.drawString("It\'s a stalemate!", 160, 200);
            }
            g2.setFont(new Font("Ubuntu", Font.PLAIN, 18));
            g2.drawString("Press 'New game' to play again", 160, 275);
        }
        if (chosen != null) {
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(4));
            g2.drawRect((chosen.getSquare().getX() - 1) * 75 + 2, (chosen.getSquare().getY() - 1) * 75 + 2, 71, 71);
        }

        if (promotion != null) {
            g2.setColor(new Color(218, 166, 113));
            g2.fillRect(150, 150, 300, 150);
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Ubuntu", Font.BOLD, 18));
            g2.drawString("Choose a piece for promotion:", 155, 185);
            String[] types = new String[]{"rook", "knight", "bishop", "queen"};
            for (int i = 0; i < 4; i++) {
                try {
                    String icon = "/icons/" + types[i] + "_" + promotion.getColour() + ".png";
                    BufferedImage img = ImageIO.read(getClass().getResourceAsStream(icon));
                    g2.drawImage(img, i * 75 + 155, 230, this);
                } catch (IOException ex) {
                    Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chess = new ChessGame();
        chess.initGame();
        ended = false;
        chosen = null;
        possibleMoves.removeAll(possibleMoves);
        promotion = null;
        repaint();
    }
}
