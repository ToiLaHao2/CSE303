package review;

import java.io.*;
import java.util.*;;

class EIAPPLEBOX_CountInversion {

	public static void main(String[] args) {
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