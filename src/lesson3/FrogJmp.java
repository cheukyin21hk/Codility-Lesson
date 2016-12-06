package lesson3;

public class FrogJmp {
	class Solution {
		public int solution(int X, int Y, int D) {
			// write your code in Java SE 8
			int result = (int) Math.ceil(((double) (Y - X)) / (double) D);
			return result;
		}
	}
}
