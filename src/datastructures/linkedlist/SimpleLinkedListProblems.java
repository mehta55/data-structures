package datastructures.linkedlist;

public class SimpleLinkedListProblems {

	public static void main(String[] args) {
		LinkedListNode<Integer> head = LinkedListUtils.takeInputSimpleLL();
//		LinkedListNode<Integer> head = LinkedListUtils.takeInputCircularSimpleLL();
		System.out.println(head.toString());
//		LinkedListNode<Integer> head = null;
//		LinkedListNode<Integer> head1 = LinkedListUtils.takeInput();
//		LinkedListNode<Integer> head2 = LinkedListUtils.takeInput();

//		System.out.println(length(head));
//		printIthNode(head, 3);
//		head = insert(head, 3, 3);
//		head = deleteNode(head, 0);
//		System.out.println(lengthR(head));
//		head = insertR(head, 0, 3);
//		head = deleteNodeR(head, 3);
//		head = mergeTwoSortedLinkedLists(head1, head2);
//		head = removeDuplicates(head);
//		head = findMid(head);
//		head = reverseItr(head);
//		System.out.println(isPalindrome_2(head));
//		printReverse(head);
//		head = reverseRec(head);
//		System.out.println(findNode(head, 3));
//		head = swapNodes(head, 2, 1);
//		System.out.println(findNodeRec(head, 3));
//		head = nthNodeFromLastIter(head, 1);
//		head = mergeSort(head);
//		head = bubbleSort(head);
//		head = appendLastNToFirst(head, 5);
//		head = kReverse(head, 3);
//		head = kReverseRec(head, 3);
//		head = evenAfterOdd(head);
//		head = skipMdeleteN(head, 2, 3);
//		head = changelist(head);
		
		

//		LinkedListUtils.print(head);
//		LinkedListUtils.printCircular(head);

	}

	private static LinkedListNode<Integer> changelist(LinkedListNode<Integer> head) {
		if (head == null || head.next == null)
			return head;
		
		LinkedListNode<Integer> mid = findMid(head);
		LinkedListNode<Integer> head1 = head;
		LinkedListNode<Integer> head2 = mid.next;
		head2 = reverseRec(head2);
		LinkedListNode<Integer> temp = null;
		mid.next = null;

		boolean takeRight = true;
		while (head1 != null && head2 != null) {
			if (takeRight) {
				if(temp == null) {
					head = head1;
					temp = head1;
				} else {
					temp.next = head1;
					temp = temp.next;
				}
				head1 = head1.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
			
			takeRight = !takeRight;
		}
		
		if(head1 != null) {
			temp.next = head1;
		}
		if(head2 != null) {
			temp.next = head2;
		}
		
		return head;
	}

	private static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int m, int n) {
		if (head == null || n == 0)
			return head;
		if (m == 0)
			return null;
		
		LinkedListNode<Integer> temp = head;
		LinkedListNode<Integer> tail = null;
		while(temp != null) {

			int skip = m;
			while(temp != null && skip-- > 0) {
				if(tail == null) {
					tail = temp;
				} else {
					tail.next = temp;
					tail = tail.next;
				}
				temp = temp.next;
			}
			
			int delete = n;
			while(temp != null && delete-- > 0) {
				temp = temp.next;
			}
			
		}
		tail.next = null;
		return head;
	}

	private static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		if (head == null || head.next == null)
			return head;

		LinkedListNode<Integer> oddHead = null;
		LinkedListNode<Integer> evenHead = null;
		LinkedListNode<Integer> oddTail = null;
		LinkedListNode<Integer> evenTail = null;

		while (head != null) {
			if (head.data.intValue() % 2 == 0) {

				if (evenHead == null) {
					evenHead = head;
					evenTail = head;
				} else {
					evenTail.next = head;
					evenTail = evenTail.next;
				}

			} else {

				if (oddHead == null) {
					oddHead = head;
					oddTail = head;
				} else {
					oddTail.next = head;
					oddTail = oddTail.next;
				}
			}
			head = head.next;
		}

		if (oddHead != null) {
			head = oddHead;
			oddTail.next = evenHead;
		} else {
			head = evenHead;
		}
		if (evenHead != null) {
			evenTail.next = null;
		}

		return head;
	}

	private static LinkedListNode<Integer> kReverseRec(LinkedListNode<Integer> head, int n) {
		if (head == null || head.next == null)
			return head;

		int count = n;
		LinkedListNode<Integer> tail = head;
		while (tail.next != null && count-- > 1) {
			tail = tail.next;
		}

		LinkedListNode<Integer> nhead = kReverseRec(tail.next, n);
		LinkedListNode<Integer> temp = head;
		tail.next = null;
		head = reverseRec(head);
		temp.next = nhead;

		return head;
	}

	private static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int n) {
		if (head == null || head.next == null)
			return head;

		int count = n;
		LinkedListNode<Integer> currHead = head;
		LinkedListNode<Integer> prev = null;

		while (currHead != null && currHead.next != null) {
			LinkedListNode<Integer> temp = currHead;

			while (temp.next != null && count-- > 1) {
				temp = temp.next;
			}
			LinkedListNode<Integer> nextHead = temp.next;
			temp.next = null;

			if (prev != null) {
				prev.next = reverseItr(currHead);
			} else {
				head = reverseItr(currHead);
			}

			currHead.next = nextHead;
			prev = currHead;
			currHead = nextHead;
			count = n;
		}

		return head;
	}

	private static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
		LinkedListNode<Integer> fast = head;
		LinkedListNode<Integer> slow = head;
		while (n-- > 0 && fast != null) {
			fast = fast.next;
		}

		if (fast == null) {
			return head;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		fast.next = head;
		head = slow.next;
		slow.next = null;

		return head;
	}

	private static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		if (head == null || head.next == null)
			return head;

		LinkedListNode<Integer> temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}

		while (count-- > 0) {
			LinkedListNode<Integer> prev = null;
			LinkedListNode<Integer> curr = head;

			while (curr != null && curr.next != null) {

				if (curr.data.compareTo(curr.next.data) > 0) {
					if (prev == null) {
						head = curr.next;
						curr.next = curr.next.next;
						head.next = curr;
						prev = head;
					} else {
						prev.next = curr.next;
						curr.next = curr.next.next;
						prev.next.next = curr;
						prev = prev.next;
					}
				} else {
					prev = curr;
					curr = curr.next;
				}
			}
		}
		return head;
	}

	private static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		LinkedListNode<Integer> mid = findMid(head);
		LinkedListNode<Integer> head1 = mid.next;
		mid.next = null;
		LinkedListNode<Integer> head2 = head;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		head = merge(head1, head2);
		return head;
	}

	private static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
		LinkedListNode<Integer> head = null;
		if (head1.data.compareTo(head2.data) < 0) {
			head = head1;
			head1 = head1.next;
		} else {
			head = head2;
			head2 = head2.next;
		}

		LinkedListNode<Integer> temp = head;
		while (head1 != null && head2 != null) {
			if (head1.data.compareTo(head2.data) < 0) {
				head.next = head1;
				head1 = head1.next;
			} else {
				head.next = head2;
				head2 = head2.next;
			}
			head = head.next;
		}

		if (head1 != null) {
			head.next = head1;
		}
		if (head2 != null) {
			head.next = head2;
		}

		return temp;
	}

	private static LinkedListNode<Integer> nthNodeFromLastIter(LinkedListNode<Integer> head, int n) {
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;

		int nth = 0;
		while (fast != null && nth != n) {
			fast = fast.next;
			nth++;
		}

		if (fast == null) {
			return null;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}

	private static int findNodeRec(LinkedListNode<Integer> head, int x) {
		if (head == null) {
			return -1;
		}

		if (head.data == x) {
			return 0;
		}

		int index = findNodeRec(head.next, x);

		return index == -1 ? -1 : index + 1;
	}

	private static int findNode(LinkedListNode<Integer> head, int x) {
		int index = 0;
		while (head != null) {
			if (head.data == x) {
				return index;
			}
			head = head.next;
			index++;
		}
		return -1;
	}

	private static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		if (i == j || head == null)
			return head;

		if (i > j) {
			int temp = j;
			j = i;
			i = temp;
		}
		LinkedListNode<Integer> prev1 = head;
		LinkedListNode<Integer> prev2 = head;

		int x = i;
		int y = j;

		if (i != 0) {
			while (prev1 != null && i-- != 1) {
				prev1 = prev1.next;
			}
		}

		while (prev2 != null && j-- != 1) {
			prev2 = prev2.next;
		}

		if (prev1 == null || prev2 == null) {
			return head;
		}

		if (x - y == 1) {
			if (x == 0) {
				LinkedListNode<Integer> target1 = head;
				LinkedListNode<Integer> target2 = prev2.next;
				head = target2;
				LinkedListNode<Integer> temp = target2.next;
				target2.next = target1.next;
				target1.next = temp;

			} else {
				LinkedListNode<Integer> target1 = prev1.next;
				LinkedListNode<Integer> target2 = prev2.next;
				prev1.next = target2;
				LinkedListNode<Integer> temp = target2.next;
				target2.next = target1.next;
				target1.next = temp;
			}

		} else {
			if (x == 0) {
				LinkedListNode<Integer> target1 = head;
				LinkedListNode<Integer> target2 = prev2.next;
				head = target2;
				prev2.next = target1;
				LinkedListNode<Integer> temp = target2.next;
				target2.next = target1.next;
				target1.next = temp;

			} else {
				LinkedListNode<Integer> target1 = prev1.next;
				LinkedListNode<Integer> target2 = prev2.next;
				prev1.next = target2;
				prev2.next = target1;
				LinkedListNode<Integer> temp = target2.next;
				target2.next = target1.next;
				target1.next = temp;
			}
		}

		return head;
	}

	private static LinkedListNode<Integer> reverseRec(LinkedListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		LinkedListNode<Integer> revHead = reverseRec(head.next);
		head.next.next = head;
		head.next = null;
		return revHead;
	}

	private static void printReverse(LinkedListNode<Integer> head) {
		if (head == null)
			return;
		printReverse(head.next);
		System.out.print(head.data + " ");

	}

	private static LinkedListNode<Integer> reverseItr(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> curr = head;
		while (curr != null) {
			LinkedListNode<Integer> temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		return prev;
	}

	private static boolean isPalindrome_2(LinkedListNode<Integer> head) {
		if (head == null || head.next == null)
			return true;
		LinkedListNode<Integer> mid = findMid(head);
		LinkedListNode<Integer> head2 = mid.next;

		mid.next = null;
		head2 = reverseItr(head2);

		while (head != null && head2 != null) {
			if (head.data != head2.data) {
				return false;
			}
			head = head.next;
			head2 = head2.next;
		}

		return true;
	}

	private static LinkedListNode<Integer> findMid(LinkedListNode<Integer> head) {
		if (head == null)
			return head;
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		if (head == null) {
			return head;
		}

		LinkedListNode<Integer> temp = removeDuplicates(head.next);
		if (temp != null && temp.data == head.data) {
			head = temp;
		} else {
			head.next = temp;
		}

		return head;
	}

	private static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1,
			LinkedListNode<Integer> head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> temp = null;

		if (head1.data < head2.data) {
			head = head1;
			head1 = head1.next;
		} else {
			head = head2;
			head2 = head2.next;
		}

		temp = head;
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				temp.next = head1;
				head1 = head1.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}

		if (head1 != null) {
			temp.next = head1;
		}
		if (head2 != null) {
			temp.next = head2;
		}

		return head;
	}

	private static LinkedListNode<Integer> deleteNodeR(LinkedListNode<Integer> head, int pos) {
		if (head == null) {
			return head;
		}

		if (pos == 0) {
			return head.next;
		}
		head.next = deleteNodeR(head.next, pos - 1);
		return head;
	}

	private static LinkedListNode<Integer> insertR(LinkedListNode<Integer> head, int data, int pos) {
		if (head == null) {
			return head;
		}

		if (pos == 0) {
			LinkedListNode<Integer> nn = new LinkedListNode<Integer>(data);
			nn.next = head;
			return nn;
		}

		head.next = insertR(head.next, data, pos - 1);
		return head;
	}

	private static int lengthR(LinkedListNode<Integer> head) {
		return head == null ? 0 : 1 + lengthR(head.next);
	}

	private static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int i) {
		if (i < 0)
			return head;

		if (i == 0) {
			return head.next;
		} else {
			LinkedListNode<Integer> temp = head;
			while (temp != null && i-- != 1) {
				temp = temp.next;
			}

			if (temp != null && temp.next != null) {
				temp.next = temp.next.next;
			}
		}

		return head;
	}

	private static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int data, int i) {
		if (i < 0)
			return head;

		if (i == 0) {
			LinkedListNode<Integer> nn = new LinkedListNode<Integer>(data);
			nn.next = head;
			return nn;
		} else {
			LinkedListNode<Integer> temp = head;
			while (temp != null && i-- != 1) {
				temp = temp.next;
			}
			if (temp != null) {
				LinkedListNode<Integer> nn = new LinkedListNode<Integer>(data);
				nn.next = temp.next;
				temp.next = nn;
			}
		}

		return head;
	}

	private static void printIthNode(LinkedListNode<Integer> head, int i) {

		while (i != 0 && head != null) {
			head = head.next;
			i--;
		}

		System.out.println(head != null ? head.data : -1);

	}

	private static int length(LinkedListNode<Integer> head) {
		int n = 0;
		while (head != null) {
			n++;
			head = head.next;
		}

		return n;
	}

}
