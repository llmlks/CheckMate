package checkmate.logic.game;

import checkmate.logic.pieces.Piece;
import java.util.ArrayList;

/**
 * Player object for the chess game.
 *
 * @author llmlks
 */
public class Player {

    /**
     * Private variable ArrayList to hold pieces.
     */
    private final ArrayList<Piece> pieces;

    /**
     * Private variable String colour.
     */
    private final String colour;

    /**
     * Constructor generates empty ArrayList for pieces and assigns value c to
     * colour.
     *
     * @param c String
     */
    public Player(final String c) {
        this.colour = c;
        this.pieces = new ArrayList<>();
    }

    /**
     * Returns players pieces as an ArrayList.
     *
     * @return ArrayList
     */
    public final ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    /**
     * Returns players colour as a String.
     *
     * @return String
     */
    public final String getColour() {
        return this.colour;
    }

    /**
     * Adds a piece to players ArrayList pieces.
     *
     * @param p Piece
     */
    public final void addPiece(final Piece p) {
        this.pieces.add(p);
    }

    /**
     * Removes a piece from players ArrayList pieces.
     *
     * @param p Piece
     */
    public final void removePiece(final Piece p) {
        this.pieces.remove(p);
    }
    
    /**
     * Return this player's king, or null if there isn't one.
     * 
     * @return Piece
     */
    public final Piece getKing() {
        for (Piece p : this.pieces) {
            if (p.getType().equals("king") && p.getAvailable()) {
                return p;
            }
        }        
        return null;
    }
}
