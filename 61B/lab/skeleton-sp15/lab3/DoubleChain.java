
public class DoubleChain {
	
	private DNode head;
	
	public DoubleChain(double val) {
		/* your code here. */
		head = new DNode(null, val, null); 
	}

	public DNode getFront() {
		return head;
	}

	/** Returns the last item in the DoubleChain. */		
	public DNode getBack() {
		/* your code here */
		DNode p = head;
		while (p.next != null) {
			p = p.next;
		}
		return p;
	}
	
	/** Adds D to the front of the DoubleChain. */	
	public void insertFront(double d) {
		/* your code here */
		head = new DNode(null, d, head);
	}
	
	/** Adds D to the back of the DoubleChain. */	
	public void insertBack(double d) {
		/* your code here */
		DNode p = head;
		while (p.next != null) {
			p = p.next;
		}
		p = new DNode(p, d, null);
		p.prev.next = p;
	}
	
	/** Removes the last item in the DoubleChain and returns it. 
	  * This is an extra challenge problem. */
	public DNode deleteBack() {
		/* your code here */
		DNode p = head;
		while (p.next != null) {
			p = p.next;
		}
		p.prev.next = null;
		return new DNode(p.prev, p.val, null);
	}
	
	/** Returns a string representation of the DoubleChain. 
	  * This is an extra challenge problem. */
	public String toString() {
		/* your code here */		
		DNode p = head;
		String result = String.valueOf(p.val);
		while (p.next != null) {
			p = p.next;
			result = result + ", " + String.valueOf(p.val);
		}
		return "<[" + result + "]>";
	}

	public void deleteByIndex(int n) {
		if (n == 0) {
			head = head.next;
			return;
		}
		int i = 0;
		DNode p = head;
		while (p.next != null & i < n) {
			p = p.next;
			i++;
		}
		if (p.next != null) {
			p.prev.next = p.next;
			p.next.prev = p.prev;
		} else {
			p.prev.next = null;
		}
	}

	public void deleteByValue(double val) {
		int i = 0;
		DNode p = head;
		if (Math.abs(p.val - val) < 1e-8) {
			deleteByIndex(i); // no need to add index
		}
		while (p.next != null) {
			p = p.next;
			i++;
			if (Math.abs(p.val - val) < 1e-8) {
				deleteByIndex(i);
				i--;
			}
		}
	}

	public static class DNode {
		public DNode prev;
		public DNode next;
		public double val;
		
		private DNode(double val) {
			this(null, val, null);
		}
		
		private DNode(DNode prev, double val, DNode next) {
			this.prev = prev;
			this.val = val;
			this.next = next;
		}
	}
	
}
