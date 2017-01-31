package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 *
 * @author llmlks
 */
public class Pawn extends Piece {

    private Square initSquare;
    private int direction;
    
    public Pawn(Square s, String c) {
        super(s, c);
        initSquare = s;
        if (c.equals("w")) {
            direction = -1;
        } else {
            direction = 1;
        }
    }

    @Override
    public boolean isValidMove(Square s) {
        if (s.isSameFile(square) && (square.getY() - s.getY() == 1*direction || 
                (square.equals(initSquare) && square.getY() - s.getY() == 2*direction))) {
            return true;
        }
        return false;
    }
}

