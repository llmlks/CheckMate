/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic;

/**
 *
 * @author llmlks
 */
public class ChessGame {

    private ChessBoard board;

    public ChessGame() {
        this.board = new ChessBoard();
    }

    public ChessBoard getBoard() {
        return this.board;
    }
}
