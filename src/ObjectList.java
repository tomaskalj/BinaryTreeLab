/**
 * Class representing a linear linked list that can hold any object.
 *
 * @author Richard Stegman (implemented by Tomas Kaljevic)
 */
public class ObjectList implements ObjectListInterface {
    private ObjectListNode list;
    private ObjectListNode last;

    /**
     * Initializes an empty list
     */
    public ObjectList() {
        list = null;
        last = null;
    }

    /**
     * Returns the first node in the list if it exists, or null otherwise
     *
     * @return the first node in the list
     */
    @Override
    public ObjectListNode getFirstNode() {
        return list;
    }

    /**
     * Returns the last node in the list if it exists, or null otherwise
     *
     * @return the last node in the list
     */
    @Override
    public ObjectListNode getLastNode() {
        return last;
    }

    /**
     * Returns the object representing the first node in the list, or throws an error if the first node is null
     *
     * @return the object representing the first node in the list
     */
    @Override
    public Object getFirst() {
        if (list == null) {
            System.out.println("Runtime Error: getFirst()");
            System.exit(1);
        }
        return list.getInfo();
    }

    /**
     * Returns the object representing the last node in the list, or throws an error if the last node is null
     *
     * @return the object representing the last node in the list
     */
    @Override
    public Object getLast() {
        if (list == null) {
            System.out.println("Runtime Error: getLast()");
            System.exit(1);
        }
        return last.getInfo();
    }

    /**
     * Adds an object to the front of the list
     *
     * @param o the object being added to the front of the list
     */
    @Override
    public void addFirst(Object o) {
        ObjectListNode p = new ObjectListNode(o, list);
        if (list == null) {
            last = p;
        }
        list = p;
    }

    /**
     * Adds a node to the front of the list
     *
     * @param p the node being added to the front of the list
     */
    @Override
    public void addFirst(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if (list == null) {
            last = p;
        }
        list = p;
    }

    /**
     * Adds an object to the end of the list
     *
     * @param o the object being added to the end of the list
     */
    @Override
    public void addLast(Object o) {
        ObjectListNode p = new ObjectListNode(o);
        if (list == null) {
            list = p;
        } else {
            last.setNext(p);
        }
        last = p;
    }

    /**
     * Adds a node to the end of the list
     *
     * @param p the node being added to the end of the list
     */
    @Override
    public void addLast(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list == null) {
            list = p;
        } else {
            last.setNext(p);
        }
        last = p;
    }

    /**
     * Removes the first object from the list
     *
     * @return the object removed from the front of the list
     */
    @Override
    public Object removeFirst() {
        if (list == null) {
            System.out.println("Runtime Error: removeFirst()");
            System.exit(1);
        }
        ObjectListNode p = list;
        list = p.getNext();
        if (list == null) {
            last = null;
        }
        return p.getInfo();
    }

    /**
     * Removes the last object from the list
     *
     * @return the object removed from the end of the list
     */
    @Override
    public Object removeLast() {
        if (list == null) {
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        if (q == null) {
            list = null;
            last = null;
        } else {
            q.setNext(null);
            last = q;
        }
        return p.getInfo();
    }

    /**
     * Inserts an object after the node referenced
     *
     * @param p the node the object is being placed after
     * @param o the object being placed after the node
     */
    @Override
    public void insertAfter(ObjectListNode p, Object o) {
        if (list == null || p == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        ObjectListNode q = new ObjectListNode(o, p.getNext());
        p.setNext(q);
        if (q.getNext() == null) {
            last = q;
        }
    }

    /**
     * Inserts a node after the node referenced
     *
     * @param p the node referenced which the node is being placed after
     * @param q the node being placed after the referenced node
     */
    @Override
    public void insertAfter(ObjectListNode p, ObjectListNode q) {
        if (list == null || p == null || q == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext() != null) {
            last = q;
        }
    }

    /**
     * Deletes the node after the node referenced
     *
     * @param p the node whose succeeding node is being deleted
     * @return the deleted node
     */
    @Override
    public Object deleteAfter(ObjectListNode p) {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ObjectListNode q = p.getNext();
        p.setNext(q.getNext());
        if (p.getNext() == null) {
            last = p;
        }
        return q.getInfo();
    }

    /**
     * Inserts an item into its correct location within an ordered list
     *
     * @param o the object being inserted
     */
    @Override
    public void insert(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable) o).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null) {
            addFirst(o);
        } else {
            insertAfter(q, o);
        }
    }

    /**
     * Inserts a node into its correct location within an ordered list
     *
     * @param r the node being inserted
     */
    @Override
    public void insert(ObjectListNode r) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null &&
                ((Comparable) r.getInfo()).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null) {
            addFirst(r);
        } else {
            insertAfter(q, r);
        }
    }

    /**
     * Removes the first occurrence of an item in a list
     *
     * @param o the object whose first occurrence is being removed
     * @return the removed object
     */
    @Override
    public Object remove(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable) o).compareTo(p.getInfo()) != 0) {
            q = p;
            p = p.getNext();
        }
        if (p == null) {
            return null;
        } else {
            return q == null ? removeFirst() : deleteAfter(q);
        }
    }

    /**
     * Returns true if the item is found in the list
     *
     * @param o the object being searched
     * @return whether the given object is found in the list
     */
    @Override
    public boolean contains(Object o) {
        ObjectListNode p = list;
        while (p != null && ((Comparable) o).compareTo(p.getInfo()) != 0) {
            p = p.getNext();
        }
        return p != null;
    }

    /**
     * Returns a reference to the node with the requested value, null otherwise
     *
     * @param o the object whose node is being searched for
     * @return the node corresponding to the given object
     */
    @Override
    public ObjectListNode select(Object o) {
        ObjectListNode p = list;
        while (p != null) {
            if (((Comparable) o).compareTo(p.getInfo()) == 0) {
                return p;
            } else {
                p = p.getNext();
            }
        }
        return null;
    }

    /**
     * Determines whether or not a list is empty
     *
     * @return whether the list is empty
     */
    @Override
    public boolean isEmpty() {
        return list == null;
    }

    /**
     * Removes all elements from a list
     */
    @Override
    public void clear() {
        list = null;
        last = null;
    }

    /**
     * Determines the size of the list
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        int count = 0;
        ObjectListNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }

    /**
     * Makes a copy of a list
     *
     * @return the newly duplicated list
     */
    @Override
    public ObjectList copyList() {
        ObjectListNode p = null;
        ObjectListNode q = null; // to satisfy compiler;
        ObjectListNode r = list;

        if (isEmpty()) {
            return null;
        }
        ObjectList newList = new ObjectList();
        while (r != null) {
            p = new ObjectListNode(r.getInfo());
            if (newList.isEmpty()) {
                newList.addFirst(p);
            } else {
                q.setNext(p);
            }
            q = p;
            r = r.getNext();
        }
        newList.last = p;
        return newList;
    }

    /**
     * Reverses the list
     */
    @Override
    public void reverse() {
        ObjectListNode p = list;
        ObjectListNode q = null;
        ObjectListNode r;

        while (p != null) {
            r = q;
            q = p;
            p = p.getNext();
            q.setNext(r);
        }
        last = list;
        list = q;
    }
}