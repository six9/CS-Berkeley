import java.util.Arrays;

public class Insert {
	public static int[] insert(int[] x, int val, int position) {
		int[] result = new int[x.length + 1];
		for (int i = 0; i < x.length + 1; i++) {
			if (i < position) {
				result[i] = x[i];
			} else if (i == position) {
				result[i] = val;
			} else {
				result[i] = x[i - 1];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] x = {5, 9, 14, 15};
		int[] y = insert(x, 6, 2);
		System.out.println(Arrays.toString(y));
	}
}