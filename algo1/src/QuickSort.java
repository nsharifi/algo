/**
 * Created by naser on 3/15/14.
 */
public class QuickSort {
    private static Integer[] b = { 5, 3, 4, 2, 1 };

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while(true) {
            while (Sort.less(a[++i], a[lo]))
                if (i == hi) break;

            while (Sort.less(a[lo], a[--j]))
                if (j == lo) break;

            if (i >= j) break;
            Sort.exch(a, i, j);
        }

        Sort.exch(a, lo, j);
        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // cut of to insertion sort for small sizes (<= 10?)
        if (hi <= lo + Sort.CUTOFF - 1)
        {
            Sort.insertionSort(a, lo, hi);
            return;
        }
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static void sort3Way(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) Sort.exch(a, lt++, i++);
            else if (cmp > 0) Sort.exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


    public static void sort(Comparable[] a) {
        System.out.println("Before shuffling:");
        Sort.print(a);
        Sort.shuffle(a);
        System.out.println("After shuffling:");
        Sort.print(a);
        sort(a, 0, a.length - 1);
    }
    public static void main(String[] args) {
        Sort.print(Sort.c);
        sort(Sort.c);
        System.out.println("After quick sorting: ");
        Sort.print(Sort.c);
    }
}
