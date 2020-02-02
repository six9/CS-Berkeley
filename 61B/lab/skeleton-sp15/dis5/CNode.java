public class CNode {
	char head;
	CNode next;

	public CNode(char head, CNode next) {
		this.head = head;
		this.next = next;
	}

	public static CNode makeHugString(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		CNode start = new CNode(s.charAt(0), null);
		CNode curr = start;
		for (int i = 1; i < s.length(); i++) {
			curr.next = new CNode(s.charAt(i), null);
			curr = curr.next;
		}
		return start;
	}

	public static void swapSpace(CNode in) {
		CNode l = in;
		while (l != null) {
			if (l.head == ' ') {
				l.head = '6';
				l.next = new CNode('1', l.next);
				l.next.next = new CNode('B', l.next.next);
				l = l.next.next;
			}
			l = l.next;
		}
	}

	public static String toString(CNode in) {
		CNode l = in;
		String s = "";
		while (l != null) {
			s += l.head;
			l = l.next;
		}
		return s;
	}

	public static void main(String[] args) {
		CNode hs = CNode.makeHugString("University of California, Berkeley");
		System.out.println(CNode.toString(hs));
		CNode.swapSpace(hs);
		System.out.println(CNode.toString(hs));
	}
}