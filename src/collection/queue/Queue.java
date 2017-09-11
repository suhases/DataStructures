package collection.queue;

import collection.queue.Node;

public class Queue<T> {

	private Node front;
	private Node rear;
	private int size;

	public void enqueue(T data) {

		Node n = new Node(data);
		if (front == null && rear == null) {
			front = n;
			rear = n;
			size++;
		} else {
			rear.setNext(n);
			rear = n;
			size++;
		}
	}

	public T dequeue() {

		if (front == null && rear == null) {
			System.out.println("Queue is empty");
			return null;
		} else {
			if (front == rear) {
				T data = (T) front.getData();
				front = null;
				rear = null;
				size--;
				return data;
			} else {
				T data = (T) front.getData();
				front = front.getNext();
				size--;
				return data;
			}
		}

	}

	public boolean isEmpty() {
		if (front == null && rear == null && size == 0)
			return true;
		return false;
	}

	public int getSize() {
		return size;
	}
}
