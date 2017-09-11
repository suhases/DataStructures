package collection.binarysearchtree;

public class Utilities {

	private static int prev=Integer.MIN_VALUE;
	public static boolean checkBST(BinarySearchTree b) {

		return checkBST(b.getRoot());
	}

	private static boolean checkBST(BNode root) {

		if (root == null)
			return true;
		if (root.getLeft() == null && root.getRight() == null)
			return true;

		if (root.getLeft() != null && findmax(root.getLeft()) > root.getData()) {
			return false;
		}
		if (root.getRight() != null && findmin(root.getRight()) < root.getData()) {
			return false;
		}

		boolean flag = checkBST(root.getLeft());
		if (!flag)
			return flag;
		return checkBST(root.getRight());
		//return false;

	}
	public static boolean isBST(BinarySearchTree b ){
		return checkBSTusingInorder(b.getRoot());
	}	 
	
	private static boolean checkBSTusingInorder(BNode root) {
		if(root==null)
		return true;
		
		else{
			boolean left=checkBSTusingInorder(root.getLeft());
			if(!left)return false;
			if(prev>root.getData())return false;
			prev=root.getData();
			System.out.print(prev+" ");
			boolean right=checkBSTusingInorder(root.getRight());
			return right;
		}
	}

	private static int findmin(BNode right) {
		if (right == null)
			return -1;

		if (right.getLeft() == null)
			return right.getData();

		return findmin(right.getLeft());
	}

	private static int findmax(BNode left) {

		if (left == null)
			return -1;

		if (left.getRight() == null)
			return left.getData();

		return findmax(left.getRight());
	}
}
