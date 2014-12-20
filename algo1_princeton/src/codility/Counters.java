package codility;

/**
 * Created by naser on 3/21/14.
 */
public class Counters {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 7
        int M = A.length;
        int[] counters = new int[N];
        for (int k = 0; k < M; k++) {
            if (A[k] <= N && A[k] >= 1) {
                counters[A[k]-1] += 1;
            } else if (A[k] == N + 1) {
                setCounters(counters, getMax(counters));
            } else {
                // @FIXME
            }
        }
        return counters;
    }

    private void setCounters(int[] A, int value) {
        for (int i = 0; i < A.length; i++) {
            A[i] = value;
        }
    }
    private int getMax(int[] A) {
        int max = -1;
        for(int i = 0; i < A.length; i++) {
            if (A[i] > max) max = A[i];
        }
        return max;
    }
}
