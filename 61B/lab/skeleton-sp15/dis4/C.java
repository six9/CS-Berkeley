class C extends B {
	public int y = x + 1;
	public void m2() {System.out.println("Cm2-> " + super.x);}
	// public void m3() {System.out.println("Cm3-> " + super.super.x);} // super.super.x is not allowed!
	public void m4() {System.out.println("Cm4-> " + y);}
	// public void m5() {System.out.println("Cm5-> " + super.y);} // there is no variable y in superclass B.
}