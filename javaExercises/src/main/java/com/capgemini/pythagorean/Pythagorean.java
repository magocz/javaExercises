package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52. There exists
 * exactly one Pythagorean triplet for which a + b + c = 1000. Find the product
 * abc.
 */
public class Pythagorean {

	final static int SUM_OF_ALL = 1000;

	public static int findABC() {
		return specyficznaMetoda();
	}

	private static int drewnianaMetoda() {
		int a = 0;
		int b = a + 1;
		for (; a < 500; a++) {
			for (b = a + 1; b < 500; b++) {
				if (Math.pow(SUM_OF_ALL, 2) - 2 * SUM_OF_ALL * a - 2 * SUM_OF_ALL * b + 2 * a * b == 0) {
					int c = 1000 - a - b;
					return c * b * a;
				}
			}
		}
		return 0;
	}

	private static int specyficznaMetoda() {
		int[] tab = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61 };

		int m, n, a, b, c;
		for (int i = 0; i < tab.length; i++) {
			n = tab[i];
			m = (int) (Math.sqrt((n * n + 2 * SUM_OF_ALL)) / 2 - n / 2);
			b = m * m - n * n;
			a = 2 * m * n;
			c = m * m + n * n;
			if (a + b + c == SUM_OF_ALL) {
				return c * b * a;
			}

		}
		return 0;
	}
}
