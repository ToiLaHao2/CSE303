package review;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;;

class ReviewT2 {

	public static void main(String[] args) {
//		Logging();
//		Logging2();
//		MaximumPathSum();
//		JumpJump();
//		Depreciation();
		Loggging3();
	}

	public static void Logging() {
		int numberTree = ni();

		long maxNotCut = 0;
		long maxCut = 0;

		for (int i = 0; i < numberTree; i++) {
			long currentTree = nl();

			long temp = Math.max(maxNotCut + currentTree, maxCut);

			maxNotCut = maxCut;
			maxCut = temp;
		}
		System.out.println(maxCut);
	}

	public static void Logging2() {
		int numberTree = ni();

		long maxPrevious = 0;
		long maxPreviousOne = 0;
		long maxPreviousTwo = 0;

		for (int i = 0; i < numberTree; i++) {
			long currentTree = nl();

			long temp = Math.max(maxPrevious, Math.max(maxPreviousOne, maxPreviousTwo + currentTree));

			maxPreviousTwo = maxPreviousOne;
			maxPreviousOne = maxPrevious;
			maxPrevious = temp;
		}
		System.out.println(maxPrevious);
	}

	public static void MaximumPathSum() {
		int n = ni();
		int m = ni();

		long[] path = new long[m + 1];

		Arrays.fill(path, Long.MIN_VALUE);
		path[1] = 0;

		long temp;

		for (int i = 1; i <= n; i++) {
			path[1] += nl();

			for (int j = 2; j <= m; j++) {
				temp = nl();

				path[j] = Math.max(path[j], path[j - 1]) + temp;

			}
		}
		System.out.println(path[m]);
	}

	public static void JumpJump() {
		int numberStone = ni();
		int[] arr = new int[numberStone];

		Map<Integer, Integer> mapStone = new HashMap<>();

		int[] dp = new int[numberStone];
		dp[0] = 0;

		for (int i = 0; i < numberStone; i++) {
			arr[i] = ni();
		}

		mapStone.put(arr[0], 0);

		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i - 1] + 1;

			if (mapStone.containsKey(arr[i])) {
				dp[i] = Math.min(dp[i], dp[mapStone.get(arr[i])] + 1);
			}
			mapStone.put(arr[i], i);
		}
		System.out.println(dp[numberStone - 1]);
	}

	public static void Depreciation() {
		int year = ni();
		long initialVal = nl();
		long residualVal = nl();

		DecimalFormat df = new DecimalFormat("#.#######");

		double l = 0;
		double r = 1;
		double mid = 0;

		while ((r - l) > 0.0000001) {
			mid = (r + l) / 2;

			double remainingVal = initialVal;
			for (int i = 0; i < year; i++) {
				double x = mid - mid * i / year;
				remainingVal *= (1 - x);
			}

			if (remainingVal >= residualVal) {
				l = mid;
			} else {
				r = mid;
			}
		}
		System.out.println(df.format(mid));
	}

	public static void Loggging3() {
		int numberTree = ni();

		long[] values = new long[numberTree + 1];
		long[] dp = new long[numberTree + 1];

		values[0] = 0;
		values[1] = Math.max(nl(), values[0]);

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= numberTree; i++) {
			long currentTree = nl();

			values[i] = Math.max(values[i - 2] + currentTree, values[i - 1]);

			if (values[i - 2] + currentTree == values[i - 1]) {
				dp[i] = dp[i - 1] + dp[i - 2];
				dp[i] = dp[i] % (1000000007L);
			} else if (values[i - 2] + currentTree > values[i - 1]) {
				dp[i] = dp[i - 2];
			} else if (values[i - 2] + currentTree < values[i - 1]) {
				dp[i] = dp[i - 1];
			}
		}
		System.out.println(values[numberTree] + " " + dp[numberTree]);
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
