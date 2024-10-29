import java.io.*;
import java.util.*;

class  Main {
    public static void main(String[] args) throws Exception {
        EIUSUBSET();
    }

    public static void EIEQUALS() {
        // Ý tưởng : tính tổng 2 dãy r lấy abs 2 tổng nếu lớn hơn k thì out, còn không
        // làm tiếp
        // dùng 2 con trỏ đếm xem bao nhiêu số khác nhau, nếu có nhiều hơn 1 thì no còn
        // khôn thì yes
        int n = ni();
        int k = ni();
        int count1 = 0;
        int count2 = 0;
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = ni();
            count1 += arrA[i];
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = ni();
            count2 += arrB[i];
        }

        if (Math.abs(count1 - count2) > k) {
            System.out.println("NO");
        } else {
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            int temp = 0;
            int i = 0;
            int j = 0;
            while (i < n && j < n && temp > 1) {
                if (arrA[i] == arrB[j]) {
                    i++;
                    j++;
                } else if (arrA[i] < arrB[j]) {
                    i++;
                    temp++;
                } else {
                    j++;
                }
            }
            if (temp > 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public static void EIUSUBSET() {
        int n = ni();
        ArrayList<Integer> sets = new ArrayList<>();
        ArrayList<String> subsets = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sets.add(ni());
        }

        for (int i = sets.size() - 1; i >= 0; i--) {
            subsets.add(String.valueOf(sets.get(i)));
            int temp = subsets.size() - 1;
            for (int j = 0; j < temp; j++) {
                subsets.add(sets.get(i) + " " + subsets.get(j));
            }
        }

        sb.append(subsets.size() + "\n");
        for (String string : subsets) {
            sb.append(string + "\n");
        }
        System.out.println(sb);
    }

    public static void EIUQBHV() {
        String input = ns();

        TreeSet<String> output = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        char[] keyCharacters = input.toCharArray();
        output.add("");

        for (char newChar : keyCharacters) {
            TreeSet<String> newOutput = new TreeSet<>();
            for (String key : output) {
                for (int i = 0; i <= key.length(); i++) {
                    String newKey = key.substring(0, i) + newChar + key.substring(i);
                    newOutput.add(newKey);
                }
            }
            output.clear();
            output.addAll(newOutput);
        }
        for (String key : output) {
            sb.append(key + "\n");
        }
        System.out.println(output.size() + "\n" + sb);
    }

    // public static void EIFLIP() {

    // }

    // public class Node {
    // private int x;
    // private int y;
    // private char value;

    // public Node(int x, int y, char value) {
    // this.x = x;
    // this.y = y;
    // this.value = value;
    // }
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

