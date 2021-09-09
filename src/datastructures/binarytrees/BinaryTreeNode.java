package datastructures.binarytrees;

public class BinaryTreeNode<T> {

	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
	
	
	public BinaryTreeNode(T data) {
		super();
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}
	
}
