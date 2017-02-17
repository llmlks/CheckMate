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
     * Constructor generates new ChessBoard.
     */
    public ChessGame() {
        this.board = new ChessBoard();
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
    }
}
