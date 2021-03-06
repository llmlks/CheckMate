package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 * Class for Knight objects.
 *
 * @author llmlks
 */
public class Knight extends Piece {

    /**
     * Calls constructor of parent class Piece and sets this.type to "knight".
     *
     * @param s Square where knight is positioned
     * @param c String for colour, w for white or b for black
     */
    public Knight(final Square s, final String c) {
        super(s, c);
        this.setType("knight");
    }

    /**
     * Checks whether the move to square s from this.square is valid for knight.
     *
     * @param s Square to which knight would move
     * @return true if move would be legal, false otherwise
     */
    @Override
    public final boolean isValidMove(final Square s) {
        Square square = this.getSquare();
        if (Math.abs(s.getX() - square.getX()) == 2 && Math.abs(s.getY()
                - square.getY()) == 1) {
            return true;
        }
        return Math.abs(s.getX() - square.getX()) == 1 && Math.abs(s.getY()
                - square.getY()) == 2;
    }

}
