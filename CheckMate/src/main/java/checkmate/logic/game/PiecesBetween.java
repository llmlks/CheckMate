package checkmate.logic.game;

import java.util.ArrayList;

/**
 * Class to check whether there are pieces between squares.
 *
 * @author llmlks
 */
public class PiecesBetween {

    /**
     * Private variable to keep track of squares that are occupied.
     */
    private final ArrayList<Square> occupiedSquares;

    /**
     * Constructor assigns ArrayList to occupiedSquares.
     *
     * @param squares ArrayList
     */
    public PiecesBetween(ArrayList<Square> squares) {
        this.occupiedSquares = squares;
    }

    /**
     * Checks whether there are any pieces between squares to and from.
     *
     * @param from Square
     * @param to Square
     * @return true if there are pieces between squares given as parameters
     */
    public final boolean piecesBetween(final Square from, final Square to) {
        if (from.isNextTo(to)) {
            return false;
        } else if (from.isDiagonal(to)) {
            return piecesBetweenDiagonally(from, to);
        } else if (from.isSameFile(to)) {
            return piecesBetweenVertically(from, to);
        } else if (from.isSameRank(to)) {
            return piecesBetweenHorizontally(from, to);
        }
        return false;
    }

    /**
     * Checks whether there are any pieces between squares to and from
     * horizontally.
     *
     * @param from Square
     * @param to Square
     * @return true if there are pieces between squares given as parameters
     * horizontally
     */
    public final boolean piecesBetweenHorizontally(final Square from,
            final Square to) {
        int help = Math.max(from.getX(), to.getX());
        int help2 = Math.min(from.getX(), to.getX());
        for (int i = help2 + 1; i < help; i++) {
            if (occupiedSquares.contains(new Square(i, from.getY()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there are any pieces between squares to and from
     * vertically.
     *
     * @param from Square
     * @param to Square
     * @return true if there are pieces between squares given as parameters
     * vertically
     */
    public final boolean piecesBetweenVertically(final Square from,
            final Square to) {
        int help = Math.max(from.getY(), to.getY());
        int help2 = Math.min(from.getY(), to.getY());
        for (int i = help2 + 1; i < help; i++) {
            if (occupiedSquares.contains(new Square(from.getX(), i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there are any pieces between squares to and from
     * diagonally.
     *
     * @param from Square
     * @param to Square
     * @return true if there are pieces between squares given as parameters
     * diagonally
     */
    public final boolean piecesBetweenDiagonally(final Square from,
            final Square to) {
        int factorY = (to.getY() - from.getY()) / Math.abs(to.getY()
                - from.getY());
        int factorX = (to.getX() - from.getX()) / Math.abs(to.getX()
                - from.getX());
        for (int i = 1; i < Math.abs(to.getY() - from.getY()); i++) {
            if (occupiedSquares.contains(new Square(from.getX() + factorX * i,
                    from.getY() + factorY * i))) {
                return true;
            }
        }
        return false;
    }
}
