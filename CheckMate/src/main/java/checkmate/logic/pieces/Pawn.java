package checkmate.logic.pieces;

import checkmate.logic.game.Square;
import java.util.ArrayList;

/**
 *
 * @author llmlks
 */
public class Pawn extends Piece {

    /**
     * Private variable to hold inital Square.
     */
    private final Square initSquare;
    /**
     * Private variable for integer direction (different for balcks and whites).
     */
    private final int direction;

    /**
     * Calls constructor of parent class Piece, sets initSquare to s and sets
     * direction based on colour to 1 or -1, for whites and blacks,
     * respectively.
     *
     * @param s Square
     * @param c String
     */
    public Pawn(final Square s, final String c) {
        super(s, c);
        initSquare = s;
        if (c.equals("w")) {
            direction = 1;
        } else {
            direction = -1;
        }
        this.setType("pawn");
    }

    /**
     * @return this.direction int
     */
    public final int getDirection() {
        return this.direction;
    }

    /**
     * @return this.initSquare Square
     */
    public final Square getInitSquare() {
        return this.initSquare;
    }

    /**
     * Checks whether the move to square s from this.square is valid for pawn.
     *
     * @param s Square
     * @return boolean
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        if (s.isOccupied() && s.isNextTo(square) && s.isDiagonal(square)
                && !s.getPiece().getColour().equals(this.getColour())) {
            s.getPiece().setAvailable(false);
            return true;
        }
        return s.isSameFile(square) && (square.getY() - s.getY()
                == direction * 1 || (square.equals(initSquare) && square.getY()
                - s.getY() == direction * 2));
    }

    @Override
    public final ArrayList<Square> possibleMoves() {
        ArrayList<Square> possible = new ArrayList<>();
        return possible;
    }
}
