package collection.queue;

public class Utilities {

	public static <T> void reverse(Queue q) {

		if (q.isEmpty()) {
			return;
		}
		T x =  (T) q.dequeue();
		reverse(q);
		q.enqueue(x);

	}

}
