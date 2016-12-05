package lesson1;

public class BinaryGap {

	class Solution {
		public int solution(int N) {
			String[] diffBinaryGap = Integer.toBinaryString(N).replace("0", " ").trim().split("1");
			if (diffBinaryGap.length > 0) {
				int largestBinaryGap = diffBinaryGap[0].length();
				for (String currentBinaryGap : diffBinaryGap) {
					if (currentBinaryGap.length() > largestBinaryGap) {
						largestBinaryGap = currentBinaryGap.length();
					}
				}
				return largestBinaryGap;
			} else {
				return 0;
			}
		}
	}
}
