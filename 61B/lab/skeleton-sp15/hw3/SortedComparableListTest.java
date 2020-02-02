import static org.junit.Assert.*;
import org.junit.Test;

public class SortedComparableListTest {
	@Test
	public void testAll() {
		SortedComparableList l = new SortedComparableList(1, null);
		assertEquals("(1)", l.toString());

		l.insert(3);
		l.insert(-1);
		assertEquals("(-1, 1, 3)", l.toString());

		assertEquals(l.get(0), -1);

		SortedComparableList lp = new SortedComparableList(5, null);
		lp.insert(2);
		assertEquals("(2, 5)", lp.toString());

		l.extend(lp);
		assertEquals("(-1, 1, 2, 3, 5)", l.toString());

		assertEquals("(1, 2, 3, 5)", l.subTail(l, 1).toString());
		assertEquals("(1, 2, 3)", l.sublist(l, 1, 3).toString());
		assertEquals("(-1, 1, 2, 3, 5)", l.toString());

		l.expungeTail(l, 2);
		assertEquals("(-1, 1, 2)", l.toString());

		l = new SortedComparableList();
		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 5; j++) {
				l.insert(i + 1);
			}
		}
		assertEquals("(0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5)", l.toString());
		l.squish();
		assertEquals("(0, 1, 2, 3, 4, 5)", l.toString());

		l.twin();
		assertEquals("(0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5)", l.toString());
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(SortedComparableListTest.class);
	}
}