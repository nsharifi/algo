/**
 * Created by naser on 11/1/14.
 */
public class QuickSort {
    private static long compareCounter = 0;

    private static int choosePivot(long[] a, int l, int r) {
        return l;
    }

    private static int findMedian(long[] a, int l, int r) {
        int m = (l+r)/2;
        if (a[l] <= a[m] && a[l] >= a[r] || a[l] >= a[m] && a[l] <= a[r]) return l;
        if (a[m] <= a[l] && a[m] >= a[r] || a[m] >= a[l] && a[m] <= a[r]) return m;
        return r;
    }

    public static void sort(long[] a, int l, int r) {
        if (r <= l) return;
        compareCounter += r-l;
        int median = findMedian(a, l, r);
        int pivotPos = partition(a, l, r, median);
        sort(a, l, pivotPos-1);
        sort(a, pivotPos+1, r);
    }

    private static int partition(long[] a, int l, int r, int pivot) {
        long p = a[pivot];
        a[pivot] = a[l];
        a[l] = p;

        int i = l + 1;
        for (int j = l+1; j <= r; j++) {
            if (a[j] < p) {
                long temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        long temp = a[l];
        a[l] = a[i-1];
        a[i-1] = temp;
        return i-1;
    }

    public static void main(String[] args) {
        long[] a = FileService.textToArray("./src/QuickSort.txt");
        sort(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("# Compares: " + compareCounter);
    }
}
