import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> implements Map61B<K, V> {
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private static final int MAXIMUM_CAPACITY = 1 << 30; // 2^30
	private int capacity;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private float loadFactor;
	private int threshold;
	private int size = 0;
	private LinkedList<Entry<K, V>>[] table;

	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public MyHashMap(int initialSize) {
		this(initialSize, DEFAULT_LOAD_FACTOR);
	}

	public MyHashMap(int initialSize, float loadFactor) {
		if (initialSize > MAXIMUM_CAPACITY) {
			this.capacity = MAXIMUM_CAPACITY;
		} else {
			this.capacity = trimToPowerOf2(initialSize);
		}
		this.loadFactor = loadFactor;
		threshold = (int) (capacity * loadFactor);
		table = new LinkedList[capacity];
	}

	/* Trim a number to the closest number that is a power of 2. */
	private int trimToPowerOf2(int initialSize) {
		int capacity = 1;
		while (capacity < initialSize) {
			capacity = capacity << 1; // capacity *= 2;
		}
		return capacity;
	}

	/** Removes all of the mappings from this map. */
	@Override
	public void clear() {
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				table[i].clear();
			}
		}
		size = 0;
	}

	/* Returns true if this map contains a mapping for the specified key. 
	 * Should run on average constant time when called on a HashMap. 
	 */
	@Override
	public boolean containsKey(K key) {
		int bucket = hash(key.hashCode());
		if (table[bucket] != null) {
			for (Entry<K, V> e : table[bucket]) {
				if (e.getKey().equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	/* Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key. Should run on average constant time
	 * when called on a HashMap. 
	 */
	@Override
	public V get(K key) {
		int bucket = hash(key.hashCode());
		if (table[bucket] != null) {
			for (Entry<K, V> e : table[bucket]) {
				if (e.getKey().equals(key)) {
					return e.getValue();
				}
			}
		}
		return null;		
	}

	/* Returns the number of key-value mappings in this map. */
	@Override
	public int size() {
		return size;
	}

	/* Associates the specified value with the specified key in this map. 
	 * Should run on average constant time when called on a HashMap. */
	@Override
	public void put(K key, V value) {
		if (size > threshold) { // Resize the table
			if (capacity == MAXIMUM_CAPACITY) {
				throw new RuntimeException("Exceeding maximum capacity!");
			}
			capacity = capacity << 1;
			table = new LinkedList[capacity];
			threshold = (int) (capacity * loadFactor);
			size = 0;
			rehash();
		}
		int bucket = hash(key.hashCode());
		if (table[bucket] == null) {
			table[bucket] = new LinkedList<Entry<K, V>>();
		}
		table[bucket].add(new Entry(key, value));
		size++;
	}

	private void rehash() {
		Set<Entry<K, V>> eSet = entrySet();
		for (Entry<K, V> e : eSet) {
			put(e.getKey(), e.getValue());
		}
	}

	/* Returns a Set view of the entries contained in this map. */
	private Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> eSet = new HashSet<Entry<K, V>>();
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				for (Entry<K, V> e : table[i]) {
					eSet.add(e);
				}
			}
		}
		return eSet;
	}

	/* Removes the mapping for the specified key from this map if present. 
	 * Should run on average constant time when called on a HashMap. */
	@Override
	public V remove(K key) {
		int bucket = hash(key.hashCode());
		V val;
		if (table[bucket] != null) {
			for (Entry<K, V> e : table[bucket]) {
				if (e.getKey().equals(key)) {
					val = e.getValue();
					table[bucket].remove(e);
					size--;
					return val;
				}
			}
		}
		return null;
	}

	/* Removes the entry for the specified key only if it is currently mapped to
	 * the specified value. Should run on average constant time when called on 
	 * a HashMap. */
	@Override
	public V remove(K key, V value) {
		int bucket = hash(key.hashCode());
		V val;
		if (table[bucket] != null) {
			for (Entry<K, V> e : table[bucket]) {
				if (e.getKey().equals(key) && e.getValue().equals(value)) {
					val = e.getValue();
					table[bucket].remove(e);
					size--;
					return val;
				}
			}
		}
		return null;	
	}

	/* Returns a Set view of the keys contained in this map. */
	@Override
	public Set<K> keySet() {
		Set<K> kSet = new HashSet<K>();
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				for (Entry<K, V> e : table[i]) {
					kSet.add(e.getKey());
				}
			}
		}
		return kSet;		
	}

	/* This function ensures that hashCodes that differ only by
	 * constant multiples at each bit position have a bounded
	 * number of collisions (approximately 8 at default load factor). 
	 * (Obviously stolen from Java library) */
	private int hash(int hashCode) {
		return supplementalHash(hashCode) & (capacity - 1);
	}
  
	/** Ensure the hashing is evenly distributed */
	private static int supplementalHash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	private class Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}
}