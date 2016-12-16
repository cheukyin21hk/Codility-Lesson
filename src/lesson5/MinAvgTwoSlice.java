package lesson5;

public class MinAvgTwoSlice {
	class Solution {
		public int solution(int[] A) {
			double minAvg = Double.MAX_VALUE;
			double currentAvg = 0;
			int result = -1;
			for (int i = 0; i < A.length; i++) {

				if (i + 1 < A.length) {
					currentAvg = calculateSliceWithTwo(A[i], A[i + 1]);
					if (currentAvg < minAvg) {
						minAvg = currentAvg;
						result = i;
					}
				}

				if (i + 2 < A.length) {
					currentAvg = calculateSliceWithThree(A[i], A[i + 1], A[i + 2]);
					if (currentAvg < minAvg) {
						minAvg = currentAvg;
						result = i;
					}
				}
			}
			return result;
		}

		private double calculateSliceWithThree(int i, int j, int k) {
			return (i + j + k) / 3.0;
		}

		private double calculateSliceWithTwo(int i, int j) {
			return (i + j) / 2.0;
		}
	}
}
