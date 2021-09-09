package datastructures.stackandqueues;

import datastructures.linkedlist.LinkedListNode;

public class Stack<T> {
	
	private LinkedListNode<T> head;
	private int size;

	public Stack() {
		head = null;
		size = 0;
	}
	
	public void push(T data) {
		LinkedListNode<T> nn = new LinkedListNode<>(data);
		nn.next = head;
		head = nn;
		size++;
	}
	
	public T pop() throws StackEmptyException {
		if(size == 0) {
			throw new StackEmptyException();
		}
		
		T data = head.data;
		head = head.next;
		size--;
		return data;
	}
	
	public T top() throws StackEmptyException {
		if(size == 0) {
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
}
