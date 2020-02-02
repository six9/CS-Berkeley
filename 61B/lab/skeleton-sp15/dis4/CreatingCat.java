public class CreatingCat {
	public static void main(String[] args) {
		Cat smallCat = new Cat("Kitty", 2);
		Cat largeCat = new Cat("Garfield", 10);
		smallCat.greet();
		largeCat.greet();
	}
}