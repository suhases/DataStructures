package test;

import collection.doublylinkedlist.DoublyLinkedList;
import collection.stack.Stack;

public class TestDLL {

	
	public static void main(String[] args) {
		
		
		/*DoublyLinkedList d= new DoublyLinkedList();
		d.add(5);
		d.add(8);
		d.add(9);
		d.add(1);
		d.traverse();
		d.delete(9);
		d.traverse();*/
		
		Stack s=new Stack();
		s.push(5);
		s.push(7);
		s.push(9);
		
		System.out.println();
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
