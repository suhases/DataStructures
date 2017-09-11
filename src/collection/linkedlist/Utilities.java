package collection.linkedlist;

import collection.stack.Stack;

public class Utilities {

	public static LinkedList mergeinSorted(LinkedList a, LinkedList b) {

		Node anode = a.getHead();
		Node bnode = b.getHead();
		Node head;
		Node mnode;
		if (anode.getData() < bnode.getData()) {
			head = anode;
			mnode = head;
			anode = anode.getNext();
		} else {
			head = bnode;
			mnode = head;
			bnode = bnode.getNext();
		}
		while (anode != null && bnode != null) {
			if (anode.getData() < bnode.getData()) {
				mnode.setNext(anode);
				mnode = mnode.getNext();
				anode = anode.getNext();
			} else {
				mnode.setNext(bnode);
				mnode = mnode.getNext();
				bnode = bnode.getNext();
			}
		}
		while (anode != null) {
			mnode.setNext(anode);
			mnode = mnode.getNext();
			anode = anode.getNext();
		}
		while (bnode != null) {
			mnode.setNext(bnode);
			mnode = mnode.getNext();
			bnode = bnode.getNext();
		}
		return new LinkedList(head);
	}

	public static boolean isCyclic(LinkedList l) {
		if (l.isEmpty()) {
			return false;
		}
		Node fast = l.getHead();
		Node slow = l.getHead();
		while (fast != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Partition the LinkedList based on given data old LinkedList will not be
	 * retained
	 * 
	 * @return
	 */
	public static LinkedList partition(LinkedList l, int data) {

		Node temp = l.getHead();
		if (temp == null) {
			System.out.println("LinkedList is empty");
			return new LinkedList(temp);
		}

		Node bh = null, be = null, ah = null, ae = null;
		while (temp != null) {

			if (temp.getData() < data) {
				if (bh == null) {
					bh = temp;
					be = bh;
				} else {
					be.setNext(temp);
					be = be.getNext();
				}
			} else {
				if (ah == null) {
					ah = temp;
					ae = ah;
				} else {
					ae.setNext(temp);
					ae = ae.getNext();
				}
			}
			temp = temp.getNext();
		}
		if (be != null) {
			be.setNext(ah);
		}
		ae.setNext(null);
		if (bh == null)
			return new LinkedList(ah);
		else
			return new LinkedList(bh);
	}

	public static LinkedList addDatainLL(LinkedList x, LinkedList y) {

		Node a = x.getHead();
		Node b = y.getHead();

		FullSum f = addData(a, b);

		if (f.getCarry() != 0) {
			Node n = new Node(f.getCarry());
			n.setNext(f.getSum());
			return new LinkedList(n);
		} else {
			return new LinkedList(f.getSum());
		}

	}

	private static FullSum addData(Node a, Node b) {

		if (a == null && b == null) {
			return new FullSum();
		}

		FullSum f = addData(a.getNext(), b.getNext());

		Node n = new Node();
		int s = a.getData() + b.getData() + f.getCarry();
		int c = s / 10;
		s = s % 10;
		n.setData(s);
		n.setNext(f.getSum());
		return new FullSum(n, c);
	}

	public static boolean palindrome(LinkedList l) {

		Node slow = l.getHead();
		Node fast = l.getHead();
		Stack s = new Stack();

		while (fast != null && fast.getNext() != null) {
			s.push(slow.getData());
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		if (fast != null && fast.getNext() == null)
			slow = slow.getNext();
		while (slow.getNext() != null) {

			if (s.pop() != slow.getData())
				return false;
			slow = slow.getNext();
		}
		return true;
	}
}

class FullSum {
	private Node sum;
	private int carry;

	public FullSum() {
		// TODO Auto-generated constructor stub
	}

	public FullSum(Node sum, int carry) {
		this.sum = sum;
		this.carry = carry;
	}

	public Node getSum() {
		return sum;
	}

	public void setSum(Node sum) {
		this.sum = sum;
	}

	public int getCarry() {
		return carry;
	}

	public void setCarry(int carry) {
		this.carry = carry;
	}
}
