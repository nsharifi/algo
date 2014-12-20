/**
 * Created by naser on 11/23/14.
 */
public class Heap {
    private int[] data;
    private int cursor;

    // TODO implement self-resizing array
    // TODO implement heapify and delte arbitrary object O(n), O(logn) respectively
    // todo Heap sort
    // todo median maintenance

    public Heap(int size) {
        this.data = new int[size];
        this.cursor = -1;
    }
    public Heap() {
        this.data = new int[1000];
        this.cursor = -1;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }
    private int getLeftChild(int index) {
        // TODO check boundary cases
        return 2 * index + 1;
    }
    private int getRightChild(int index) {
        // TODO check boundary cases
        return 2 * index + 2;
    }
    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    private void swimUp() {
        int index = cursor;
        int temp;
        while(index > 0 && data[index] < data[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }
    private void swimDown() {
        // FIXME do not allow access to non-existing cells
        int index = 0;
        int tempIndex;
        while(index <= (cursor-1)/2) {
            if(data[getLeftChild(index)] < data[getRightChild(index)])
                tempIndex = getLeftChild(index);
            else
                tempIndex = getRightChild(index);

            if(data[index] > data[tempIndex]) {
                swap(index, tempIndex);
                index = getLeftChild(tempIndex);
            } else {
                break;
            }
        }
    }

    public void insert(int item) {
        data[++cursor] = item;
        swimUp();
    }
    public int getMin() { return data[0]; }
    public void delete() {
        data[0] = data[cursor--];
        swimDown();
    }
    public boolean isEmpty() { return cursor == -1; }
    public int size() { return cursor + 1; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i = 0; i <= cursor; i++) {
            sb.append(data[i] + ", ");
        }

        return sb.toString() + "}";
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(10);
        h.insert(20);
        h.insert(30);
        h.insert(5);
        h.insert(8);
        h.insert(100);
        h.insert(2);
        System.out.println(h);
        h.delete();
        System.out.println(h);
    }
}
