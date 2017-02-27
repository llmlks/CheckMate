package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 * Class for Queen objects.
 *
 * @author llmlks
 */
public class Queen extends Piece {

    /**
     * Calls constructor of parent class Piece.
     *
     * @param s Square where queen is positioned
     * @param c String for colour, w for white or b for black
     */
    public Queen(final Square s, final String c) {
        super(s, c);
        this.setType("queen");
    }

    /**
     * Checks if move to Square s is valid for queen.
     *
     * @param s Square to which queen would move
     * @return true if move would be legal, false otherwise
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        return s.isDiagonal(square) || s.isSameFile(square)
                || s.isSameRank(square);
    }

}
