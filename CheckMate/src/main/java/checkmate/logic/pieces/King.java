package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 *
 * @author llmlks
 */
public class King extends Piece {

    /**
     * Calls constructor of parent class Piece.
     *
     * @param s Square
     * @param c String
     */
    public King(final Square s, final String c) {
        super(s, c);
    }

    /**
     * Checks whether the move to square s from this.square is valid for king.
     *
     * @param s Square
     * @return boolean
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        return square.isNextTo(s);
    }
}
