import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        EI2122Q1ADAM2();
    }

    public static void EIPAIR() {
        int numOfT = ni();

        for (int i = 0; i < numOfT; i++) {
            Map<Integer, Integer> gifts = new HashMap<>();
            int numOfG = ni();
            for (int j = 0; j < numOfG; j++) {
                int g = ni();
                gifts.put(g, gifts.getOrDefault(g, 0) + 1);
            }
            long numOfWays = 0;
            for (int g : gifts.values()) {
                numOfWays += (((long) g * ((long) g - 1)) / 2);
            }
            System.out.println(numOfWays);
        }
    }

    public static void EIULOVE() {
        long numOfGift = nl();
        long moneyInPock = nl();
        long giftMax = -1;

        for (int i = 0; i < numOfGift; i++) {
            int temp = ni();
            if (temp > giftMax && temp < moneyInPock) {
                giftMax = temp;
            }
        }

        System.out.println(giftMax);
    }

    public static void EIGIFTS() {
        int numOfGift = ni();
        long moneyInPock = nl();

        long totalAmount = -1;
        long difBtwTGift = Integer.MAX_VALUE;

        long[] gifts = new long[numOfGift];

        for (int i = 0; i < numOfGift; i++) {
            gifts[i] = nl();
        }

        Arrays.sort(gifts);

        int left = 0;
        int right = gifts.length - 1;

        while (left < right) {
            long totalTemp = gifts[left] + gifts[right];

            if (totalTemp > moneyInPock) {
                right--;
            } else {
                long diff = Math.abs(gifts[left] - gifts[right]);

                if (totalTemp > totalAmount || (totalTemp == totalAmount && diff < difBtwTGift)) {
                    totalAmount = totalTemp;
                    difBtwTGift = diff;
                }
                left++;
            }
        }

        if (totalAmount == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(totalAmount + " " + difBtwTGift);
        }
    }

    public static void EI2122Q1ADAM1() {
        int n = ni();
        int x = ni();
        int count = 0;
        Map<Integer, Integer> nums = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int temp = ni();

            int target = temp - x;
            if (nums.containsKey(target)) {
                count += nums.get(target);
            }

            nums.put(temp, nums.getOrDefault(temp, 0) + 1);
        }

        System.out.println(count);
    }

    public static void EI2122Q1ADAM2() {
        int n = ni();
        int m = ni();
        int x = ni();
        int count = 0;
        int h = 0;

        int[] men = new int[n];
        int[] women = new int[m];
        Map<Integer, Integer> pairs = new TreeMap<>();

        for (int i = 0; i < men.length; i++) {
            men[i] = ni();
        }

        for (int i = 0; i < women.length; i++) {
            women[i] = ni();
        }

        Arrays.sort(men);
        Arrays.sort(women);

        int high = (men[n - 1] - women[0]) > (women[m - 1] - men[0]) ? (women[m - 1] - men[0])
                : (men[n - 1] - women[0]);
        int mid = high / 2;

        for (int i = 0; i < men.length; i++) {
            for (int j = 0; j < women.length; j++) {
                int diff = Math.abs(men[i] - women[j]);
                if (diff < mid) {
                    pairs.put(diff, pairs.getOrDefault(diff, 0) + 1);
                } else {
                    break;
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
            h = entry.getKey();
            Integer value = entry.getValue();
            count += value;
            if (count > x) {
                break;
            }
        }

        System.out.println(h);
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
