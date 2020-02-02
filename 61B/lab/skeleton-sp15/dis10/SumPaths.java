public class SumPaths {
	public void printSumPaths(Node t, int k) {
		if (t != null) {
			sumPathsHelper(t, 0, "", k);
		}
	}

	private void sumPathsHelper(Node n, int sum, String path, int k) {
		sum += n.value;
		path += n.value + " ";

		if (n.left == null && n.right == null) {
			if (sum == k) {
				System.out.println(path);
			}
			return;
		}

		if (n.left == null) {
			sumPathsHelper(n.right, sum, path, k);
		}

		if (n.right == null) {
			sumPathsHelper(n.left, sum, path, k);
		}
	}

	private class Node {
		Node left;
		Node right;
		int value;
	}
}