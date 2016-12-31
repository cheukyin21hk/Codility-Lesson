package lesson7;

import java.util.Stack;

public class StoneWall {

    class Solution {
	public int solution(int[] H) {
	    int numberOfStone = 1;
	    Stack<Integer> stackForCount = new Stack<>();
	    stackForCount.add(H[0]);
	    for (int i = 1; i < H.length; i++) {
		if (stackForCount.isEmpty()) {
		    stackForCount.add(H[i]);
		    numberOfStone++;
		} else {
		    if (H[i] < stackForCount.peek()) {
			boolean needIncrement = false;
			while (!stackForCount.isEmpty()) {
			    if (H[i] < stackForCount.peek()) {
				stackForCount.pop();
				needIncrement = true;
			    } else if (H[i] == stackForCount.peek()) {
				needIncrement = false;
				break;
			    } else if (H[i] > stackForCount.peek()) {
				stackForCount.add(H[i]);
				needIncrement = true;
				break;
			    }
			}

			if (stackForCount.isEmpty()) {
			    stackForCount.add(H[i]);
			}

			if (needIncrement) {
			    numberOfStone++;
			}
		    } else if (H[i] > stackForCount.peek()) {
			stackForCount.add(H[i]);
			numberOfStone++;
		    }
		}
	    }
	    return numberOfStone;
	}
    }
}
