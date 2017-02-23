package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 * Class for Pawn objects.
 *
 * @author llmlks
 */
public class Pawn extends Piece {

    /**
     * Private variable for integer direction (different for blacks and whites).
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
        if (c.equals("w")) {
            direction = 1;
        } else {
            direction = -1;
        }
        this.setType("pawn");
    }

    /**
     * Returns private variable direction.
     *
     * @return this.direction int
     */
    public final int getDirection() {
        return this.direction;
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
        if (s.isNextTo(square) && s.isDiagonal(square) && s.isOccupied()
                && s.getY() == super.getSquare().getY() + direction * (-1)
                && !s.getPiece().getColour().equals(this.getColour())) {
            return true;
        }
        return s.isSameFile(square) && ((square.getY() - s.getY()
                == direction * 1) || (square.equals(this.getInitSquare()) 
                && square.getY() - s.getY() == direction * 2)) 
                && !s.isOccupied();
    }

}
