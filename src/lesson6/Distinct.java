package lesson6;

import java.util.Arrays;
// Target BIG-O in O(N*log(N))
// For the same thing we can achieve by using a Hashset with O(N)

public class Distinct {
	class Solution {
		public int solution(int[] A) {
			Arrays.sort(A);
			if (A.length == 0) {
				return 0;
			}
			int result = 1;
			for (int i = 1; i < A.length; i++) {
				if (A[i] != A[i - 1]) {
					result++;
				}
			}
			return result;
		}
	}
}
