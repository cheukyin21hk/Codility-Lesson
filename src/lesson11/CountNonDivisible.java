package lesson11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chrisng on 11/08/2017.
 */
public class CountNonDivisible {
    public static void main(String args[]) {
        CountNonDivisible cf = new CountNonDivisible();
        cf.runTest(new int[]{1, 1});
    }

    public void runTest(int[] input) {
        CountNonDivisible.Solution proposedSolution = new CountNonDivisible.Solution();
        int[] result = proposedSolution.solution(input);
        for (int i = 0; i < result.length; i++) {

            System.out.println("input : " + input[i] + " result :  " + result[i]);
        }
    }

    class Solution {
        public int[] solution(int[] A) {
            Map<Integer, Integer> countMap = new HashMap<>();
            int[] reusltForEachNumberArr = new int[A.length * 2];

            for (int currentInteger : A) {
                if (!countMap.containsKey(currentInteger)) {
                    countMap.put(currentInteger, 1);
                } else {
                    countMap.put(currentInteger, countMap.get(currentInteger) + 1);
                }
            }

            for (Iterator<Integer> it = (countMap.keySet()).iterator(); it.hasNext(); ) {
                int currentValue = it.next();
                int productOfCurrentValue = currentValue;
                while ((productOfCurrentValue) <= A.length * 2) {
                    if (countMap.containsKey(productOfCurrentValue)) {
                        reusltForEachNumberArr[productOfCurrentValue] += countMap.get(currentValue);
                    }
                    productOfCurrentValue += currentValue;
                }
            }

            int[] result = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                result[i] = A.length - reusltForEachNumberArr[A[i]];
            }
            return result;
        }


    }
}
