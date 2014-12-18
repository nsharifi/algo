import java.math.BigInteger;

/**
 * Created by naser on 10/11/14.
 */
public class Karatsuba {

    public static BigInteger kMultiply(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);

        N = N / 2 + N % 2;
        BigInteger a = x.subtract(x.shiftLeft(N));
        BigInteger b = x.shiftRight(N);
        BigInteger c = y.subtract(y.shiftLeft(N));
        BigInteger d = y.shiftRight(N);

        BigInteger ac = kMultiply(a, c);
        BigInteger bd = kMultiply(b, d);
        BigInteger abcd = kMultiply(a.add(b), c.add(d));

        return bd.add(abcd.subtract(ac).subtract(bd).shiftLeft(2*N)).add(ac.shiftLeft(N));
    }


    public static void main(String[] args) {
        BigInteger x = new BigInteger("12345");
        BigInteger y = new BigInteger("56789");
//        test();
        // If length of x != length of y zero-pad the shorter???
        System.out.println(kMultiply(x, y));
    }

}
