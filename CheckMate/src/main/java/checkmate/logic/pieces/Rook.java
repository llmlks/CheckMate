package checkmate.logic.pieces;

import checkmate.logic.game.Square;
import java.util.ArrayList;

/**
 * Class for Rook objects.
 *
 * @author llmlks
 */
public class Rook extends Piece {

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
    public Rook(final Square s, final String c) {
        super(s, c);
        this.initSquare = s;
        this.setType("rook");
    }

    /**
     * Checks whether the move to square s from this.square is valid for rook.
     *
     * @param s Square
     * @return boolean
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        return s.isSameFile(square) || s.isSameRank(square);
    }

    /**
     * Returns initial square.
     *
     * @return Square
     */
    public final Square getInitSquare() {
        return this.initSquare;
    }

    @Override
    public final ArrayList<Square> possibleMoves() {
        ArrayList<Square> possible = new ArrayList<>();
        return possible;
    }
}
