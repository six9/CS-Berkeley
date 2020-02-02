import org.junit.Test;
import static org.junit.Assert.*;

public class SQueueTest {
	@Test
	public void testAll() {
		SQueue sq = new SQueue();
		sq.enqueue(1);
		sq.enqueue(2);
		sq.enqueue(3);
		assertEquals(sq.dequeue(), 1);
		assertEquals(sq.dequeue(), 2);
		assertEquals(sq.dequeue(), 3);
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(SQueueTest.class);
	}
}