package checkmate.logic.pieces;

import checkmate.logic.game.Square;
import java.util.ArrayList;

/**
 *
 * @author llmlks
 */
public class Queen extends Piece {

    /**
     * Calls constructor of parent class Piece.
     *
     * @param s Square
     * @param c String
     */
    public Queen(final Square s, final String c) {
        super(s, c);
    }

    /**
     * Checks if move to Square s is valid for queen.
     *
     * @param s Square
     * @return boolean
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        return s.isDiagonal(square) || s.isSameFile(square)
                || s.isSameRank(square);
    }

    @Override
    public final ArrayList<Square> possibleMoves() {
        ArrayList<Square> possible = new ArrayList<>();
        return possible;
    }
}
