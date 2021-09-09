package datastructures.stackandqueues;

import datastructures.linkedlist.LinkedListNode;

public class Queue<T> {

	private LinkedListNode<T> head;
	private LinkedListNode<T> tail;
	private int size;
	
	public Queue() {
		size = 0;
	}
	
	public void enqueue(T data) {
		LinkedListNode<T> nn = new LinkedListNode<>(data);
		if(size == 0) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}
		size++;
	}
	
	public T dequeue() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		T data = head.data;
		head = head.next;
		size--;
		return data;
	}
	
	public T front() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		return head.data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		LinkedListNode<T> temp = head;
		while(temp != null ) {
			str.append(temp.data);
			str.append(", ");
			temp = temp.next;
		}
		str.delete(str.length() - 2, str.length());
		str.append("]");
		return str.toString();
	}
}
