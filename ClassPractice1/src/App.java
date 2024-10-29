import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        EIGIFT1();
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

    public static void EISUBARRAY() {
        int n = ni();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = ni();
        }

        int max_ending_here = A[0];
        int max_so_far = A[0];

        for (int i = 1; i < A.length; i++) {
            max_ending_here = Math.max(A[i], max_ending_here + A[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        int min_ending_here = A[0];
        int min_so_far = A[0];

        for (int i = 1; i < A.length; i++) {
            min_ending_here = Math.min(A[i], min_ending_here + A[i]);
            min_so_far = Math.min(min_so_far, min_ending_here);
        }

        int result = Math.max(Math.abs(max_so_far), Math.abs(min_so_far));

        System.out.println(result);
    }

    public static void EIQUEENS() {
        Queen[] arr = new Queen[8];
        boolean flag = true;
        for (int i = 0; i < 8; i++) {
            String line = ns();
            int col = line.indexOf('*');
            if (col == -1) {
                flag = false;
                break;
            }
            arr[i] = new Queen(i, col);
        }

        if (flag == true) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i].col == arr[j].col || arr[i].row == arr[j].row
                            || Math.abs(arr[i].row - arr[j].row) == Math.abs(arr[i].col - arr[j].col)) {
                        flag = false;
                        break;
                    }
                }
                if (flag == false) {
                    break;
                }
            }
        }

        if (flag == true) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }

    static class Queen {
        private int row;
        private int col;

        public Queen(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void EIPAINTING() {
        int numOfPics = ni();
        Map<Integer, Integer> Painting = new HashMap<>();

        for (int i = 0; i < numOfPics; i++) {
            int pic = ni();
            if (Painting.containsKey(pic)) {
                Painting.put(pic, Painting.get(pic) + 1);
            } else {
                Painting.put(pic, 1);
            }
        }

        ArrayList<Integer> ListPainting = new ArrayList<>(Painting.values());
        ListPainting.sort((n1, n2) -> {
            return n2 - n1;
        });

        System.out.println(numOfPics - ListPainting.get(0));
    }

    public static void EIGIFT1() {
        int numOfGift = ni();
        int numOfPapers = ni();

        double[] gifts = new double[numOfGift];
        double[] papers = new double[numOfPapers];

        for (int i = 0; i < numOfGift; i++) {
            gifts[i] = nd();
        }
        for (int i = 0; i < numOfPapers; i++) {
            papers[i] = nd();
        }

        Arrays.sort(gifts);
        Arrays.sort(papers);

        int i = 0;
        int j = 0;
        int giftWrapt = 0;

        while (i < numOfGift && j < numOfPapers) {
            if (papers[j] / gifts[i] < 2) {
                j++;
            } else if (papers[j] / gifts[i] > 3) {
                i++;
            } else {
                i++;
                j++;
                giftWrapt++;
            }
        }
        System.out.println(giftWrapt);
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
