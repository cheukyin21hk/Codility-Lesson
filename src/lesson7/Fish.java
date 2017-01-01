package lesson7;

import java.util.Stack;

public class Fish {
	class Solution {
		public int solution(int[] A, int[] B) {
			int safeFishCount = 1;
			int previousFishDirection = B[0];
			int previousFishSize = A[0];
			Stack<Integer> storedDownSteamFish = new Stack<>();

			for (int i = 1; i < A.length; i++) {
				switch (previousFishDirection) {
					case 0:
					previousFishSize = A[i];
					previousFishDirection = B[i];
					safeFishCount++;
					break;
					case 1:
					switch (B[i]) {
						case 0:
						if (previousFishSize < A[i]) {
							boolean needCheckStack = true;
							while (needCheckStack && !storedDownSteamFish.isEmpty()) {
								if (storedDownSteamFish.peek() < A[i]) {
									storedDownSteamFish.pop();
								} else {
									needCheckStack = false;
									previousFishDirection = 1;
									previousFishSize = storedDownSteamFish.pop();
								}
							}
							if (needCheckStack == true) {
								previousFishSize = A[i];
								previousFishDirection = B[i];
							}
						}
						break;
						case 1:
						storedDownSteamFish.add(previousFishSize);
						previousFishSize = A[i];
						break;
					}
					break;
				}
			}
			return safeFishCount + storedDownSteamFish.size();
		}
	}
}
