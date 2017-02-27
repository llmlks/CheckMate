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
     * @param c String for colour, w for white and b for black
     */
    public Player(final String c) {
        this.colour = c;
        this.pieces = new ArrayList<>();
    }

    /**
     * Returns players pieces as an ArrayList.
     *
     * @return List of player's pieces
     */
    public final ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    /**
     * Returns players colour as a String.
     *
     * @return Players colour as a String
     */
    public final String getColour() {
        return this.colour;
    }

    /**
     * Adds a piece to players ArrayList pieces.
     *
     * @param p Piece to be added to player's listof pieces
     */
    public final void addPiece(final Piece p) {
        this.pieces.add(p);
    }

    /**
     * Removes a piece from players ArrayList pieces.
     *
     * @param p Piece to be removed from player's list of pieces
     */
    public final void removePiece(final Piece p) {
        this.pieces.remove(p);
    }
    
    /**
     * Return this player's king, or null if there isn't one.
     * 
     * @return Player's Piece of type king
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
