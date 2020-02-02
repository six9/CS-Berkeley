public class SquaringList {
	public static void SquareDestructive(IntList L) {
		IntList p = L;
		while (p != null) {
			p.head = p.head * p.head;
			p = p.tail;
        }
	}

	public static IntList SquareNonDestructive(IntList L) {
		if (L == null) {
			return null;
		} else {
			IntList tail = SquareNonDestructive(L.tail);
			return new IntList(L.head * L.head, tail);
        }
	}

	public static void main(String[] args) {
		IntList L = new IntList(4, null);
		L = new IntList(3, L);
		L = new IntList(2, L);
		L = new IntList(1, L);
		System.out.println("L: " + L.toString());

		IntList LSquared = SquareNonDestructive(L);
		System.out.println("LSquared: " + LSquared.toString());
		System.out.println("L: " + L.toString());

		SquareDestructive(L);
		System.out.println("L: " + L.toString());
	}
}