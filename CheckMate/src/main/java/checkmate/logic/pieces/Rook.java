package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 *
 * @author llmlks
 */
public class Rook extends Piece {

    public Rook(Square s, String c) {
        super(s, c);
    }

    @Override
    public boolean isValidMove(Square s) {
        if (s.isSameFile(square) || s.isSameRank(square)) {
            return true;
        }
        return false;
    }
}
