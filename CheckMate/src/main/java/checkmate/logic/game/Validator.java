package checkmate.logic.game;

import checkmate.logic.pieces.Piece;
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
     * Private variable to hold players.
     */
    private final Player[] players;
    /**
     * Private variable to hold checker for Castling and Check validations.
     */
    private final CastlingAndCheck checker;

    /**
     * Assigns ChessBoard to board and initialises occupiedSquares.
     *
     * @param chessboard ChessBoard
     * @param playerArray Players
     */
    public Validator(final ChessBoard chessboard, final Player[] playerArray) {
        this.board = chessboard;
        occupiedSquares = this.setOccupiedSquares();
        players = playerArray;
        this.checker = new CastlingAndCheck(playerArray, chessboard, this);
    }

    /**
     * Returns private variable board.
     *
     * @return ChessBoard
     */
    public final ChessBoard getBoard() {
        return board;
    }

    /**
     * Returns private variable occupiedSquares.
     *
     * @return List of squares that are occupied
     */
    public final ArrayList<Square> getOccupiedSquares() {
        return occupiedSquares;
    }

    /**
     * Checks which of the squares are occupied.
     *
     * @return List of squares that are occupied
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
     * @param p Piece under inspection
     * @param to Square where piece would be moved to
     * @return true if move is valid, false otherwise
     */
    public final boolean isValidMove(final Piece p, final Square to) {
        if (!p.getAvailable()) {
            return false;
        }
        this.occupiedSquares = this.setOccupiedSquares();
        if (p.getType().equals("pawn") && to.getEnPassant() != null
                && to.isNextTo(p.getSquare()) && to.isDiagonal(p.getSquare())) {
            return true;
        }
        if (!p.isValidMove(to) || p.getSquare().equals(to)) {
            return false;
        }
        if (piecesBetween(p.getSquare(), to) && !p.getType().equals("knight")) {
            return false;
        }
        if (occupiedSquares.contains(to)) {
            return !to.getPiece().getColour().equals(p.getColour());
        }
        return true;
    }

    /**
     * Checks whether there are any pieces between squares to and from.
     *
     * @param from Square
     * @param to Square
     * @return true if there are pieces between squares to and from
     */
    public final boolean piecesBetween(final Square from, final Square to) {
        PiecesBetween check = new PiecesBetween(this.occupiedSquares);
        return check.piecesBetween(from, to);
    }

    /**
     * Checks through all player's pieces if any have valid moves left.
     *
     * @param player Player to be inspected
     * @return true if any of player's pieces has at least one valid move
     */
    public final boolean hasValidMoves(final Player player) {
        for (Piece piece : player.getPieces()) {
            if (piece.getAvailable() && !validMoves(piece).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks every square on board whether p can be moved to it according to
     * chess rules.
     *
     * @param p Piece for which valid moves are searched for
     * @return List of squares where piece p can move to
     */
    public final ArrayList<Square> validMoves(final Piece p) {
        ArrayList<Square> moves = new ArrayList<>();
        for (Square s : this.board.getSquares()) {
            if (isValidMove(p, s)) {
                moves.add(s);
            }
        }
        if (p.getType().equals("king")) {
            moves.addAll(checker.possibleCastlingSquares(p));
        }
        moves.removeAll(checker.movesCausingCheck(moves, p));
        return moves;
    }

    /**
     * Checks whether both players have valid moves and haven't lost their
     * kings.
     *
     * @return true if either of the players is out of valid moves
     */
    public final boolean gameEnded() {
        return !(hasValidMoves(players[0]) && hasValidMoves(players[1]));
    }

    /**
     * Checks at the end of the game whether it is a checkmate or a stalemate.
     *
     * @return true if either player is checked.
     */
    public final boolean playersInCheck() {
        return checker.isChecked(players[0]) || checker.isChecked(players[1]);
    }
}
