/**
 * Created by naser on 3/17/14.
 * Binary heap implementation of priority queue
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }
    public MaxPQ(Key[] keys) {

    }
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }
    public Key delMax() {
        Key v = pq[1];
        pq[1] = pq[N--];
        pq[N+1] = null;
        sink(1);
        return v;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key max() {
        return pq[1];
    }

    public int size() {
        return pq.length;
    }

    private void sink(int k) {
        int j;
        while (k * 2 < N) {
            j = k * 2;
            if (Sort.less(pq[j], pq[j + 1])) j++;
            if (Sort.less(pq[k], pq[j])) Sort.exch(pq, k, j);
            k = j;
        }
    }
    private void swim(int k) {
        while(k > 1 && Sort.less(pq[k / 2], pq[k])) {
            Sort.exch(pq, k / 2, k);
            k = k / 2;
        }
    }
    private void print() {
        for (int i = 1; i <= N; i++) {
            System.out.println(pq[i]);
        }
    }
    public static void main(String[] args) {
        MaxPQ<Integer> pq1 = new MaxPQ<Integer>(15);
        pq1.insert(4);
        pq1.insert(2);
        pq1.insert(5);
        pq1.insert(7);
        pq1.insert(1);
        pq1.insert(10);
        pq1.print();
        System.out.println("Delmax: " + pq1.delMax());
        pq1.print();
    }
}
