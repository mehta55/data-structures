package datastructures.stackandqueues;

import java.util.LinkedList;

public class QueueProblems {

	public static void main(String[] args) throws Exception {

//		implementation();
		java.util.Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		System.out.println(q);
		reverseQueue(q);
		System.out.println(q);
		
	}

	private static void reverseQueue(java.util.Queue<Integer> q1) {
		if(q1.isEmpty()) {
			return;
		}
		int val = q1.remove();
		reverseQueue(q1);
		q1.add(val);
	}

	private static void implementation() {
	Queue<String> q = new Queue<>();
		
		try {
			q.dequeue();
		} catch (QueueEmptyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(q.isEmpty());
			q.enqueue("first");
			System.out.println(q.size());
			q.enqueue("second");
			System.out.println(q.size());
			q.enqueue("third");
			System.out.println(q.size());
			
			System.out.println(q.isEmpty());
			System.out.println(q.front());
			q.dequeue();
			q.enqueue("forth");
			System.out.println(q.size());
			System.out.println(q.front());
			q.dequeue();
			System.out.println(q.front());
			q.dequeue();
			System.out.println(q.front());
			q.dequeue();
			System.out.println(q.isEmpty());
			q.dequeue();
			
		} catch (QueueEmptyException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
