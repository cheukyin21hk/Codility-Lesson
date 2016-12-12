package lesson4;

public class PermCheck {
	class Solution {
		public int solution(int[] A) {
			boolean[] exist = new boolean[A.length + 1];
			for (int i = 0; i < A.length; i++) {
				if (A[i] > A.length) {
					return 0;
				}
				if (exist[A[i]]) {
					return 0;
				}
				exist[A[i]] = true;
			}
			return 1;
		}
	}
}
