package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 * Class for Rook objects.
 *
 * @author llmlks
 */
public class Rook extends Piece {

    /**
     * Calls constructor of parent class Piece.
     *
     * @param s Square where rook is positioned
     * @param c String for colour, w for white or b for black
     */
    public Rook(final Square s, final String c) {
        super(s, c);
        this.setType("rook");
    }

    /**
     * Checks whether the move to square s from this.square is valid for rook.
     *
     * @param s Square to which knight would move
     * @return true if move would be legal, false otherwise
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        return s.isSameFile(square) || s.isSameRank(square);
    }
}
