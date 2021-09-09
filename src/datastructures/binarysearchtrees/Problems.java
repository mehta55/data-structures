package datastructures.binarysearchtrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import datastructures.binarytrees.BinaryTreeNode;
import datastructures.binarytrees.BinaryTreeUtils;
import datastructures.linkedlist.LinkedListNode;

public class Problems {

	private static class LargestBST {
		private int min;
		private int max;
		private int ht;
		private boolean isBst;

		public LargestBST(int min, int max, int ht, boolean isBst) {
			super();
			this.min = min;
			this.max = max;
			this.ht = ht;
			this.isBst = isBst;
		}

	}

	private static class ReplaceByLargest {
		BinaryTreeNode<Integer> root;
		int lastLargest;

		public ReplaceByLargest(BinaryTreeNode<Integer> root, int lastLargest) {
			super();
			this.root = root;
			this.lastLargest = lastLargest;
		}

	}

	private static class ConstructLLReturnType<T> {
		private LinkedListNode<T> head;
		private LinkedListNode<T> tail;

	}

	public static void main(String[] args) {
//		BinaryTreeNode<Integer> root = null;
		BinaryTreeNode<Integer> root = BinaryTreeUtils.takeInputLevelWise();

//		System.out.println(searchInBST(root, 4));
//		elementsInRangeK1K2(root, 6, 10);
//		LinkedListNode<Integer> head = constructLinkedList_v1(root);
//		LinkedListNode<Integer> head = constructLinkedList(root);
//		System.out.println(head);

//		System.out.println(getPath(root, 2));
//		root = sortedArrayToBST(new int[] {1,2,3,4,5,6,7}, 7);
//		System.out.println(isBST(root));
//		System.out.println(getLCA(root, 2, 6));
//		System.out.println(largestBSTSubtree(root));

//		replaceWithLargerNodesSum(root);
		
		printNodesSumToS(root, 12);
		System.out.println("---------------");
		BinaryTreeUtils.printLevelWise(root);
	}

	private static void printNodesSumToS(BinaryTreeNode<Integer> root, int reqSum) {
		int count = getCount(root);
		Stack<BinaryTreeNode<Integer>> inorderStack = new Stack<>();
		Stack<BinaryTreeNode<Integer>> revInorderStack = new Stack<>();
		
		BinaryTreeNode<Integer> inorderRoot = root;
		BinaryTreeNode<Integer> revInorderRoot = root;
		
		while (inorderRoot != null) {
			inorderStack.push(inorderRoot);
			inorderRoot = inorderRoot.left;
		}
		while (revInorderRoot != null) {
			revInorderStack.push(revInorderRoot);
			revInorderRoot = revInorderRoot.right;
		}
		
		while (count > 1) {
//			System.out.println("peeking 1: " + inorderStack + " " + revInorderStack);
			int sum = inorderStack.peek().data + revInorderStack.peek().data;
			if (sum < reqSum) {
				pushNextMinNodes(inorderStack.pop(), inorderStack);
				count--;
//				System.out.println("peeking 2: " + inorderStack + " " + revInorderStack);
			} else if (sum > reqSum) {
				pushNextMaxNodes(revInorderStack.pop(), revInorderStack);				
				count--;
//				System.out.println("peeking 3: " + inorderStack + " " + revInorderStack);
			} else {
				BinaryTreeNode<Integer> node1 = inorderStack.pop();
				BinaryTreeNode<Integer> node2 = revInorderStack.pop();
				System.out.println(node1.data + " " + node2.data);
				pushNextMinNodes(node1, inorderStack);
				pushNextMaxNodes(node2, revInorderStack);	
				count -= 2;
//				System.out.println("peeking 4: " + inorderStack + " " + revInorderStack);
			}
		}
	}
	
	private static void pushNextMinNodes(BinaryTreeNode<Integer> root, Stack<BinaryTreeNode<Integer>> inorderStack) {
		root = root.right;
		while (root != null) {
			inorderStack.push(root);
			root = root.left;
		}
	}

	private static void pushNextMaxNodes(BinaryTreeNode<Integer> root, Stack<BinaryTreeNode<Integer>> revInorderStack) {
		root = root.left;
		while (root != null) {
			revInorderStack.push(root);
			root = root.right;
		}
	}

	private static int getCount(BinaryTreeNode<Integer> root) {
		return root == null ? 0 : 1 + getCount(root.left) + getCount(root.right);
	}

	private static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		replaceWithLargerNodesSumHelper1(root, 0);
		replaceWithLargerNodesSumHelper(root, new BinaryTreeNode<Integer>(0));
	}

	

	private static void replaceWithLargerNodesSumHelper(BinaryTreeNode<Integer> root,
			BinaryTreeNode<Integer> sum) {
		if(root == null) {
			return;
		}
		
		replaceWithLargerNodesSumHelper(root.right, sum);
		sum.data += root.data;
		root.data = sum.data;
		replaceWithLargerNodesSumHelper(root.left, sum);
		
	}

	private static int replaceWithLargerNodesSumHelper1(BinaryTreeNode<Integer> root, int sum) {
		if(root == null) {
			return sum;
		}
		
		int rightAns = replaceWithLargerNodesSumHelper1(root.right, sum);
		sum = rightAns + root.data;
		root.data = sum;		
		return replaceWithLargerNodesSumHelper1(root.left, sum);
	}

	private static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		return largestBSTSubtreeHelper(root).ht;
	}

	private static LargestBST largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new LargestBST(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
		}

		LargestBST leftAns = largestBSTSubtreeHelper(root.left);
		LargestBST rightAns = largestBSTSubtreeHelper(root.right);
		LargestBST ans = null;

		if (leftAns.isBst && rightAns.isBst && (root.data > leftAns.max && root.data < rightAns.min)) {
			int ht = Math.max(leftAns.ht, rightAns.ht) + 1;
			boolean isBst = true;
			int min = Math.min(root.data, leftAns.min);
			int max = Math.max(root.data, rightAns.max);
			ans = new LargestBST(min, max, ht, isBst);
		} else {
			ans = leftAns.ht > rightAns.ht ? leftAns : rightAns;
			ans.isBst = false;
		}
		return ans;
	}

	private static int getLCA(BinaryTreeNode<Integer> root, int x, int y) {
		if (root == null) {
			return -1;
		}

		if (root.data == x || root.data == y) {
			return root.data;
		}

		if (root.data > x && root.data > y) {
			return getLCA(root.left, x, y);
		}
		if (root.data < x && root.data < y) {
			return getLCA(root.right, x, y);
		}

		int leftAns = getLCA(root.left, x, y);
		int rightAns = getLCA(root.right, x, y);
		int ans = -1;

		if (leftAns != -1 && rightAns != -1) {
			ans = root.data;
		} else if (leftAns == -1) {
			ans = rightAns;
		} else if (rightAns == -1) {
			ans = leftAns;
		}
		return ans;
	}

	private static boolean isBST(BinaryTreeNode<Integer> root) {

		return root == null ? true : isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTHelper(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}

		if (root.data < minValue || root.data > maxValue) {
			return false;
		}

		return isBSTHelper(root.left, minValue, root.data) && isBSTHelper(root.right, root.data, maxValue);
	}

	private static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr, int n) {
		if (arr.length == 0)
			return null;
		return sortedArrayToBSTHelper(arr, 0, arr.length - 1);
	}

	private static BinaryTreeNode<Integer> sortedArrayToBSTHelper(int[] arr, int si, int ei) {
		if (si > ei) {
			return null;
		}

		if (si == ei) {
			return new BinaryTreeNode<>(arr[si]);
		}

		int mid = si + ((ei - si) / 2);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
		root.left = sortedArrayToBSTHelper(arr, si, mid - 1);
		root.right = sortedArrayToBSTHelper(arr, mid + 1, ei);
		return root;
	}

	private static List<Integer> getPath(BinaryTreeNode<Integer> root, int k) {
		if (root == null) {
			return new LinkedList<>();
		}

		List<Integer> ans = null;
		if (root.data > k) {
			ans = getPath(root.left, k);
		} else if (root.data < k) {
			ans = getPath(root.right, k);
		} else {
			ans = new LinkedList<>();
			ans.add(k);
			return ans;
		}

		if (!ans.isEmpty()) {
			ans.add(root.data);
		}

		return ans;
	}

	/**
	 * Time complexity: O(n)
	 * 
	 */
	private static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		if (root == null)
			return null;
		return constructLinkedListHelper(root).head;
	}

	private static ConstructLLReturnType<Integer> constructLinkedListHelper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}

		ConstructLLReturnType<Integer> ans = new ConstructLLReturnType<>();
		ConstructLLReturnType<Integer> leftAns = constructLinkedListHelper(root.left);
		ConstructLLReturnType<Integer> rightAns = constructLinkedListHelper(root.right);
		LinkedListNode<Integer> nn = new LinkedListNode<>(root.data);

		if (leftAns == null && rightAns == null) {
			ans.head = nn;
			ans.tail = nn;
		} else if (leftAns == null) {
			nn.next = rightAns.head;
			ans.head = nn;
			ans.tail = rightAns.tail;
		} else if (rightAns == null) {
			ans.head = leftAns.head;
			leftAns.tail.next = nn;
			ans.tail = nn;
		} else {
			ans.head = leftAns.head;
			leftAns.tail.next = nn;
			nn.next = rightAns.head;
			ans.tail = rightAns.tail;
		}

		return ans;
	}

	/**
	 * Time complexity: O(n2)
	 * 
	 */
	private static LinkedListNode<Integer> constructLinkedList_v1(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}

		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> leftHead = constructLinkedList_v1(root.left);
		LinkedListNode<Integer> rightHead = constructLinkedList_v1(root.right);
		LinkedListNode<Integer> nn = new LinkedListNode<>(root.data);

		if (leftHead != null) {
			head = leftHead;
			while (leftHead.next != null) {
				leftHead = leftHead.next;
			}
			leftHead.next = nn;
		} else {
			head = nn;
		}

		nn.next = rightHead;
		return head;
	}

	private static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (root == null) {
			return;
		}

		if (root.data < k1) {
			elementsInRangeK1K2(root.right, k1, k2);
		} else if (root.data > k2) {
			elementsInRangeK1K2(root.left, k1, k2);
		} else {
			elementsInRangeK1K2(root.left, k1, k2);
			System.out.print(root.data + " ");
			elementsInRangeK1K2(root.right, k1, k2);
		}

	}

	private static boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return false;
		}
		if (root.data.compareTo(x) > 0) {
			return searchInBST(root.left, x);
		} else if (root.data.compareTo(x) < 0) {
			return searchInBST(root.right, x);
		} else {
			return true;
		}
	}

}
