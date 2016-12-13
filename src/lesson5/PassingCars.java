package lesson5;

public class PassingCars {
	public static void main(String args[]) {
		PassingCars test = new PassingCars();
		test.runTest();
	}

	private void runTest() {
		int A[] = { 0, 1, 0, 1, 0, 1, 1 };
		System.out.println(new Solution().solution(A));
	}

	class Solution {
		public int solution(int[] A) {
			final int MAX_COUNT = 1000000000;
			int prefixSum = 0;
			int currentSum = 0;
			int result = 0;
			for (int i = A.length - 1; i >= 0; i--) {
				if (A[i] == 1) {
					currentSum++;
				} else {
					result += (currentSum + prefixSum);
					if (result > MAX_COUNT) {
						return -1;
					} else {
						prefixSum = (currentSum + prefixSum);
						currentSum = 0;
					}
				}

			}
			return result;
		}
	}
}
