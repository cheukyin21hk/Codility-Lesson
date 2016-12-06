package lesson3;

public class PermMissingElem {
	class Solution {
		public int solution(int[] A) {
			int result = 0;
			for (int i = 0; i < A.length; i++) {
				result += ((i + 1) - A[i]);
			}
			return result + (A.length + 1);
		}
	}

}
