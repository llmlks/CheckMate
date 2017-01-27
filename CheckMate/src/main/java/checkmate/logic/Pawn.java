package checkmate.logic;

/**
 *
 * @author llmlks
 */
public class Pawn implements ChessPiece {

    private int colour;
    private int[] position;

    public Pawn(int colour, int[] position) {
        this.colour = colour;
        this.position = position;
    }

    @Override
    public int getColour() {
        return this.colour;
    }

    @Override
    public int[] getPosition() {
        return this.position;
    }
}

