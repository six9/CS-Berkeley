import java.util.ArrayList;

public class Extra {
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				long arg = Long.parseLong(args[0]);
				if (arg < 0) {
					usage();
					return;
				}
				Stopwatch timer = new Stopwatch();
				function(arg);
				System.out.println(timer.elapsedTime() + " seconds elapsed");
			} catch (NumberFormatException e) {
				usage();
			}
		} else {
			usage();
		}
	}

	public static void function(long n) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (long i = 0; i < n; i++) {
			long j = i * i;
			while (j <= n) {
				j += 1;
				a.add(0);
				a.clear();
			}
		}
	}

	public static void usage() {
		System.out.println("To run function x with input n (where x and n " +
						   "are positive integers and x is less than 5) use" +
						   " the command 'java Asymptotics x n'");
	}
}