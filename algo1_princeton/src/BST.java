/**
 * Created by naser on 3/25/14.
 * BST implementation of symbol table
 */
public class BST<Key extends Comparable<Key>, Value> {
    Node root;

    /**
     * search operation
     * return value corresponding to key or null
     */
    public Value get(Key key) {
        return null;
    }

    /**
     * insert operation
     */
    public void put(Key key, Value value) {
        return;
    }

    /**
     * Find the largest key smaller than key
     */
    public Value floor(Key key) {
        return null;
    }
    /**
     * Find the smallest key larger than key
     */
    public Value ceiling(Key key) {
        return null;
    }

    public int size() {
        return -1;
    }
    public int rank(Key key) {
        return -1;
    }

    public Iterable<Key> keys() {
        return null;
    }

    public void deleteMin() {
        return;
    }

    /**
     * Hibbard deletion
     */
    public void delete(Key key) {

    }
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int count;
        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

}

