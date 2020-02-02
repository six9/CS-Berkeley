import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest {
    @Test
    public void testBasic() {
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("San Francisco", "California");
        um.put("Seattle", "Washington");
        um.put("Portland", "Oregon");
        um.put("Los Angeles", "California");
        assertEquals(um.get("San Francisco"), "California");
        assertEquals(um.containsKey("Seattle"), true);
        assertEquals(um.size(), 4);
    }

    @Test
    public void testIterator() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        Iterator<Integer> umi = um.iterator();
        System.out.println(umi.next());
        System.out.println(umi.next());
        System.out.println(umi.next());
    }

    @Test
    public void testInvert() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        um.put(3, "three");
        ULLMap<String, Integer> umInv = ULLMap.invert(um);
        Iterator<String> umiInv = umInv.iterator();
        System.out.println(umiInv.next());
        System.out.println(umiInv.next());
        System.out.println(umiInv.next()); 
        System.out.println(umiInv.next());       
    }

    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ULLMapTest.class);
    }
} 