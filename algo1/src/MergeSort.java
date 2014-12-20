/**
 * Created by naser on 10/11/14.
 */
public class MergeSort {
    static final int N = 9;
    static int[] list = {5, 4, 1, 8, 7, 2, 6, 3, 0};
    static int[] aux = new int[N];

    public static void merge(int lo1, int lo2, int hi) {
        for(int i = lo1; i <= hi; i++)
            aux[i] = list[i];

        int i = lo1, j = lo2, k = lo1;
        while(i < lo2 && j <= hi) {
            if (aux[i] < aux[j])
                list[k++] = aux[i++];
            else
                list[k++] = aux[j++];
        }
        while(i < lo2) list[k++] = aux[i++];
        while(j <= hi) list[k++] = aux[j++];
    }
    public static void sort(int lo, int hi) {
        if(lo >= hi) return;

        int mid = (lo+hi) / 2;
        sort(lo, mid);
        sort(mid+1, hi);
        merge(lo, mid+1, hi);
    }
    static void mergeSort(int[] a){
        sort(0, a.length-1);
    }
    public static void main(String[] args) {

        for(int i = 0; i < N; i++)
            System.out.print(list[i]+" ");
        System.out.printf("\nAfter Sort:\n");
        mergeSort(list);
        for(int i=0; i<aux.length; i++)
            System.out.print(list[i]+" ");
    }
}
