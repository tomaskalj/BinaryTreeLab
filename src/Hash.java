import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Class concerning everything regarding the creation of the hash table and data for it
 *
 * @author Tomas Kaljevic
 */
public class Hash {
    private PrintWriter pw;
    private ObjectList[] table;
    private ObjectList omitted;

    private int collisions;
    private int numChains;
    private int totalChainSize;
    private int maxChainSize;

    private static final int TABLE_SIZE = 37;

    /**
     * Initializes the Hash class and loads the omitted words, creates the hash table, and forms data about it
     * @param pw the given {@link PrintWriter} used to write information to csis.txt
     */
    public Hash(PrintWriter pw) {
        this.pw = pw;
        this.table = new ObjectList[TABLE_SIZE];

        for (int i = 0; i < table.length; i++) {
            table[i] = new ObjectList();
        }

        loadOmittedWords();
        createHashtable();
        loadInfo();
    }

    /**
     * Creates the hash for an omitted word in O(1) time
     * @param s the omitted word
     * @return a number between 0 and 36 inclusive representing the hash for the omitted word
     */
    private int getHash(String s) {
        int hash = 0;
        hash += 3 + (s.charAt(0) + s.charAt(s.length() - 1) * 1373 * s.length()) * 1801;
        return hash % TABLE_SIZE;
    }

    /**
     * Loads all the omitted words from omit.txt
     */
    private void loadOmittedWords() {
        omitted = new ObjectList();

        try {
            Scanner scanner = new Scanner(new File("omit.txt"));
            while (scanner.hasNext()) {
                omitted.addLast(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the hash table by hashing each String in the omitted linked list
     * and inserting it into its correct location in the hash table
     */
    private void createHashtable() {
        ObjectListNode node = omitted.getFirstNode();
        while (node != null) {
            String word = (String) node.getInfo();
            int hashCode = getHash(word);

            int size = table[hashCode].size();

            if (size > 0) {
                collisions++;
            }

            table[hashCode].addLast(word);

            node = node.getNext();
        }
    }

    /**
     * Loads all information surrounding the hash table, including the
     * number of chains, the total chain size, and the maximum chain size
     */
    private void loadInfo() {
        for (ObjectList list : table) {
            int size = list.size();

            if (size > 0) {
                numChains++;
                totalChainSize += list.size();

                if (size > maxChainSize) {
                    maxChainSize = size;
                }
            }
        }
    }

    /**
     * Checks whether a word is in the hash table, used in {@link Xref}
     * @param word the word being checked
     * @return true if the word being checked is in the omitted words hash table, or false otherwise
     */
    public boolean isInHashtable(String word) {
        int hash = getHash(word);
        if (hash < 0 || hash > TABLE_SIZE) {
            return false;
        }

        ObjectList list = table[hash];

        ObjectListNode node = list.getFirstNode();

        if (node != null) {
            String str = (String) node.getInfo();
            if (str.equalsIgnoreCase(word)) {
                return true;
            } else {
                node = node.getNext();

                if (node != null) {
                    str = (String) node.getInfo();
                    return str.equalsIgnoreCase(word);
                }
            }
        }

        return false;
    }

    /**
     * Prints all data pertaining to the hash table, its elements, and its construction
     */
    public void printHashtable() {
        pw.println("Description of hash function: Add 3 to the sum of the ASCII values of the first and last characters of the word times 1249 times the length of the word times 1801. Modulus by the table size to return the hash.");
        System.out.println();
        System.out.println("Omitted word hash table with chaining:");
        pw.println("Omitted word hash table with chaining:");
        System.out.println("Description of hash function: Add 3 to the sum of the ASCII values of the first and last characters of the word times 1249 times the length of the word times 1801. Modulus by the table size to return the hash.");
        pw.println();

        for (int i = 0; i < table.length; i++) {
            ObjectList list = table[i];

            System.out.printf("%2d", i);
            pw.printf("%2d", i);

            ObjectListNode node = list.getFirstNode();
            while (node != null) {
                System.out.printf("\t%-10s", node.getInfo());
                pw.printf("\t%-10s", node.getInfo());

                node = node.getNext();
            }
            System.out.println();
            pw.println();
        }
        System.out.println();
        pw.println();

        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        double loadFactor = ((double) omitted.size() / (double) TABLE_SIZE) * 100;

        System.out.println("Total Collisions: " + collisions);
        pw.println("Total Collisions: " + collisions);
        System.out.println("Average Chain Size: " + formatter.format((double) totalChainSize / (double) numChains));
        pw.println("Average Chain Size: " + formatter.format((double) totalChainSize / (double) numChains));
        System.out.println("Maximum Chain Size: " + maxChainSize);
        pw.println("Maximum Chain Size: " + maxChainSize);
        System.out.println("Load Factor: " + formatter.format(loadFactor) + "%");
        pw.println("Load Factor: " + formatter.format(loadFactor) + "%");
        System.out.println();
        pw.println();
    }
}
