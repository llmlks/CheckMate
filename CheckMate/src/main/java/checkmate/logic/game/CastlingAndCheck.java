package checkmate.logic.game;

import checkmate.logic.pieces.Piece;
import java.util.ArrayList;

/**
 * Class for checking castling and check.
 *
 * @author llmlks
 */
public class CastlingAndCheck {

    /**
     * Private variable to hold players.
     */
    private final Player[] players;
    /**
     * Private variable to hold chessboard.
     */
    private final ChessBoard board;
    /**
     * Private variable to hold validator.
     */
    private final Validator validator;

    /**
     * Constructor sets final variables for players, chessboard and validator.
     *
     * @param pl Player
     * @param cb ChessBoard
     * @param val Validator
     */
    public CastlingAndCheck(Player[] pl, ChessBoard cb, Validator val) {
        this.players = pl;
        this.board = cb;
        this.validator = val;
    }

    /**
     * Checks the list given as parameter, if any of the moves would cause
     * check.
     *
     * @param moves List of possible moves
     * @param p Piece to be moved
     * @return List of moves that would cause for the player to become checked
     */
    public final ArrayList<Square> movesCausingCheck(
            final ArrayList<Square> moves, final Piece p) {
        ArrayList<Square> notValidMoves = new ArrayList<>();
        for (Square s : moves) {
            if (!tryMove(p, s)) {
                notValidMoves.add(s);
            }
        }
        return notValidMoves;
    }

    /**
     * Checks whether moving a player's piece to a square would cause that
     * player to become checked.
     *
     * @param p Piece which will be temporarily moved
     * @param s Square to which the move is tried
     * @return true if move doesn't cause check, false otherwise
     */
    public final boolean tryMove(final Piece p, final Square s) {
        Player player = p.getColour().equals("w") ? players[0] : players[1];
        Square from = p.getSquare();
        Piece occupier = s.getPiece();
        p.setSquare(s);
        from.setPiece(null);
        s.setPiece(p);
        boolean moveFails = isChecked(player);
        p.setSquare(from);
        s.setPiece(occupier);
        from.setPiece(p);
        return !moveFails;
    }

    /**
     * Goes through all the pieces on the board, and if the piece under
     * inspection is of different colour than the one given as a parameter,
     * checks whether it can move to parameter pieces square legally.
     *
     * @param p Piece
     * @return true if piece can be captured, false otherwise
     */
    public final boolean canBeCaptured(final Piece p) {
        for (Piece piece : this.board.getPieces()) {
            if (!piece.getColour().equals(p.getColour())
                    && validator.isValidMove(piece, p.getSquare())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether player's king is in check.
     *
     * @param player Player whose check situation is to be looked at
     * @return true if the player is in check, false otherwise
     */
    public final boolean isChecked(final Player player) {
        return canBeCaptured(player.getKing());
    }

    /**
     * Checks whether player has available rooks on the board and if player's
     * king is in its initial position, then returns a list of squares the
     * player can castle their king.
     *
     * @param king Players king
     * @return List of squares where king can move to for castling
     */
    public final ArrayList<Square> possibleCastlingSquares(final Piece king) {
        ArrayList<Piece> rooks = findPlayersRooks(king.getColour());
        Square kingS = king.getSquare();
        if (!kingS.equals(king.getInitSquare()) || rooks.isEmpty()) {
            return new ArrayList<>();
        }
        return castlingSquares(rooks, kingS);
    }

    /**
     * Returns a list of rooks of specified colour.
     *
     * @param colour String for colour, w for white or b for black
     * @return List of rooks of type Piece of the colour specified
     */
    public final ArrayList<Piece> findPlayersRooks(final String colour) {
        ArrayList<Piece> rooks = new ArrayList<>();
        for (Piece p : this.board.getPieces()) {
            if (p.getColour().equals(colour) && p.getAvailable()
                    && p.getType().equals("rook")) {
                rooks.add(p);
            }
        }
        return rooks;
    }

    /**
     * Returns squares to which player can castle.
     *
     * @param rooks List of players rooks that are still available
     * @param kingS Square where player's king is positioned
     * @return List of squares where king can move to for castling
     */
    public final ArrayList<Square> castlingSquares(final ArrayList<Piece> rooks,
            final Square kingS) {
        ArrayList<Square> castling = new ArrayList<>();
        for (Piece r : rooks) {
            if (r.getSquare().equals(r.getInitSquare())
                    && !validator.piecesBetween(kingS, r.getSquare())) {
                int help = kingS.getX() > r.getSquare().getX() ? -2 : 2;
                castling.add(this.board.findSquareByCoordinates(kingS.getX()
                        + help, kingS.getY()));
            }
        }
        return castling;
    }
}
