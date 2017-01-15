package lesson10;

/**
 * TC : O(sqrt of (N))
 * SC : O(1)
 */
public class CountFactors {
	class Solution {
		public int solution(int N) {
			int result = 0;
			long i = 1;
			for (i = 1; (i * i) < N; i++) {
				if ((N % i) == 0) {
					result += 2;
				}
			}

			if (N % (i * i) == 0) {
				result++;
			}
			return result;
		}
	}

	public void runTest(int testData) {
		Solution proposedSolution = new Solution();
		System.out.println(proposedSolution.solution(testData));
	}

	public static void main(String args[]) {
		CountFactors cf = new CountFactors();
		cf.runTest(2147483647);
	}
}
