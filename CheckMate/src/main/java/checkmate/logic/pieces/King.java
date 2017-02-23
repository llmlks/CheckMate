package checkmate.logic.pieces;

import checkmate.logic.game.Square;
import java.util.ArrayList;

/**
 * Class for King objects.
 *
 * @author llmlks
 */
public class King extends Piece {

    /**
     * Private variable to hold the initial square.
     */
    private final Square initSquare;

    /**
     * Calls constructor of parent class Piece.
     *
     * @param s Square
     * @param c String
     */
    public King(final Square s, final String c) {
        super(s, c);
        this.setType("king");
        this.initSquare = s;
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

    /**
     * Returns initial square.
     *
     * @return Square
     */
    public final Square getInitSquare() {
        return this.initSquare;
    }

}
