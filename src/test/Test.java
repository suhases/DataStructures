package test;

import collection.linkedlist.LinkedList;
import collection.linkedlist.Utilities;

public class Test {

	public static void main(String[] args) {
	
		LinkedList l=new LinkedList();
		
		/*l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);*/
		int arr[]={5,4,3,3,4,5};
		int b[]={7,2,8,4};
		l.addAll(arr);
		
		boolean x=Utilities.palindrome(l);
		System.out.println(x);
	/*	LinkedList l2=new LinkedList();
		l2.addAll(b);
		LinkedList s=Utilities.addDatainLL(l, l2);
		l.traverse();
		System.out.println();
		l2.traverse();
		System.out.println();
		s.traverse();
		System.out.println();*/
		
	
	
	
		
		
		
	
	}
}
