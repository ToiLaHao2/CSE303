import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        EIUDEPRE();
    }

    public static void EIPMOD() {
        long x, n, k;
        x = nl();
        n = nl();
        k = nl();

        System.out.println(powerMod(x, n, k));
    }

    public static long powerMod(long x, long n, long k) {
        if (n == 0) {
            return 1 % k;
        }
        long result = powerMod(x, n / 2, k);
        result = (result * result) % k; // Đảm bảo x nhỏ hơn k

        if (n % 2 != 0) {
            result = (result * x) % k;
        }
        return result;
    }

    public static void EISUBSET2() {
        int n, k;
        n = ni();
        k = ni();
        List<Integer> subsets = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int numIn = ni();
            subsets.add(numIn);
            int temp = subsets.size() - 1;
            for (int j = 0; j < temp; j++) {
                subsets.add(numIn + subsets.get(j));
            }
        }

        for (Integer integer : subsets) {
            if (integer == k) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void EIUDEPRE() {
        int n;
        long c, r;
        n = ni();
        c = nl();
        r = nl();

        DecimalFormat df = new DecimalFormat("#.######");

        double left = 0;
        double right = 1;
        double mid = 0;

        while (right - left > 0.0000001) {
            mid = (left + right) / 2;

            double currentValue = resultAfterYears(c, n, mid);

            if (currentValue >= r) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // double result = (right + mid) / 2;
        System.out.println(df.format(mid));
    }

    public static double resultAfterYears(long c, int n, double rate) {
        double result = c;
        for (int i = 0; i < n; i++) {
            result *= (1 - rate + rate * i / n);
        }
        return result;
    }

    public static void EIDIVIDE() {
        int n, L, R;
        n = ni();
        L = ni();
        R = ni();

    }

    // Bộ reader mới
    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    static double nd() {
        return Double.parseDouble(ns());
    }

    static char nc() {
        return (char) skip();
    }

    static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}
