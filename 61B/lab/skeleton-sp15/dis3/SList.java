public class SList {
    private SNode front;
    private int size;

    public void insertBack(int x) {
        if (front == null) {
            front = new SNode(x, null);
            size = 1;
            return;
        }

        SNode p = front;
        while (p.next != null) {
            p = p.next;
        }

        // p is the LAST node at this point
        p.next = new SNode(x, null);
        size = size + 1;
    }

    public double getBack() {
        SNode p = front;
        while (p.next != null) {
            p = p.next;
        }

        // p is the LAST node at this point
        return p.val;
    }

    public int size() {
        return size;
    }

    /* Return the size of the sublist starting
     * at SNode x */
    /*private int size(SNode x) {
        if (x == null)
            return 0;
        return 1 + size(x.next);
    }*/

    public SList(int x) {
        front = new SNode(x, null);
        size = 1;
    }

    public SList() {
        size = 0;
        front = null;
    }

    public double getFront() {
        return front.val;
    }

    public void insertFront(int x) {
        front = new SNode(x, front);
        size = size + 1;
    }

	public void insert(double val, int position) {
		int i = 0;
		SNode p = front;

		if (p == null || position == 0) {
			front = new SNode(val, front);
		} else {
			while (p.next != null && i < position - 1) {
				p = p.next;
				i++;
			}
			p.next = new SNode(val, p.next);
		}
		size = size + 1;
	}

	public void print() {
		SNode p = front;
		while (p != null) {
			System.out.print(String.valueOf(p.val) + " ");
			p = p.next;
		}
		System.out.println();
	}
}