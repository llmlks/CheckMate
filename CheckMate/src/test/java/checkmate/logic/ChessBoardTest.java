/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic;

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
        this.board = new ChessBoard();
    }
    
    @Test
    public void constructorCreatesArrayListSquares() {
        assertFalse(board.getSquares() == null);
    }
    
    @Test
    public void constructorCreatesArrayListPieces() {
        assertFalse(board.getPieces() == null);
    }
    
    @Test
    public void constructorCreatesNewSquares() {
        assertFalse(board.getSquares().isEmpty());
    }
    
    @Test
    public void constructorCreates64Squares() {
        assertTrue(board.getSquares().size() == 64);
    }
}
