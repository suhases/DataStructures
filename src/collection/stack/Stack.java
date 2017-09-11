package collection.stack;

import collection.linkedlist.Node;

public class Stack {

	private Node top;
	private int size;

	public void push(int data) {

		Node n = new Node(data);

		n.setNext(top);
		top = n;
		size++;
	}

	public int pop() {

		if (top == null) {
			try {
				throw new Exception("Stack is Empty");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		} else {
			int data = top.getData();
			top = top.getNext();
			size--;
			return data;
		}
	}

	public int getSize() {
		return size;
	}

	public int peek() {

		if (top == null) {
			System.out.println("Stack is empty");
			return 0;
		} else {
			return top.getData();
		}
	}

	public boolean isEmpty() {
		if (top == null && size == 0)
			return true;
		return false;
	}

	public int search(int data) {

		if (top == null) {
			System.out.println("Stack is empty");
			return 0;
		} else {
			int x = 1;
			Node temp = top;
			while (temp != null) {
				if (temp.getData() == data)
					break;
				temp = temp.getNext();
				x++;
			}
			return x;
		}
	}
}
