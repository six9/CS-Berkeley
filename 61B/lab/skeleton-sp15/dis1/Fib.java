public class Fib {
	public static int fib (int N) {
		if (N == 0) {
			return 0;
		} else if (N == 1 || N == 2) {
			return 1;
		} else {
			return fib(N - 1) + fib(N - 2);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(fib(i));
		}
	}
}