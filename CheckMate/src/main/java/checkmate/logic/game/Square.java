/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package checkmate.logic.game;

import checkmate.logic.pieces.Piece;

/**
 *
 * @author llmlks
 */
public class Square {

    private int x;
    private int y;
    private Piece piece;

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

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece p) {
        this.piece = p;
    }

    public boolean isNextTo(Square s) {
        if (s.x == this.x && s.y == this.y) {
            return false;
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (s.x == this.x + i && s.y == this.y + j) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSameRank(Square s) {
        if (s.y == this.y && !s.equals(this)) {
            return true;
        }
        return false;
    }

    public boolean isSameFile(Square s) {
        if (s.x == this.x && !s.equals(this)) {
            return true;
        }
        return false;
    }

    public boolean isDiagonal(Square s) {
        if (Math.abs(s.x - this.x) == Math.abs(s.y - this.y) && !s.equals(this)) {
            return true;
        }
        return false;
    }

    public boolean isOccupied() {
        return this.piece != null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !Square.class.isAssignableFrom(o.getClass())) {
            return false;
        }
        final Square s = (Square) o;
        return s.x == this.x && s.y == this.y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.x;
        hash = 67 * hash + this.y;
        return hash;
    }
}
