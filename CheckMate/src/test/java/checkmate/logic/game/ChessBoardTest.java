/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

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
    public void testInitPieces() {
    }

    @Test
    public void testInitPiecesByColour() {
    }

    @Test
    public void testIsValidMove() {
    }

    @Test
    public void testPiecesBetween() {
    }
    
}
