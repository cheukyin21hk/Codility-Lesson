package lesson6;

/**
 * @author lohris
 *         Time Complexity = NLog(N)
 *         Space Complexity = N
 *         provided Basic test case :
 *          A[0] = 1 (-1, 0, 1)
 *          A[1] = 5 (-4, 1, 6)
 *          A[2] = 2 ( 0, 2, 4)
 *          A[3] = 1 ( 2, 3, 4)
 *          A[4] = 4 ( 0, 4, 8)
 *          A[5] = 0 ( 5, 5, 5)
 *          
 *          Solution is from
 *          http://stackoverflow.com/questions/4801242/algorithm-to-calculate-number-of-intersecting-discs
 */
public class NumberOfDiscIntersections {

	public static void main(String[] args) {
		int[] testData = { 1, 2147483647, 0 };
		NumberOfDiscIntersections a = new NumberOfDiscIntersections();
		a.runTest(testData);
	}

	public void runTest(int[] testData) {
		Solution proposedSolution = new Solution();
		System.out.println(proposedSolution.solution(testData));
	}

	class Solution {

		private final int MAX_RESULT_VALUE = 10000000;

		public int solution(int[] A) {
			int result = 0;
			int[] discStartPoint = new int[A.length];
			int[] discEndPoint = new int[A.length];

			for (int i = 0, t = A.length - 1; i < A.length; i++) {
				int s = calculateTheStartPoint(i, A[i]);
				int e = calculateTheEndPoint(i, A[i], t);
				discStartPoint[s]++;
				discEndPoint[e]++;
			}

			int activeDisc = 0;
			for (int i = 0; i < A.length; i++) {
				if (discStartPoint[i] > 0) {
					//Intersect of active disc and new start disc
					result += activeDisc * discStartPoint[i];
					//Intersect of new start disc.
					result += discStartPoint[i] * (discStartPoint[i] - 1) / 2;
					if (MAX_RESULT_VALUE < result) {
						return -1;
					}
					activeDisc += discStartPoint[i];
				}
				activeDisc -= discEndPoint[i];
			}
			return result;
		}

		private int calculateTheEndPoint(long i, long radius, int rightMostPoint) {
			if (i + radius > rightMostPoint)
				return rightMostPoint;
			else
				return (int) (i + radius);
		}

		private int calculateTheStartPoint(long i, long radius) {
			if (i > radius)
				return (int) (i - radius);
			else
				return 0;
		}
	}
}
