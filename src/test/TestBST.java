package test;

import collection.binarysearchtree.BinarySearchTree;
import collection.binarysearchtree.Utilities;

public class TestBST {

	public static void main(String[] args) {
		
		
		BinarySearchTree b= new BinarySearchTree();
		
		b.insert(50);
		b.insert(25);
		b.insert(75);
		b.insert(10);
		b.insert(30);
		b.insert(60);
		b.insert(90);
		b.insert(5);
		b.insert(15);
		b.insert(27);
		b.insert(40);
		b.insert(55);
		b.insert(70);
		b.insert(80);
		b.insert(95);
		b.traverse();
		
		System.out.println();
		System.out.println("check node : "+b.Search(10));
		System.out.println(b.minimum());
		System.out.println(b.maximum());
		
		b.delete(50);
		b.traverse();
		System.out.println();
		System.out.println(Utilities.checkBST(b));
		System.out.println(Utilities.isBST(b));
		System.out.println(b.kthsmallest(0));
	}
}
