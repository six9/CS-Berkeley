class B extends A {
	public int x = 10;
	public void m2() {System.out.println("Bm2-> " + x);}
	public void m3() {System.out.println("Bm3-> " + super.x);}
	public void m4() {System.out.print("Bm4-> "); super.m2();}
}