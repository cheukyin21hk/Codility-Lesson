package lesson7;

import java.util.Stack;

/**
 * @author lohris
 * Target BIG-O in O(N)
 * Point to notice :
 * For this solution , The worst case space complexity is O(N)
 * to improve this problem , we can use int instead of stack for counting.
 * This should be able to solve the problem too,because the content is not the matter.
 */
public class Nesting {
	public static void main(String args[]) {
		new Nesting().runTest();
	}

	public void runTest() {
		Solution s = new Solution();
		System.out.println(s.solution("()()()(((()"));
		System.out.println(s.solution(""));
		System.out.println(s.solution("()()()"));
		System.out.println(s.solution("(()()())"));
		System.out.println(s.solution(")))))"));
	}

	class Solution {
		public int solution(String S) {
			if (isNested(S)) {
				return 1;
			} else {
				return 0;
			}
		}

		private boolean isNested(String s) {
			if (s == null || s.isEmpty()) {
				return true;
			}
			Stack<Character> storedChar = new Stack<>();
			Character tempChar = null;
			for (int i = 0; i < s.length(); i++) {
				tempChar = s.charAt(i);
				switch (tempChar) {
					case '(':
						storedChar.push('(');
						break;
					case ')':
						if (!storedChar.isEmpty()) {
							storedChar.pop();
						} else {
							return false;
						}
						break;
				}
			}
			if (storedChar.empty()) {
				return true;
			} else {
				return false;
			}
		}
	}

}
