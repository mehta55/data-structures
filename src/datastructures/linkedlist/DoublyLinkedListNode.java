package datastructures.linkedlist;

public class DoublyLinkedListNode<T> {

	T data;
	DoublyLinkedListNode<T> next;
	DoublyLinkedListNode<T> prev;

	public DoublyLinkedListNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoublyLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode<T> next) {
		this.next = next;
	}

	public DoublyLinkedListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedListNode<T> prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		String prevNodeData = prev == null ? "null" : prev.data.toString();
		String nextNodeData = next == null ? "null" : next.data.toString();
		return prevNodeData + " <- ["+ data + "] -> " + nextNodeData;
	}

}
