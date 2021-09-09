package datastructures.trees;

public class Problems {

	static class MaxSumNode {
		private TreeNode<Integer> maxNode;
		private int maxSum;

		public MaxSumNode(TreeNode<Integer> maxNode, int maxSum) {
			super();
			this.maxNode = maxNode;
			this.maxSum = maxSum;
		}
	}
	
	static class SecondLargest<T> {
		private TreeNode<T> largest;
		private TreeNode<T> secondLargest;

		public SecondLargest(TreeNode<T> largest, TreeNode<T> secondLargest) {
			super();
			this.largest = largest;
			this.secondLargest = secondLargest;
		}

	}

	public static void main(String args[]) {
		TreeNode<Integer> root = TreeUtils.takeInputLevelWise();
//		TreeNode<Integer> root1 = TreeUtils.takeInputLevelWise();
//		TreeNode<Integer> root2 = TreeUtils.takeInputLevelWise();

//		System.out.println(countNodes(root));
//		System.out.println(sumOfAllNode(root));
//		System.out.println(maxDataNode(root).data);
//		printNodesAtDepthK(root, 1);
//		System.out.println(numNodeGreater(root, 30));
//		System.out.println(countLeafNodes(root));
//		TreeUtils.printLevelWise2(root);
//		System.out.println(checkIfContainsX(root, 40));
//		System.out.println(maxSumNode(root).data);
//		System.out.println(checkIdentical(root1, root2));
//		System.out.println(findNextLargerNode(root, 38).data);
//		System.out.println(findSecondLargest(root).data);
		replaceWithDepthValue(root);
		
		TreeUtils.printLevelWise2(root);
	}

	
	
	private static void replaceWithDepthValue(TreeNode<Integer> root) {
		if (root == null) return;
		replaceWithDepthValue(root, 0);
	}



	private static void replaceWithDepthValue(TreeNode<Integer> root, int d) {
		root.data = d;
		for(TreeNode<Integer> childNode : root.children) {
			replaceWithDepthValue(childNode, d + 1);
		}
	}



	private static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
		if (root == null) return root;
		return findSecondLargestHelper(root).secondLargest;
	}

	private static SecondLargest<Integer> findSecondLargestHelper(TreeNode<Integer> root) {

		SecondLargest<Integer> ans = new SecondLargest<>(root, null);
		for (TreeNode<Integer> childNode : root.children) {
			SecondLargest<Integer> smallAns = findSecondLargestHelper(childNode);
			
			if (ans.largest.data > smallAns.largest.data) {
				if(ans.secondLargest == null || ans.secondLargest.data < smallAns.largest.data) {
					ans.secondLargest = smallAns.largest;
					ans.secondLargest.data = smallAns.largest.data;
				}
			} else if (ans.largest.data < smallAns.largest.data) {
				if (smallAns.secondLargest != null && smallAns.secondLargest.data > ans.largest.data) {
					ans = smallAns;
				} else {
					ans.secondLargest = ans.largest;
					ans.largest = smallAns.largest;
				}
			} else {
				if(ans.secondLargest != null && smallAns.secondLargest != null) {
					ans.secondLargest = ans.secondLargest.data > smallAns.secondLargest.data ? ans.secondLargest
							: smallAns.secondLargest;
				} else if(smallAns.secondLargest != null) {
					ans.secondLargest = smallAns.secondLargest;
				}
			}
		}
		return ans;
	}


	private static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int x) {
		if (root == null)
			return root;
		
		TreeNode<Integer> nextLargerNode = null;
		if (root.data > x) {
			nextLargerNode = root;
		}
		
		for (TreeNode<Integer> childNode : root.children) {
			TreeNode<Integer> childNextLargerNode = findNextLargerNode(childNode, x);
			if (childNextLargerNode != null
					&& (nextLargerNode == null || nextLargerNode.data > childNextLargerNode.data)) {
				nextLargerNode = childNextLargerNode;
			}
		}
		return nextLargerNode;
	}



	private static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		} 
		return checkIdenticalHelper(root1, root2);
	}



	private static boolean checkIdenticalHelper(TreeNode<Integer> root1, TreeNode<Integer> root2) {

		boolean isIdentical = root1.data.equals(root2.data) && root1.children.size() == root2.children.size();
		if (isIdentical) {
			for (int i = 0; i < root1.children.size(); i++) {
				isIdentical = isIdentical && checkIdenticalHelper(root1.children.get(i), root2.children.get(i));
				if(!isIdentical) {
					break;
				}
			}
		}

		return isIdentical;
	}



	private static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
		return root == null ? null : maxSumNodeHelper(root).maxNode;
	}



	private static MaxSumNode maxSumNodeHelper(TreeNode<Integer> root) {
		int maxSum = root.data;
		for(TreeNode<Integer> childNode : root.children) {
			maxSum += childNode.data;
		}
		MaxSumNode maxSumNode = new MaxSumNode(root, maxSum);
		
		for(TreeNode<Integer> childNode : root.children) {
			MaxSumNode childMaxSumNode = maxSumNodeHelper(childNode);
			if(maxSumNode.maxSum < childMaxSumNode.maxSum) {
				maxSumNode = childMaxSumNode;
			}
		}
		
		return maxSumNode;
	}

	private static boolean checkIfContainsX(TreeNode<Integer> root, int x) {
		if(root == null) {
			return false;
		}
		
		if(root.data.equals(x)) {
			return true;
		}
		
		boolean isPresent = false;
		for(TreeNode<Integer> childNode : root.children) {
			isPresent = isPresent || checkIfContainsX(childNode, x);
		}
		
		return isPresent;
	}

	private static int countLeafNodes(TreeNode<Integer> root) {
		if (root == null)
			return 0;
		
		int count = 0;
		if(root.children.isEmpty()) {
			count = 1;
		} else {
			for(TreeNode<Integer> childNode : root.children) {
				count += countLeafNodes(childNode);
			}
		}
		
		return count;
	}

	private static int numNodeGreater(TreeNode<Integer> root, int x) {
		if (root == null) {
			return 0;
		}
		
		int count = root.data > x ? 1 : 0;
		for(TreeNode<Integer> childNode : root.children) {
			count += numNodeGreater(childNode, x);
		}
		return count;
	}

	private static void printNodesAtDepthK(TreeNode<Integer> root, int k) {
		if (root == null) {
			return;
		} else if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		
		for(TreeNode<Integer> childNode : root.children) {
			printNodesAtDepthK(childNode, k - 1);
		}
	}

	private static TreeNode<Integer> maxDataNode(TreeNode<Integer> root) {
		if(root == null || root.children.isEmpty()) {
			return root;
		}
		
		TreeNode<Integer> maxDataNode = root;
		for(TreeNode<Integer> childNode : root.children) {
			TreeNode<Integer> maxDataChildNode = maxDataNode(childNode);
			if(maxDataNode.data < maxDataChildNode.data) {
				maxDataNode = maxDataChildNode;
			}
		}
		
		return maxDataNode;
	}

	private static int sumOfAllNode(TreeNode<Integer> root) {
		if (root == null) 
			return 0;
		if (root.children.isEmpty()) 
			return root.data;
		
		int subTotal = root.data;
		for(TreeNode<Integer> childNode : root.children) {
			subTotal += sumOfAllNode(childNode);
		}
		return subTotal;
	}

	private static int countNodes(TreeNode<Integer> root) {
		if (root == null)
			return 0;
		if (root.children.isEmpty()) {
			return 1;
		}
		int subCount = 1;
		for (TreeNode<Integer> childNode : root.children) {
			subCount += countNodes(childNode);
		}
		return subCount;
	}
}


