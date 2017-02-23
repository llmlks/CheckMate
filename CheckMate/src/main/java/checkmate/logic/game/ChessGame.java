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
     * Constructor generates new ChessBoard.
     */
    public ChessGame() {
        this.initGame();
    }

    /**
     * Sets this.board to b.
     *
     * @param b ChessBoard
     */
    public final void setBoard(final ChessBoard b) {
        this.board = b;
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
     * @return this.players Player[]
     */
    public final Player[] getPlayers() {
        return this.players;
    }

    /**
     * Finds square at coordinates x and y.
     *
     * @param x int
     * @param y int
     * @return Square
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
     * Calls initSquares and initPieces on this.board, generates 2 players in
     * this.players, then starts the game.
     */
    public final void initGame() {
        this.board = new ChessBoard();
        this.board.initSquares();
        board.initPieces();
        this.validator = new Validator(this.board);
        validator.setOccupiedSquares();

        players = new Player[]{new Player("w"), new Player("b")};
        for (Player player : players) {
            for (Piece piece : board.getPieces()) {
                if (piece.getColour().equals(player.getColour())) {
                    player.addPiece(piece);
                }
            }
        }
        this.turn = 0;
    }

    /**
     * Checks whether the players still have valid moves, then executes the
     * player's move.
     *
     * @param p Piece
     * @param s Square
     */
    public final void turn(Piece p, Square s) {
        if (!ended) {
            Square from = p.getSquare();
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
                castle(p, s);
            }
            turn = (turn + 1) % 2;
            ended = validator.gameEnded(players);
        }
    }

    /**
     * Helper function to determine when en passant is possible.
     * 
     * @param pawn
     * @param to
     */
    public final void enPassant(Piece pawn, Square to, Square from) {
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
     * @param king
     * @param s
     */
    public final void castle(final Piece king, final Square s) {
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
     * @return boolean
     */
    public final boolean getEnded() {
        return this.ended;
    }

    /**
     * Returns the String colour of the player whose turn it is.
     *
     * @return String
     */
    public String getTurn() {
        String turns = "wb";
        return turns.charAt(turn) + "";
    }
}
