import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class defines a linkedlist
 * @param <T> generic parameter
 */
public class DList<T extends Comparable<T>> implements IList<T>, Cloneable {

	private Node<T> header = null;
	private Node<T> trailer = null;
	private Integer size = 0;
	
	/**
	 * Default constructor
	 */
	public DList() {
		trailer = new Node<T>(null, null, null);
		header = new Node<T>(trailer, null, null);
		trailer.setPrev(header);
		size = 0;
	}
	
	/**
	 * Construct a List from an Array
	 * @param fromArray the array used to construct the list
	 */
	public DList(T[] fromArray) {
		// add each element of the array to the list
		for(T element : fromArray){
			this.addFirst(element);
		}
	}
	
	/**
	 * Convert the list to an array.
	 */
	public T[] toArray() {
		//COMPLETE CODE HERE
		ArrayList<T> newList = new ArrayList<>();

		Node<T> iterator = header.getNext();
		// iterate through the whole list
		while(iterator != null){
			newList.add(iterator.data); // add element from linked list to this arrayLIST
			iterator = iterator.next; // move to the next position
		}
		// convert arraylist to an array
        return (T[]) newList.toArray();
	}
	
	/**
	 * Provide a deep copy of the Linked List
	 */
	@Override
	public DList<T> clone() {
		/*
			creating a new list and an iterator node
		 */
		DList<T> newList = new DList<>();
		Node<T> iterator = header.getNext();
		// iterate through the current list
		while(iterator != null){
			newList.addLast(iterator.data); // add data from current list to new list
			iterator = iterator.next; // move to next position
		}
		return newList; // return the new list
	}
	
	/**
	 * Add an element after a given node in the list
	 */
	@Override
	public Node<T> addAfter(Node<T> elem, T item) {
		/*
			set New-node.next = current.next
			set New-node.prev = current
			lastly set node.next = New-node
		 */
		Node<T> node = new Node<>(elem.getNext(), elem, item);
		elem.next = node;
		elem.next.prev = node; // for extra safety
		size++; // update size
		return  node; // return the added element
	}

	/**
	 * Add an element before a given node in a list
	 */
	@Override
	public Node<T> addBefore(Node<T> elem, T item) {
		/*
			set New-node.next = current
			set New-node.prev = current.prev
			lastly set current.prev.next = New-node
		 */
		Node<T> node = new Node<>(elem, elem.prev, item);
		elem.prev.next = node;
		elem.prev = node; // for extra safety
		size++; // update size
		return  node; // return the added element
	}

	/**
	 * Add an element to the start of the list
	 */
	public Node<T> addFirst(T item) {
		return addAfter(header, item);
	}
	
	/**
	 * Add an element to the end of the list
	 */
	public Node<T> addLast(T item) {
		return addBefore(trailer, item);
	}
	
	/**
	 * Remove a specified node from the list. The removed element is returned
	 */
	@Override
	public T remove(Node<T> elem) {
		// creating an iterator node
		Node<T> iterator2 = header.getNext();
		Node<T> iterator1 = header;

		while(iterator2 != trailer){
			// found element
			if(iterator2.data.compareTo(elem.data) == 0){
				T data = iterator2.data;
				iterator1.next = iterator2.next;
				iterator2.next.prev = iterator1;
				size--;
				// garbage collection will do the rest
				return data;
			}
			iterator1 = iterator2;
			iterator2 = iterator2.next; // move iterator to the next position
		}
		// if we did not find the element in the list return null
		return null;
	}

	/**
	 * Returns the node that contains the element that is specified as a parameter
	 */
	@Override
	public Node<T> search(T elem) {
		// creating an iterator node
		Node<T> iterator = header.getNext();

		while(iterator != trailer.getNext()){
			// found element, return that node
			if(iterator.data.compareTo(elem) == 0){
				return iterator;
			}
			iterator = iterator.next; // move iterator to the next position
		}
		// if we did not find the element in the list return null
		return null;
	}

	/**
	 * Returns true if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return (header.getNext() == trailer);
	}

	/**
	 * Return the size of the list
	 */
	@Override
	public Integer size() {
		return size;
	}
	
		/**
	 * Return the first element in the list
	 */
	public T head() {
		return header.getNext().getElement();
	}
	
	/**
	 * Returns a list that contains everything except the first element
	 */
	public IList<T> tail() {
		/*
			creating new list and an iterator
		 */
		DList<T> newList = new DList<>();
		Node<T> iterator = header.next.getNext(); // skip the first element

		// add element from the linked list from the second node to the last
		while(iterator != trailer.next){
			newList.addFirst(iterator.data);
			iterator = iterator.next; // move to the next position
		}

		return newList; // return the new list without the first element
	}
	
	
	@Override
	public String toString() {
		String result = header.toString() + " <-> ";
		Node<T> currentNode = header.getNext();
		
		// iterate through the list
		while(currentNode != null && currentNode != trailer){
			result += currentNode.data + " <-> ";
			currentNode = currentNode.next; // move position
		}
		
		result += trailer.toString();
		return result;
	}
	
	/**
	 * Return a new list that contains all the element in the current list
	 * that are less than a specified element
	 */
	public DList<T> splitLess(T element) {
		/*
			create new list and iterator
		 */
		DList<T> newLIST = new DList<>();
		Node<T> iterator = header.getNext(); // first node on the list

		while(iterator != trailer){
			// check if the current element is less than the pivot
			if(iterator.data.compareTo(element) < 0){
				newLIST.addLast(iterator.data); // add that element to the new list
			}
			iterator = iterator.next; // move
		}

		return newLIST; // return list with elements less than the pivot
	}
	
	/**
	 * Return a new list that contains all the element in the current list
	 * that are greater than a specified element
	 */
	public DList<T> splitGreater(T element) {
		/*
			create new list and iterator
		 */
		DList<T> newLIST = new DList<>();
		Node<T> iterator = header.getNext(); // first node on the list

		while(iterator != trailer){
			// check if the current element is greater than the pivot
			if(iterator.data.compareTo(element) > 0){
				newLIST.addLast(iterator.data); // add that element to the new list
			}
			iterator = iterator.next; // move
		}

		return newLIST; // return list with elements bigger than the pivot
	}
	
	/**
	 * Return a new list that contains all the element in the current list
	 * that are equal to a specified element
	 */
	public DList<T> splitEqual(T element){

		/*
			create new list and iterator
		 */
		DList<T> newLIST = new DList<>();
		Node<T> iterator = header.getNext(); // first node on the list

		while(iterator != trailer){
			// check if the current element is equal to the pivot
			if(iterator.data.compareTo(element) == 0){
				newLIST.addLast(iterator.data); // add that element to the new list
			}
			iterator = iterator.next; // move
		}

		return newLIST; // return list with elements equal to the pivot
	}
	
	/**
	 * Return a new IList that contains the elements merged from the current list
	 * and the passed otherList
	 * @param otherList the other list to merge
	 * @return a new list of element
	 */
	public DList<T> merge(DList<T> otherList) {
		DList<T> newList = new DList<T>();
		Node<T> currentNode = header.getNext();
		Node<T> currentNode2 = otherList.header.getNext();
		
		//COMPLETE CODE HERE
		while(currentNode != trailer){
			// add elements to new list
			newList.addLast(currentNode.data);
			currentNode = currentNode.getNext(); // move
		}

		while(currentNode2 != otherList.trailer){
			// add element to new list
			newList.addLast(currentNode2.data);
			currentNode2 = currentNode2.getNext(); // move
		}
		
		return newList;
	}
	
	/**
	 * Return a new list that has been sorted using a quick sort.
	 * @return a sorted list
	 */
	public DList<T> quicksort() {
		if (size() <= 1) return this.clone();  // Base case: a list of size 0 or 1 is already sorted.

		// Step 1: Split the list into smaller, equal, and greater lists
		Node<T> pivotNode = header.getNext();  // We'll use the first element as the pivot.
		DList<T> smaller = splitLess(pivotNode.data);  // Split all elements smaller than the pivot.
		DList<T> equal = splitEqual(pivotNode.data);  // Split all elements equal to the pivot.
		DList<T> greater = splitGreater(pivotNode.data);  // Split all elements greater than the pivot.


		// Step 2: Recursively quicksort the smaller and greater lists
		smaller = smaller.quicksort();
		greater = greater.quicksort();

		// Step 3: Merge the sorted smaller, equal, and greater lists
        return smaller.merge(equal).merge(greater);
	}



}
