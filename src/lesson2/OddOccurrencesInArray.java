package lesson2;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
	class Solution {
		public int solution(int[] A) {
			Set<Integer> result = new HashSet<>();
			for (int currentInt : A) {
				if (result.contains(Integer.valueOf(currentInt))) {
					result.remove(Integer.valueOf(currentInt));
				} else {
					result.add(Integer.valueOf(currentInt));
				}
			}
			if (result.size() > 0) {
				return result.iterator().next().intValue();
			} else {
				return 0;
			}
		}
	}
}
