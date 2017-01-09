package lesson9;
/**
 * 
 * TC : O(n)
 * SC : O(1)
 */
public class MaxProfit {
	class Solution {
		public int solution(int[] A) {
			long maxEnd = 0;
			long maxSlide = 0;
			long tempValue = 0;
			for (int i = 1; i < A.length; i++) {
				tempValue = maxEnd + A[i] - A[i - 1];
				maxEnd = Math.max(0, tempValue);
				maxSlide = Math.max(maxSlide, maxEnd);
			}
			return (int) maxSlide;

		}
	}

	public void runTest(int[] testData) {
		Solution proposedSolution = new Solution();
		System.out.println(proposedSolution.solution(testData));
	}

	public static void main(String args[]) {
		int[] testData = { 23171, 21011, 21123, 21366, 21013, 21367 };
		MaxProfit mp = new MaxProfit();
		mp.runTest(testData);
	}
}
