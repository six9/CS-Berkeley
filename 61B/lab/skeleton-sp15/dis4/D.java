class D {
	public static void main (String[] args) {
		// B a0 = new A(); // A can't be converted to B. Must cast if you want.
		// a0.m1(); // see the line above.
		A b0 = new B();
		System.out.println(b0.x);
		b0.m1(); // class B hides a field in class A.
		b0.m2(); // you should never hide fields.
		// b0.m3(); // as you’ll see, it’s confusing! see C.java: super.super.x not allowed!
		B b1 = new B();
		b1.m3();
		b1.m4();
		A c0 = new C();
		c0.m1();
		// C c1 = (A) new C(); // B can't be converted to C. Must cast if you want.
		A a1 = (A) c0;
		C c2 = (C) a1;
		c2.m4();
		// c2.m5(); // see C.java: there is no variable y in superclass B.
		// ((C) c0).m3(); // very tricky! see C.java: super.super.x not allowed!
		// (C) c0.m3(); // same as the line above.
		b0.update();
		b0.m1();
		b0.m2();
	}
}