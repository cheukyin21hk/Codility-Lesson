package lesson8;

/**
 * 
 * TC : O(n)
 * SC : O(n)
 * The precondition is ensure The equilLeader exist if and only if Leader exist
 * the algorithm is to
 * 1.find the most occurrent value
 * 2.count to see is it leader
 * 3.check each partition by calculation through loop.
 */
public class EquiLeader {
	class Solution {
		public int solution(int[] A) {
			int count = 1;
			int currentIndex = 0;

			// 1. find the most occurent value
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
			// 2. Check is leader
			for (int i = 0; i < A.length; i++) {
				if (A[i] == A[currentIndex]) {
					count++;
				}
			}

			// 3. Check the partition through calculation.
			if (count++ > (A.length / 2)) {
				int result = 0;
				int currentCount = 0;
				boolean isFirstPartValid = false;
				boolean isSecondPartValid = false;
				for (int i = 0; i < A.length; i++) {
					if (A[currentIndex] == A[i]) {
						currentCount++;
					}
					isFirstPartValid = currentCount > (i + 1) / 2;
					isSecondPartValid = (count - currentCount) > ((A.length - i + 1) / 2);
					if (isFirstPartValid && isSecondPartValid) {
						result++;
					}
				}
				return result;
			} else {
				return 0;
			}
		}
	}

	public void runTest(int[] testData) {
		Solution proposedSolution = new Solution();
		System.out.println(proposedSolution.solution(testData));
	}
}
