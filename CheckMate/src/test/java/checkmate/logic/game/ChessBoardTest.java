/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

import checkmate.logic.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class ChessBoardTest {

    ChessBoard board;

    public ChessBoardTest() {
    }

    @Before
    public void setUp() {
        board = new ChessBoard();
    }

    @Test
    public void constructorCreatesPiecesList() {
        assertFalse(board.getPieces() == null);
    }

    @Test
    public void piecesListIsEmptyAtStart() {
        assertTrue(board.getPieces().isEmpty());
    }

    @Test
    public void constructorCreatesSquaresList() {
        assertTrue(board.getSquares() != null);
    }

    @Test
    public void squaresListIsEmptyAtStart() {
        assertTrue(board.getSquares().isEmpty());
    }

    @Test
    public void testInitSquares() {
        board.initSquares();
        assertTrue(board.getSquares().size() == 64);
    }

    @Test
    public void testInitSquares2() {
        board.initSquares();
        assertTrue(board.getSquares().get(0).getSize() == 8);
    }

    @Test
    public void testInitPieces() {
        board.initPieces();
        assertEquals(board.getPieces().size(), 32);
    }

    @Test
    public void testInitPawns() {
        board.initPawns();
        Piece pawn = board.getPieces().get(0);
        assertTrue((pawn.getColour().equals("w") && pawn.getSquare().getX() == 2) || (pawn.getColour().equals("b") && pawn.getSquare().getY() == 7));
    }
    
    @Test
    public void testInitPiecesExclPawns() {
        board.initPiecesExclPawns();
        Piece piece = board.getPieces().get(0);
        assertTrue((piece.getColour().equals("w") && piece.getSquare().getY() == 1) || (piece.getColour().equals("b") && piece.getSquare().getY() == 8));
    }
}
