package lesson4;

public class MaxCounters {
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	class Solution {
		public int[] solution(int N, int[] A) {
			// write your code in Java SE 8
			int lastMaxCounter = 0;
			int currentMaxCounter = 0;
			int[] counters = new int[N];
			for (int i = 0; i < A.length; i++) {
				if (A[i] <= N) {
					if (counters[A[i] - 1] < lastMaxCounter) {
						counters[A[i] - 1] = lastMaxCounter + 1;
					} else {
						counters[A[i] - 1]++;
					}
					currentMaxCounter = Math.max(currentMaxCounter, counters[A[i] - 1]);
				} else {
					lastMaxCounter = currentMaxCounter;
				}
			}

			for (int i = 0; i < counters.length; i++) {
				if (counters[i] < lastMaxCounter) {
					counters[i] = lastMaxCounter;
				}
			}
			return counters;
		}

	}

}
