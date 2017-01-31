package checkmate.logic.game;

import checkmate.logic.pieces.*;
import java.util.ArrayList;

/**
 *
 * @author llmlks
 */
public class ChessBoard {

    private ArrayList<Square> squares;
    private ArrayList<Piece> pieces;
    private final int size = 8;

    public ChessBoard() {
        this.squares = new ArrayList<>();
        this.pieces = new ArrayList<>();
    }

    public ArrayList<Square> getSquares() {
        return this.squares;
    }

    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    public void initSquares() {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                squares.add(new Square(i, j));
            }
        }        
    }
    
    public void initPieces() {
        
    }
    
    public boolean isValidMove(Piece p, Square to) {
        if (p.getSquare().equals(to)) {
            return false;
        }
        return false;
    }
    
    public boolean piecesBetween(Square from, Square to) {
        for (int i = from.getX(); i < to.getX(); i++) {
            for (int j = from.getY(); j < from.getY(); j++) {
                
            }
        }
        return false;
    }
}
