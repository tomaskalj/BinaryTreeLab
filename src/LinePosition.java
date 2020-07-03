/**
 * Class representing the line a word appears on in the
 * file being read and its position within that line.
 *
 * @author Tomas Kaljevic
 */
public class LinePosition {
    private int line;
    private int position;

    /**
     * Initializes the LinePosition class given a line and a position for the word
     *
     * @param line     the line the word appears on in the file being read
     * @param position the position within the given line
     */
    public LinePosition(int line, int position) {
        this.line = line;
        this.position = position;
    }

    /**
     * Returns the line the word appears on
     *
     * @return the line the word appears on in the file being read
     */
    public int getLine() {
        return line;
    }

    /**
     * Returns the position within the line the word appears on
     *
     * @return the position within the line the word appears on in the file being read
     */
    public int getPosition() {
        return position;
    }

    /**
     * Converts the LinePosition class to a String so as to easily print it to the user
     *
     * @return the line and position separated by a hyphen
     */
    @Override
    public String toString() {
        return line + "-" + position;
    }
}
