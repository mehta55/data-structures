package datastructures.binarytrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import datastructures.linkedlist.LinkedListNode;

public class Problems {
	
	private static class Pair<S,T> {
		private S max;
		private T min;
		
		public Pair(S max, T min) {
			this.max = max;
			this.min = min;
		}
	} 

	private static class DiameterReturnType {
		int diameter;
		int maxHeight;

		public DiameterReturnType(int diameter, int maxHeight) {
			super();
			this.diameter = diameter;
			this.maxHeight = maxHeight;
		}

	}

	private static class CheckBalancedReturnType {
		boolean isBal;
		int maxHeight;

		public CheckBalancedReturnType(boolean isBal, int maxHeight) {
			super();
			this.isBal = isBal;
			this.maxHeight = maxHeight;
		}

	}

	public static void main(String args[]) {
		BinaryTreeNode<Integer> root = BinaryTreeUtils.takeInputLevelWise();

//		System.out.println(getSum(root));
//		System.out.println(maxDataNode(root).data);
//		System.out.println(noOfLeafNodes(root));
//		System.out.println(countNodesGreaterThanX(root, 13));
//		System.out.println(isNodePresent(root, 17));
//		mirrorBinaryTree(root);
//		System.out.println(diameter(root));
//		System.out.println(checkBalanced(root));
//		System.out.println(constructLinkedListForEachLevel(root));
//		root = removeAllLeaves(root);
//		printZigZag(root);
//		printNodesWithoutSibling(root);

//		preorderTraversal(root);
//		inorderTraversal(root);
//		postorderTraversal(root);

//		root = buildTreeUsingInAndPre(new int[] {5, 6, 2, 3, 9, 10 }, new int[] {2, 6, 3, 9, 5, 10});
//		root = buildTreeUsingInAndPost(new int[] { 4, 5, 2, 6, 7, 3, 1 }, new int[] { 4, 2, 5, 1, 6, 3, 7 });
//		root = insertDuplicateNode(root);
		
//		pairSum(root, 15);
		
//		System.out.println(getLCA(root, 2,6));
//		rootToLeafPathsSumToK(root, 13);

//		nodesAtDistanceK(root, 3, 2);
//		leftView(root);
//		rightView(root);
		
		
		System.out.println("----------------------");
		BinaryTreeUtils.printLevelWise(root);
		BinaryTreeUtils.print(root);
	}

	

	private static void rightView(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			
			for (int i = 0; i < levelSize; i++) {
				BinaryTreeNode<Integer> currNode = queue.poll();
				if (i == levelSize - 1) {
					System.out.println(currNode.data);
				}
				
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
			}
		}
	}

	private static void leftView(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			
			for (int i = 0; i < levelSize; i++) {
				BinaryTreeNode<Integer> currNode = queue.poll();
				if (i == 0) {
					System.out.println(currNode.data);
				}
				
				if (currNode.left != null)
					queue.add(currNode.left);
				if (currNode.right != null)
					queue.add(currNode.right);
			}
		}
		
	}

	private static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int x, int k) {
		nodesAtDistanceKHelper(root,x, k);
		
	}

	private static int nodesAtDistanceKHelper(BinaryTreeNode<Integer> root, int x, int k) {
		if (root == null) {
			return -1;
		}
		
		if(root.data == x) {
			printNodesAtDepth(root, k);
			return 1;
		}
		
		int leftDist = nodesAtDistanceKHelper(root.left, x, k);
		int rightDist = nodesAtDistanceKHelper(root.right, x, k);
		int dist = -1;
		
		
		if (leftDist != -1 ) {
			if (leftDist == k) {
				System.out.println(root.data);
			}
			dist = leftDist + 1;
			printNodesAtDepth(root.right, k - dist);
		} 
		if (rightDist != -1) {
			if (rightDist == k) {
				System.out.println(root.data);
			}
			dist = rightDist + 1;
			printNodesAtDepth(root.left, k - dist);			
		}
		
		return dist;
	}

	private static void printNodesAtDepth(BinaryTreeNode<Integer> root, int k) {
		if(root == null || k < 0) {
			return;
		}
		if(k == 0) {
			System.out.println(root.data);
		}
		printNodesAtDepth(root.left, k - 1);
		printNodesAtDepth(root.right, k - 1);
	}

	private static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int sum) {
//		int[][] ans = rootToLeafPathsSumToKHelper1(root, sum);
//		for(int i = 0; i < ans.length; i++) {
//			for(int j = 0; j < ans[i].length; j++) {
//				System.out.print(ans[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		rootToLeafPathsSumToK(root, 13, "");
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	private static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int sum, String path) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			if(sum - root.data == 0) {
				System.out.println(path + root.data);
			}
		}
		
		rootToLeafPathsSumToK(root.left, sum - root.data, path + root.data + " ");
		rootToLeafPathsSumToK(root.right, sum - root.data, path + root.data + " ");
		
	}

	/**
	 * Time complexity: O(n2)
	 * Space complexity: O(n2)
	 */
	private static int[][] rootToLeafPathsSumToKHelper1(BinaryTreeNode<Integer> root, int sum) {
		 
		if (root == null) {
			return new int[0][0];
		} 
		if(root.left == null && root.right == null) {
			if(sum - root.data == 0) {
				return new int[][] { {root.data} };
			} else {
				return new int[0][0];
			}
		}
		
		int[][] leftAns = rootToLeafPathsSumToKHelper1(root.left, sum - root.data);
		int[][] rightAns = rootToLeafPathsSumToKHelper1(root.right, sum - root.data);
		int[][] ans = new int[leftAns.length + rightAns.length][];
		
		for(int i = 0; i < leftAns.length; i++) {
			ans[i] = new int[leftAns[i].length + 1];
			for(int j = 0; j < leftAns[i].length; j++) {
				ans[i][j + 1] = leftAns[i][j];
			}
			ans[i][0] = root.data;
		}
		for(int i = 0; i < rightAns.length; i++) {
			ans[leftAns.length + i] = new int[rightAns[i].length + 1];
			for(int j = 0; j < rightAns[i].length; j++) {
				ans[leftAns.length + i][j + 1] = rightAns[i][j];
			}
			ans[leftAns.length + i][0] = root.data;
		}
		
		return ans;
	}

	private static int getLCA(BinaryTreeNode<Integer> root, int x, int y) {
		if (root == null) {
			return -1;
		}
		
		if(root.data == x || root.data ==y) {
			return root.data;
		}
		
		int leftAns = getLCA(root.left, x, y);
		int rightAns = getLCA(root.right, x, y);
		int ans = -1;
		
		if(leftAns != -1 && rightAns != -1) {
			ans = root.data;
		} else if (leftAns == -1) {
			ans = rightAns;
		} else if(rightAns == -1) {
			ans = leftAns;
		}
		return ans;
	}

	private static void pairSum(BinaryTreeNode<Integer> root, int i) {
		Set<Integer> set = new HashSet<>();
		initializeSet(root, set);
		pairSumHelper(root, i, set);
		
	}

	private static void initializeSet(BinaryTreeNode<Integer> root, Set<Integer> set) {
		if(root != null) {
			set.add(root.data);
			initializeSet(root.left, set);
			initializeSet(root.right, set);
		}
		
	}

	private static void pairSumHelper(BinaryTreeNode<Integer> root, int k, Set<Integer> set) {
		if(root == null) {
			return;
		}
		
		if(set.contains(k - root.data)) {
			if(root.data < k-root.data)
				System.out.println(root.data + " " + (k-root.data));
			else if(root.data > k-root.data) 
				System.out.println((k-root.data) + " " + root.data);
			
			set.remove(root.data);
			set.remove(k-root.data);
		}
		
		pairSumHelper(root.left, k, set);
		pairSumHelper(root.right, k, set);
	}

	private static BinaryTreeNode<Integer> insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return root;
		}

		root.left = insertDuplicateNode(root.left);
		root.right = insertDuplicateNode(root.right);
		BinaryTreeNode<Integer> nn = new BinaryTreeNode<>(root.data);
		nn.left = root.left;
		root.left = nn;
		return root;
	}

	private static BinaryTreeNode<Integer> buildTreeUsingInAndPost(int[] postOrder, int[] inOrder) {
		return buildTreeUsingInAndPostHelper(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	private static BinaryTreeNode<Integer> buildTreeUsingInAndPostHelper(int[] postOrder, int posi, int poei,
			int[] inOrder, int iosi, int ioei) {
		if (posi > poei || iosi > ioei) {
			return null;
		}

		int data = postOrder[poei];
		int leftCount = 0;
		for (int i = iosi; i <= ioei && inOrder[i] != data; i++) {
			leftCount++;
		}
		int rightCount = ioei - iosi - leftCount;
		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(data);
		btn.left = buildTreeUsingInAndPostHelper(postOrder, posi, poei - rightCount - 1, inOrder, iosi,
				iosi + leftCount - 1);
		btn.right = buildTreeUsingInAndPostHelper(postOrder, poei - rightCount, poei - 1, inOrder, iosi + leftCount + 1,
				ioei);
		return btn;
	}

	private static BinaryTreeNode<Integer> buildTreeUsingInAndPre(int[] preOrder, int[] inOrder) {
		return buildTreeUsingInAndPreHelper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	private static BinaryTreeNode<Integer> buildTreeUsingInAndPreHelper(int[] preOrder, int posi, int poei,
			int[] inOrder, int iosi, int ioei) {
		if (posi > poei || iosi > ioei) {
			return null;
		}
		if (posi == poei && iosi == ioei) {
			return new BinaryTreeNode<>(preOrder[posi]);
		}

		int data = preOrder[posi];
		int leftCount = 0;
		for (int i = iosi; i <= ioei && inOrder[i] != data; i++) {
			leftCount++;
		}
		BinaryTreeNode<Integer> btn = new BinaryTreeNode<>(data);
		btn.left = buildTreeUsingInAndPreHelper(preOrder, posi + 1, posi + leftCount, inOrder, iosi,
				iosi + leftCount - 1);
		btn.right = buildTreeUsingInAndPreHelper(preOrder, posi + leftCount + 1, poei, inOrder, iosi + leftCount + 1,
				ioei);
		return btn;
	}

	private static void postorderTraversal(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	private static void inorderTraversal(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}

	private static void preorderTraversal(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	private static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		if (root.right == null && root.left != null) {
			System.out.print(root.left.data + " ");
		}
		if (root.right != null && root.left == null) {
			System.out.print(root.right.data + " ");
		}

		printNodesWithoutSibling(root.left);
		printNodesWithoutSibling(root.right);

	}

	private static void printZigZag(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		int level = 0;
		Stack<BinaryTreeNode<Integer>> stack1 = new Stack<>();
		Stack<BinaryTreeNode<Integer>> stack2 = new Stack<>();

		stack1.add(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if (level % 2 == 0) {
				while (!stack1.isEmpty()) {
					BinaryTreeNode<Integer> currNode = stack1.pop();
					System.out.print(currNode.data + " ");

					if (currNode.left != null) {
						stack2.push(currNode.left);
					}
					if (currNode.right != null) {
						stack2.push(currNode.right);
					}
				}
				level++;
			} else {
				while (!stack2.isEmpty()) {
					BinaryTreeNode<Integer> currNode = stack2.pop();
					System.out.print(currNode.data + " ");

					if (currNode.right != null) {
						stack1.add(currNode.right);
					}
					if (currNode.left != null) {
						stack1.add(currNode.left);
					}
				}
				level++;
			}
			System.out.println();
		}

	}

	private static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return root;
		} else if (root.left == null && root.right == null) {
			return null;
		}

		root.left = removeAllLeaves(root.left);
		root.right = removeAllLeaves(root.right);
		return root;
	}

	private static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
		ArrayList<LinkedListNode<Integer>> levelWiseList = new ArrayList<>();

		if (root != null) {
			Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
			LinkedListNode<Integer> currLevelHead = null;
			LinkedListNode<Integer> currLevelTail = null;
			pendingNodes.add(root);
			pendingNodes.add(null);

			while (!pendingNodes.isEmpty()) {
				BinaryTreeNode<Integer> currNode = pendingNodes.poll();

				if (currNode != null) {
					if (currLevelHead == null) {
						currLevelHead = new LinkedListNode<>(currNode.data);
						currLevelTail = currLevelHead;
					} else {
						LinkedListNode<Integer> nn = new LinkedListNode<>(currNode.data);
						currLevelTail.next = nn;
						currLevelTail = currLevelTail.next;
					}

					if (currNode.left != null) {
						pendingNodes.add(currNode.left);
					}
					if (currNode.right != null) {
						pendingNodes.add(currNode.right);
					}

				} else if (!pendingNodes.isEmpty()) {
					pendingNodes.add(null);
					levelWiseList.add(currLevelHead);
					currLevelHead = null;
				} else {
					levelWiseList.add(currLevelHead);
				}
			}
		}

		return levelWiseList;
	}

	private static boolean checkBalanced(BinaryTreeNode<Integer> root) {
		return checkBalHelper(root).isBal;
	}

	private static CheckBalancedReturnType checkBalHelper(BinaryTreeNode<Integer> root) {
		if (root == null)
			return new CheckBalancedReturnType(true, 0);

		CheckBalancedReturnType leftBal = checkBalHelper(root.left);
		CheckBalancedReturnType rightBal = checkBalHelper(root.right);
		if (leftBal.isBal && rightBal.isBal && Math.abs(leftBal.maxHeight - rightBal.maxHeight) <= 1) {
			return new CheckBalancedReturnType(true, Math.max(leftBal.maxHeight, rightBal.maxHeight) + 1);
		}

		return new CheckBalancedReturnType(false, 0);
	}

	private static int diameter(BinaryTreeNode<Integer> root) {
		return diameterHelper(root).diameter;
	}

	private static DiameterReturnType diameterHelper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new DiameterReturnType(0, 0);
		}

		DiameterReturnType leftDiameter = diameterHelper(root.left);
		DiameterReturnType rightDiameter = diameterHelper(root.right);
		int d = Math.max(leftDiameter.maxHeight + rightDiameter.maxHeight + 1,
				Math.max(leftDiameter.diameter, rightDiameter.diameter));
		int mh = Math.max(leftDiameter.maxHeight, rightDiameter.maxHeight) + 1;

		return new DiameterReturnType(d, mh);
	}

	private static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;

	}

	private static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return false;
		}

		boolean ans = root.data == x;
		if (root.left != null) {
			ans = ans || isNodePresent(root.left, x);
		}
		if (root.right != null) {
			ans = ans || isNodePresent(root.right, x);
		}
		return ans;
	}

	private static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return 0;
		}

		int ans = root.data > x ? 1 : 0;
		ans += root.left == null ? 0 : countNodesGreaterThanX(root.left, x);
		ans += root.right == null ? 0 : countNodesGreaterThanX(root.right, x);
		return ans;
	}

	private static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		}

		int leftAns = root.left == null ? 0 : noOfLeafNodes(root.left);
		int rightAns = root.right == null ? 0 : noOfLeafNodes(root.right);

		return leftAns + rightAns;
	}

	private static BinaryTreeNode<Integer> maxDataNode(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return root;
		}

		BinaryTreeNode<Integer> ans = root;
		BinaryTreeNode<Integer> leftAns = maxDataNode(root.left);
		if (leftAns != null && leftAns.data > ans.data) {
			ans = leftAns;
		}

		BinaryTreeNode<Integer> rightAns = maxDataNode(root.right);
		if (rightAns != null && rightAns.data > ans.data) {
			ans = rightAns;
		}

		return ans;
	}

	private static int getSum(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}

		return root.data + getSum(root.left) + getSum(root.right);
	}
}
