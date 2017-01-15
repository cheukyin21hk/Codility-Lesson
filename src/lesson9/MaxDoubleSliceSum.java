package lesson9;

/**
 * TC : O(n)
 * SC : O(n)
 */
public class MaxDoubleSliceSum {
	class Solution {
		public int solution(int[] A) {
			int[] maxValueFromStart = new int[A.length];
			int[] maxValueFromEnd = new int[A.length];
			int maxEnding = 0;
			int maxStarting = 0;
			int result = 0;
			for (int i = 1; i < A.length; i++) {
				maxValueFromStart[i] = maxStarting = Math.max(0, maxStarting + A[i]);
			}

			for (int i = A.length - 2; i >= 0; i--) {
				maxValueFromEnd[i] = maxEnding = Math.max(0, maxEnding + A[i]);
			}

			for (int i = 1; i < A.length - 1; i++) {
				result = Math.max(result, maxValueFromStart[i - 1] + maxValueFromEnd[i + 1]);
			}
			return result;
		}
	}

	public void runTest(int[] testData) {
		Solution proposedSolution = new Solution();
		System.out.println(proposedSolution.solution(testData));
	}

	public static void main(String args[]) {
		int[] testData = { 23171, 21011, 21123, 21366, 21013, 21367 };
		MaxDoubleSliceSum mp = new MaxDoubleSliceSum();
		mp.runTest(testData);
	}
}
