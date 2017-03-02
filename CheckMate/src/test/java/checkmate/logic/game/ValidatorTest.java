/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

import checkmate.logic.pieces.King;
import checkmate.logic.pieces.Pawn;
import checkmate.logic.pieces.Piece;
import checkmate.logic.pieces.Rook;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class ValidatorTest {

    Validator val;
    ChessGame game;

    public ValidatorTest() {
    }

    @Before
    public void setUp() {
        game = new ChessGame();
        val = game.getValidator();
    }

    @Test
    public void constructorSetsBoard() {
        Player[] players = new Player[]{new Player("w")};
        val = new Validator(new ChessBoard(), players);
        assertTrue(val.getBoard() != null);
    }

    @Test
    public void constructorCreatesOccupiedSquaresList() {
        Player[] players = new Player[]{new Player("w")};        
        val = new Validator(new ChessBoard(), players);
        assertTrue(val.getOccupiedSquares() != null);
    }

    @Test
    public void occupiedSquaresEmptyInitially() {
        Player[] players = new Player[]{new Player("w")};
        val = new Validator(new ChessBoard(), players);
        assertTrue(val.getOccupiedSquares().isEmpty());
    }

    @Test
    public void testGameStart() {
        assertTrue(val.getBoard().getSquares().size() == 64);
    }

    @Test
    public void testSetOccupiedSquares() {
        assertEquals(val.getOccupiedSquares().size(), 32);
    }

    @Test
    public void testIsValidMove() {
        assertTrue(val.isValidMove(new Pawn(new Square(5, 2), "b"), new Square(5, 3)));
    }

    @Test
    public void testIsValidMove2() {
        assertFalse(val.isValidMove(new Pawn(new Square(5, 2), "w"), new Square(5, 3)));
    }
    
    @Test
    public void testIsValidMove3() {
        Pawn p = new Pawn(new Square(1, 1), "w");
        Pawn p2 = new Pawn(new Square(1, 2), "b");
        assertFalse(val.isValidMove(p, p2.getSquare()));
    }
    
    @Test
    public void testIsValidMove4() {
        Rook r = new Rook(new Square(3, 3), "w");
        assertTrue(val.isValidMove(r, new Square(6, 3)));
    }
    
    @Test
    public void testIsValidMove5() {
        Rook r = new Rook(new Square(3, 3), "w");
        assertTrue(val.isValidMove(r, new Square(3, 5)));
    }
    
    @Test
    public void testIsValidMove6() {
        Piece p = game.findSquareByCoordinates(2, 2).getPiece();
        Piece enpassant = game.findSquareByCoordinates(3, 7).getPiece();
        game.turn(p, game.findSquareByCoordinates(2, 5));
        game.turn(enpassant, game.findSquareByCoordinates(3, 5));
        assertTrue(val.isValidMove(p, game.findSquareByCoordinates(3, 6)));
    }
    
    @Test
    public void testIsValidMove7() {
        Piece p = game.findSquareByCoordinates(3, 1).getPiece();
        Square to = game.findSquareByCoordinates(2, 2);
        assertFalse(val.isValidMove(p, to));
    }
    
    @Test
    public void testIsValidMove8() {
        Piece p = game.findSquareByCoordinates(2, 2).getPiece();
        p.setAvailable(false);
        assertFalse(val.isValidMove(p, game.findSquareByCoordinates(2, 3)));
    }
    
    @Test
    public void testPiecesBetween() {
        assertTrue(val.piecesBetween(new Square(1, 1), new Square(1, 5)));
    }

    @Test
    public void testPiecesBetween2() {
        assertFalse(val.piecesBetween(new Square(2, 2), new Square(3, 3)));
    }

    @Test
    public void testPiecesBetween3() {
        assertFalse(val.piecesBetween(new Square(0, 0), new Square(7, 4)));
    }

    @Test
    public void testPiecesBetweenHorizontally() {
        assertTrue(val.piecesBetween(new Square(1, 1), new Square(1, 5)));
    }

    @Test
    public void testPiecesBetweenHorizontally2() {
        assertFalse(val.piecesBetween(new Square(3, 3), new Square(3, 5)));
    }

    @Test
    public void testPiecesBetweenVertically() {
        assertTrue(val.piecesBetween(new Square(1, 1), new Square(8, 1)));
    }

    @Test
    public void testPiecesBetweenVertically2() {
        assertFalse(val.piecesBetween(new Square(1, 3), new Square(8, 3)));
    }

    @Test
    public void testPiecesBetweenDiagonally() {
        assertTrue(val.piecesBetween(new Square(1, 1), new Square(7, 7)));
    }

    @Test
    public void testPiecesBetweenDiagonally2() {
        assertTrue(val.piecesBetween(new Square(7, 7), new Square(1, 1)));
    }    

    @Test
    public void testPiecesBetweenDiagonally3() {
        assertFalse(val.piecesBetween(new Square(3, 3), new Square(5, 5)));
    }
    
    @Test
    public void testHasValidMoves() {
        assertTrue(val.hasValidMoves(game.getPlayers()[0]));
    }

    @Test
    public void testHasValidMoves2() {
        assertTrue(val.hasValidMoves(game.getPlayers()[1]));
    }
    
    @Test
    public void testHasValidMoves3() {
        Player[] players = new Player[]{new Player("w")};
        Validator v = new Validator(new ChessBoard(), players);
        assertFalse(v.hasValidMoves(players[0]));
    }

    @Test
    public void testGameEnded() {
        assertFalse(val.gameEnded());
    }
    
    @Test
    public void testCheckMate() {
        assertFalse(val.playersInCheck());
    }
    
    @Test
    public void testCheckMate2() {
        game.turn(game.findSquareByCoordinates(4, 1).getPiece(), game.findSquareByCoordinates(6, 7));
        assertTrue(val.playersInCheck());
    }
}
