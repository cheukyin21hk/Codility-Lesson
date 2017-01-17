package lesson10;

import java.util.ArrayList;
import java.util.List;

import Test.TestDataUtil;
import Test.TestUtil;

public class Flags {
	class Solution {
		public int solution(int[] A) {
			int maxFlag = (int) Math.floor(Math.sqrt(A.length));
			System.out.println("maxFlag : " + maxFlag);
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
			System.out.println("Before the loop : " + distanceBetweenPeak.toString());
			reduceListSizeToTarget(maxFlag, distanceBetweenPeak);
			System.out.println("After first Refactor : " + distanceBetweenPeak.toString());

			int numberOfCount = maxFlag;
			boolean isValidCount = false;
			while (numberOfCount > 0) {
				System.out.println("Number Of Count : " + numberOfCount);
				System.out.println("Size Of distanceBetweenPeak : " + distanceBetweenPeak.size());

				//If not enough number of peak
				if (numberOfCount > distanceBetweenPeak.size() + 1) {
					numberOfCount = distanceBetweenPeak.size() + 1;
					//If the number of Peak equal to number of flag
				} else if (numberOfCount == distanceBetweenPeak.size() + 1) {
					isValidCount = true && (distanceBetweenPeak.size() != 0);
					for (int i = 0; i < numberOfCount - 1 && isValidCount; i++) {
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
					System.out.println("Before : " + distanceBetweenPeak.toString());
					System.out.println("Before size: " + distanceBetweenPeak.size());
					reduceListSizeToTarget(numberOfCount, distanceBetweenPeak);
					System.out.println("After : " + distanceBetweenPeak.toString());
					System.out.println("After size :  " + distanceBetweenPeak.size());
					isValidCount = true && (distanceBetweenPeak.size() != 0);
					for (int i = 0; i < numberOfCount - 1; i++) {
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
				System.out.println("");
			}

			return 0;
		}

		private void reduceListSizeToTarget(int targetValue, List<Integer> distanceBetweenPeak) {
			System.out.println("Method ReduceListToTarget with parameter :");
			System.out.println("parameter targetValue : " + targetValue);
			System.out.println("parameter distanceBetweenPeak : " + distanceBetweenPeak.toString());

			if (distanceBetweenPeak.size() > targetValue - 1) {
				int baseIndex = 0;
				while (distanceBetweenPeak.size() > targetValue - 1 && baseIndex < distanceBetweenPeak.size() - 1) {

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

		int[] a = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };

		TestUtil.printArray(a);
		flags.runTest(a);

		a = TestDataUtil.generateRandArray(100, 2, 0);
		TestUtil.printArray(a);
		flags.runTest(a);
	}

}
