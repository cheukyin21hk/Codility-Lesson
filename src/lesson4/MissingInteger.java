package lesson4;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
	class Solution {
		public int solution(int[] A) {
			Set<Integer> countingSet = new HashSet<>();
			for (int currentInt : A) {
				countingSet.add(currentInt);
			}

			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				if (countingSet.contains(i)) {
					continue;
				} else {
					return i;
				}
			}
			return 1;
		}
	}
}
