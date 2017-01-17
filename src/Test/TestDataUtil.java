package Test;

import java.util.ArrayList;
import java.util.List;

public class TestDataUtil {
	public static List<Integer> generateRandList(int noOfInt, int upper, int lower) {
		List<Integer> result = new ArrayList<>();
		int generatedValue = 0;
		for (int i = 0; i < noOfInt; i++) {
			generatedValue = ((int) (Math.random() * (upper - lower)) + lower);
			result.add(generatedValue);
		}
		return result;
	}

	public static int[] generateRandArray(int noOfInt, int upper, int lower) {
		int[] result = new int[noOfInt];
		int generatedValue = 0;
		for (int i = 0; i < noOfInt; i++) {
			generatedValue = ((int) (Math.random() * (upper - lower)) + lower);
			result[i] = (generatedValue);
		}
		return result;
	}

}
