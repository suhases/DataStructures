package test;

import collection.binarytree.BinaryTree;
import collection.binarytree.Utilities;

public class TestTree {

	public static void main(String[] args) {
		
		BinaryTree bt=new BinaryTree();
		
		bt.levelorderInsert(1);
		bt.levelorderInsert(2);
		bt.levelorderInsert(3);
		bt.levelorderInsert(4);
		bt.levelorderInsert(5);
		bt.levelorderInsert(6);
		bt.levelorderInsert(7);
		bt.levelorderInsert(8);
		bt.levelorderInsert(9);
		bt.levelorderInsert(10);
		bt.levelorderInsert(11);
		bt.levelorderInsert(12);
		bt.levelorderInsert(13);
		bt.levelorderInsert(14);
		bt.levelorderInsert(15);
		bt.levelorderInsert(100);
		
		bt.levelOrdertraverse();
		System.out.println();
		bt.preorderTraverse();
		System.out.println();
		bt.inorderTraverse();
		System.out.println();
		bt.postorderTraverse();
		System.out.println();
		bt.printLeavesOfTree();
		System.out.println();
		bt.boundaryOfTree();
		System.out.println();
		System.out.println(bt.maxvalue());
		System.out.println(bt.size());
		System.out.println(bt.height());
		
	//	bt.delete();
		bt.levelOrdertraverse();
		System.out.println();
		System.out.println(bt.search(100));
		BinaryTree b2=Utilities.copyTree(bt);
		
		//b2.levelorderInsert(100);
		b2.levelOrdertraverse();
		System.out.println();
		System.out.println("compare tree  "+Utilities.compareTrees(bt, b2));
		System.out.println();
		System.out.println();
		BinaryTree b3=Utilities.createMirrorTree(bt);
		bt.inorderTraverse();
		System.out.println();
		b3.inorderTraverse();
		
		System.out.println("convert to Mirror Tree");
		System.out.println("before");
		b3.inorderTraverse();
		System.out.println();
		b3.preorderTraverse();
		System.out.println();
		b3.postorderTraverse();
		System.out.println();
		System.out.println("after");
		b3.convertToMirror();
		b3.inorderTraverse();
		System.out.println();
		b3.preorderTraverse();
		System.out.println();
		b3.postorderTraverse();
		System.out.println();
		System.out.println(b3.diameter());
		System.out.print("ancestors for a Node :");
		bt.ancestors(15);
		System.out.println();
		System.out.println("root to leaf path");
		bt.rootToLeafPaths();
		
		BinaryTree b4=new BinaryTree();
		b4.levelorderInsert(5);
		b4.levelorderInsert(10);
		
		System.out.println("check subtree   "+Utilities.checkSubTree(bt, b4));
		System.out.println();
		System.out.println("print ancestors : ");
		bt.ancestors(15);
		System.out.println("shortest path");
		bt.leastCommonAncestorspath(4, 6);
		
	}
}
