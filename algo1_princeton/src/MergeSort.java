class MergeSort {
	static int N = 10;
	static int[] b = new int[N];
    static int[] c = new int[N];
    static int[] d = new int[N];

	public static void main(String[] args) {
		int[] a = { 8, 4, 5, 0, 2, 9, 6, 1, 7, 3};
		mergeSort(a, 0, N-1);
		for (int i = 0; i < N; i++)
			System.out.println(a[i]);
		
	}

    static void mergeSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);

        for (int k = lo; k <= mid; k++)
            b[k-lo] = a[k];
        for (int k=mid+1; k <= hi; k++)
            c[k-mid-1] = a[k];

        b[mid-lo+1] = Integer.MAX_VALUE;
        c[hi-mid] = Integer.MAX_VALUE;
        int i = 0; int j = 0;
        for (int k = lo; k <= hi ; k++) {
            if (c[i] < b[j]) a[k] = c[i++];
            else a[k] = b[j++];
        }
    }


    static void mergeSort3Part(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        int per1 = lo + (hi - lo) / 3;
        int per2 = lo + ((hi - lo) * 2) / 3;
        mergeSort(a, lo, per1);
        mergeSort(a, per1+1, per2);
        mergeSort(a, per2+1, hi);

        for (int k = lo; k <= per1; k++)
            b[k-lo] = a[k];
        for (int k=per1+1; k <= per2; k++)
            c[k-per1-1] = a[k];
        for (int k=per2+1; k <= hi; k++)
            d[k-per2-1] = a[k];

        b[per1-lo+1] = Integer.MAX_VALUE;
        c[per2-per1] = Integer.MAX_VALUE;
        d[hi-per2] = Integer.MAX_VALUE;
        int i = 0, j = 0, k = 0;
        for (int l = lo; l <= hi ; l++) {
            if (c[i] < b[j] && c[i] < d[k]) a[l] = c[i++];
            else if (b[j] < d[k]) a[l] = b[j++];
            else a[l] = d[k++];
        }
    }
    static void mergeSortNoSenti(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);

        for (int k = lo; k <= mid; k++)
            b[k-lo] = a[k];
        for (int k=mid+1; k <= hi; k++)
            c[k-mid-1] = a[k];

        int i = 0; int j = 0;
        for (int k = lo; k <= hi ; k++) {
            if (c[i] < b[j] && i < mid-lo+1) a[k] = c[i++];
            else if(j < hi-mid) a[k] = b[j++];
        }
    }
}
