package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 * Class for Bishop objects.
 *
 * @author llmlks
 */
public class Bishop extends Piece {

    /**
     * Calls constructor of parent class Piece.
     *
     * @param s Square where bishop is positioned
     * @param c Colour as a String, either w for white or b for black
     */
    public Bishop(final Square s, final String c) {
        super(s, c);
        this.setType("bishop");
    }

    /**
     * Checks whether the move to square s from this.square is valid for bishop.
     *
     * @param s Square to which bishop would move
     * @return true if move would be legal, false otherwise
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        return square.isDiagonal(s);
    }

}
