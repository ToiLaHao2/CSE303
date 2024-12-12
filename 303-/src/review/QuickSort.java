package review;

import java.io.*;
import java.util.*;;

class QuickSort {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		int n = ni();
		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = nl();
		}
		
		randomElement(arr);
		quickSort(arr, 0, n);

		for (long num : arr) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void quickSort(long[] arr, int left, int right) {
		if (left < right) {
			int[] newarr = partition(arr, left, right);

			quickSort(arr, left, newarr[0] - 1);
			quickSort(arr, newarr[1] + 1, right);
		}
	}
	
	private static int[] partition(long[] arr, int left, int right) {
		int i = left + 1;
		int lowest = left;
		int highest = right == arr.length ? right - 1 : right;
		long pivot = arr[left];

		while (i <= highest) {
			if (pivot > arr[i]) {
				swap(arr, lowest, i);
				i++;
				lowest++;
			} else if (pivot < arr[i]) {
				swap(arr, highest, i);
				highest--;
			} else {
				i++;
			}
		}
		return new int[] { lowest, highest };
	}
	
	private static void swap(long[] arr, int first, int last) {
		var t = arr[first];
		arr[first] = arr[last];
		arr[last] = t;
	}

	private static void randomElement(long[] arr) {
		Random rd = new Random();

		for (int i = arr.length - 1; i > 0; i--) {
			int index = rd.nextInt(i + 1);

			swap(arr, i, index);
		}
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
