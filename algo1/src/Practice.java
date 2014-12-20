import java.math.BigInteger;

/**
 * Created by naser on 10/11/14.
 */
public class Practice {
    public static void main(String[] args) {
//        int[] a = {1,2,3};
//        int[] b = new int[10];
//        b = a;
//        for(int i = 0; i < b.length; i++) {
//            System.out.println(b[i]);
//        }
//        for(int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//        System.out.println("a:"+a+" and b:"+b);
//        List<Integer> A = new ArrayList<Integer>();
//        List<Integer> B = new ArrayList<Integer>();
//        //A.add(1);
//        B.add(1);
//        System.out.println(A.equals(B));
        BigInteger bi = new BigInteger("10");
        System.out.println("bit len bi: " + bi.bitLength());
//        System.out.println("12345%100: " + bi.mod(new BigInteger("100")));
//        System.out.println("12345/100: " + bi.divide(new BigInteger("100")));
//        System.out.println("10^2: " + bi.shiftLeft(2));
        System.out.println("shift 1 right of 10: " + bi.shiftRight(2));
    }
}
