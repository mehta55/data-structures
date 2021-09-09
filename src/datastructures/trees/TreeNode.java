package datastructures.trees;

import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {

	public T data;
	public List<TreeNode<T>> children;

	public TreeNode(T data) {
		super();
		this.data = data;
		children = new LinkedList<TreeNode<T>>();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}

}
