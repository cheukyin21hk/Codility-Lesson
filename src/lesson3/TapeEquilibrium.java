package lesson3;

public class TapeEquilibrium {
	public static void main(String args[]) {
		TapeEquilibrium testCase = new TapeEquilibrium();
		testCase.test();
	}

	public void test() {
		Solution solve = new Solution();
		int[] a = { 1000, -1000 };
		solve.solution(a);
		int[] b = { 3, 1, 2, 4, 3 };
		solve.solution(b);

		// System.out.println(solution(a));
	}

	class Solution {
		public Solution() {
		}

		public int solution(int[] A) {
			int sumOfAll = 0;
			int currentSum = 0;
			for (int i = 0; i < A.length; i++) {
				sumOfAll += A[i];
			}
			int result;
			currentSum += A[0];
			result = (int) Math.abs((sumOfAll - currentSum) - currentSum);
			for (int i = 1; i < A.length - 1; i++) {
				currentSum += A[i];
				if (Math.abs((sumOfAll - currentSum) - currentSum) < result) {
					result = (int) Math.abs((sumOfAll - currentSum) - currentSum);

				}
			}
			return result;
		}
	}

}
