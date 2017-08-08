package lesson10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chrisng on 08/08/2017.
 * <p>
 * Assume that:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(log(N)));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * <p>
 * test data :
 * A[0] = 1
 * A[1] = 2
 * A[2] = 3
 * A[3] = 4 P
 * A[4] = 3
 * A[5] = 4 P
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6 P
 * A[11] = 2
 */

public class Peaks {

    public static void main(String args[]) {
        Peaks cf = new Peaks();
        cf.runTest(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2});
    }

    public void runTest(int[] testData) {
        Peaks.Solution proposedSolution = new Peaks.Solution();
        System.out.println(proposedSolution.solution(testData));
    }

    class Solution {
        private boolean isPeak(int[] dataList, int i) {
            return (dataList[i - 1] < dataList[i] && dataList[i] > dataList[i + 1]);
        }

        public int solution(int[] A) {

            List<Integer> peakValue = new ArrayList<>();
            for (int i = 1; i < A.length - 1; i++) {
                if (isPeak(A, i)) {
                    peakValue.add(i);

                }
            }

            for (int i = peakValue.size(); i > 0; i--) {
                if (A.length % i != 0) {
                    continue;
                }
                int interval = A.length / i;
                int acceptabledMiss = peakValue.size() - i;
                int actualMissed = 0;
                int currentBucket = 0;
                for (int j = 0; j < peakValue.size() && actualMissed <= acceptabledMiss; j++) {
                    int upperBound = (currentBucket + 1) * interval - 1;
                    int lowerBound = currentBucket * interval;
                    boolean hit = isBetween(peakValue.get(j), lowerBound, upperBound);
                    if (hit) {
                        currentBucket++;
                    } else {
                        actualMissed++;
                    }
                }
                if (acceptabledMiss >= actualMissed) {
                    return i;
                }
            }

            return 0;
        }

        private boolean isBetween(int integer, int lowerBound, int upperBound) {
            return lowerBound <= integer && integer <= upperBound;
        }

    }
}
