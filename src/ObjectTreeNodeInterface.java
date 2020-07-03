/**
 * Interface containing all the methods to implement a node
 * used in the construction of a binary search tree
 *
 * @author Richard Stegman (implemented by Tomas Kaljevic)
 */
public interface ObjectTreeNodeInterface {
    void setInfo(Object o);

    Object getInfo();

    void setLeft(ObjectTreeNode p);

    ObjectTreeNode getLeft();

    void setRight(ObjectTreeNode p);

    ObjectTreeNode getRight();
}
