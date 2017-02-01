package checkmate.logic.game;

/**
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
     * Constructor generates new ChessBoard.
     */
    public ChessGame() {
        this.board = new ChessBoard();
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
     * Calls initSquares and initPieces on this.board Generates 2 players in
     * this.players.
     */
    public final void start() {
        this.board.initSquares();
        board.initPieces();

        players = new Player[]{new Player(), new Player()};
    }
}
