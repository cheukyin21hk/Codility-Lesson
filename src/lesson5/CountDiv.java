package lesson5;

public class CountDiv {
	class Solution {
		public int solution(int A, int B, int K) {
			if (A % K == 0) {
				return (B / K) - (A / K) + 1;
			} else {
				return (B / K) - (A / K);
			}
		}
	}
}