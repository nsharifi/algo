import java.util.ArrayList;
import java.util.List;

/**
 * Created by naser on 11/11/14.
 */
public class Queue {
    private List<Integer> values;

    public Queue() {
        values = new ArrayList<Integer>();
    }

    public void enqueue(int value) {
        values.add(value);
    }

    public int dequeue() {
        int front = values.get(0);
        values.remove(0);
        return front;
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int val : values) {
            sb.append(val + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.dequeue();
        q.dequeue();
        q.enqueue(50);
        q.enqueue(60);
        q.dequeue();
        System.out.println(q);
    }
}
