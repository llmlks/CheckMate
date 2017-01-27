package checkmate.logic;

/**
 *
 * @author llmlks
 */
public class King implements ChessPiece {

    private int colour;
    private int[] position;

    public King(int colour, int[] position) {
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

