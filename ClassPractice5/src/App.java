import java.io.*;
// import java.text.DecimalFormat;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        EIUQUISORT();
    }

    public static void EIUBISEA() {
        int numberOfNums = ni();
        int numberOfSearchNums = ni();

        int[] listNums = new int[numberOfNums];

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < numberOfNums; i++) {
            listNums[i] = ni();
        }

        Arrays.sort(listNums);

        for (int i = 0; i < numberOfSearchNums; i++) {
            int key = ni();
            int index = Arrays.binarySearch(listNums, key);
            if (index >= 0) { // Nếu tìm thấy
                while (index > 0 && listNums[index - 1] == key) {
                    index--;
                }
                output.append(index + " ");
            } else {
                output.append("-1 ");
            }

        }

        System.out.println(output);
    }

    public static void EIUMERSORT() {
        int n = ni();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = ni();
        }
        StringBuilder output = new StringBuilder();

        mergeSort(list, 0, n - 1);
        for (int i : list) {
            output.append(i + "\n");
        }

        System.out.println(output);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Tạo mảng tạm
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Sao chép dữ liệu
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + 1 + i];

        // Gộp lại\
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Sao chép phần còn lại
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    public static void EIUQUISORT() {
        int n = ni();
        long[] list = new long[n];
        for (int i = 0; i < n; i++) {
            list[i] = ni();
        }
        StringBuilder output = new StringBuilder();

        quickSort(list, 0, n - 1);
        for (long i : list) {
            output.append(i + "\n");
        }

        System.out.println(output);
    }

    public static void quickSort(long[] arr, int low, int high) {
        if (low < high) {
            int randomIndex = low + (int) (Math.random() * (high - low + 1));
            swap(arr, randomIndex, high);
            int[] partition = threeWayPartition(arr, low, high);
            quickSort(arr, low, partition[0] - 1);
            quickSort(arr, partition[1] + 1, high);
        }
    }

    public static int[] threeWayPartition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int lt = low, gt = high;
        int i = low;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, i++, lt++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        return new int[] { lt, gt };
    }

    public static void swap(long[] arr, int l, int r) {
        long temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
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
