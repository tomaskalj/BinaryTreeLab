/**
 * Interface containing all the methods necessary to construct
 * a node that holds data within a fully functional linear
 * linked list able to contain objects of any data type.
 *
 * @author Tomas Kaljevic
 */
public interface ObjectListNodeInterface {
    void setInfo(Object o);

    Object getInfo();

    void setNext(ObjectListNode p);

    ObjectListNode getNext();
}