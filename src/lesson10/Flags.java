package lesson10;

import java.util.ArrayList;
import java.util.List;

import Test.TestDataUtil;
import Test.TestUtil;

public class Flags {
	class Solution {
		public int solution(int[] A) {
			int maxFlag = (int) Math.floor(Math.sqrt(A.length));
			List<Integer> storedPeak = new ArrayList<>();
			List<Integer> distanceBetweenPeak = new ArrayList<>();
			boolean isPeak = false;

			for (int i = 1; i < A.length - 1; i++) {
				isPeak = A[i - 1] < A[i] && A[i] > A[i + 1];
				if (isPeak) {
					storedPeak.add(i);
				}
			}
			if (storedPeak.size() == 1) {
				return 1;
			}

			for (int i = 0; i < storedPeak.size() - 1; i++) {
				distanceBetweenPeak.add(storedPeak.get(i + 1) - storedPeak.get(i));
			}
			System.out.println("Before : " + distanceBetweenPeak.toString());
			System.out.println("Before size: " + distanceBetweenPeak.size());

			reduceListSizeToTarget(maxFlag, distanceBetweenPeak);
			System.out.println("After : " + distanceBetweenPeak.toString());
			System.out.println("After size :  " + distanceBetweenPeak.size());

			int numberOfCount = maxFlag;
			boolean isValidCount = false;
			while (numberOfCount > 0) {

				//If not enough number of peak
				if (numberOfCount > distanceBetweenPeak.size() + 1) {
					numberOfCount = distanceBetweenPeak.size() + 1;
					//If the number of Peak equal to number of flag
				} else if (numberOfCount == distanceBetweenPeak.size() + 1) {
					reduceListSizeToTarget(numberOfCount, distanceBetweenPeak);
					isValidCount = true && (distanceBetweenPeak.size() != 0);
					for (int i = 0; i < distanceBetweenPeak.size(); i++) {
						if (distanceBetweenPeak.get(i) < numberOfCount) {
							isValidCount = false;
						}
					}
					if (isValidCount) {
						return numberOfCount;
					} else {
						numberOfCount--;
					}
					//if the number of Peak Smaller than number of flag
				} else {
					reduceListSizeToTarget(numberOfCount, distanceBetweenPeak);
					if (distanceBetweenPeak.size() + 1 > numberOfCount) {
						return numberOfCount;
					} else {
						isValidCount = true && (distanceBetweenPeak.size() != 0);
						for (int i = 0; i < distanceBetweenPeak.size(); i++) {
							if (distanceBetweenPeak.get(i) < numberOfCount) {
								isValidCount = false;
							}
						}
						if (isValidCount) {
							return numberOfCount;
						} else {
							numberOfCount--;
						}
					}
				}
			}

			return 0;
		}

		private void reduceListSizeToTarget(int targetValue, List<Integer> distanceBetweenPeak) {
			if (distanceBetweenPeak.size() > targetValue) {
				int baseIndex = 0;
				while (distanceBetweenPeak.size() > targetValue - 1 || baseIndex < distanceBetweenPeak.size() - 1) {
					if (distanceBetweenPeak.get(baseIndex) < targetValue) {
						distanceBetweenPeak.set(baseIndex, distanceBetweenPeak.get(baseIndex) + distanceBetweenPeak.get(baseIndex + 1));
						distanceBetweenPeak.remove(baseIndex + 1);
					} else {
						baseIndex++;
					}
				}
			}
		}
	}

	public void runTest(int[] testData) {
		Solution proposedSolution = new Solution();
		System.out.println(proposedSolution.solution(testData));
	}

	public static void main(String args[]) {
		Flags flags = new Flags();
		int[] a = TestDataUtil.generateRandArray(10000, 10, 0);
		TestUtil.printArray(a);
		flags.runTest(a);
	}

}
