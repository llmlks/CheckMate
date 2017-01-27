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
public class Square {

    private int x;
    private int y;
    private ChessPiece piece;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getPosition() {
        String abc = "abcdefgh";
        return abc.charAt(x - 1) + "" + y;
    }
}
