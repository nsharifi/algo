/**
 * Created by naser on 11/22/14.
 */
public class PriorityQueue {
    //TreeSet<Integer> set = new TreeSet<Integer>();
    Heap heap;

    public PriorityQueue () {
        heap = new Heap();
    }

    public void enqueue(int item) { heap.insert(item); }
    public int dequeue() {
        int item = heap.getMin();
        heap.delete();
        return item;
    }
    public void add(int item) { heap.insert(item); }
    public int poll() { return heap.getMin(); }
    public boolean isEmpty() { return heap.isEmpty(); }
    public int size() { return heap.size(); }

    public static void main(String[] args){
        PriorityQueue q = new PriorityQueue();
        q.enqueue(0);
        q.enqueue(-3);
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.heap.size());
        System.out.println(q);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
