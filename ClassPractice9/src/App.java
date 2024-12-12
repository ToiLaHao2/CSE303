import java.io.*;
// import java.text.DecimalFormat;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        EIUCOL();
    }

    // EIUCOL
    public static void EIUCOL() {
        var moneys = ni();

        var values = new int[3];
        for (var i = 0; i < 3; i++) {
            values[i] = ni();
        }

        var MIN = Integer.MIN_VALUE / 2;
        var minWays = new int[moneys + 1];
        Arrays.fill(minWays, MIN);
        minWays[0] = 0;

        for (var i = 0; i < 3; i++) {
            for (var j = values[i]; j <= moneys; j++) {
                minWays[j] = Math.max(minWays[j], minWays[j - values[i]] + 1);
            }
        }
        System.out.println(minWays[moneys] > MIN ? minWays[moneys] : -1);
    }

    // EITHIEF2
    public static void EITHIEF2() {
        int numberItems = ni();
        int p = ni(); // so can nang Tan co the vac
        int[][] items = new int[numberItems][2];

        for (int i = 0; i < numberItems; i++) {
            items[i][0] = ni();
            items[i][1] = ni();
        }

        System.out.println(calMaxThief(numberItems, p, items));
    }

    public static long calMaxThief(int numberItems, int p, int[][] items) {
        long[] dp = new long[p + 1];

        for (int i = 0; i < numberItems; i++) {
            int weight = items[i][0];
            int value = items[i][1];
            for (int j = p; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }
        return dp[p];
    }

    // EISTORE
    public static void EISTORE() {
        int numberTypes = ni();
        int money = ni();

        int[] values = new int[numberTypes];
        for (int i = 0; i < numberTypes; i++) {
            values[i] = ni();
        }

        int result = minItems(numberTypes, money, values);
        System.out.println(result);
    }

    public static int minItems(int numberTypes, int money, int[] values) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int value : values) {
            for (int j = value; j <= money; j++) {
                if (dp[j - value] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - value] + 1);
                }
            }
        }

        if (dp[money] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[money];
        }

    }

    // EIUDP2
    // EIBORE
    public static void EIBORE() {
        int numbers = ni();
        int[] arr = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i] = ni();
        }

        System.out.println(calMax(numbers, arr));
    }

    public static int calMax(int numbers, int[] arr) {
        int maxValue = 100_000;

        int[] arr2 = new int[maxValue + 1];

        for (int value : arr) {
            arr2[value]++;
        }

        int[] dp = new int[maxValue + 1];
        dp[1] = arr2[1];

        for (int i = 2; i <= maxValue; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * arr2[i]);
        }

        return dp[maxValue];
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
