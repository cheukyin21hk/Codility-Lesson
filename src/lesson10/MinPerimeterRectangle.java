package lesson10;

public class MinPerimeterRectangle {
	class Solution {
		public int solution(int N) {
			int result = 0;
			long i = 1;
			long firstDivisor = 0;
			long secondDivisor = 0;
			for (i = 1; (i * i) < N; i++) {
				if ((N % i) == 0) {
					firstDivisor = i;
					secondDivisor = N / i;
				}
			}

			if (N % (i * i) == 0) {
				result = (int) (i * 4);
			} else {
				result = (int) (2 * (firstDivisor + secondDivisor));
			}
			return result;
		}
	}

	public void runTest(int testData) {
		Solution proposedSolution = new Solution();
		System.out.println(proposedSolution.solution(testData));
	}

	public static void main(String args[]) {
		MinPerimeterRectangle cf = new MinPerimeterRectangle();
		cf.runTest(2147483647);
	}
}
