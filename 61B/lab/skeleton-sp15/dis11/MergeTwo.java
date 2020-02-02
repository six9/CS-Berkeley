import java.util.Arrays;

public class MergeTwo {
	public static int[] mergeTwo(int[] a, int[] b) {
		int ap = 0;
		int bp = 0;
		int[] c = new int[a.length + b.length];
		for (int i = 0; i < c.length; i++) {
			if (ap < a.length && bp < b.length) {
				if (a[ap] < b[bp]) {
					c[i] = a[ap];
					ap++;
				} else {
					c[i] = b[bp];
					bp++;
				}				
			} else if (ap < a.length) {
				c[i] = a[ap];
				ap++;
			} else if (bp < b.length) {
				c[i] = b[bp];
				bp++;
			}
		}
		return c;
	}

	public static void main(String[] args) {
		int[] a = {-18, -7, 0, 1, 3, 5, 11, 29, 253};
		int[] b = {-22, -7, 0, 2, 5, 9, 22, 111, 789, 1000, 2333};
		System.out.println(Arrays.toString(mergeTwo(a, b)));
	}
}