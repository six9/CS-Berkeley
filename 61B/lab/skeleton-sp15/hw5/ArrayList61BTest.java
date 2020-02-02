import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

/** ArrayList61BTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ArrayList61BTest {
    @Test
    public void basicTest() {
        List<Integer> L = new ArrayList61B<Integer>();
        L.add(5);
        L.add(10);
        L.add(15);
        L.add(20);
        assertTrue(L.contains(5));        
        assertFalse(L.contains(0));
        assertEquals(5, (int) L.get(0));
        assertEquals(15, (int) L.get(2));
        assertEquals(4, L.size());
    }

    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ArrayList61BTest.class);
    }
}   