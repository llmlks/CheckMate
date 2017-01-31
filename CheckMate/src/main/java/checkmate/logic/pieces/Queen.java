package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 *
 * @author llmlks
 */
public class Queen extends Piece {
    
    public Queen(Square s, String c) {
        super(s, c);
    }
    
    @Override
    public boolean isValidMove(Square s) {
        if (s.isDiagonal(square) || s.isSameFile(square) || s.isSameRank(square)) {
            return true;
        }
        return false;
    }
}
