/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

import checkmate.logic.pieces.Pawn;
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
        assertTrue((pawn.getColour().equals("w") && pawn.getSquare().getY() == 7) || (pawn.getColour().equals("b") && pawn.getSquare().getY() == 2));
    }

    @Test
    public void testInitPiecesExclPawns() {
        board.initPiecesExclPawns();
        Piece piece = board.getPieces().get(0);
        assertTrue((piece.getColour().equals("w") && piece.getSquare().getY() == 8) || (piece.getColour().equals("b") && piece.getSquare().getY() == 1));
    }

    @Test
    public void testSetPiecesToSquares() {
        board.initPawns();
        assertEquals(board.getPieces().get(0).getSquare(), new Square(1, 2));
    }

    @Test
    public void testPromote() {
        Pawn p = new Pawn(new Square(1, 1), "w");
        Player pl = new Player("w");
        pl.addPiece(p);
        board.promote(p, "rook", pl);
        assertFalse(pl.getPieces().contains(p));
    }

    @Test
    public void testPromote2() {
        Pawn p = new Pawn(new Square(1, 1), "w");
        Player pl = new Player("w");
        pl.addPiece(p);
        board.promote(p, "rook", pl);
        assertTrue(pl.getPieces().get(0).getType().equals("rook"));
    }

    @Test
    public void testPromote3() {
        Pawn p = new Pawn(new Square(1, 1), "w");
        Player pl = new Player("w");
        pl.addPiece(p);
        board.promote(p, "rook", pl);
        assertFalse(board.getPieces().contains(p));
    }    

    @Test
    public void testPromote4() {
        Pawn p = new Pawn(new Square(1, 1), "w");
        Player pl = new Player("w");
        pl.addPiece(p);
        board.promote(p, "knight", pl);
        assertTrue(pl.getPieces().get(0).getType().equals("knight"));
    }

    @Test
    public void testPromote5() {
        Pawn p = new Pawn(new Square(1, 1), "w");
        Player pl = new Player("w");
        pl.addPiece(p);
        board.promote(p, "bishop", pl);
        assertTrue(pl.getPieces().get(0).getType().equals("bishop"));
    }


    @Test
    public void testPromote6() {
        Pawn p = new Pawn(new Square(1, 1), "w");
        Player pl = new Player("w");
        pl.addPiece(p);
        board.promote(p, "anything", pl);
        assertTrue(pl.getPieces().get(0).getType().equals("queen"));
    }
        
    @Test
    public void testFindSquare() {
        assertTrue(board.findSquareByCoordinates(0, 0) == null);
    }
    
    @Test
    public void testFindSquare2() {
        ChessBoard cb = new ChessGame().getBoard();
        assertTrue(cb.findSquareByCoordinates(1, 1).equals(new Square(1, 1)));
    }
}
