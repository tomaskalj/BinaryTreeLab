/**
 * Interface containing all the methods to implement a binary
 * search tree capable of storing objects of any data type
 *
 * @author Richard Stegman (implemented by Tomas Kaljevic)
 */
public interface ObjectBinaryTreeInterface {
    ObjectTreeNode getRoot();

    void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);

    void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);

    void insertBST(Object o);

    void insertBSTDup(Object o);

    ObjectTreeNode searchBST(Object o);

    void preTrav(ObjectTreeNode tree);

    void inTrav(ObjectTreeNode tree);

    void postTrav(ObjectTreeNode tree);

    void delete(Object o);
}
