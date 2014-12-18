import java.util.Arrays;

/**
 * Created by naser on 11/27/14.
 */
public class MedianMaintenance {
    // FIXME implement heap version
    public static void main(String[] args) {
        long[] numbers = FileService.textToArray("./src/Median.txt");
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            long[] meds = Arrays.copyOf(numbers, i+1);
            Arrays.sort(meds);
            sum += meds[i/2];
        }
        sum = sum % 10000;
        System.out.println(sum);
    }
}
