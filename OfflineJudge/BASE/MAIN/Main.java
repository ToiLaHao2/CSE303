import java.io.*;
// import java.text.DecimalFormat;
import java.util.*;

class  Main {
    public static void main(String[] args) throws Exception {
        EIULOGGING2();
    }

    // EIJUMP
    public static void EIJUMP() {
        int n = ni();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ni();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // nhảy tới từ hòng đá trước đó
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            // nhảy tới từ hòn đá gần nhất
            if (lastSeen.containsKey(arr[i])) {
                dp[i] = Math.min(dp[i], dp[lastSeen.get(arr[i])] + 1);
            }
            // cập nhật vị trí hiện tại của hòn đá
            lastSeen.put(arr[i], i);
        }
        System.out.println(dp[n - 1]);
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

    }

    // EIDIVIDE
    public static void EIDIVIDE() {

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

