package week5;

import java.io.*;
import java.util.*;;

class EIULOGGING3_LOGGING3 {

	public static void main(String[] args) {
		int numberTrees = ni();

		long[] values = new long[numberTrees + 1];
		long[] dp = new long[numberTrees + 1];

		values[0] = 0;
		values[1] = Math.max(nl(), values[0]);

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= numberTrees; i++) {
			long currentValue = nl();

			values[i] = Math.max(values[i - 2] + currentValue, values[i - 1]);

			if (values[i - 2] + currentValue == values[i - 1]) {
				dp[i] = dp[i - 1] + dp[i - 2];
				dp[i] = dp[i] % (1000000007L);

			} else if (values[i - 2] + currentValue > values[i - 1]) {
				dp[i] = dp[i - 2];

			} else if (values[i - 2] + currentValue < values[i - 1]) {
				dp[i] = dp[i - 1];
			}
		}

		System.out.println(values[numberTrees] + " " + dp[numberTrees]);

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