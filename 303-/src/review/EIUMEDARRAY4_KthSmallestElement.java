package review;

import java.io.*;
import java.util.*;

class EIUMEDARRAY4_KthSmallestElement {

	public static void main(String[] args) {
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
