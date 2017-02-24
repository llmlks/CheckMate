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
public class CastlingAndCheckTest {

    CastlingAndCheck check;
    ChessGame game;

    public CastlingAndCheckTest() {
    }

    @Before
    public void setUp() {
        game = new ChessGame();
        check = new CastlingAndCheck(game.getPlayers(), game.getBoard(), game.getValidator());
    }

    @Test
    public void testTryMove() {
        Piece w = game.findSquareByCoordinates(3, 7).getPiece();
        Square ws = game.findSquareByCoordinates(3, 5);
        assertTrue(check.tryMove(w, ws));
    }
    
    @Test
    public void testTryMove2() {
        Piece w = game.findSquareByCoordinates(3, 7).getPiece();
        Piece b = game.findSquareByCoordinates(4, 2).getPiece();
        Square ws = game.findSquareByCoordinates(3, 5);
        Square bs = game.findSquareByCoordinates(4, 4);
        Piece wq = game.findSquareByCoordinates(4, 8).getPiece();
        Square wqs = game.findSquareByCoordinates(1, 5);
        Square bps = game.findSquareByCoordinates(4, 5);
        game.turn(w, ws);
        game.turn(b, bs);
        game.turn(wq, wqs);        
        assertFalse(check.tryMove(b, bps));
    }

    @Test
    public void testCanBeCaptured() {
        assertFalse(check.canBeCaptured(game.findSquareByCoordinates(1, 1).getPiece()));
    }

    @Test
    public void testCanBeCaptured2() {
        Piece w = game.findSquareByCoordinates(5, 7).getPiece();
        Piece b = game.findSquareByCoordinates(4, 2).getPiece();
        Square ws = game.findSquareByCoordinates(5, 5);
        Square bs = game.findSquareByCoordinates(4, 4);
        game.turn(w, ws);
        game.turn(b, bs);
        assertTrue(check.canBeCaptured(b));
    }

    @Test
    public void testIsChecked() {
        assertFalse(check.isChecked(game.getPlayers()[0]));
    }

    @Test
    public void testIsChecked2() {
        Piece w = game.findSquareByCoordinates(3, 7).getPiece();
        Piece b = game.findSquareByCoordinates(4, 2).getPiece();
        Square ws = game.findSquareByCoordinates(3, 5);
        Square bs = game.findSquareByCoordinates(4, 4);
        Piece wq = game.findSquareByCoordinates(4, 8).getPiece();
        Square wqs = game.findSquareByCoordinates(1, 5);
        game.turn(w, ws);
        game.turn(b, bs);
        game.turn(wq, wqs);
        assertTrue(check.isChecked(game.getPlayers()[1]));
    }

    @Test
    public void testPossibleCastlingSquares() {
        assertTrue(check.possibleCastlingSquares(game.getPlayers()[0].getKing()).isEmpty());
    }

    @Test
    public void testPossibleCastlingSquares2() {
        Piece w = game.findSquareByCoordinates(5, 7).getPiece();
        Piece b = game.findSquareByCoordinates(4, 2).getPiece();
        Square ws = game.findSquareByCoordinates(5, 5);
        Square bs = game.findSquareByCoordinates(4, 4);
        Piece wk = game.findSquareByCoordinates(5, 8).getPiece();
        Square wrs = game.findSquareByCoordinates(2, 5);
        game.turn(w, ws);
        game.turn(b, bs);
        game.turn(wk, wrs);
        assertTrue(check.possibleCastlingSquares(wk).isEmpty());
    }

    @Test
    public void testFindPlayersRooks() {
        assertEquals(check.findPlayersRooks("w").size(), 2);
    }

    @Test
    public void testFindPlayersRooks2() {
        assertEquals(check.findPlayersRooks("xw").size(), 0);
    }

    @Test
    public void testCastlingSquares() {
        assertEquals(check.castlingSquares(check.findPlayersRooks("w"), game.findSquareByCoordinates(5, 8)).size(), 0);
    }

}
