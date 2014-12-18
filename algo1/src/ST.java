/**
 * Created by naser on 3/25/14.
 *
 * Symbol table (elementary implementation)
 *
 * value type: any generic type
 * key type: comparable, equals; compareTo takes precedence over equals if implemented
 */
public class ST<Key, Value> {
    public ST() {

    }

    public void put(Key k, Value v) {

    }

    public Value get(Key k) {
        return null;
    }

    public void delete(Key k) {
        put(k, null);
    }

    public boolean contains(Key k) {
        return get(k) != null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return -1;
    }

    public Iterable<Key> keys() {
        return null;
    }
}
