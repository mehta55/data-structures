package datastructures.linkedlist;

import java.util.Scanner;

public class LinkedListUtils {

	public static LinkedListNode<Integer> takeInputSimpleLL() {
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		Scanner scn = new Scanner(System.in);
		int data = scn.nextInt();
		while(data != -1) {
			LinkedListNode<Integer> nn = new LinkedListNode<Integer>(data);

			if(head == null) {
				head = nn;
				tail = nn;
			} else {
				tail.next = nn;
				tail = nn;
			}
			data = scn.nextInt();
		}
		return head;
	}
	
	public static LinkedListNode<Integer> takeInputCircularSimpleLL() {
		Scanner scn = new Scanner(System.in);
		int data = scn.nextInt();
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		
		while(data != -1) {
			LinkedListNode<Integer> nn = new LinkedListNode<>(data);
			if(head == null) {
				head = nn;
				tail = nn;
			} else {
				tail.next = nn;
				tail = nn;
			}
			data = scn.nextInt();
		}
		
		if(head != null) {
			tail.next = head;
		}
	
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void print(DoublyLinkedListNode<Integer> head) {
		while(head != null) {
			System.out.println(head);
			head = head.next;
		}
		System.out.println();
	}
	
	public static DoublyLinkedListNode<Integer> takeInputDoublyLL() {
		Scanner scn = new Scanner(System.in);
		int data = scn.nextInt();
		DoublyLinkedListNode<Integer> head = null;
		DoublyLinkedListNode<Integer> tail = null;
		
		while(data != -1) {
			DoublyLinkedListNode<Integer> node = new DoublyLinkedListNode<>(data);
			if(head == null) {
				head = node;
				tail = node;
			} else {
				node.prev = tail;
				tail.next = node;
				tail = node;
			}
			data = scn.nextInt();
		}
		
		return head;
	} 
	
	public static DoublyLinkedListNode<Integer> takeInputCircularDoublyLL() {
		Scanner scn = new Scanner(System.in);
		DoublyLinkedListNode<Integer> head = null;
		DoublyLinkedListNode<Integer> tail = null;
		int data = scn.nextInt();
		
		while(data != -1) {
			DoublyLinkedListNode<Integer> nn = new DoublyLinkedListNode<>(data);
			if(head == null) {
				head = nn;
				tail = nn;
			} else {
				nn.prev = tail;
				tail.next = nn;
				tail = nn;
			}
			data = scn.nextInt();
		}
		
		if(head != null) {
			tail.next = head;
		}
		return head;
	}
	
	
	public static void printCircular(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		boolean checkRepeat = false;
		while(head != null && (!checkRepeat || head != temp)) {
			String nextData = head.next == null ? "null" : head.next.data.toString();
			System.out.println("["+ head.data +"] -> " + nextData);
			head = head.next;
			checkRepeat = true;
		}
	}

	public static void printCircular(DoublyLinkedListNode<Integer> head) {
		DoublyLinkedListNode<Integer> temp = head;
		boolean checkRepeat = false;
		while(head != null && (!checkRepeat || head != temp)) {
			String nextData = head.next == null ? "null" : head.next.data.toString();
			String prevData = head.prev == null ? "null" : head.prev.data.toString();
			System.out.println(prevData + "<- ["+ head.data +"] -> " + nextData);
			head = head.next;
			checkRepeat = true;
		}
	}
	
}
