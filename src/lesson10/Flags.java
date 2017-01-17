package lesson10;

import java.util.ArrayList;
import java.util.List;

public class Flags {
	class Solution {
		public int solution(int[] A) {

			int maxFlag = (int) Math.ceil(Math.sqrt(A.length));

			List<Integer> storedPeak = new ArrayList<>();

			boolean isPeak = false;

			for (int i = 1; i < A.length - 1; i++) {
				isPeak = A[i - 1] < A[i] && A[i] > A[i + 1];
				if (isPeak) {
					storedPeak.add(i);
				}
			}

			int numberOfCount = maxFlag;

			while (numberOfCount > 0 && storedPeak.size() > 0) {
				int validCount = 0;
				int lastPeak = storedPeak.get(0);

				for (int i = 1; i < storedPeak.size() && validCount < numberOfCount - 1; i++) {
					if (storedPeak.get(i) - lastPeak >= numberOfCount) {
						validCount++;
						lastPeak = storedPeak.get(i);
					}
				}
				validCount++;
				if (numberOfCount == validCount) {
					return validCount;
				} else {
					numberOfCount--;
				}
			}
			return 0;
		}

	}

	public void runTest(int[] testData) {
		Solution proposedSolution = new Solution();
		long st = System.currentTimeMillis();
		proposedSolution.solution(testData);
		System.out.println(System.currentTimeMillis() - st);
	}

}
