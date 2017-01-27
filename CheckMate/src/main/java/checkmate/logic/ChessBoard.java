/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic;

import java.util.ArrayList;

/**
 *
 * @author llmlks
 */
public class ChessBoard {

    private ArrayList<Square> squares;
    private ArrayList<ChessPiece> pieces;
    private final int size = 8;

    public ChessBoard() {
        this.squares = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                squares.add(new Square(i, j));
            }
        }
        this.pieces = new ArrayList<>();
    }

    public ArrayList<Square> getSquares() {
        return this.squares;
    }

    public ArrayList<ChessPiece> getPieces() {
        return this.pieces;
    }
}
