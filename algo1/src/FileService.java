import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by naser on 11/2/14.
 */
public class FileService {
    public static long[] textToArray(String fileName) {
        long[] a = null;
        BufferedReader br = null;
        List<Long> tmpList = new ArrayList<Long>();
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) != null) {
                tmpList.add(Long.parseLong(line));
            }
            br.close();
            a = new long[tmpList.size()];
            for(int i = 0; i < a.length; i++)
                a[i] = tmpList.get(i);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public static List<String> readLines(String fileName) {
        List<String> lines = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) != null) {
                lines.add(line.trim());
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
