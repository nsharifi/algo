import java.util.LinkedList;
import java.util.List;

/**
 * Created by naser on 11/12/14.
 */
public class Stack {
    List<Integer> values;

    public Stack() {
        values = new LinkedList<Integer>();
    }

    public void push(int value) {
        values.add(value);
    }

    public int pop() {
        int value = values.get(values.size()-1);
        values.remove(values.size()-1);
        return value;
    }

    public boolean contains(int value) {
        if (values.contains(value)) return true;
        return false;
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public int size() {
        return values.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int value : values) {
            sb.append(value + " ");
        }
        return sb.toString();
    }
}
