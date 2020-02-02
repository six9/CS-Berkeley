import java.util.Arrays;

public class CountingStars {
	public static String[] starCount(String[] args) {
		if (args == null || args.length == 0) {
			return args;
		}

		int count = 0;
		String[] copy = new String[args.length];
		int j = 0;
		for (int i = 0; i < args.length; i++) {
			if (args[i] == "star") {
				count++;
			} else {
				copy[j] = args[i];
				j++;
			}
		}

		if (isEven(count)) {
			return args;
		} else {
			return Arrays.copyOf(copy, args.length - count);
		}
	}

	private static boolean isEven(int x) {
		return (x & 1) == 0;
	}

	public static void main(String[] args) {
		String[] a = {"star", "cat", "dog", "star"};
		String[] b = {"cat", "nebula", "star", "planet", "star", "star", "moon"};
		System.out.println("Even number of \"star\"s:");
		System.out.println("Original: " + Arrays.toString(a));
		System.out.println("Result: " + Arrays.toString(starCount(a)));
		System.out.println("Odd number of \"star\"s:");
		System.out.println("Original: " + Arrays.toString(b));
		System.out.println("Result: " + Arrays.toString(starCount(b)));
	}
}