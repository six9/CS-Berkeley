import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class MyHashMapTest {
	@Test
	public void testMyHashMap() {
		MyHashMap<String, String> hm = new MyHashMap<String, String>();
		hm.put("Berkeley", "California");
		hm.put("San Francisco", "California");
		hm.put("New York", "New York");
		assertEquals(3, hm.size());
		assertEquals(true, hm.containsKey("Berkeley"));
		assertEquals(false, hm.containsKey("Stanford"));

		hm = new MyHashMap<String, String>(51);
		hm.put("Berkeley", "California");
		assertEquals(1, hm.size());
	}

	@Test
	public void testClear() {
		MyHashMap<String, String> hm = new MyHashMap<String, String>();
		hm.put("Berkeley", "California");
		hm.put("San Francisco", "California");
		hm.put("New York", "New York");
		hm.clear();
		assertEquals(0, hm.size());
	}

	@Test
	public void testGet() {
		MyHashMap<String, String> hm = new MyHashMap<String, String>();
		hm.put("Berkeley", "California");
		hm.put("San Francisco", "California");
		hm.put("New York", "New York");
		assertEquals("California", hm.get("Berkeley"));
	}

	@Test
	public void testRemove() {
		MyHashMap<String, String> hm = new MyHashMap<String, String>();
		hm.put("Berkeley", "California");
		hm.put("San Francisco", "California");
		hm.put("New York", "New York");
		assertEquals("California", hm.remove("Berkeley"));
		assertEquals(2, hm.size());
		hm.put("Berkeley", "California");
		assertEquals(null, hm.remove("Berkeley", "Mars"));
		assertEquals(3, hm.size());
	}

	@Test
	public void testKeySet() {
		MyHashMap<String, String> hm = new MyHashMap<String, String>();
		hm.put("Berkeley", "California");
		hm.put("San Francisco", "California");
		hm.put("New York", "New York");
		Set<String> expected = new HashSet<String>();
		expected.add("Berkeley");
		expected.add("San Francisco");
		expected.add("New York");
		assertEquals(expected, hm.keySet());
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(MyHashMapTest.class);
	}
}