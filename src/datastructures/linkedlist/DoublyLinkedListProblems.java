package datastructures.linkedlist;

public class DoublyLinkedListProblems {
	
	public static void main(String[] args) {
//		DoublyLinkedListNode<Integer> head = LinkedListUtils.takeInputDoublyLL();
		DoublyLinkedListNode<Integer> head = LinkedListUtils.takeInputCircularDoublyLL();

//		LinkedListUtils.print(head);
		LinkedListUtils.printCircular(head);
	}
}
