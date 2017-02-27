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
     * @param s Square where pawn is positioned
     * @param c String for colour, w for white or b for black
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
     * Returns private variable direction; 1 for white pawns and
     * -1 for blacks.
     *
     * @return Integer direction of this this piece
     */
    public final int getDirection() {
        return this.direction;
    }

    /**
     * Checks whether the move to square s from this.square is valid for pawn.
     *
     * @param s Square to which pawn would move
     * @return true if move would be valid, false otherwise
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
