package checkmate.logic.game;

import checkmate.logic.pieces.Bishop;
import checkmate.logic.pieces.Knight;
import checkmate.logic.pieces.Pawn;
import checkmate.logic.pieces.Piece;
import checkmate.logic.pieces.Queen;
import checkmate.logic.pieces.Rook;

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
            p.move(s);
            turn = (turn + 1) % 2;
            ended = validator.gameEnded(players);
        }
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
