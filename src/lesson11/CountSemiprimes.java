package lesson11;

/**
 * Created by chrisng on 10/08/2017.
 */
public class CountSemiprimes {
    public static void main(String args[]) {
        CountSemiprimes cf = new CountSemiprimes();
        cf.runTest(2147483647);
    }

    public void runTest(int testData) {
        CountSemiprimes.Solution proposedSolution = new CountSemiprimes.Solution();
        int[] result = proposedSolution.solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20});
        for (int currentCount : result) {
            System.out.println(currentCount);
        }
    }

    class Solution {
        public int[] solution(int N, int[] P, int[] Q) {
            int[] primeDivisor = new int[N + 1];
            boolean[] isSemiPrimeArr = new boolean[N + 1];
            int[] cacheSemiPrime = new int[N + 1];

            getSmallestPrimeDivisorForAll(primeDivisor);
            getIsSemiPrimeForAll(isSemiPrimeArr, primeDivisor);
            getCountSemiPrimeForAll(cacheSemiPrime, isSemiPrimeArr);

            int[] result = new int[P.length];
            for (int i = 0; i < Q.length; i++) {
                int firstValue = P[i];
                int secondValue = Q[i];
                result[i] = cacheSemiPrime[secondValue] - cacheSemiPrime[firstValue - 1];
            }
            return result;
        }

        private void getCountSemiPrimeForAll(int[] cacheSemiPrime, boolean[] isSemiPrimeArr) {
            int totalCount = 0;
            for (int i = 0; i < cacheSemiPrime.length; i++) {
                if (isSemiPrimeArr[i]) {
                    totalCount++;
                }
                cacheSemiPrime[i] = totalCount;
            }
        }

        private boolean isValueSemiPrime(int j, int[] primeDivisor) {
            if (isPrime(j, primeDivisor)) {
                return false;
            }
            int dividedResult = primeDivisor[j];
            if (isPrime((j / dividedResult), primeDivisor)) {
                return true;
            } else {
                return false;
            }
        }

        private boolean isPrime(int i, int[] primeDivisor) {
            if (primeDivisor[i] == 0) {
                return true;
            } else {
                return false;
            }
        }

        private void getIsSemiPrimeForAll(boolean[] isSemiPrimeArr, int[] inputArray) {
            for (int i = 1; i <= inputArray.length - 1; i++) {
                isSemiPrimeArr[i] = isValueSemiPrime(i, inputArray);
            }
        }

        private void getSmallestPrimeDivisorForAll(int[] inputArray) {
            int currentPrime = 2;
            int n = inputArray.length - 1;
            while (currentPrime * currentPrime <= n) {
                if (inputArray[currentPrime] == 0) {
                    int primeForCalculation = currentPrime * currentPrime;
                    while (primeForCalculation <= n) {
                        if (inputArray[primeForCalculation] == 0) {
                            inputArray[primeForCalculation] = currentPrime;
                        }
                        primeForCalculation += currentPrime;
                    }
                }
                currentPrime += 1;
            }
        }

    }

}
