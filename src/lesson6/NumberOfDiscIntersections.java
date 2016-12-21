package lesson6;

/**
 * @author lohris
 *         Time Complexity = NLog(N)
 *         Space Complexity = N
 */
public class NumberOfDiscIntersections {
    class Solution {
	final int MAX_OF_INTERSECT = 10000000;

	public int solution(int[] A) {
	    int result = 0;
	    result = handleAllRangePart(A);
	    if (result == -1) {
		return result;
	    }
	    return result;

	}

	private int handleAllRangePart(int[] A) {
	    int numberOfWholeRange = 0;
	    for (int i = 0; i < A.length; i++) {
		if (A[i] >= A.length) {
		    numberOfWholeRange++;
		}
	    }

	    if (numberOfWholeRange > MAX_OF_INTERSECT) {
		return -1;
	    } else {
		long result = (combination(numberOfWholeRange, 2) + (A.length - numberOfWholeRange)
			* numberOfWholeRange);
		if (result > MAX_OF_INTERSECT) {
		    return -1;
		} else {
		    return (int) result;
		}
	    }
	}

	private long factorial(int n) {
	    long result = 1;
	    for (int i = 1; i <= n; i++) {
		result *= i;
	    }
	    return result;
	}

	private long combination(int total, int pick) {
	    long result = factorial(total)
		    / (factorial(pick) * factorial(total - pick));
	    return result;
	}
    }
}
