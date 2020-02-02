class SNode { 
	private Integer val;
	private SNode prev;

	public SNode(Integer v, SNode p) { 
		val = v;
		prev = p;
	}
	
	public SNode(Integer v) { 
		this(v, null); 
	}
} 