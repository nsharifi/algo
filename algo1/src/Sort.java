import java.util.Random;

/**
 * Created by naser on 3/7/14.
 */
public class Sort {
    public static final int CUTOFF = 7;
    //public static Integer[] a = { 5, 3, 4, 2, 1 };
    public static Integer[] b = { 1, 2, 3, 4, 5 };
    public static Integer[] c = { 5, 4, 3, 2, 1 };

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for(int i = lo+1; i <= hi; i++) {
            if (Sort.less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void insertionSort(Comparable[] a, int lo, int hi) {

    }
    public static void insertionSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1]))
                    exch(a, j, j-1);
                else break;
            }
        }
    }
    public static void selectionSort(Comparable[] a) {
        int i, j, min;
        for(i = 0; i < a.length; i++) {
            min = i;
            for (j = i+1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int h = 0;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j = j - h)
                    exch(a, j, j - h);
            }
            h = h / 3;
        }
    }

    public static void shuffle(Comparable[] a) {
        Random r = new Random();
        int N = a.length;
        for(int i = 0; i < N; i++) {
            int nextRand = r.nextInt(N);
            exch(a, i, nextRand);
        }
    }

    public static void print(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
    public static void main(String[] args) {
//        selectionSort(a);
//        insertionSort(b);
//        shellSort(b);
        shuffle(b);
        print(b);
    }
}
