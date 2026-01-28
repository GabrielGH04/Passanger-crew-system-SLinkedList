package Assignment1Algo;

//Title: Node class
//Author: Yousef Ghadri
//Description: Represents a single node used in the singly linked list data structure.
public class Node {
	private Object data;
	private Node next;

    // constructor
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
	// setters and getters for better code maintainability and safety

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
