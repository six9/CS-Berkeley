import static org.junit.Assert.*;
import org.junit.Test;

public class ApplicableIntListTest {
	@Test
	public void testAll() {
		ApplicableIntList l = new ApplicableIntList(1, null);
		assertEquals("(1)", l.toString());

		l.insert(3);
		l.insert(-1);
		assertEquals("(-1, 1, 3)", l.toString());

		assertEquals(l.get(0), -1);

		l.apply(new F());
		assertEquals("(0, 2, 12)", l.toString());
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(ApplicableIntListTest.class);
	}
}