package other;

import test.TestDataUtil;
import test.TestUtil;

/**
 * 1. An array int A[N] , can be positive and negative
 * 2. assume 0 <= P <= Q < N
 * 3. X =A[P] + A[Q] + (Q-P)
 * Find Largest X with
 * space complexity O(1)，
 * time complexity O(N)
 */
public class FindLargestIndexedValue {
    private static final int N = 10;

    public static void main(String[] args) {
        int[] testData = TestDataUtil.generateRandArray(10, 150, -150);
        System.out.println(findLargestXWithImprovedCorrected(testData));
    }


    public static int findLargestXWithImprovedCorrected(int[] inputArray) {
        int findIndex = findLargestElementForX(inputArray);
        int result = 0;
        for (int i = 0; i < inputArray.length; i++) {
            int x = calculateX(findIndex, i, inputArray);
            if (x > result) {
                result = x;
            }
        }
        return result;
    }

    public static int findLargestElementForX(int[] inputArray){
        int result = 0 ;
        for(int i = 0 ; i < inputArray.length;i++){
            if ((inputArray[i]+i) > (inputArray[result]+result)) {
                result = i;
            }
        }
        return result;
    }

    public static int calculateX(int p, int q, int[] inputArray) {
        if(q > p ){
            return inputArray[p] - p + inputArray[q] + q ;

        }else{
            return inputArray[p] + inputArray[q] + (p - q);
        }

    }


}
