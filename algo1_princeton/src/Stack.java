/**
 * Created by naser on 2/25/14.
 */

import lib.*;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private int N = 0;
    private Item[] stack;

    @Override public Iterator<Item> iterator() { return new ListIterator(); }
    private class ListIterator implements Iterator<Item> {
        private int current = N;
        public boolean hasNext() { return current >= 0; }
        public void remove() { /* Not implemented */ }
        public Item next() {
            Item itm = stack[current--];
            return itm;
        }

    }

    Stack() {
        stack = (Item[])new Object[1];
    }
    public Item pop() {
//        if (top < 0) {
//            System.err.println("Stack underflows!");
//            return "Stack underflows!";
//        }

        // Resize if necessary
        if (N > 0 && N == stack.length/4) {
            resize(stack.length/2);
        }
        return stack[--N];
    }

    public void push(Item elem) {
//        if(top >= SIZE) {
//            System.err.println("Stack overflows!");
//            return;
//        }
        // Resize happens here
        if (N == stack.length) {
            resize(2 * stack.length);
        }

        stack[N++] = elem;
    }
    private void resize(int n) {
        Item[] newStack = (Item[])new Object[n];
        for (int i = 0; i < N; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N <= 0;
    }

//    private class Node {
//        String item;
//        Node next;
//    }
//
//    private Node first;
//
//    public Stack() {
////        first = new Node();
////        oldFirst = first;
//    }
//    public boolean isEmpty() {
//        return first == null;
//    }
//
//    public void push(String elem) {
//        Node n = new Node();
//        n.item = elem;
//        if (isEmpty()) {
//            first = n;
//        } else {
//            n.next = first;
//            first = n;
//        }
//    }
//    public String pop() {
//        if (first == null) {
//            System.err.println("Stack underflows!");
//            return "Stack underflows!";
//        }
//        String elem = first.item;
//        first = first.next;
//
//        return elem;
//    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("item 1");
        s.push("item 2");
        s.push("item 3");
        for (String string: s) {
            System.out.println(string);
        }
//        System.out.println("Size: " + s.size());
//        System.out.println(s.pop());
//        while(!StdIn.isEmpty()) {
//            String s = StdIn.readString();
//            if(s.equals("-")) StdOut.println(stack.pop());
//            else stack.push(s);
//        }
    }
}
