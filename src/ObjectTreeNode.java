/**
 * Class representing a node in a binary search tree
 *
 * @author Richard Stegman (implemented by Tomas Kaljevic)
 */
public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;

    /**
     * Initializes an empty node
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }

    /**
     * Initializes an empty node containing an object
     * @param o the object being contained in the node
     */
    public ObjectTreeNode(Object o) {
        info = o;
        left = null;
        right = null;
    }

    /**
     * Sets the content of the node
     * @param o the object being contained in the node
     */
    @Override
    public void setInfo(Object o) {
        info = o;
    }

    /**
     * Returns the object contained in the node
     * @return the object which the node holds
     */
    @Override
    public Object getInfo() {
        return info;
    }

    /**
     * Sets the left child of the node
     * @param p the node being set as the left child
     */
    @Override
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }

    /**
     * Returns the left child
     * @return the left child of the node
     */
    @Override
    public ObjectTreeNode getLeft() {
        return left;
    }

    /**
     * Sets the right child of the node
     * @param p the node being set as the right child
     */
    @Override
    public void setRight(ObjectTreeNode p) {
        right = p;
    }

    /**
     * Returns the right child
     * @return the right child of the node
     */
    @Override
    public ObjectTreeNode getRight() {
        return right;
    }
}