package checkmate.logic.game;

import checkmate.logic.pieces.Piece;
import java.util.ArrayList;

/**
 *
 * @author llmlks
 */
public class Validator {

    /**
     * Private variable for ChessGame.
     */
    private final ChessGame game;
    /**
     * Private variable for ChessBoard.
     */
    private final ChessBoard board;
    /**
     * Private variable to keep track of squares that are occupied.
     */
    private final ArrayList<Square> occupiedSquares;

    /**
     * Assigns ChessGame g to this.game, g.getBoard() to board and goes through
     * each square on the board to check which ones are occupied, then adds the
     * ones that are to occupiedSquares.
     *
     * @param g ChessGame
     */
    public Validator(final ChessGame g) {
        this.game = g;
        this.board = g.getBoard();
        occupiedSquares = new ArrayList<>();
        for (Square square : this.board.getSquares()) {
            if (square.isOccupied()) {
                occupiedSquares.add(square);
            }
        }
    }

    /**
     * Checks whether the move of piece p to square to is valid.
     *
     * @param p Piece
     * @param to Square
     * @return boolean
     */
    public final boolean isValidMove(final Piece p, final Square to) {
        if (!p.isValidMove(to) || p.getSquare().equals(to)) {
            return false;
        }
        if (piecesBetween(p.getSquare(), to) && !p.getType().equals("knight")) {
            return false;
        }
        if (p.getType().equals("pawn")) {
            return p.isValidMove(to);
        }
        if (to.isOccupied() && 
                !to.getPiece().getColour().equals(p.getColour())) {
            to.getPiece().setAvailable(false);
            return true;
        }
        return true;
    }

    /**
     * Checks whether there are any pieces between squares to and from by
     * calling the appropriate method based on how the pieces are located in
     * respect to each other.
     *
     * @param from Square
     * @param to Square
     * @return boolean
     */
    public final boolean piecesBetween(final Square from, final Square to) {
        if (from.isNextTo(to) || from.equals(to)) {
            return false;
        }
        if (from.isDiagonal(to)) {
            return piecesBetweenDiagonally(from, to);
        } else if (from.isSameFile(to)) {
            return piecesBetweenVertically(from, to);
        } else if (from.isSameRank(to)) {
            return piecesBetweenHorizontally(from, to);
        }
        return false;
    }

    /**
     * Checks whether there are any pieces between squares to and from
     * horizontally.
     *
     * @param from Square
     * @param to Square
     * @return boolean
     */
    public final boolean piecesBetweenHorizontally(final Square from,
            final Square to) {
        int help = Math.max(from.getX(), to.getX());
        int help2 = Math.min(from.getX(), to.getX());
        for (int i = help2 + 1; i < help; i++) {
            if (occupiedSquares.contains(new Square(i, from.getY()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there are any pieces between squares to and from
     * vertically.
     *
     * @param from Square
     * @param to Square
     * @return boolean
     */
    public final boolean piecesBetweenVertically(final Square from,
            final Square to) {
        int help = Math.max(from.getY(), to.getY());
        int help2 = Math.min(from.getY(), to.getY());
        for (int i = help + 1; i < help2; i++) {
            if (occupiedSquares.contains(new Square(from.getX(), i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there are any pieces between squares to and from
     * diagonally.
     *
     * @param from Square
     * @param to Square
     * @return boolean
     */
    public final boolean piecesBetweenDiagonally(final Square from,
            final Square to) {
        for (int i = from.getX() + 1; i < to.getX(); i++) {
            if (occupiedSquares.contains(new Square(i, from.getY()))) {
                return true;
            }
        }
        return false;
    }
}
