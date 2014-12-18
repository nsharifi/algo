import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class CountInversions {

    static long countInvNaive(int[] a)
    {
        long inv_count = 0;
        int i, j;
        int n = a.length;
        for(i = 0; i < n - 1; i++)
            for(j = i+1; j < n; j++)
                if(a[i] > a[j])
                    inv_count++;

        return inv_count;
    }

    public static void main(String[] args) {
        String inputFile = "./src/IntegerArray.txt";
        int[] a = null;
        BufferedReader br = null;
        List<Integer> tmpList = new ArrayList<Integer>();
        try {
            br = new BufferedReader(new FileReader(inputFile));
            String line;
            while((line = br.readLine()) != null) {
                tmpList.add(Integer.parseInt(line));
            }
            br.close();
            a = new int[tmpList.size()];
            for(int i = 0; i < a.length; i++)
                a[i] = tmpList.get(i);
        } catch(Exception e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < a.length; i++) System.out.println(a[i]);
        int[] arr = {1, 20, 6, 4, 5};
        System.out.println(countInvNaive(a));
    }
}
