package datastructures.binarysearchtrees;

import datastructures.binarytrees.BinaryTreeNode;

public class BinarySearchTree {
	
	private BinaryTreeNode<Integer> root;

	public void insert(int data) {
		if (root == null) {
			root = new BinaryTreeNode<>(data);
		} else {
			root = insert(root, data);
		}
	}
	
	private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
		if(root == null) {
			return new BinaryTreeNode<>(data);
		}
		
		if(root.data >= data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}

	public void remove(int data) {
		root = removeNode(root, data);
	}
	
	private BinaryTreeNode<Integer> removeNode(BinaryTreeNode<Integer> root, int data) {
		if(root == null) {
			return root;
		}
		
		if(root.data.equals(data)) {
			if(root.left == null && root.right == null) {
				return null;
			} else if (root.left != null && root.right == null) {
				return root.left;
			} else if (root.right != null && root.left == null) {
				return root.right;
			} else {
				BinaryTreeNode<Integer> temp = root.right;
				while (temp.left != null) {
					temp = temp.left;
				}
				root.data = temp.data;
				root.right = removeNode(temp, temp.data);
			}			 
		}
		
		if(root.data > data) {
			root.left = removeNode(root.left, data);
		} else {
			root.right = removeNode(root.right, data);
		}
		return root;
	}

	public void printTree() {
		printTree(root);
	}
	
	private void printTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		StringBuilder str = new StringBuilder();
		str.append(root.data + ":" );
		
		if(root.left != null) {
			str.append("L:" + root.left.data + ",");			
		}
		if(root.right != null) {
			str.append("R:" + root.right.data );			
		}
		
		System.out.println(str);
		printTree(root.left);
		printTree(root.right);
		
	}

	public boolean search(int data) {
		return search(root, data);
	}

	private boolean search(BinaryTreeNode<Integer> root, int data) {
		if(root == null) {
			return false;
		}
		
		if(root.data.equals(data)) {
			return true;
		}
		
		boolean found = false;
		if(root.data > data) {
			found = search(root.left, data);
		} else {
			found = search(root.right, data);
		}
		return found;
	}
}
