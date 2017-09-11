package collection.MinPriorityQueue;

public class MinPriorityQueue {

	int pq[];
	int n;

	public MinPriorityQueue(int capacity) {
		pq = new int[capacity + 1];
	}

	public void insert(int x) {

		pq[++n] = x;
		swim(n);
	}
	public int deletemin(){
		int temp=pq[1];
		swap(1,n);
		n--;
		sink(1);
		return temp;
	}
	
	public void heapify(int n){
		int temp=n/2;
		while(temp>=1){
			sink(temp);
			temp--;
		}
	}
	private void sink(int i) {
		int j=0;
		while(j<n){
			j=2*i;
			if(greater(j,j+1) && j<n)i++;
			if(!greater(i,j))break;
			swap(i,j);
			i=j;
		}
	}

	private void swim(int n) {

		while (greater(n/2 , n) || (n != 1)) {
			swap(n / 2, n);
			n = n / 2;
		}
	}

	private void swap(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	private boolean greater(int i, int j) {
		if (pq[i] > pq[j])
			return true;
		else
			return false;
	}
}
