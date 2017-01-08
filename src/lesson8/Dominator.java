package lesson8;

/**
 * @author lohris
 *         Target BIG-O for time in O(N)
 *         Space O(1)
 */
public class Dominator {
	class Solution {
		public int solution(int[] A) {
			int count = 1;
			int currentIndex = 0;

			for (int i = 1; i < A.length; i++) {
				if (count == 0) {
					currentIndex = i;
					count++;
				} else {
					if (A[currentIndex] != A[i]) {
						count--;
					} else {
						count++;
					}
				}
			}

			count = 0;

			for (int i = 0; i < A.length; i++) {
				if (A[i] == A[currentIndex]) {
					count++;
				}
				if (count > (A.length / 2)) {
					return currentIndex;
				}
			}
			return -1;
		}
	}

	public void runTest(int[] testData) {
		Solution proposedSolution = new Solution();
		System.out.println(proposedSolution.solution(testData));
	}
}
