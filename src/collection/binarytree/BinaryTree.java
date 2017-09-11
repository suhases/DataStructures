package collection.binarytree;

import collection.queue.Queue;

public class BinaryTree {

	private BNode root;
	private int size;

	public BinaryTree() {
	}

	public BinaryTree(BNode root2) {
		this.root = root2;
		this.size = size(root2);
	}

	public void levelorderInsert(int data) {

		Queue<BNode> queue = new Queue<BNode>();
		BNode b = new BNode(data);
		BNode temp = root;

		if (temp == null) {
			root = b;
			size++;
			return;
		}
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			temp = queue.dequeue();
			if (temp.getLeft() == null) {
				temp.setLeft(b);
				size++;
				return;
			} else {
				queue.enqueue(temp.getLeft());
			}
			if (temp.getRight() == null) {
				temp.setRight(b);
				size++;
				return;
			} else {
				queue.enqueue(temp.getRight());
			}
		}
	}

	public void levelOrdertraverse() {

		Queue<BNode> queue = new Queue<BNode>();
		if (root != null) {
			queue.enqueue(root);

			while (!queue.isEmpty()) {
				BNode temp = queue.dequeue();
				System.out.print(temp.getData() + " ");
				if (temp.getLeft() != null)
					queue.enqueue(temp.getLeft());
				if (temp.getRight() != null)
					queue.enqueue(temp.getRight());

			}
		}
	}

	public void preorderTraverse() {
		preorder(root);
	}

	public void postorderTraverse() {
		postorder(root);
	}

	public void inorderTraverse() {
		inorder(root);
	}

	private void inorder(BNode root2) {

		if (root2 == null)
			return;
		inorder(root2.getLeft());
		System.out.print(root2.getData() + " ");
		inorder(root2.getRight());

	}

	private void postorder(BNode root2) {

		if (root2 == null)
			return;

		postorder(root2.getLeft());
		postorder(root2.getRight());
		System.out.print(root2.getData() + " ");

	}

	private void preorder(BNode root2) {
		if (root2 == null)
			return;

		System.out.print(root2.getData() + " ");
		preorder(root2.getLeft());
		preorder(root2.getRight());

	}

	public void printLeavesOfTree() {
		leafOfTree(root);
	}

	private void leafOfTree(BNode root2) {
		if (root2 == null)
			return;
		if (root2.getLeft() == null && root2.getRight() == null)
			System.out.print(root2.getData() + " ");

		leafOfTree(root2.getLeft());
		leafOfTree(root2.getRight());

	}

	public void boundaryOfTree() {

		leftpart(root);
		leafOfTree(root);
		rightpart(root);
	}

	private void rightpart(BNode root2) {

		if (root2 == null || (root2.getLeft() == null && root2.getRight() == null))
			return;
		if (root2.getRight() != null)
			rightpart(root2.getRight());
		else
			rightpart(root2.getLeft());
		System.out.print(root2.getData() + " ");

	}

	private void leftpart(BNode root2) {

		if (root2 == null || (root2.getLeft() == null && root2.getRight() == null))
			return;

		System.out.print(root2.getData() + " ");
		if (root2.getLeft() != null)
			leftpart(root2.getLeft());
		else
			leftpart(root2.getRight());
	}

	public int maxvalue() {
		return maxvalueinTree(root);
	}

	public int size() {
		return size(root);
	}

	private int size(BNode root2) {

		if (root2 == null)
			return 0;

		int left = size(root2.getLeft());
		int right = size(root2.getRight());
		return left + right + 1;
	}

	public int height() {
		return height(root);
	}

	/**
	 * Deletes entire Tree
	 */
	public void delete() {
		deleteTree(root);
		root = null;
	}

	public boolean search(int data) {
		return search(root, data);
	}

	private boolean search(BNode root2, int data) {
		if (root2 == null)
			return false;
		else {
			boolean flag = false;
			if (root2.getData() == data)
				return true;
			else {
				flag = search(root2.getLeft(), data);
				if (!flag)
					flag = search(root2.getRight(), data);
				return flag;
			}
		}
	}

	public void convertToMirror() {
		root = convertToMirrorTree(root);
	}

	private BNode convertToMirrorTree(BNode root2) {

		if (root2 == null)
			return null;
		else {
			BNode left = convertToMirrorTree(root2.getLeft());
			BNode right = convertToMirrorTree(root2.getRight());
			root2.setLeft(right);
			root2.setRight(left);
			return root2;
		}

	}

	public void ancestors(int data) {
		ancestors(root, data);
	}

	private boolean ancestors(BNode root2, int data) {

		if (root2 == null)
			return false;
		else {
			if (root2.getData() == data)
				return true;
			else {
				boolean left = ancestors(root2.getLeft(), data);
				if (left) {
					System.out.print(root2.getData() + " ");
					return left;
				}
				boolean right = ancestors(root2.getRight(), data);
				if (right)
					System.out.print(root2.getData() + " ");
				return right;
			}

		}

	}

	public BNode leastCommonAncestors(int data1,int data2) {
		return lca(root, data1,data2);
	}

	private BNode lca(BNode root2, int data1,int data2) {

		if (root2 == null)
			return null;
		else {
			if (root2.getData() == data1 || root2.getData()==data2)
				return root2;
			 
				BNode left = lca(root2.getLeft(), data1,data2);
				BNode right= lca(root2.getRight(), data1,data2);
				
				
				if(left!=null && right!=null)
					return root2;
				
				return (left!=null ?left :right);
			}

		}

	public BNode leastCommonAncestorspath(int data1,int data2) {
		return lcapath(root, data1,data2);
	}

	private BNode lcapath(BNode root2, int data1,int data2) {

		if (root2 == null)
			return null;
		else {
			if (root2.getData() == data1 || root2.getData()==data2){
				//System.out.print(root2.getData()+" ");
				return root2;
			}
				
			 
				BNode left = lcapath(root2.getLeft(), data1,data2);
				if(left!=null){
					System.out.print(left.getData()+" ");
					return root2;
					}
				BNode right= lcapath(root2.getRight(), data1,data2);
				
				
				if(right!=null){
					System.out.print(right.getData()+" ");
					return root2;
				}
				
				
				
				return (left!=null ?left :right);
			}

		}
	public void rootToLeafPaths() {
		int arr[] = new int[height()];
		rootToLeafPath(root, arr, 0);
	}
	
	

	private void rootToLeafPath(BNode root2, int[] arr, int count) {

		if (root2 == null) {
			return;
		}
		arr[count] = root2.getData();
		if (root2.getLeft() == null && root2.getRight() == null) {
			printarray(arr, count);
		}
		rootToLeafPath(root2.getLeft(), arr, count + 1);
		rootToLeafPath(root2.getRight(), arr, count + 1);

	}

	private void printarray(int[] arr, int count) {

		for (int i = 0; i <= count; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(BNode root2) {
		if (root2 == null)
			return 0;
		else {
			int left = diameter(root2.getLeft());
			int right = diameter(root2.getRight());

			int dia = 1 + height(root2.getLeft()) + height(root2.getRight());
			return (left > right ? left : right) > dia ? (left > right ? left : right) : dia;
		}
	}

	private void deleteTree(BNode root2) {
		if (root2 == null)
			return;
		else {

			deleteTree(root2.getLeft());
			root2.setLeft(null);
			deleteTree(root2.getRight());
			root2.setRight(null);

		}
	}

	private int height(BNode root2) {

		if (root2 == null)
			return 0;

		int left = height(root2.getLeft());
		int right = height(root2.getRight());
		return left > right ? left + 1 : right + 1;
	}

	private int maxvalueinTree(BNode root2) {

		if (root2 == null)
			return Integer.MIN_VALUE;
		else {
			int left = maxvalueinTree(root2.getLeft());
			int right = maxvalueinTree(root2.getRight());

			return max(left, right, root2.getData());
		}

	}

	private int max(int left, int right, int data) {
		int temp = left > right ? left : right;
		return temp > data ? temp : data;
	}

	public int getSize() {
		return size;
	}

	protected BNode getRoot() {
		return root;
	}
}
