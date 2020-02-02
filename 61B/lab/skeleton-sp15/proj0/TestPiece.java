import org.junit.Test;
import static org.junit.Assert.*;

public class TestPiece {
	@Test
	public void testAll() {
		Board b = new Board(false);
		Piece p = new Piece(true, b, 0, 0, "pawn");
		assertTrue(p.isFire());
		assertEquals(p.side(), 0);
		assertFalse(p.isKing());
		assertFalse(p.isBomb());
		assertFalse(p.isShield());
		assertFalse(p.isKing());
		assertFalse(p.hasCaptured());
		p.doneCapturing();
		assertFalse(p.hasCaptured());
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(TestPiece.class);  
	}
}