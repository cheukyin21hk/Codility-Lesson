package lesson2;

public class RotationArray {
	class Solution {
		public int[] solution(int[] A, int K) {
			if (A.length <= 1) {
				return A;
			} else {
				int[] result = A;
				for (int i = 0; i < K; i++) {
					result = rotateArrayToRight(result);
				}
				return result;
			}
		}

		private int[] rotateArrayToRight(int[] inputArray) {
			int[] result = new int[inputArray.length];
			result[0] = inputArray[inputArray.length - 1];
			for (int i = 1; i < inputArray.length; i++) {
				result[i] = inputArray[i - 1];
			}
			return result;
		}
	}
}
