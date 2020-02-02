public class FindSum {
	public static boolean findSum(int[] A, int x) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[i] + A[j] == x) { // Should we consider i != j ?
					return true;
				}
			}
		}
		return false;
	}

	public static boolean findSumFast(int[] A, int x) {
		int l = 0;
		int r = A.length - 1;
		while (l < r) {
			if (A[l] + A[r] == x) {
				return true;
			} else if (A[l] + A[r] > x) {
				r--;
			} else {
				l++;
			}
		}
		return false;
	}
}