class BadIntStack { 
	private SNode top;

	public boolean isEmpty() { 
		return top == null;
	}

	public void push(Integer num) {
		top = new SNode(num, top);
	}

	public Integer pop() { 
		if (top == null) {
			return null;
		}
		Integer ans = top.val; 
		top = top.prev;
		return ans;
	}

	public Integer peek() {
		if (top == null) {
			return null;
		}
		return top.val;
	}
}