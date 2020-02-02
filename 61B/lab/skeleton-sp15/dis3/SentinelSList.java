public class SentinelSList {
	private SNode front;
	private SNode back;
	private int size;

	public void insertBack(double x) {
		back.next = new SNode(x, null);
		back = back.next;
		size = size + 1;
	}

	public int size() {
		return size;
	}

	public SentinelSList() {
		back = new SNode(0, null);
		front = new SNode(0, back);
		size = 0;
	}

	public SentinelSList(double x) {
		back = new SNode(x, null);
		front = new SNode(0, back);
		size = 1;
	}

	public void insert(double val, int position) {
		SNode p = front;
		int i = 0;
		while (p.next != back && i < position) {
			p = p.next;
			i++;
		}
		if (i == position) {
			p.next = new SNode(val, p.next);
		} else {
			back.next = new SNode(val, null);
		}
	}

	public void print() {
		SNode p = front.next;
		while (p != null) {
			System.out.print(String.valueOf(p.val) + " ");
			p = p.next;
		}
		System.out.println();
	}
}