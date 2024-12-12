package week3;

import java.io.*;
import java.util.*;;

class EIFLIP_FlippingCells {

	public static void main(String[] args) {
		int n = ni();

		for (int tc = 0; tc < n; tc++) {
			boolean[][] matrix1 = new boolean[3][3];
			int minCount = 10;
			boolean hasStar = false;

			for (int i = 0; i < 3; i++) {
				String row = ns();

				for (int j = 0; j < row.length(); j++) {
					if (row.charAt(j) == '*') {
						matrix1[i][j] = true;
						hasStar = true;
					}
				}
			}

			if (!hasStar) {
				System.out.println(0);
				continue;
			}

			List<List<Integer>> subset = new ArrayList<>();

			for (int i = 0; i < 9; i++) {
				boolean[][] matrix2 = new boolean[3][3];
				int subsetSize = subset.size();

				List<Integer> wayI = new ArrayList<>();
				wayI.add(i);
				subset.add(wayI);

				matrix2 = click(matrix2, i);
				if (compareMatrix(matrix2, matrix1)) {
					minCount = 1;
					break;
				}

				for (int j = 0; j < subsetSize; j++) {
					matrix2 = new boolean[3][3];
					List<Integer> newWayI = new ArrayList<>(wayI);
					newWayI.addAll(subset.get(j));

					matrix2 = clickNTimes(matrix2, newWayI);
					if (compareMatrix(matrix2, matrix1)) {
						minCount = Math.min(minCount, newWayI.size());
					}

					subset.add(newWayI);
				}
			}

			System.out.println(minCount);
		}

	}

	public static boolean[][] clickNTimes(boolean[][] matrix, List<Integer> positions) {
		for (Integer pos : positions) {
			matrix = click(matrix, pos);
		}

		return matrix;
	}

	public static boolean compareMatrix(boolean[][] matrix1, boolean[][] matrix2) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix1[i][j] != matrix2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean[][] click(boolean[][] matrix, int pos) {
		int row = pos / 3;
		int col = pos % 3;

		matrix[row][col] = !matrix[row][col];
		if (row == 0 || row == 2) {
			matrix[1][col] = !matrix[1][col];
		} else {
			matrix[2][col] = !matrix[2][col];
			matrix[0][col] = !matrix[0][col];
		}

		if (col == 0 || col == 2) {
			matrix[row][1] = !matrix[row][1];
		} else {
			matrix[row][0] = !matrix[row][0];
			matrix[row][2] = !matrix[row][2];
		}
		return matrix;
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
