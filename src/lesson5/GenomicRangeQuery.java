package lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Target BIG-O in O(N+M)

public class GenomicRangeQuery {
    class Solution {
	private final int NUMBER_OF_DNA_COMBINATION = 4;
	private Map<Character, Integer> convertionMap = new HashMap<>();

	public int[] solution(String S, int[] P, int[] Q) {
	    convertionMap.put('A', 0);
	    convertionMap.put('C', 1);
	    convertionMap.put('G', 2);
	    convertionMap.put('T', 3);
	    List<int[]> prefixSum = new ArrayList<>();
	    // prefixSumCalculation

	    int[] tempResult = new int[NUMBER_OF_DNA_COMBINATION];
	    tempResult[convertionMap.get(S.charAt(0))]++;
	    prefixSum.add(tempResult);
	    for (int i = 1; i < S.length(); i++) {
		tempResult = new int[NUMBER_OF_DNA_COMBINATION];
		// Since the length is limited therefore is it Big-O(1)
		tempResult = Arrays
			.copyOf(prefixSum.get(i - 1), NUMBER_OF_DNA_COMBINATION);
		tempResult[convertionMap.get(S.charAt(i))]++;
		prefixSum.add(tempResult);
	    }

	    int[] result = new int[P.length];
	    // part of N
	    for (int i = 0; i < P.length; i++) {
		result[i] = getResult(S, prefixSum, P[i], Q[i]);
	    }
	    return result;
	}

	private int getResult(String s, List<int[]> prefixSum, int startIdx,
		int endIdx) {
	    if (startIdx != endIdx && startIdx != 0) {
		int[] prefixSumLatter = prefixSum.get(endIdx);
		int[] prefixSumEarly = prefixSum.get(startIdx - 1);
		for (int i = 0; i < NUMBER_OF_DNA_COMBINATION; i++) {
		    if (prefixSumLatter[i] - prefixSumEarly[i - 1] > 0) {
			return i + 1;
		    }
		}
	    } else if (startIdx != endIdx && startIdx == 0) {
		int[] prefixSumLatter = prefixSum.get(endIdx);
		for (int i = 0; i < NUMBER_OF_DNA_COMBINATION; i++) {
		    if (prefixSumLatter[i] > 0) {
			return i + 1;
		    }
		}
	    } else {
		return convertionMap.get(s.charAt(startIdx)) + 1;
	    }
	    return 0;
	}
    }
}
