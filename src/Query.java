import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class utilized for allowing the user to perform run-time queries and
 * perform searches for the words defined on page 446 in the textbook.
 *
 * @author Tomas Kaljevic
 */
public class Query {
    private PrintWriter pw;
    private String[] queryWordList;

    /**
     * Initializes the Query class
     * @param pw the given {@link PrintWriter} which writes output to csis.txt
     */
    public Query(PrintWriter pw) {
        this.pw = pw;
        this.queryWordList = new String[]{"dedicate", "devotion", "gave", "men", "not", "people", "resolve", "soldier", "us", "vain", "war"};
    }

    /**
     * Prompts the user to query words
     * @param tree the tree being searched
     */
    public void performQuery(ObjectBinaryTree tree) {
        System.out.println("Enter a word to query or Q to quit:");
        pw.println("Enter a word to query or Q to quit:");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                System.out.println(input);
                pw.println(input);
                break;
            }

            System.out.println(input + "\n");
            pw.println(input + "\n");

            if (!isQueryable(input)) {
                System.out.println("Invalid word. Available words include: " + getQueryWordList() + ". Enter a valid word to query or Q to quit:");
                pw.println("Invalid word. Available words include: " + getQueryWordList() + ". Enter a valid word to query or Q to quit:");
                continue;
            }

            ObjectTreeNode treeNode = tree.searchBST(new Word(input));
            if (treeNode == null) {
                System.out.println("Word not found. Available words include: " + getQueryWordList() + ". Enter a valid word to query or Q to quit:");
                pw.println("Word not found. Available words include: " + getQueryWordList() + ". Enter a valid word to query or Q to quit:");
                continue;
            }

            Word word = (Word) treeNode.getInfo();

            System.out.println("Word: " + word.getWord());
            pw.println("Word: " + word.getWord());

            System.out.println("Word Count: " + word.getCount());
            pw.println("Word Count: " + word.getCount());

            System.out.print("Occurrences: ");
            pw.print("Occurrences: ");

            ObjectListNode node = word.getLineList().getFirstNode();
            while (node != null) {
                System.out.printf("%-9s", node.getInfo());
                pw.printf("%-9s", node.getInfo());

                node = node.getNext();
            }

            System.out.println("\n\nEnter a word to query or Q to quit:");
            pw.println("\n\nEnter a word to query or Q to quit:");
        }
    }

    /**
     * Checks if a word is able to be queried according to the given list of words
     * @param word the word being queried
     * @return whether the word is able to be queried
     */
    private boolean isQueryable(String word) {
        for (String queryWord : queryWordList) {
            if (word.equalsIgnoreCase(queryWord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the list of words able to be queried for user convenience
     * @return the list of words concatenated and separated by commas
     */
    private String getQueryWordList() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < queryWordList.length; i++) {
            list.append(queryWordList[i]);
            if (i != queryWordList.length - 1) {
                list.append(", ");
            }
        }
        return list.toString();
    }
}
