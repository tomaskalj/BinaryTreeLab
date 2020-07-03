/**
 * Class representing a node in a linear linked list that can hold any object.
 *
 * @author Richard Stegman (implemented by Tomas Kaljevic)
 */
public class ObjectListNode implements ObjectListNodeInterface {
    private Object info;
    private ObjectListNode next;

    /**
     * Initializes an empty list node
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * Initializes a list node containing an object
     * @param o the object being stored in the node
     */
    public ObjectListNode(Object o) {
        info = o;
        next = null;
    }

    /**
     * Initializes a list node holding an object and referencing a second node
     * @param o the object being stored in the node
     * @param p the next node
     */
    public ObjectListNode(Object o, ObjectListNode p) {
        info = o;
        next = p;
    }

    /**
     * Sets the info of the list node
     * @param o the object being set to the info of the node
     */
    @Override
    public void setInfo(Object o) {
        info = o;
    }


    /**
     * Returns the info of the node
     * @return the object which refers to the info of the node
     */
    @Override
    public Object getInfo() {
        return info;
    }

    /**
     * Sets the next node to the current node
     * @param p the node being set as the next node
     */
    @Override
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * Returns the next node
     * @return the next node as defined by relation to the current node
     */
    @Override
    public ObjectListNode getNext() {
        return next;
    }
}