import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // EIUGAME();
    }

    // EIUGAME2 - The number of path
    public static void EIUGAME2() {

    }

    // EIUMEDARRAY4
    public static void EIUMEDARRAY4() {

    }

    // EIAPPLEBOX
    public static void EIAPPLEBOX() {
        int numOfTest = ni();
        for (int i = 0; i < numOfTest; i++) {
            int n, a;
            long p;
            n = ni();
            a = ni();
            p = nl();
        }
    }

    // public static void EIUGAME() {
    // int n = ni();
    // int m = ni();

    // int[][] matrix = new int[n][m];

    // for (int[] is : matrix) {
    // for (int j = 0; j < is.length; j++) {
    // is[j] = ni();
    // }
    // }

    // int max = matrix[0][0];

    // int i = 0;
    // int j = 0;

    // while (i < n - 1 || j < m - 1) {
    // if (j == m - 1) {
    // // Nếu đang ở cột cuối cùng, chỉ có thể đi xuống
    // max += matrix[i + 1][j];
    // i++;
    // } else if (i == n - 1) {
    // // Nếu đang ở hàng cuối cùng, chỉ có thể đi sang phải
    // max += matrix[i][j + 1];
    // j++;
    // } else if (matrix[i][j + 1] > matrix[i + 1][j]) {
    // // Chọn sang phải
    // max += matrix[i][j + 1];
    // j++;
    // } else {
    // // Chọn đi xuống
    // max += matrix[i + 1][j];
    // i++;
    // }
    // }

    // System.out.println(max);
    // }

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
