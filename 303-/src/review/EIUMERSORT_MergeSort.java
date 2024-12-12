package review;

import java.io.*;
import java.util.*;

class EIUMERSORT_MergeSort {

	public static void main(String[] args) {
		StringBuffer outBuffer = new StringBuffer();

		var n = ni();
		int[] arr = new int[n];

		for (var i = 0; i < arr.length; i++) {
			arr[i] = ni();
		}

		mergeSort(arr);

		for (var i : arr) {
			outBuffer.append(i).append(" ");
		}

		System.out.println(outBuffer);
	}

	static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			var middle = (start + end) / 2;

			mergeSort(arr, start, middle);
			mergeSort(arr, middle + 1, end);
			merge(arr, start, middle, end);
		}
	}

	static void merge(int[] arr, int start, int middle, int end) {

		var n1 = middle - start + 1;
		var n2 = end - middle;

		var L = new int[n1];
		var R = new int[n2];

		for (var i = 0; i < n1; i++) {
			L[i] = arr[start + i];
		}

		for (var j = 0; j < n2; j++) {
			R[j] = arr[middle + j + 1];
		}

		var i = 0;
		var j = 0;
		var k = start;
		while (i < n1 || j < n2) {

			if (i < n1 && j < n2 && L[i] <= R[j] || j == n2) {
				arr[k++] = L[i++];

			} else {
				arr[k++] = R[j++];
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
