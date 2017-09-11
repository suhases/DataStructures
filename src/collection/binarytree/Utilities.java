package collection.binarytree;

public class Utilities {

	public static BinaryTree copyTree(BinaryTree b) {
		BNode newroot = copyTree(b.getRoot());
		return new BinaryTree(newroot);

	}

	private static BNode copyTree(BNode root2) {

		if (root2 == null)
			return null;
		else {
			BNode b = new BNode(root2.getData());
			b.setLeft(copyTree(root2.getLeft()));
			b.setRight(copyTree(root2.getRight()));
			return b;
		}

	}

	public static boolean compareTrees(BinaryTree b1, BinaryTree b2) {
		return compareTree(b1.getRoot(), b2.getRoot());
	}

	private static boolean compareTree(BNode root1, BNode root2) {

		if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		else if (root1 == null && root2 == null)
			return true;
		else {

			if (root1.getData() != root2.getData())
				return false;
			else {
				boolean flag = false;

				flag = compareTree(root1.getLeft(), root2.getLeft());
				if (!flag)
					return flag;
				return compareTree(root1.getRight(), root2.getRight());

			}

		}
	}

	public static BinaryTree createMirrorTree(BinaryTree b) {
		BNode newroot = createMirrorTree(b.getRoot());
		return new BinaryTree(newroot);
	}

	private static BNode createMirrorTree(BNode root1) {

		if (root1 == null)
			return null;
		else {

			BNode b = new BNode(root1.getData());

			b.setRight(createMirrorTree(root1.getLeft()));
			b.setLeft(createMirrorTree(root1.getRight()));
			return b;
		}
	}

	public static boolean checkSubTree(BinaryTree b1, BinaryTree b2) {

		return findSubTree(b1.getRoot(), b2.getRoot());

	}

	private static boolean findSubTree(BNode root1, BNode root2) {

		if (root1 == null && root2 == null)
			return true;
		if (root1 == null && root2 != null)
			return false;

		if (root1.getData() == root2.getData())
			return checkSubTree(root1, root2);

		boolean flag = findSubTree(root1.getLeft(), root2);
		if (flag)
			return flag;
		flag = findSubTree(root1.getRight(), root2);
		return flag;
	}

	private static boolean checkSubTree(BNode root1, BNode root2) {

		if (root1 == null && root2 == null)
			return true;
		else if (root1 != null && root2 == null)
			return true;
		else if (root1 == null && root2 != null)
			return false;

		else {

			if(root1.getData()!=root2.getData())return false;
			
			boolean flag=checkSubTree(root1.getLeft(), root2.getLeft());
			if(!flag)return false;
			return checkSubTree(root1.getRight(), root2.getRight());
		}

	}
}
