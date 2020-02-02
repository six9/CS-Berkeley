public class PracticeIntList {
	public static void main(String[] args) {
		IntList L = new IntList(4, null);
		L = new IntList(3, L);
		L = new IntList(2, L);
		L = new IntList(1, L);
		System.out.println("L: " + L.toString());

		IntList M = L.tail;
		IntList N = new IntList(6, null);
		System.out.println("M: " + M.toString());

		N = new IntList(5, N);
		System.out.println("N: " + N.toString());

		N.tail.tail = N;
		M.tail.tail.tail = N.tail;
		L.tail.tail = L.tail.tail.tail;
		L = M.tail;
	}
}