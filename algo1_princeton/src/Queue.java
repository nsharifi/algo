import java.util.Stack;

/**
 * Created by naser on 3/6/14.
 */
//public class QueueOfStrings {
//    private Node front;
//    private Node back;
//    private class Node {
//        String item;
//        Node previous;
//        Node next;
//    }
//
//    public void enque(String item) {
//        Node n = new Node();
//        n.item = item;
//        if (front == null) {
//            back = front = n;
//            return;
//        }
//        if (back == front) {
//            back = n;
//            back.previous = front;
//            front.next = back;
//            back.next = front.previous = null;
//            return;
//        }
//        back.next = n;
//        n.previous = back;
//        back = n;
//    }
//
//    public String deque() {
//        // Check empty?
//        String item;
//        if (front == back) {
//            item = back.item;
//            front = back = null;
//            return item;
//        }
//        item = front.item;
//        //front.previous.next = null;
//        front = front.next;
//        front.previous = null;
//
//        return item;
//    }
//
//    boolean isEmpty() {
//        return (front == null);
//    }

//  Single-linked list
    /*private Node first;
    private Node last;
    private class Node {
        String item;
        Node next;
    }

    public void enqueue(String item) {
        Node n = new Node();
        n.item = item;
        if (first == null) {
            first = last = n;
            return;
        }
        if (first == last) {
            last = n;
            first.next = last;
        }
        Node oldLast = last;
        last = n;
        oldLast.next = last;
    }

    public String dequeue() {
        String item;
        if(first == last) {
            item = first.item;
            first = last = null;
            return item;
        }
        item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }
}*/
    // Array implementation
class Queue<Item> {
    private Item[] q;
    private int head;
    private int tail;

    public void enqueue(Item item) {
        if (isEmpty()) {
            head = tail = 0;
            q[tail] = item;
            return;
        }
        if (tail == q.length-1) {
            resize(2 * q.length);
        }
        q[++tail] = item;
    }

    public Item dequeue() {
        Item item;
        if(head == tail) {
            item = q[head];
            head = tail = -1;
            return item;
        }
        return q[head++];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    private void resize(int c) {
        Item[] newQ = (Item[])new Object[c];
        for (int i = 0; i < q.length; i++) {
            newQ[i] = q[i];
        }
        q = newQ;
    }

    Queue(int size) {
        q = (Item[])new Object[size];
        head = tail = -1;
    }

    public static void main(String[] args) {
        Queue q = new Queue<String>(2);
        System.out.println(q.isEmpty());
        q.enqueue("item 1");
        System.out.println(q.dequeue());
        q.enqueue("item 2");
        q.enqueue("item 3");
        q.enqueue("item 4");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
