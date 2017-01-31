/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

/**
 *
 * @author llmlks
 */
public class ChessGame {

    private ChessBoard board;
    private Player[] players;

    public ChessGame() {
        this.board = new ChessBoard();
    }

    public ChessBoard getBoard() {
        return this.board;
    }
    
    public void start() {
        this.board.initSquares();
        board.initPieces();
        
        players = new Player[]{new Player(0), new Player(1)};
    }
}
