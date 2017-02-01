package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 *
 * @author llmlks
 */
public abstract class Piece {

    /**
     * Private variable Square to hold square which this occupies.
     */
    private Square square;
    /**
     * Private variable String to hold colour of this.
     */
    private final String colour;
    /**
     * Private variable String to hold type of this.
     */
    private String type;

    /**
     * Constructor sets this.square to s, this.colour to c and this.type to "".
     *
     * @param s Square
     * @param c String
     */
    public Piece(final Square s, final String c) {
        this.square = s;
        this.colour = c;
        this.type = "";
    }

    /**
     * Abstract method to check whether move to Square s is valid.
     *
     * @param s Square
     * @return boolean
     */
    public abstract boolean isValidMove(final Square s);

    /**
     * Calls setPiece(this) for s, and sets this.square to s.
     *
     * @param s Square
     */
    public final void move(final Square s) {
        s.setPiece(this);
        this.square = s;
    }

    /**
     *
     * @return this.square Square
     */
    public final Square getSquare() {
        return this.square;
    }

    /**
     *
     * @return this.colour String
     */
    public final String getColour() {
        return this.colour;
    }

    /**
     *
     * @return this.type String
     */
    public final String getType() {
        return this.type;
    }

    /**
     * Sets this.type to t.
     *
     * @param t String
     */
    public final void setType(final String t) {
        this.type = t;
    }
}
