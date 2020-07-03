/**
 * Interface that allows for the comparison of two objects
 * that are stored in a {@link ObjectBinaryTree}
 */
public interface TreeComparable {
    int compareTo(Object o);

    void operate(Object o);

    void visit();
}
