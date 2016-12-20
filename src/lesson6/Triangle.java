package lesson6;

import java.util.Arrays;

/*
 * Target BIG-O in O(N*log(N))
 * Point to notice :
 * 1.) the negative case
 * 2.) the overflow case
 */
public class Triangle {

	class Solution {
		public int solution(int[] A) {
			Arrays.sort(A);
			for (int i = A.length - 1; i > 1; i--) {
				if (A[i] <= 0 || A[i - 1] <= 0 || A[i - 2] <= 0) {
					break;
				}
				if (isTriangle((long) A[i], (long) A[i - 1], (long) A[i - 2])) {
					return 1;
				}
			}
			return 0;
		}

		private boolean isTriangle(long a, long b, long c) {
			long tempSum = a + b;
			if (tempSum <= c) {
				return false;
			}
			tempSum = a + c;
			if (tempSum <= b) {
				return false;
			}
			tempSum = b + c;
			if (tempSum <= a) {
				return false;
			}
			return true;
		}
	}

}
