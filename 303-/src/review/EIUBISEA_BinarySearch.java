package review;

import java.io.*;
import java.util.*;;

class EIUBISEA_BinarySearch {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		int numbers = ni();
		int[] arrNumbers = new int[numbers];

		int listSearch = ni();

		for (int i = 0; i < arrNumbers.length; i++) {
			arrNumbers[i] = ni();
		}

		Arrays.sort(arrNumbers);

		for (int i = 0; i < listSearch; i++) {
			int key = ni();
			int index = binarySearch(arrNumbers, 0, arrNumbers.length, key);

			if (index == -1) {
				sb.append(-1).append(" ");
			} else {
				sb.append(index).append(" ");
			}
		}
		System.out.println(sb);

	}

	static int binarySearch(int[] arr, int start, int end, int key) {
		while (start + 1 < end) {
			int mid = (start + end) / 2;

			if (arr[mid] < key) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (arr[start] == key) {
			return start;

		} else if (end < arr.length && arr[end] == key) {
			return end;
		}
		return -1;
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
