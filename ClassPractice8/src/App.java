import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        EIUMEDARRAY4();
    }

    // EIUGAME2 - The number of path
    public static void EIUGAME2() {

    }

    // EIUMEDARRAY4
    public static void EIUMEDARRAY4() {
        StringBuilder sb = new StringBuilder();
        int T = ni();

        for (int i = 0; i < T; i++) {
            int N = ni();
            long A = nl();
            long P = nl();
            int K = ni();
            long[] arr = new long[N];

            arr[0] = (A * A) % P;
            for (int j = 1; j < N; j++) {
                arr[j] = (arr[j - 1] * A) % P;
            }

            sb.append(quickSort(arr, 0, N - 1, K)).append("\n");
        }

        System.out.println(sb);
    }

    public static long quickSort(long[] arr, int low, int high, int k) {
        int pivot = partition(arr, low, high);

        if (pivot == k - 1) {
            return arr[pivot];
        } else if (pivot > k - 1) {
            return quickSort(arr, low, pivot - 1, k);
        } else {
            return quickSort(arr, pivot + 1, high, k);
        }
    }

    public static int partition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                long temp = arr[i];

                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        long temp = arr[i + 1];

        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // EIAPPLEBOX
    public static void EIAPPLEBOX() {
        StringBuilder sb = new StringBuilder();
        int T = ni();

        for (int t = 0; t < T; t++) {
            int N = ni();
            long A = ni();
            long P = ni();

            long[] array = new long[N];
            array[0] = (long) (A * A) % P;

            for (int i = 1; i < N; i++) {
                array[i] = (array[i - 1] * A) % P;
            }

            long count = mergeSortAndCount(array, 0, N - 1);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static long mergeSortAndCount(long[] arr, int start, int end) {
        long count = 0;

        if (start < end) {
            int middle = start + (end - start) / 2;

            count += mergeSortAndCount(arr, start, middle);
            count += mergeSortAndCount(arr, middle + 1, end);
            count += mergeAndCount(arr, start, middle, end);
        }
        return count;
    }

    public static long mergeAndCount(long[] arr, int start, int middle, int end) {
        var n1 = middle - start + 1;
        var n2 = end - middle;

        long[] L = new long[n1];
        long[] R = new long[n2];

        System.arraycopy(arr, start, L, 0, n1);
        System.arraycopy(arr, middle + 1, R, 0, n2);

        long count = 0;
        int i = 0;
        int j = 0;
        int k = start;

        while (i < n1 && j < n2) {
            if (L[i] > R[j]) {
                arr[k++] = R[j++];
                count += middle - (start + i) + 1;
            } else {
                arr[k++] = L[i++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }

        return count;
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
