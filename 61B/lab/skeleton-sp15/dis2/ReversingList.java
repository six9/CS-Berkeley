public class ReversingList {
	public static IntList reverseNonDestructive(IntList lst) {
		IntList p = null;
		if (lst == null) {
			return null;
		} 
		while (lst != null) {
			p = new IntList(lst.head, p);
			lst = lst.tail;
		}
		return p;
	}

	// The soultion is incorrect, only returns the first element.
	// Is there a easy way to do it without a swap() method?
	public static IntList reverseDestructive(IntList lst) {
		if (lst == null || lst.tail == null) {
			return lst;
		} else {
			IntList newHead = reverseDestructive(lst.tail);
			lst.tail.tail = lst;
			lst.tail = null;
			return newHead;
		}
	}

	public static void main(String[] args) {
		IntList L = new IntList(4, null);
		L = new IntList(3, L);
		L = new IntList(2, L);
		L = new IntList(1, L);
		System.out.println("L: " + L.toString());

		IntList LReversed = reverseNonDestructive(L);
		System.out.println("LReversed: " + LReversed.toString());
		System.out.println("L: " + L.toString());

		reverseDestructive(L);
		System.out.println("L: " + L.toString());
	}
}