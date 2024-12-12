package week1;

import java.io.*;
import java.util.*;;

class EIPAGES_PageNumbers {

	public static void main(String[] args) {
		int numberPages = ni();
		int[] arrPages = new int[numberPages];
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < numberPages; i++) {
			arrPages[i] = ni();
		}
		Arrays.sort(arrPages);
		
		for (int i = 0; i < numberPages; i++) {
			int distant = 1;
			int to = 0;
			int count = 1;
			
			for (int j = i + 1; j < numberPages; j++) {
				if (arrPages[j] - arrPages[i] == distant ) {
					distant++;
					to = j;
					count++;
				} else {
					break;
				}
			}
			
			if (count == 1) {
				sb.append(arrPages[i]).append(" ");
			} else if (count == 2) {
				sb.append(arrPages[i]).append(" ").append(arrPages[to]).append(" ");
				i++;
			} else {
				sb.append(arrPages[i]).append("-").append(arrPages[to]).append(" ");
				i = i + count - 1;
			}
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
