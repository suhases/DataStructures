package test;

import collection.queue.Utilities;
import collection.queue.Queue;

public class TestQueue {

	public static void main(String[] args) {

		
		
		Queue q=new Queue(); 
		q.enqueue(5);
		q.enqueue(7);
		q.enqueue(9);
		Utilities.reverse(q);
		System.out.println();
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
