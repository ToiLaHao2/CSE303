package week3;

import java.io.*;
import java.util.*;

class EIEQUALS_Permutation {

	public static void main(String[] args) {

		int n = ni();
		int k = ni();

		int[] arr1 = new int[n];
		int[] arr2 = new int[n];

		int totalList1 = 0;
		int totalList2 = 0;

		for (int i = 0; i < n; i++) {
			int number = ni();
			arr1[i] = number;
			totalList1 += number;
		}
		Arrays.sort(arr1);

		for (int i = 0; i < n; i++) {
			int number = ni();
			arr2[i] = number;
			totalList2 += number;
		}
		Arrays.sort(arr2);

		if (Math.abs(totalList1 - totalList2) > k) {
			System.out.println("NO");

		} else {
			int i = 0;
			int j = 0;
			int count = 0;

			while (i < n && j < n) {
				if (arr1[i] == arr2[j]) {
					i++;
					j++;
				} else if (arr1[i] < arr2[j]) {
					i++;
					count++;
				} else {
					j++;
				}
			}

			if (count > 1) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
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
