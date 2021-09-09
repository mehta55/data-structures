package datastructures.binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUtils {

	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner scn = new Scanner(System.in);
		BinaryTreeNode<Integer> root = null;
		int data = scn.nextInt();
		if (data != -1) {
			Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
			root = new BinaryTreeNode<>(data);
			pendingNodes.add(root);

			while (!pendingNodes.isEmpty()) {
				BinaryTreeNode<Integer> currNode = pendingNodes.poll();
				int leftNodeData = scn.nextInt();
				if (leftNodeData != -1) {
					BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(leftNodeData);
					currNode.left = leftNode;
					pendingNodes.add(leftNode);
				}
				int rightNodeData = scn.nextInt();
				if (rightNodeData != -1) {
					BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(rightNodeData);
					currNode.right = rightNode;
					pendingNodes.add(rightNode);
				}
			}
		}

		return root;
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if (root == null) return;
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		pendingNodes.add(null);
		
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currNode = pendingNodes.poll();
			
			if(currNode != null) {
				System.out.print(currNode.data + " ");
				if(currNode.left != null) {
					pendingNodes.add(currNode.left);
				}
				if(currNode.right != null) {
					pendingNodes.add(currNode.right);
				}
			} else if(!pendingNodes.isEmpty()) {
				pendingNodes.add(null);
				System.out.println();
			} else {
				System.out.println();
			}
		}
	}

	public static void print(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currNode = pendingNodes.poll();
			StringBuilder str = new StringBuilder();
			str.append(currNode.data);

			str.append(":L:");
			if (currNode.left != null) {
				str.append(currNode.left.data);
				pendingNodes.add(currNode.left);
			} else {
				str.append("-1");
			}
			str.append(",R:");
			if (currNode.right != null) {
				str.append(currNode.right.data);
				pendingNodes.add(currNode.right);
			} else {
				str.append("-1");
			}

			System.out.println(str);
		}
	}

}
