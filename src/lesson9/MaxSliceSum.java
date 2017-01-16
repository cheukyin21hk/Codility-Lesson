package lesson9;

/**
 * TC : O(n)
 * SC : O(1)
 * Algorithem designed principle : 
 * To prevent the false 0 solutions :
 * 
 * find the largest combined slice first O(n)
 * find the largest single as the same time.
 *
 */
public class MaxSliceSum {
	class Solution {
		public int solution(int[] A) {
			long maxEnd = 0;
			long maxSlide = 0;
			int largestElement = A[0];
			boolean zeroSumExist = false;
			for (int i = 0; i < A.length; i++) {
				if (maxEnd + A[i] == 0) {
					zeroSumExist = true;
				}
				maxEnd = Math.max(0, maxEnd + A[i]);
				maxSlide = Math.max(maxSlide, maxEnd);
				largestElement = Math.max(largestElement, A[i]);
			}

			if (zeroSumExist) {
				return (int) Math.max(maxSlide, largestElement);
			} else {
				if (maxSlide == 0) {
					return largestElement;
				} else {
					return (int) Math.max(maxSlide, largestElement);
				}
			}
		}
	}

	public void runTest(int[] testData) {
		Solution proposedSolution = new Solution();
		System.out.println(proposedSolution.solution(testData));
	}

	public static void main(String args[]) {
		int[] testData = { 3, 2, -6, 4, 0 };
		MaxSliceSum mp = new MaxSliceSum();
		mp.runTest(testData);
	}
}
