/**
 * This class defined a node for a double linkedlist
 * @param <T> generic parameter
 */
public class Node<T> {
	//COMPLETE CODE HERE

    /*
        Next, Prev pointers and data holder
     */
    Node<T> next;
    Node<T> prev;
    T data;

    /**
     * Constructor to create node
     * @param Next pointer to the next node
     * @param Prev pointer to the previous node
     * @param Data element to be hold by node
     */
    public Node(Node<T> Next, Node<T> Prev, T Data){
        this.next = Next;
        this.prev = Prev;
        this.data = Data;
    }

    /**
     * Set previous pointer for this current node
     * @param Prev is the previous pointer pointing to the node before this
     */
    public void setPrev(Node<T> Prev){
        this.prev = Prev;
    }

    /**
     * Method to return the pointer to the node ahead of this
     * @return returns the pointer
     */
    public Node<T> getNext(){
        return this.next;
    }

    /**
     * Method to get the element contained by this node
     * @return returns the element
     */
    public T getElement() {
        return this.data;
    }

    /**
     * Method to show the internal structure of the node
     * @return returns a string representation of the node
     */
    @Override
    public String toString() {
        return "" + this.data;
    }
}
