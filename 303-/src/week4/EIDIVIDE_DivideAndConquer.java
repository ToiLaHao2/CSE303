package week4;

import java.io.*;
import java.util.*;;

class EIDIVIDE_DivideAndConquer {

	public static void main(String[] args) {
//		long n =nl();
//		long l = nl();
//		long r = nl();
//		
//		long level = (long)Math.floor((Math.log(n)/Math.log(2)));
//		long count = 0;
//		
//		while (level >= 0) {
//			if (n % 2 == 1) {
//				count+= countK(level, l, r);
//			}
//			n /= 2;
//			level--;
//		}
//		
//		System.out.println(count);
//	}
//	
//	public static long countK(long level, long l, long r) {
//		long left = 1 << level;
//		long right = 1 << (level + 1);
//		
//		long kLeft = (long)Math.ceil((double)(l - left) / (double)right);
//		long kRight = (long)Math.floor((double)(r - left)/ (double)right);
//		
//		if (kLeft > kRight) {
//			return 0;
//		}
//		return (kRight - kLeft + 1);
//	}
		
		long n = nl();
		long l = nl(); // range
		long R = nl(); // range

		int log2 = (int) (Math.log(n) / Math.log(2));
		long middle = 0;

		for (var i = 0; i < log2; i++) {
			middle += (1L << i);
		}

		if (middle == n) {
			middle = (middle - 1) / 2;
		}
		divideAndConquer(n, l, R, middle + 1, (middle + 1) / 2);
		System.out.println(result);

	}

	static long result = 0;

	public static void divideAndConquer(long n, long l, long r, long i, long depth) {
		if (n == 2 || n == 3) {
			long left = i - 1;
			long right = i + 1;

			if (left >= l && left <= r) {
				result += 1;
			}
			if (right >= l && right <= r) {
				result += 1;
			}
			if (n == 3 && l <= i && i <= r) {
				result += 1;
			}
			return;
		}

		if (l <= i && i <= r) {
			result += n % 2;
		}
		if (l < i) {
			divideAndConquer(n / 2, l, r, i - depth, depth / 2);
		}
		if (r > i) {
			divideAndConquer(n / 2, l, r, i + depth, depth / 2);
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
