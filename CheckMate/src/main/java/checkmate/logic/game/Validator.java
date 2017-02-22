package checkmate.logic.game;

import checkmate.logic.pieces.King;
import checkmate.logic.pieces.Piece;
import checkmate.logic.pieces.Rook;
import java.util.ArrayList;

/**
 * Class for validating moves and situations in the game.
 *
 * @author llmlks
 */
public class Validator {

    /**
     * Private variable for ChessBoard.
     */
    private final ChessBoard board;
    /**
     * Private variable to keep track of squares that are occupied.
     */
    private ArrayList<Square> occupiedSquares;

    /**
     * Assigns ChessBoard to board and initialises occupiedSquares.
     *
     * @param chessboard ChessBoard
     */
    public Validator(final ChessBoard chessboard) {
        this.board = chessboard;
        occupiedSquares = this.setOccupiedSquares();
    }

    /**
     * Returns private variable board.
     *
     * @return this.board
     */
    public final ChessBoard getBoard() {
        return board;
    }

    /**
     * Returns private variable occupiedSquares.
     *
     * @return this.occupiedSquares
     */
    public final ArrayList<Square> getOccupiedSquares() {
        return occupiedSquares;
    }

    /**
     * Checks which of the squares are occupied.
     *
     * @return ArrayList
     */
    public final ArrayList<Square> setOccupiedSquares() {
        ArrayList<Square> occupied = new ArrayList<>();
        for (Square s : this.board.getSquares()) {
            if (s.isOccupied()) {
                occupied.add(s);
            }
        }
        return occupied;
    }

    /**
     * Checks whether the move of piece p to square to is valid.
     *
     * @param p Piece
     * @param to Square
     * @return boolean
     */
    public final boolean isValidMove(final Piece p, final Square to) {
        this.occupiedSquares = this.setOccupiedSquares();
        if (!p.isValidMove(to) || p.getSquare().equals(to)) {
            return false;
        }
        if (piecesBetween(p.getSquare(), to) && !p.getType().equals("knight")) {
            return false;
        }
        if (p.getType().equals("pawn")) {
            return true;
        }
        if (occupiedSquares.contains(to)) {
            if (!to.getPiece().getColour().equals(p.getColour())) {
                to.getPiece().setAvailable(false);
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks whether there are any pieces between squares to and from.
     *
     * @param from Square
     * @param to Square
     * @return boolean
     */
    public final boolean piecesBetween(final Square from, final Square to) {
        PiecesBetween check = new PiecesBetween(this.occupiedSquares);
        return check.piecesBetween(from, to);
    }

    /**
     * Checks whether piece given can be captured by any of opponent's pieces.
     *
     * @param p Piece
     * @return boolean
     */
    public final boolean canBeCaptured(final Piece p) {
        for (Piece piece : board.getPieces()) {
            if (piece.getAvailable()
                    && !piece.getColour().equals(p.getColour())) {
                if (piece.isValidMove(p.getSquare())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks whether player's king is in check.
     *
     * @param colour String
     * @return boolean
     */
    public final boolean isChecked(final String colour) {
        for (Piece piece : board.getPieces()) {
            if (piece.getColour().equals(colour)
                    && piece.getType().equals("king")) {
                return canBeCaptured(piece);
            }
        }
        return false;
    }

    /**
     * Checks whether player can castle using a chosen rook.
     *
     * @param king King
     * @param rook Rook
     * @return boolean
     */
    public final boolean canCastle(final King king, final Rook rook) {
        return king.getInitSquare().equals(king.getSquare())
                && rook.getInitSquare().equals(rook.getSquare())
                && !piecesBetween(king.getSquare(), rook.getSquare());
    }

    /**
     * Checks whether player has any valid moves left.
     *
     * @param player Player
     * @return boolean
     */
    public final boolean hasValidMoves(final Player player) {
        for (Piece piece : player.getPieces()) {
            if (!validMoves(piece).isEmpty() && piece.getAvailable()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an ArrayList of Squares that Piece p can move to.
     *
     * @param p Piece
     * @return ArrayList, type Squares
     */
    public final ArrayList<Square> validMoves(final Piece p) {
        ArrayList<Square> moves = new ArrayList<>();
        for (Square s : this.board.getSquares()) {
            if (isValidMove(p, s)) {
                moves.add(s);
            }
        }
        return moves;
    }

    /**
     * Checks whether both players have valid moves and haven't lost 
     * their kings.
     *
     * @param players Player[]
     * @return boolean
     */
    public final boolean gameEnded(Player[] players) {
        return !(hasValidMoves(players[0]) && hasValidMoves(players[1])
                && players[0].hasKing() && players[1].hasKing());
    }
}
