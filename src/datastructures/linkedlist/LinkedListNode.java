package datastructures.linkedlist;

public class LinkedListNode<T> {

	public T data;
	public LinkedListNode<T> next;

	
	public LinkedListNode() {
		super();
	}

	public LinkedListNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(data.toString());
		
		if(next != null) {
			str.append("->");
			str.append(next.toString());
		}
		
		return str.toString();
	}
	
	
	
}
