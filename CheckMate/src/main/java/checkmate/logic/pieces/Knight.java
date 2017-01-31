package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 *
 * @author llmlks
 */
public class Knight extends Piece {

    public Knight(Square s, String c) {
        super(s, c);
    }

    @Override
    public boolean isValidMove(Square s) {
        if (Math.abs(s.getX() - square.getX()) == 2 && Math.abs(s.getY() - 
                square.getY()) == 1) {
            return true;
        }
        if (Math.abs(s.getX() - square.getX()) == 1 && Math.abs(s.getY() - 
                square.getY()) == 2) {
            return true;
        }        
        return false;
    }
}
