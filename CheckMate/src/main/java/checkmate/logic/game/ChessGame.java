package checkmate.logic.game;

import checkmate.logic.pieces.Piece;

/**
 * Main class for game logic.
 *
 * @author llmlks
 */
public class ChessGame {

    /**
     * Private variable for ChessBoard.
     */
    private ChessBoard board;

    /**
     * Private variable Player[].
     */
    private Player[] players;

    /**
     * Private variable for Validator.
     */
    private Validator validator;

    /**
     * Private variable for keeping track of turns.
     */
    private int turn;

    /**
     * Private variable for checking if the game has ended.
     */
    private boolean ended;

    /**
     * Constructor calls own method initGame().
     */
    public ChessGame() {
        this.initGame();
    }

    /**
     * Returns private variable board.
     *
     * @return this.board ChessBoard
     */
    public final ChessBoard getBoard() {
        return this.board;
    }

    /**
     * Returns list of players.
     *
     * @return array of players
     */
    public final Player[] getPlayers() {
        return this.players;
    }

    /**
     * Finds square at coordinates x and y.
     *
     * @param x integer x coordinate
     * @param y integer y coordinate
     * @return Square at coordinates x and y, or null if none is found
     */
    public final Square findSquareByCoordinates(int x, int y) {
        for (Square s : this.board.getSquares()) {
            if (s.getX() == x && s.getY() == y) {
                return s;
            }
        }
        return null;
    }

    /**
     * Returns validator.
     *
     * @return Validator
     */
    public final Validator getValidator() {
        return this.validator;
    }

    /**
     * Creates a new ChessBoard, and calls appropriate methods to generate 64
     * squares and 32 pieces; generates 2 players, and matches created pieces by
     * colour to players; creates a new Validator, sets variable turn to 0.
     */
    public final void initGame() {
        this.board = new ChessBoard();
        this.board.initSquares();
        board.initPieces();

        players = new Player[]{new Player("w"), new Player("b")};
        for (Player player : players) {
            for (Piece piece : board.getPieces()) {
                if (piece.getColour().equals(player.getColour())) {
                    player.addPiece(piece);
                }
            }
        }
        this.validator = new Validator(this.board, players);
        validator.setOccupiedSquares();
        this.turn = 0;
    }

    /**
     * Checks whether the players still have valid moves, then executes the
     * player's move.
     *
     * @param p Piece to be moved this turn
     * @param s Square for the piece to be moved to
     */
    public final void turn(Piece p, Square s) {
        if (!ended) {
            Square from = p.getSquare();
            players[p.getColour().equals("w") ? 1 : 0].removePiece(s.getPiece());
            p.move(s);
            for (Square square : this.board.getSquares()) {
                square.setEnPassant(null);
            }
            if (p.getType().equals("pawn")
                    && Math.abs(s.getY() - from.getY()) == 2) {
                enPassant(p, s, from);
            }
            if (p.getType().equals("king")
                    && Math.abs(s.getX() - from.getX()) == 2) {
                castle(s);
            }
            turn = (turn + 1) % 2;
            ended = validator.gameEnded();
        }
    }

    /**
     * Helper function to determine when en passant is possible.
     *
     * @param pawn Piece that can be captured en passant
     * @param to Square piece pawn moved to
     * @param from Square piece pawn moved from
     */
    public final void enPassant(final Piece pawn, final Square to, final Square from) {
        int help = Math.max(to.getY(), from.getY());
        if (help == to.getY()) {
            findSquareByCoordinates(to.getX(), from.getY()
                    + 1).setEnPassant(pawn);
        } else {
            findSquareByCoordinates(to.getX(), from.getY()
                    - 1).setEnPassant(pawn);
        }
    }

    /**
     * Handles castling when king is moved two squares to square s.
     *
     * @param s Square where king moved to
     */
    public final void castle(final Square s) {
        int rookX = s.getX() == 3 ? 1 : 8;
        int newRookX = rookX == 1 ? 4 : 6;
        int y = s.getY();
        Square rookSquare = findSquareByCoordinates(rookX, y);
        Square newRookSquare = findSquareByCoordinates(newRookX, y);
        rookSquare.getPiece().move(newRookSquare);
    }

    /**
     * Returns boolean value for whether the game is finished.
     *
     * @return true if game has ended (neither player has valid moves left)
     */
    public final boolean getEnded() {
        return this.ended;
    }

    /**
     * Returns the String colour of the player whose turn it is.
     *
     * @return String for colour, w for white, b for black
     */
    public String getTurn() {
        String turns = "wb";
        return turns.charAt(turn) + "";
    }
}
