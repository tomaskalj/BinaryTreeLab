import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class pertaining to the construction of the cross-reference
 * listing and utilization of the hash table and query system
 *
 * @author Tomas Kaljevic
 */
public class Xref {
    private PrintWriter pw;
    private ObjectBinaryTree tree;
    private Hash hash;

    /**
     * Constructs an instance of the cross-reference listing
     * @param pw the given {@link PrintWriter} used to write information to csis.txt
     */
    public Xref(PrintWriter pw) {
        this.pw = pw;
        this.tree = new ObjectBinaryTree();
        this.hash = new Hash(pw);
    }

    /**
     * Outputs the text-based document in getty.txt with lines and adds
     * each non-omitted word in the document to the binary search tree
     */
    public void getGettysburg() {
        System.out.println("Contents of getty.txt: The Gettysburg Address\n");
        pw.println("Contents of getty.txt: The Gettysburg Address\n");

        try {
            Scanner scanner = new Scanner(new File("getty.txt"));

            int i = 1;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.printf("%2d \t%-75s %n", i, line);
                pw.printf("%2d \t%-75s %n", i, line);

                String delims = "[ ,.;-]+";
                String[] words = line.toLowerCase().split(delims);
                for (int position = 0; position < words.length; position++) {
                    String wordStr = words[position];
                    if (hash.isInHashtable(wordStr)) {
                        continue;
                    }

                    LinePosition pos = new LinePosition(i, position + 1);
                    Word word = new Word(pw, wordStr, pos);
                    tree.insertBSTDup(word);
                }

                i++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
        pw.println();
    }

    /**
     * Prints the hash table and traverses the binary search tree,
     * outputting each non-omitted word in the document along
     * with the number of occurrences and line positions of each word
     */
    public void printWordData() {
        hash.printHashtable();

        System.out.println("Cross-Referenced Listing:");
        pw.println("Cross-Referenced Listing:");
        System.out.println();
        pw.println();

        ObjectTreeNode root = tree.getRoot();
        tree.inTrav(root);

        System.out.println();
        pw.println();

        Query query = new Query(pw);
        query.performQuery(tree);
    }
}