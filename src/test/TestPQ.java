package test;

import collection.MinPriorityQueue.MinPriorityQueue;

public class TestPQ {

	public static void main(String[] args) {
		
		MinPriorityQueue min=new MinPriorityQueue(31);
		
		min.insert(50);
		min.insert(45);
		min.insert(23);
		min.insert(75);
		min.insert(99);
		min.insert(60);
		min.insert(49);
		min.heapify(6);
		min.deletemin();
		System.out.println("min priority queue");
		
		
	}
}
