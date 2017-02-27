package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 * Class for King objects.
 *
 * @author llmlks
 */
public class King extends Piece {

    /**
     * Calls constructor of parent class Piece.
     *
     * @param s Square where king is positioned
     * @param c String for colour, w for white or b for black
     */
    public King(final Square s, final String c) {
        super(s, c);
        this.setType("king");
    }

    /**
     * Checks whether the move to square s from this.square is valid for king.
     *
     * @param s Square to which king would move
     * @return true if move would be legal, false otherwise
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        return square.isNextTo(s);
    }
}
