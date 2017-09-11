package collection.binarysearchtree;

public class BinarySearchTree {

	private BNode root;
	private int size;
	private int cnt; 
	public void insert(int data) {

		BNode temp = root;
		BNode b = new BNode(data);
		if (temp == null) {
			root = b;
			size++;
		}
		while (temp != null) {

			if (data < temp.getData()) {
				if (temp.getLeft() == null) {
					temp.setLeft(b);
					size++;
					return;
				} else
					temp = temp.getLeft();
			} else {
				if (temp.getRight() == null) {
					temp.setRight(b);
					size++;
					return;
				} else
					temp = temp.getRight();
			}

		}

	}

	public void traverse() {
		traverse(root);
	}

	private void traverse(BNode root2) {
		if (root2 == null)
			return;

		System.out.print(root2.getData() + " ");
		traverse(root2.getLeft());
		traverse(root2.getRight());

	}

	public boolean Search(int data) {

		if (root == null)
			return false;

		BNode temp = root;

		while (temp != null) {

			if (temp.getData() == data)
				return true;

			else if (data < temp.getData()) {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}

		}

		return false;

	}

	public int minimum() {

		if (root == null)
			return -1;

		BNode temp = root;

		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		return temp.getData();
	}

	public int maximum() {
		return maximum(root);
	}

	public void delete(int data) {

		deletenode(root, data);
	}

	private BNode deletenode(BNode root2, int data) {

		if (root2 == null)
			return null;

		else if (data < root2.getData())
			root2.setLeft(deletenode(root2.getLeft(), data));
		else if (data > root2.getData())
			root2.setRight(deletenode(root2.getRight(), data));
		else {
			if (root2.getLeft() == null && root2.getRight() == null) {
				return null;
			} else if (root2.getLeft() == null)
				return root2.getRight();
			else if (root2.getRight() == null)
				return root2.getLeft();
			else {

				BNode temp = maximumvalueNode(root2.getLeft());
				root2.setData(temp.getData());
				deletenode(root2.getLeft(), temp.getData());
			}

		}
		return root2;
	}

	private int maximum(BNode root2) {

		if (root2 == null)
			return -1;

		if (root2.getRight() == null)
			return root2.getData();

		return maximum(root2.getRight());
	}

	private BNode maximumvalueNode(BNode root2) {

		if (root2 == null)
			return null;

		if (root2.getRight() == null)
			return root2;

		return maximumvalueNode(root2.getRight());
	}
	public int kthsmallest(int k){
		cnt=k;
		return kthsmallest(root).getData();
	}
	private BNode kthsmallest(BNode root){
		if(root==null) return null;
		
		BNode temp=kthsmallest(root.getLeft());
		if(temp!=null)return temp;
		if(cnt==0)return root;
		cnt--;
		System.out.println(root.getData());
		BNode tem=kthsmallest(root.getRight());
		return tem;
	}
	protected  BNode getRoot(){
		return root;
	}
}
