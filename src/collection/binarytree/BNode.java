package collection.binarytree;

public class BNode {

	private BNode left;
	private BNode right;
	private int data;

	public BNode() {
		// TODO Auto-generated constructor stub
	}

	public BNode(int data) {
		this.data=data;// TODO Auto-generated constructor stub
	}

	public BNode getLeft() {
		return left;
	}

	public void setLeft(BNode left) {
		this.left = left;
	}

	public BNode getRight() {
		return right;
	}

	public void setRight(BNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
