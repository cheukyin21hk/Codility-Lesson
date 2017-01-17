package Test;

public class TestUtil {
	public static void printArray(int[] a) {
		System.out.print("[ ");
		for (int i = 0; i < a.length - 1; i++) {
			System.out.print(a[i] + " ,");
		}
		System.out.print(a[a.length - 1]);
		System.out.println(" ]");

	}

}
