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
     * @param moves ArrayList of type Square
     * @param p Piece
     * @return ArrayList of type Square
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
     * Checks whether moving a piece to a square causes that player to become
     * checked.
     *
     * @param p Piece
     * @param s Square
     * @return boolean
     */
    public final boolean tryMove(final Piece p, final Square s) {
        Player player = p.getColour().equals("w") ? players[0] : players[1];
        Square from = p.getSquare();
        Piece occupier = s.getPiece();
        p.setSquare(s);
        from.setPiece(null);
        s.setPiece(p);
        boolean moveSucceeds = isChecked(player);
        p.setSquare(from);
        s.setPiece(occupier);
        from.setPiece(p);
        return !moveSucceeds;
    }

    /**
     * Checks whether piece can be captured.
     *
     * @param p Piece
     * @return boolean
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
     * @param player Player
     * @return boolean
     */
    public final boolean isChecked(final Player player) {
        return canBeCaptured(player.getKing());
    }

    /**
     * Returns a list of squares the player can castle their king.
     *
     * @param king Piece
     * @return ArrayList of Squares
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
     * @param colour String
     * @return ArrayList of type Piece
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
     * @param rooks ArrayList of type Piece
     * @param kingS Square
     * @return ArrayList of type Square
     */
    public final ArrayList<Square> castlingSquares(final ArrayList<Piece> rooks,
            final Square kingS) {
        ArrayList<Square> castling = new ArrayList<>();
        for (Piece r : rooks) {
            if (r.getInitSquare().equals(r.getSquare())
                    && !validator.piecesBetween(kingS, r.getSquare())) {
                int help = 2;
                int help2 = Math.max(kingS.getX(), r.getSquare().getX());
                if (help2 == kingS.getX()) {
                    help = -2;
                }
                castling.add(this.board.findSquareByCoordinates(kingS.getX()
                        + help, kingS.getY()));
            }
        }
        return castling;
    }
}
