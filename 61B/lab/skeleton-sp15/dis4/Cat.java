public class Cat extends Animal {
	public Cat(String name, int age) {
		super(name, age);
		noise = "Meow!";
	}

	public String makeNoise() {
		return super.makeNoise();
	}

	@Override
	public void greet() {
		System.out.println("Cat " + name + " says: " + makeNoise());
	}
}