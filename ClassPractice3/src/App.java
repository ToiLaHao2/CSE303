import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        EIFLIP();
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

    public static void EIFLIP() {
        int n = ni();
        boolean hasStar = false;
        int totalSteps = 10; // Số bước nhấn tối thiểu khởi tạo lớn hơn 9

        while (n-- > 0) {
            // nhap
            MatrixMap resultMatrix = new MatrixMap();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char x = nc();
                    if (x == '*') {
                        resultMatrix.SetPosition(i, j);
                        hasStar = true;
                    }
                }
            }

            if (!hasStar) {
                System.out.println(0);
                continue;
            }

            // Duyệt qua tất cả các tổ hợp nhấn bằng cách sử dụng bitmask
            for (int mask = 0; mask < (1 << 9); mask++) {
                MatrixMap currentMap = new MatrixMap();
                int stepCount = 0;

                // Áp dụng nhấn theo các bit của `mask`
                for (int i = 0; i < 9; i++) {
                    if ((mask & (1 << i)) != 0) { // Kiểm tra xem bit thứ i có được nhấn không
                        int x = i / 3;
                        int y = i % 3;
                        currentMap.ClickCell(x, y); // Nhấn ô (x, y) và lật các ô lân cận
                        stepCount++;
                    }
                }

                // System.out.println(currentMap.toString());
                // Kiểm tra nếu ma trận hiện tại khớp với targetMap
                if (currentMap.CompareMap(resultMatrix)) {
                    totalSteps = stepCount;
                }
            }

            System.out.println(totalSteps);
        }
    }

    public static class MatrixMap {
        private boolean[][] matrix;

        public MatrixMap() {
            matrix = new boolean[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = false;
                }
            }
        }

        public void SetPosition(int x, int y) {
            if (matrix[x][y] == true) {
                matrix[x][y] = false;
            } else {
                matrix[x][y] = true;
            }
        }

        public void ClickCell(int x, int y) {
            int[] dx = { 0, 1, -1, 0, 0 };
            int[] dy = { 0, 0, 0, 1, -1 };

            for (int i = 0; i < 5; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    SetPosition(nx, ny);
                }

            }
        }

        public boolean CompareMap(MatrixMap mapT) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j] != mapT.matrix[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        // @Override
        // public String toString() {
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < 3; i++) {
        // for (int j = 0; j < 3; j++) {
        // if (matrix[i][j] == true) {
        // sb.append(1 + " ");
        // } else {
        // sb.append(0 + " ");
        // }
        // }
        // sb.append("\n");
        // }
        // return sb.toString();
        // }
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
