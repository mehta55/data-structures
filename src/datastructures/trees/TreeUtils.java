package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUtils {

	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner scn = new Scanner(System.in);
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		int data = scn.nextInt();
		TreeNode<Integer> root = null;
		if(data != -1) {
			root = new TreeNode<>(data);
			pendingNodes.add(root);
			
			while(!pendingNodes.isEmpty()) {
				TreeNode<Integer> currNode = pendingNodes.poll();
				int childCount = scn.nextInt();
				for(int i = 0; i < childCount; i++) {
					TreeNode<Integer> childNode = new TreeNode<>(scn.nextInt());
					currNode.children.add(childNode);
					pendingNodes.add(childNode);
				}

			}
		}
		
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		System.out.println("printing...");
		if(root == null) return;
		
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		pendingNodes.add(null);
		
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> currNode = pendingNodes.poll();
			if(currNode == null && pendingNodes.isEmpty()) {
				
			} else if(currNode == null) {
				System.out.println();
				pendingNodes.add(null);
			} else {
				System.out.print(currNode.data + " ");
				for(TreeNode<Integer> childNode : currNode.children) {
					pendingNodes.add(childNode);
				}

			}
		}
	}
	
	public static void printLevelWise2(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		while (!pendingNodes.isEmpty()) {
			TreeNode<Integer> currNode = pendingNodes.poll();
			StringBuilder str = new StringBuilder(currNode.data + ":");
			for(int i = 0; i < currNode.children.size(); i++) {
				TreeNode<Integer> childNode = currNode.children.get(i);
				if(i != currNode.children.size() - 1) {
					str.append(childNode.data + ",");
				} else {
					str.append(childNode.data);
				}
				pendingNodes.add(childNode);
			}
			System.out.println(str.toString());
		}
	}
}
