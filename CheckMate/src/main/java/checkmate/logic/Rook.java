package checkmate.logic;

/**
 *
 * @author llmlks
 */
public class Rook implements ChessPiece {

    private int colour;
    private int[] position;

    public Rook(int colour, int[] position) {
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
