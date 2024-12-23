package week2;

import java.io.*;
import java.util.*;;

class EIUSUBSET_subset1 {

	public static void main(String[] args) {
		// int n = ni();

		// List<Integer> set = new ArrayList<>();
		// StringBuilder sb = new StringBuilder();

		// for (int i = 0; i < n; i++) {
		// set.add(ni());
		// }

		// List<String> subset = new ArrayList<>();

		// for (int i = set.size()-1; i >= 0; i--) {
		// subset.add(String.valueOf(set.get(i)));
		// int temp = subset.size() - 1;

		// for (int j = 0; j < temp; j++) {
		// subset.add(set.get(i) + " " + subset.get(j));
		// }
		// }

		// sb.append(subset.size()).append("\n");

		// for (var i : subset) {
		// sb.append(i).append("\n");
		// }
		// System.out.println(sb);

		int n = ni();
		List<Integer> set = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			set.add(ni());
		}

		List<String> subdsets = new ArrayList<>();
		for (int i = set.size() - 1; i >= 0; i--) {
			subdsets.add(String.valueOf(set.get(i)));
			int temp = subdsets.size() - 1;
			for (int j = 0; j < temp; j++) {
				subdsets.add(set.get(i) + subdsets.get(j));
			}
		}
		sb.append(subdsets.size() + "\n");
		for (String string : subdsets) {
			sb.append(string + "\n");
		}

		System.out.println(sb);
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
