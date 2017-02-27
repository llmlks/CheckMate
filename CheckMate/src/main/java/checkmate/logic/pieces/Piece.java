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
     * @param s Square where Piece is positioned
     * @param c String for colour, w for white or b for black
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
     * @param s Square where piece would be moved
     * @return true if move would be valid, false otherwise
     */
    public abstract boolean isValidMove(final Square s);

    /**
     * Calls setPiece(this) for s, and sets this.square to s.
     *
     * @param s Square where piece is moved to
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
     * @return Square where Piece is positioned
     */
    public final Square getSquare() {
        return this.square;
    }

    /**
     * Returns private variable colour.
     *
     * @return String for piece's colour, w for white or b for black
     */
    public final String getColour() {
        return this.colour;
    }

    /**
     * Returns private variable type.
     *
     * @return String for piece's type
     */
    public final String getType() {
        return this.type;
    }

    /**
     * Sets this.type to t.
     *
     * @param t String defining a type of piece
     */
    public final void setType(final String t) {
        this.type = t;
    }

    /**
     * Sets Square to s.
     *
     * @param s Square for piece's position
     */
    public final void setSquare(Square s) {
        this.square = s;
    }

    /**
     * Returns private variable available.
     *
     * @return true if piece is available, false otherwise
     */
    public final boolean getAvailable() {
        return this.available;
    }

    /**
     * Sets variable available to b.
     *
     * @param b boolean for whether piece is available
     */
    public final void setAvailable(final boolean b) {
        this.available = b;
    }

    /**
     * Returns private variable initSquare.
     *
     * @return This pieces initial position as Square
     */
    public final Square getInitSquare() {
        return this.initSquare;
    }
}
