package lesson4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public static void main(String args[]) {
		int[] testData = { 1, 1, 1, 1 };
		new FrogRiverOne().runTest(2, testData);

	}

	public void runTest(int X, int[] testData) {
		Solution mySolution = new Solution();
		System.out.println("Result : " + mySolution.solution(2, testData));
	}

	class Solution {
		public int solution(int X, int[] A) {
			// write your code in Java SE 8
			Set<Integer> existPath = new HashSet<>();
			int result = -1;
			for (int i = 0; i < A.length; i++) {
				if (existPath.contains(A[i])) {
					continue;
				} else {
					existPath.add(A[i]);
					System.out.println(existPath);
					if (existPath.size() == X) {
						return i;
					}
				}
			}
			return result;
		}
	}
}
