import java.io.*;
// import java.text.DecimalFormat;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        EIDIVIDE();
    }

    // EIJUMP
    // public static void EIJUMP() {
    // int n = ni();
    // int[] arr = new int[n];

    // for (int i = 0; i < arr.length; i++) {
    // arr[i] = ni();
    // }

    // int[] dp = new int[n];
    // Arrays.fill(dp, Integer.MAX_VALUE);
    // dp[0] = 0;

    // Map<Integer, Integer> lastSeen = new HashMap<>();

    // for (int i = 0; i < n; i++) {
    // // nhảy tới từ hòng đá trước đó
    // if (i > 0) {
    // dp[i] = Math.min(dp[i], dp[i - 1] + 1);
    // }
    // // nhảy tới từ hòn đá gần nhất
    // if (lastSeen.containsKey(arr[i])) {
    // dp[i] = Math.min(dp[i], dp[lastSeen.get(arr[i])] + 1);
    // }
    // // cập nhật vị trí hiện tại của hòn đá
    // lastSeen.put(arr[i], i);
    // }
    // System.out.println(dp[n - 1]);
    // }

    public static void EIJUMP() {
        // int n = ni();
        // int[] arr = new int[n];
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = ni();
        // }

        // int[] dp = new int[n];
        // dp[0] = 0;
        // Map<Integer, Integer> lastSeen = new HashMap<>();
        // for (int i = 0; i < n; i++) {
        // if (i > 0) {
        // dp[i] = Math.min(dp[i], dp[i - 1] + 1);// nhảy tới từ hòn đá trước đó
        // }
        // if (lastSeen.containsKey(arr[i])) {
        // dp[i] = Math.min(dp[i], dp[lastSeen.get(arr[i])] + 1);
        // }
        // lastSeen.put(arr[i], i);
        // }
        // System.out.println(dp[n - 1]);

        int n = ni();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ni();
        }

        int[] dp = new int[n];
        dp[0] = 0;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);//
            }
            if (lastSeen.containsKey(arr[i])) {
                dp[i] = Math.min(dp[i], dp[lastSeen.get(arr[i])] + 1);
            }
            lastSeen.put(arr[i], i);
        }
    }

    // EIULOGGING2
    public static void EIULOGGING2() {
        int numberOfLogs = ni();
        long[] logs = new long[numberOfLogs];
        long result = 0;

        if (numberOfLogs == 1) {
            result = Math.max(result, nl());
        } else if (numberOfLogs == 2) {
            for (int i = 0; i < numberOfLogs; i++) {
                result = Math.max(result, nl());
            }
        } else {
            for (int i = 0; i < logs.length; i++) {
                logs[i] = nl();
            }
            long[] dp = new long[numberOfLogs];
            dp[0] = Math.max(0, logs[0]);
            dp[1] = Math.max(dp[0], logs[1]);
            dp[2] = Math.max(dp[1], logs[2]);

            for (int i = 3; i < numberOfLogs; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 3] + logs[i]);
            }

            result = dp[numberOfLogs - 1];
        }

        System.out.println(result);
    }

    // EIULOGGING3
    public static void EIULOGGING3() {
        int numberOfLogs = ni();
        long MOD = 1_000_000_007;

        long[] logs = new long[numberOfLogs + 1];
        long[] count = new long[numberOfLogs + 1];
        logs[0] = 0;
        count[0] = 1;
        logs[1] = Math.max(nl(), logs[0]);
        count[1] = logs[1] > 0 ? 1 : 1;

        for (int i = 2; i < numberOfLogs + 1; i++) {
            long value = nl(); // Giá trị cây thứ i

            // Tính giá trị tối đa tại cây i
            if (logs[i - 1] > logs[i - 2] + value) {
                logs[i] = logs[i - 1];
                count[i] = count[i - 1];
            } else if (logs[i - 2] + value > logs[i - 1]) {
                logs[i] = logs[i - 2] + value;
                count[i] = count[i - 2];
            } else { // logs[i-1] == logs[i-2] + value
                logs[i] = logs[i - 1];
                count[i] = (count[i - 1] + count[i - 2]) % MOD;
            }
        }

        System.out.println(logs[numberOfLogs] + " " + count[numberOfLogs]);

        // 3 1 3 3 2 2
        // 0 3 3 6 6 8 8
        // 1 1 2 2 3 3
    }

    static long result = 0;

    // EIDIVIDE
    public static void EIDIVIDE() {
        long n = nl();
        long l = nl(); // range
        long R = nl(); // range

        int log2 = (int) (Math.log(n) / Math.log(2));
        long middle = 0;

        for (var i = 0; i < log2; i++) {
            middle += (1L << i);
        }

        if (middle == n) {
            middle = (middle - 1) / 2;
        }
        divideAndConquer(n, l, R, middle + 1, (middle + 1) / 2);
        System.out.println(result);

    }

    public static void divideAndConquer(long n, long l, long r, long i, long depth) {
        if (n == 2 || n == 3) {
            long left = i - 1;
            long right = i + 1;

            if (left >= l && left <= r) {
                result += 1;
            }
            if (right >= l && right <= r) {
                result += 1;
            }
            if (n == 3 && l <= i && i <= r) {
                result += 1;
            }
            return;
        }

        if (l <= i && i <= r) {
            result += n % 2;
        }
        if (l < i) {
            divideAndConquer(n / 2, l, r, i - depth, depth / 2);
        }
        if (r > i) {
            divideAndConquer(n / 2, l, r, i + depth, depth / 2);
        }
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
