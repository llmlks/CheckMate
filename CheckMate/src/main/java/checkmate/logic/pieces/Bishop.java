package checkmate.logic.pieces;

import checkmate.logic.game.Square;
import checkmate.logic.pieces.Piece;

/**
 *
 * @author llmlks
 */
public class Bishop extends Piece {

    public Bishop(Square s, String c) {
        super(s, c);
    }

    @Override
    public boolean isValidMove(Square s) {
        return square.isDiagonal(s);
    }
}

