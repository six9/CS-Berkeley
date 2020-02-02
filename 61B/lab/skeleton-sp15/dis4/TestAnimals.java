public class TestAnimals {
	public static void main(String[] args) {
		Animal a = new Animal("Pluto", 10);
		Cat c = new Cat("Garfield", 6);
		Dog d = new Dog("Fido", 4);
		a.greet(); // Animal Pluto says: Huh?
		c.greet(); // Cat Garfield says: Meow!
		d.greet(); // Dog Fido says: WOOF!
		a = c;
		a.greet(); // Cat Garfield says: Meow!
		((Cat) a).greet(); // Cat Garfield says: Meow!

		/* Compiler error!
		 * because a Dog is an Animal, but an Animal is not necessarily a Dog. */
		// a = new Dog("Hiernoymus", 10);
		// d = a;

		/* We have to make an awkward cast. */
		a = new Dog("Hiernoymus", 10);
		d = (Dog) a;
	}
}