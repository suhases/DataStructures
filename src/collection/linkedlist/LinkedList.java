package collection.linkedlist;

public class LinkedList {
	private Node head;
	private int size = 0;

	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	public LinkedList(Node head) {
		this.head = head;
		Node temp = head;
		while (temp != null) {
			temp = temp.getNext();
			size++;
		}
	}

	// add data to LL
	public void add(int data) {
		Node n = new Node(data);

		if (head == null) {
			head = n;
			size++;
		} else {
			Node temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(n);
			size++;
		}
	}

	// Traverse
	public void traverse() {
		if (isEmpty())
			System.out.println("LinkedList is Empty");
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}

	}

	public void delete(int data) {
		boolean flag = false;
		if (head.getData() == data) {
			Node temp = head;
			head = temp.getNext();
			temp.setNext(null);
			flag = true;
			size--;
		} else {
			Node temp = head;
			Node prev = null;
			while (temp.getNext() != null) {
				prev = temp;
				temp = temp.getNext();
				if (temp.getData() == data) {
					prev.setNext(temp.getNext());
					temp.setNext(null);
					flag = true;
					size--;
					break;
				}
			}
		}
		if (!flag)
			System.out.println("Given data does not exist");
	}

	public void updateAtPosition(int data, int pos) {
		if (pos >= size) {
			System.out.println("Given position does not exit");
		} else {
			Node temp = head;
			while (pos != 0) {
				temp = temp.getNext();
				pos--;
			}
			temp.setData(data);

		}
	}

	public void insertAtPosition(int data, int pos) {
		if (pos > size) {
			System.out.println("Given position does not exit");
		} else {
			Node n = new Node(data);
			if (pos == 0) {
				n.setNext(head);
				head = n;
				size++;
			} else {
				Node temp = head;
				while (pos != 1) {
					temp = temp.getNext();
					pos--;
				}
				n.setNext(temp.getNext());
				temp.setNext(n);
				size++;
			}
		}
	}

	public void insertAtBegin(int data) {
		Node n = new Node(data);
		n.setNext(head);
		head = n;
		size++;
	}

	public boolean isEmpty() {
		if (size == 0 && head == null)
			return true;
		return false;
	}

	public void deleteAtBegin() {
		if (isEmpty())
			System.out.println("LinkedList is Empty");
		else {
			Node temp = head;
			head = head.getNext();
			temp.setNext(null);
			size--;
		}
	}

	public Node getMiddleNode() {
		Node slow = head;
		Node fast = head;

		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}

	public void deleteLastNode() {

		if (head.getNext() == null) {
			head = null;
			size--;
		} else {
			Node temp = head;
			Node prev = head;
			while (temp.getNext() != null) {
				prev = temp;
				temp = temp.getNext();
			}
			temp = null;
			prev.setNext(null);
			size--;
		}

	}

	public void deleteAtPosition(int pos) {
		if (pos >= size) {
			System.out.println("Given position does not exit");
		} else {
			if (pos == 0) {
				Node temp = head;
				head = head.getNext();
				temp.setNext(null);
				size--;
			} else {
				Node prev = head;
				Node cur = head.getNext();
				while (pos != 1) {
					prev = cur;
					cur = cur.getNext();
					pos--;
				}
				prev.setNext(cur.getNext());
				cur.setNext(null);
				size--;
			}
		}
	}

	public Node getNfromLast(int pos) {
		if (pos > size || pos == 0) {
			System.out.println("Given position does not exit");
			return new Node();
		} else {
			Node fast = head;
			Node slow = head;
			while (pos != 1) {
				fast = fast.getNext();
				pos--;
			}
			while (fast.getNext() != null) {
				fast = fast.getNext();
				slow = slow.getNext();
			}
			return slow;
		}
	}

	public void printreverse() {

		printreverse(head);

	}

	private void printreverse(Node tmp) {
		if (tmp == null)
			return;
		else {
			printreverse(tmp.getNext());
			System.out.print(tmp.getData() + " ");
		}
	}

	public void reverse() {

		Node prev = null;
		Node cur = head;
		Node next = head;
		while (cur != null) {
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		head = prev;
	}

	public void reverseRecu() {
		Node prev = null;
		Node cur = head;
		Node next = head;
		head = reverserecursion(cur, prev);
	}

	private Node reverserecursion(Node cur, Node prev) {

		if (cur == null) {
			return prev;
		}
		Node next = cur.getNext();
		cur.setNext(prev);
		return reverserecursion(next, cur);
	}

	protected Node getHead() {
		return head;
	}

	public void addAll(int arr[]) {

		Node temp = head;
		if (head != null) {
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
		}
		for (int i : arr) {
			Node n = new Node(i);
			if (head == null) {
				head = n;
				temp = head;
				size++;
			} else {
				temp.setNext(n);
				temp=n;
				size++;
			}
		}
	}

	public void createCycle() {

		Node temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(getMiddleNode());
	}
	/**
	 * Partition the LinkedList based on given data
	 * old LinkedList will not be retained
	 * @return
	 */
	public void partition(int data) {

		Node temp = head;
		if (temp == null) {
			System.out.println("LinkedList is empty");
			
		}
		else{
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
			head=ah;
		else
			head=bh;
		}
	}
}
