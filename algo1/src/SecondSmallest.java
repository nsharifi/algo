/**
 * Created by naser on 12/6/14.
 */
public class SecondSmallest {

    static int smallest(int[] a, int lo, int hi) {
        if(lo >= hi) return a[lo] < a[hi] ? a[lo] : a[hi];
        int mid = (lo+hi) / 2;
        int x = smallest(a, lo, mid);
        int y = smallest(a, mid+1, hi);
        return x < y ? x : y;
    }
    public static void main(String[] args) {
        int[] a = { 10, 8, 5, -10, 3, 7, 6, 1, 4, 0 };
        System.out.println(smallest(a, 0, a.length-1));
    }
}
