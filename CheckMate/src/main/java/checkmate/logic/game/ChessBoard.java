package checkmate.logic.game;

import checkmate.logic.pieces.Bishop;
import checkmate.logic.pieces.King;
import checkmate.logic.pieces.Knight;
import checkmate.logic.pieces.Pawn;
import checkmate.logic.pieces.Piece;
import checkmate.logic.pieces.Queen;
import checkmate.logic.pieces.Rook;
import java.util.ArrayList;

/**
 * Class for the chessboard.
 *
 * @author llmlks
 */
public class ChessBoard {

    /**
     * ArrayList for type Square.
     */
    private final ArrayList<Square> squares;
    /**
     * ArrayList for type Piece.
     */
    private final ArrayList<Piece> pieces;
    /**
     * Integer value for size of one side of the board (8 * 8 squares).
     */
    private final int size = 8;

    /**
     * Constructor generates empty ArrayLists for pieces and squares.
     */
    public ChessBoard() {
        this.squares = new ArrayList<>();
        this.pieces = new ArrayList<>();
    }

    /**
     * Returns private variable squares.
     *
     * @return List of squares on the board
     */
    public final ArrayList<Square> getSquares() {
        return this.squares;
    }

    /**
     * Returns private variable pieces.
     *
     * @return List of pieces on the board
     */
    public final ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    /**
     * Initialises squares; creates 64 squares and adds them to this board's
     * list of squares.
     */
    public final void initSquares() {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                Square square = new Square(i, j);
                square.setSize(size);
                squares.add(square);
            }
        }
    }

    /**
     * Calls appropriate methods to initialise pieces, i.e. initPawns(),
     * initPiecesExclPawns() and setPiecesToSquares().
     */
    public final void initPieces() {
        initPawns();
        initPiecesExclPawns();
        setPiecesToSquares();
    }

    /**
     * Initialises pawns; creates 12 of both colours with appropriate initial
     * squares and adds them to pieces list.
     */
    public final void initPawns() {
        int[] rows = new int[]{2, size - 1};
        for (int row : rows) {
            String colour = "w";
            if (row == 2) {
                colour = "b";
            }
            for (int i = 1; i <= size; i++) {
                pieces.add(new Pawn(new Square(i, row), colour));
            }
        }
    }

    /**
     * Initialises pieces other than pawns, creating 12 of each colour with
     * appropriate initial squares, and adding them to pieces list.
     */
    public final void initPiecesExclPawns() {
        int[] rows = new int[]{1, size};
        String[] initials = new String[]{"rook", "knight", "bishop", "queen",
            "king", "bishop", "knight", "rook"};
        for (int row : rows) {
            String colour = "w";
            if (row == 1) {
                colour = "b";
            }
            for (int j = 0; j < size; j++) {
                switch (initials[j]) {
                    case "rook":
                        pieces.add(new Rook(new Square(j + 1, row), colour));
                        break;
                    case "knight":
                        pieces.add(new Knight(new Square(j + 1, row), colour));
                        break;
                    case "bishop":
                        pieces.add(new Bishop(new Square(j + 1, row), colour));
                        break;
                    case "queen":
                        pieces.add(new Queen(new Square(j + 1, row), colour));
                        break;
                    default:
                        pieces.add(new King(new Square(j + 1, row), colour));
                        break;
                }
            }
        }
    }

    /**
     * Matches all the pieces on board to appropriate squares and vice versa.
     */
    public final void setPiecesToSquares() {
        for (Piece p : this.pieces) {
            for (Square s : this.squares) {
                if (p.getSquare().equals(s) && p.getAvailable()) {
                    s.setPiece(p);
                    p.setSquare(s);
                }
            }
        }
    }

    /**
     * Promotes pawn to another piece of the player's choice.
     *
     * @param p Pawn to be promoted
     * @param promo Piece to be promoted to
     * @param player Player whose piece is promoted
     */
    public final void promote(Piece p, String promo, Player player) {
        switch (promo) {
            case "rook":
                Rook r = new Rook(p.getSquare(), p.getColour());
                player.addPiece(r);
                this.pieces.add(r);
                break;
            case "knight":
                Knight k = new Knight(p.getSquare(), p.getColour());
                player.addPiece(k);
                this.pieces.add(k);
                break;
            case "bishop":
                Bishop b = new Bishop(p.getSquare(), p.getColour());
                player.addPiece(b);
                this.pieces.add(b);
                break;
            default:
                Queen q = new Queen(p.getSquare(), p.getColour());
                player.addPiece(q);
                this.pieces.add(q);
                break;
        }
        player.removePiece(p);
        this.pieces.remove(p);
        setPiecesToSquares();
    }

    /**
     * Finds square at coordinates x and y.
     *
     * @param x integer x coordinate
     * @param y integer y coordinate
     * @return Square at coordinates x and y, or null if none is found
     */
    public final Square findSquareByCoordinates(int x, int y) {
        for (Square s : this.getSquares()) {
            if (s.getX() == x && s.getY() == y) {
                return s;
            }
        }
        return null;
    }
}
