package checkmate.logic.pieces;

import checkmate.logic.game.Square;
import java.util.ArrayList;

/**
 * Class for Bishop objects.
 *
 * @author llmlks
 */
public class Bishop extends Piece {

    /**
     * Calls constructor of parent class Piece.
     *
     * @param s Square
     * @param c String
     */
    public Bishop(final Square s, final String c) {
        super(s, c);
        this.setType("bishop");
    }

    /**
     * Checks whether the move to square s from this.square is valid for bishop.
     *
     * @param s Square
     * @return boolean
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        return square.isDiagonal(s);
    }

}
