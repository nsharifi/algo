import java.util.HashMap;

/**
 * Created by naser on 11/26/14.
 */
public class TwoSum {

    public static boolean twoSum(long[] list, long t) {
        for(int i = 0; i < list.length; i++);
        return false;
    }
    public static void main(String[] args){
        long[] numbers = FileService.textToArray("./src/algo1-2sum.txt");
        HashMap<Long,Long> nums = new HashMap<Long, Long>();
//        HashSet<Long> nums = new HashSet<Long>();
        for(int i = 0; i < numbers.length; i++)
            nums.put(numbers[i], numbers[i]);
//            nums.add(numbers[i]);
        System.out.println("dist: " + nums.size());
//        System.out.println("item: " + nums.contains(56619844751L));
        int count = 0;
        for (long t = -10000L; t <= 10000L; t++) {
            for(int i = 0; i < numbers.length; i++) {
                if(!nums.containsKey(numbers[i])) break;
                if(nums.containsKey(t - numbers[i])) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);

//            System.out.println(numbers[i]);
//        QuickSort qs = new QuickSort();
//        qs.sort(numbers, 0, numbers.length-1);
    }
}
