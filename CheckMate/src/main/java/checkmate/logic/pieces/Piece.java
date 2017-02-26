package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 * Abstract class for chess pieces to inherit.
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
     * Private variable boolean to keep track of whether this piece is
     * available, aka not captured.
     */
    private boolean available;
    /**
     * Private variable to hold inital Square.
     */
    private Square initSquare;
    

    /**
     * Constructor sets this.square to s, this.colour to c, this.type to "" and
     * this.available to boolean.
     *
     * @param s Square
     * @param c String
     */
    public Piece(final Square s, final String c) {
        this.square = s;
        this.colour = c;
        this.type = "";
        this.available = true;
        this.initSquare = s;
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
        this.initSquare = null;
        this.square.setPiece(null);
        if (s.isOccupied()) {
            s.getPiece().setAvailable(false);
        } 
        if (s.getEnPassant() != null) {
            s.getEnPassant().setAvailable(false);
            s.getEnPassant().getSquare().setPiece(null);
        }
        s.setPiece(this);
        this.square = s;
    }

    /**
     * Returns private variable square.
     *
     * @return this.square Square
     */
    public final Square getSquare() {
        return this.square;
    }

    /**
     * Returns private variable colour.
     *
     * @return this.colour String
     */
    public final String getColour() {
        return this.colour;
    }

    /**
     * Returns private variable type.
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

    /**
     * Sets Square to s.
     *
     * @param s Square
     */
    public final void setSquare(Square s) {
        this.square = s;
    }

    /**
     * Returns private variable available.
     *
     * @return boolean
     */
    public final boolean getAvailable() {
        return this.available;
    }

    /**
     * Sets variable available to b.
     *
     * @param b boolean
     */
    public final void setAvailable(final boolean b) {
        this.available = b;
    }

    /**
     * Returns private variable initSquare.
     *
     * @return this.initSquare Square
     */
    public final Square getInitSquare() {
        return this.initSquare;
    }
}
