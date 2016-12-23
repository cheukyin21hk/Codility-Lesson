package lesson7;

import java.util.Stack;

/**
 * @author lohris
 * Target BIG-O in O(N)
 * Point to notice :
 * 1.) the all open case
 */
public class Brackets {
	class Solution {
		public int solution(String S) {
			if (isProperlyNested(S)) {
				return 1;
			} else {
				return 0;
			}
		}

		private boolean isProperlyNested(String s) {
			if (s == null || s.isEmpty()) {
				return true;
			}
			Stack<Character> storedChar = new Stack<>();
			Character tempChar = null;
			for (int i = 0; i < s.length(); i++) {
				tempChar = s.charAt(i);
				switch (tempChar) {
					case '}':
						if (storedChar.isEmpty()) {
							return false;
						} else {
							switch (storedChar.peek()) {
								case '(':
								case '[':
									return false;
								case '{':
									storedChar.pop();
							}
						}
						break;
					case ')':
						if (storedChar.isEmpty()) {
							return false;
						} else {
							switch (storedChar.peek()) {
								case '{':
								case '[':
									return false;
								case '(':
									storedChar.pop();
							}
						}
						break;
					case ']':
						if (storedChar.isEmpty()) {
							return false;
						} else {
							switch (storedChar.peek()) {
								case '(':
								case '{':
									return false;
								case '[':
									storedChar.pop();
							}
						}
						break;
					default:
						storedChar.push(tempChar);
				}
			}
			if (storedChar.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
	}

}
