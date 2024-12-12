package review;

import java.io.*;
import java.util.*;;

class ReviewT1 {

	public static void main(String[] args) {
//		possiblePassword();
//		subset1();
//		Permutation();
//		BuyGifts();
//		WomenDay();
//		Adam1();
//		eimin();
//		Subbarray();
//		GiftWrapping();
		PageNumbers();
	}

	// POSSIBLE PASSWORD
	public static void possiblePassword() {
		String capitalLetter = ns();

		char[] characters = capitalLetter.toCharArray();

		TreeSet<String> passwords = new TreeSet<>();
		passwords.add(String.valueOf(characters[0]));

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < characters.length; i++) {
			TreeSet<String> newPasswords = new TreeSet<>();

			for (var password : passwords) {
				for (int j = 0; j <= password.length(); j++) {
					var newPassword = password.substring(0, j) + characters[i] + password.substring(j);
					newPasswords.add(newPassword);
				}
			}

			passwords = newPasswords;
		}

		sb.append(passwords.size()).append("\n");

		for (var password : passwords) {
			sb.append(password).append("\n");
		}

		System.out.println(sb);
	}

	// SUBSET 1
	public static void subset1() {
		int n = ni();

		List<Integer> sets = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sets.add(ni());
		}

		List<String> subsets = new ArrayList<>();

		for (int i = sets.size() - 1; i >= 0; i--) {
			subsets.add(String.valueOf(sets.get(i)));
			int temp = subsets.size() - 1;

			for (int j = 0; j < temp; j++) {
				subsets.add(sets.get(i) + " " + subsets.get(j));
			}
		}

		sb.append(subsets.size()).append("\n");

		for (var subset : subsets) {
			sb.append(subset).append("\n");
		}
		System.out.println(sb);
	}

	// PERMUTATION
	public static void Permutation() {
		int n = ni();
		int k = ni();

		int[] arr1 = new int[n];
		int[] arr2 = new int[n];

		int totalArr1 = 0;
		int totalArr2 = 0;

		for (int i = 0; i < n; i++) {
			arr1[i] = ni();
			totalArr1 += arr1[i];
		}
		Arrays.sort(arr1);

		for (int i = 0; i < n; i++) {
			arr2[i] = ni();
			totalArr2 += arr2[i];
		}
		Arrays.sort(arr2);

		if (Math.abs(totalArr1 - totalArr2) > k) {
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

	// BUY GIFTS
	public static void BuyGifts() {
		int testcase = ni();
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < testcase; j++) {
			int numberGifts = ni();

			Map<Integer, Integer> mapGifts = new HashMap<>();

			for (int i = 0; i < numberGifts; i++) {
				int price = ni();
				if (!mapGifts.containsKey(price)) {
					mapGifts.put(price, 1);
				} else {
					mapGifts.put(price, mapGifts.get(price) + 1);
				}
			}

			long count = 0;

			for (var value : mapGifts.values()) {
				count += ((long) value * ((long) value - 1)) / 2;
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

	// WOMEN DAY
	public static void WomenDay() {
		int numberItems = ni();
		int amount = ni();

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < numberItems; i++) {
			int price = ni();
			if (price <= amount) {
				list.add(price);
			}
		}

		list.sort((n1, n2) -> {
			return n1 - n2;
		});

		int totalAmount = -1;
		int mindiff = -1;

		int i = 0;
		int j = list.size() - 1;

		while (i < j) {
			int tempTotal = list.get(i) + list.get(j);
			int tempDiff = list.get(j) - list.get(i);

			if (tempTotal <= amount && tempTotal >= totalAmount) {
				totalAmount = tempTotal;
				mindiff = tempDiff;

				if (tempDiff == 0) {
					break;
				}
				i++;
			} else if (tempTotal > amount) {
				j--;
			} else {
				i++;
			}
		}

		System.out.println(totalAmount + " " + mindiff);
	}

	// ADAM1 - NUMBER OF PAIRS
	public static void Adam1() {
		int n = ni();
		int x = ni();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = ni();
		}

		System.out.println(countPairs(n, x, arr));
	}

	public static int countPairs(int n, int x, int[] arr) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (var num : arr) {
			if (map.containsKey(num - x)) {
				count += map.get(num - x);
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		return count;
	}

	// EIMIN
	public static void eimin() {
		int n = ni();
		int k = ni();

		TreeSet<Integer> set = new TreeSet<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			set.add(ni());
		}

		int min = 0;
		Iterator<Integer> iterator = set.iterator();

		for (int i = 0; i < k; i++) {
			if (iterator.hasNext()) {
				int number = iterator.next();
				sb.append(number - min).append("\n");
				min = number;
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

	// SUBBARRAY
	public static void Subbarray() {
		int n = ni();

		int max = 0;
		int totalPos = 0;
		int totalNeg = 0;

		for (int i = 0; i < n; i++) {
			int number = ni();

			totalPos = Math.max(totalPos + number, 0);
			totalNeg = Math.min(totalNeg + number, 0);

			if (totalPos > 0) {
				max = Math.max(totalPos, max);
			} else {
				max = Math.max((Math.abs(totalNeg)), max);
			}
		}
		System.out.println(max);
	}

	// GIFT WRAPPING
	public static void GiftWrapping() {
		int numberGifts = ni();
		int numberPapers = ni();

		double[] arrGifts = new double[numberGifts];
		double[] arrPapers = new double[numberPapers];

		for (int i = 0; i < numberGifts; i++) {
			arrGifts[i] = ni();
		}
		Arrays.sort(arrGifts);

		for (int i = 0; i < numberPapers; i++) {
			arrPapers[i] = ni();
		}
		Arrays.sort(arrPapers);

		int i = 0;
		int j = 0;
		int count = 0;

		while (i < numberGifts && j < numberPapers) {
			if (arrPapers[j] / arrGifts[i] < 2) {
				j++;
			} else if (arrPapers[j] / arrGifts[i] > 3) {
				i++;
			} else {
				i++;
				j++;
				count++;
			}
		}
		System.out.println(count);
	}

	// PAGE NUMBERS
	public static void PageNumbers() {
		var n = ni();
		int[] arr = new int[n];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			arr[i] = ni();
		}
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			int distant = 1;
			int to = 0;
			int count = 1;

			for (int j = i + 1; j < n; j++) {
				if (arr[j] - arr[i] == distant) {
					distant++;
					to = j;
					count++;
				} else {
					break;
				}
			}

			if (count == 1) {
				sb.append(arr[i]).append(" ");
			} else if (count == 2) {
				sb.append(arr[i]).append(" ").append(arr[to]).append(" ");
				i++;
			} else {
				sb.append(arr[i]).append("-").append(arr[to]).append(" ");
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