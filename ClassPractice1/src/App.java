import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        // EIMIN();
        EIUQBHV();
    }

    public static void EIMIN() {
        int n = ni();
        int k = ni();
        StringBuffer sb = new StringBuffer();
        TreeSet<Integer> trSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            trSet.add(ni());
        }
        for (int i = 0; i < k; i++) {
            int a = trSet.first();
            sb.append(a + "\n");

            TreeSet<Integer> newElements = new TreeSet<>();
            Iterator<Integer> iterator = trSet.iterator();
            while (iterator.hasNext()) {
                int x = iterator.next();
                int temp = x - a;
                if (temp > 0) {
                    newElements.add(temp);
                }
                iterator.remove();
            }
            trSet.addAll(newElements);
            if (trSet.isEmpty()) {
                trSet.add(0);
            }
        }
        System.out.println(sb);
    }

    public static void EIPAGES() {
        int n = ni();
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> trS = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            trS.add(ni());
        }

        int temp = 0;

        while (trS.isEmpty() != true) {
            int x = trS.first();
            if (temp == 0) {
                sb.append(x);
            }

        }
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
