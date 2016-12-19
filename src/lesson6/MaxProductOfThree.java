package lesson6;

import java.util.Arrays;

/*
 * Target time complexity is O(N*log(N)) space complexity is O(1)
 * seems can be acheive by TC - O(N).
 */
public class MaxProductOfThree {
	class Solution {
		public int solution(int[] A) {
			Arrays.sort(A);
			return Math.max((A[A.length - 1] * A[A.length - 2] * A[A.length - 3]), (A[A.length - 1] * A[0] * A[1]));
		}
	}
}
