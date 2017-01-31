package checkmate.logic.pieces;

import checkmate.logic.game.Square;

/**
 *
 * @author llmlks
 */
public abstract class Piece {
    
    Square square;
    String colour;
    String type;
    
    public Piece(Square s, String c) {
        this.square = s;
        this.colour = c;
        this.type = "";
    }

    public abstract boolean isValidMove(Square s);

    public void move(Square s) {
        s.setPiece(this);
        this.square = s;
    }
    
    public Square getSquare() {
        return this.square;
    }
    
    public String getColour() {
        return this.colour;
    }
    
    public String getType() {
        return this.type;
    }
}
