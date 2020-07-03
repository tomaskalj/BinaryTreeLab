import java.io.PrintWriter;

/**
 * Class representing a word in the cross-referenced listing
 *
 * @author Tomas Kaljevic
 */
public class Word implements TreeComparable {
    private PrintWriter pw;
    private String word;
    private int count;
    private ObjectList lineList;

    /**
     * Initializes the Word class representing a word String
     * @param word a string containing a word in getty.txt
     */
    public Word(String word) {
        this.word = word;
    }

    /**
     * Completely initializes the Word class
     * @param pw the given {@link PrintWriter} used to write information to csis.txt
     * @param word a string containing a word in getty.txt
     * @param pos the {@link LinePosition} pertaining to the word
     */
    public Word(PrintWriter pw, String word, LinePosition pos) {
        this.pw = pw;
        this.word = word;
        this.count = 1;
        this.lineList = new ObjectList();
        this.lineList.addLast(pos);
    }

    /**
     * Returns the word String
     * @return a String containing the word for this Word class
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the word count
     * @return the number of times the word appears in getty.txt
     */
    public int getCount() {
        return count;
    }

    /**
     * Returns the list of lines and positions
     * @return a linear linked list containing every line and position the word appears on in getty.txt
     */
    public ObjectList getLineList() {
        return lineList;
    }

    /**
     * Compares two Word objects checking for equality
     * @param o the other Word this instance of Word is being compared to
     * @return 0 if the two Word objects are equal, a non-zero value if they are inequal
     */
    @Override
    public int compareTo(Object o) {
        Word other = (Word) o;
        return word.compareTo(other.getWord());
    }

    /**
     * Increments the word count and adds the line number and position to the list
     * @param o the Word being operated on
     */
    @Override
    public void operate(Object o) {
        count++;
        Word other = (Word) o;
        lineList.addLast(other.getLineList().getFirst());
    }

    /**
     * Outputs the word being visited, the number of times the word was
     * found, and the line numbers and positions of each word found
     */
    @Override
    public void visit() {
        System.out.printf("%-15s %-6d", word, count);
        pw.printf("%-15s %-6d", word, count);

        ObjectListNode node = lineList.getFirstNode();
        while (node != null) {
            System.out.printf("%-9s", node.getInfo());
            pw.printf("%-9s", node.getInfo());

            node = node.getNext();
        }
        System.out.println();
        pw.println();
    }
}
