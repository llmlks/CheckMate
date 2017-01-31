package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 *
 * @author llmlks
 */
public class King extends Piece {

    public King(Square s, String c) {
        super(s, c);
    }

    @Override
    public boolean isValidMove(Square s) {
        return square.isNextTo(s);
    }
}
