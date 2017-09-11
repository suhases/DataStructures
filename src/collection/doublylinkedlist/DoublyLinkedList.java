package collection.doublylinkedlist;

public class DoublyLinkedList {

	private DNode head;
	private int size;

	public void add(int data) {
		DNode n = new DNode(data);
		if (head == null) {
			head = n;
			size++;
		} else {
			DNode temp = head;

			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(n);
			n.setPrev(temp);
			size++;
		}
	}

	public boolean isEmpty() {
		if (head == null && size == 0)
			return true;
		return false;
	}

	public void traverse() {
		DNode temp = head;

		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}

	public void delete(int data) {

		if (head.getData() == data) {
			DNode temp = head;
			head = head.getNext();
			temp.setNext(null);
			head.setPrev(null);
			size--;
		} else {
			DNode temp = head;

			while (temp != null) {

				if (temp.getData()==data) {
					
					temp.getPrev().setNext(temp.getNext());
					temp.getNext().setPrev(temp.getPrev());
					temp.setNext(null);
					temp.setPrev(null);
					size--;
					break;//exits while loop
					
				}
				temp = temp.getNext();
			}
		}
	}
}
