public class Part1 {
	public static void main(String[] args) {
		/* Question 1 */
		Animal a0 = new Animal();   // Line 1
		Fox f0 = new Fox();         // Line 2
		a0.speak();                 // Line 3
		f0.speak();                 // Line 4
		((Animal) f0).speak();      // Line 5
		// ((Fox) a0).speak();         // Line 6
		/* (a) What does the second line print? If it doesn't print anything, write None.
		 *     SuperAnimal
		 * (b) Will the fifth line cause an error? (Yes or No)
		 *     No
		 * (c) What does the fifth line print? If it doesn't print anything or causes an error, write None.
		 *     Ringding
		 * (d) Will the sixth line cause an error? (Yes or No)
		 *     Yes
		 * (e) What does the sixth line print? If it doesn't print anything or causes an error, write None.
		 *     None
		 * (f) Selection of overridden instance (non-static) methods is based on the _ type. (static or dynamic)
		 *     dynamic */
		System.out.println("----------------------------------------");

		/* Question 2 */
		Animal a1 = new Fox();
		a1.speak();
		((Animal) a1).speak();
		/* (a) Will the following line cause a (A) compile-time error or (B) run-time error. (A or B)
		 *     A
		// Fox f1 = new Animal();
		/* (b) What does the second line print?
		 *     Ringding
		/* (c) What does the third line print?
		 *     Ringding
		/* (d) The third line uses the _ type to select which speak() method to run. (static or dynamic)
		 *     dynamic */
		System.out.println("----------------------------------------");

		/* Question 3 */
		Animal a2 = new Animal();
		System.out.println(a2.name);
		Animal a3 = new Fox("SuperFox");
		System.out.println(a3.name);
		System.out.println(((Animal) a3).name);
		/* (a) Calling the Fox() constructor with one argument implicitly calls super(). (True or False)
		 *     No
		 * (b) What does the fourth line print?
		 *     SuperAnimal
		 * (c) What does the fifth line print?
		 *     SuperAnimal
		 * (d) Selection of hidden fields is based on the type. (static or dynamic)
		 *     static */
	}
}