package checkmate.logic.game;

import checkmate.logic.pieces.Piece;

/**
 *
 * @author llmlks
 */
public class Square {

    /**
     * Private variable integer for x coordinate.
     */
    private final int x;
    /**
     * Private variable integer for y coordinate.
     */
    private final int y;
    /**
     * Private variable Piece to hold piece occupying this square.
     */
    private Piece piece;
    /**
     * Private variable int to hold the size of the chessboard.
     */
    private int size;

    /**
     * Assigns parameter values x and y to variables x and y respectively, and
     * boardSize to variable size.
     *
     * @param xCoordinate int
     * @param yCoordinate int
     */
    public Square(final int xCoordinate, final int yCoordinate) {
        this.x = xCoordinate;
        this.y = yCoordinate;
    }

    /**
     * Sets this.size.
     *
     * @param s int
     */
    public final void setSize(final int s) {
        this.size = s;
    }

    /**
     * @return s int
     */
    public final int getSize() {
        return this.size;
    }

    /**
     * @return this.x int
     */
    public final int getX() {
        return this.x;
    }

    /**
     * @return this.y int
     */
    public final int getY() {
        return this.y;
    }

    /**
     * @return this.piece Piece
     */
    public final Piece getPiece() {
        return piece;
    }

    /**
     * Sets p to this.piece.
     *
     * @param p Piece
     */
    public final void setPiece(final Piece p) {
        this.piece = p;
    }

    /**
     * Checks whether square s is next to this.
     *
     * @param s Square
     * @return boolean
     */
    public final boolean isNextTo(final Square s) {
        if (s.x == this.x && s.y == this.y) {
            return false;
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (s.x == this.x + i && s.y == this.y + j) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if Square s is in the same rank (line horizontally) as this.
     *
     * @param s Square
     * @return boolean
     */
    public final boolean isSameRank(final Square s) {
        return s.y == this.y && !s.equals(this);
    }

    /**
     * Checks whether Square s is in the same file (line vertically) as this.
     *
     * @param s Square
     * @return boolean
     */
    public final boolean isSameFile(final Square s) {
        return s.x == this.x && !s.equals(this);
    }

    /**
     * Checks if Square s is located diagonally from this.
     *
     * @param s Square
     * @return boolean
     */
    public final boolean isDiagonal(final Square s) {
        return Math.abs(s.x - this.x) == Math.abs(s.y - this.y)
                && !s.equals(this);
    }

    /**
     * Checks if this is occupied, returns false if this.piece is null.
     *
     * @return boolean
     */
    public final boolean isOccupied() {
        return this.piece != null;
    }

    @Override
    public final boolean equals(final Object o) {
        if (o == null || !Square.class.isAssignableFrom(o.getClass())) {
            return false;
        }
        final Square s = (Square) o;
        return s.x == this.x && s.y == this.y;
    }

    @Override
    public final int hashCode() {
        int hash = this.x + (this.y - 1) * size;
        return hash;
    }
}
