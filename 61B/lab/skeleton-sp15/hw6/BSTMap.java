import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
	private Node root;

	private class Node {
		private K key;
		private V value;
		private Node left, right;
		private int N;

		public Node(K key, V value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

	/** Removes all of the mappings from this map. */
	@Override
	public void clear() {
		root = null;
	}

	/* Returns true if this map contains a mapping for the specified key. */
	@Override
	public boolean containsKey(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		return get(key) != null;
	}

	/* Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key. */
	@Override
	public V get(K key) {
		return get(root, key);
	}

	private V get(Node x, K key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		} else {
			return x.value;
		}
	}

	/* Returns the number of key-value mappings in this map. */
	@Override
	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		}
		return x.N;		
	}

	/* Associates the specified value with the specified key in this map. */
	@Override
	public void put(K key, V value) {
		if (key == null || value == null) {
			throw new NullPointerException();
		}
		root = put(root, key, value);
	}

	private Node put(Node x, K key, V value) {
		if (x == null) {
			return new Node(key, value, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		x.N = 1 + size(x.left) + size(x.right);
		return x;	
	}

	public void printInOrder() {
		printInOrder(root);
	}

	private void printInOrder(Node x) {
		if (x.left == null && x.right == null) {
			System.out.println(x.key + " " + x.value);
		} else if (x.left == null) {
			System.out.println(x.key + " " + x.value);
			printInOrder(x.right);
		} else if (x.right == null) {
			printInOrder(x.left);
			System.out.println(x.key + " " + x.value);
		} else {
			printInOrder(x.left);
			System.out.println(x.key + " " + x.value);
			printInOrder(x.right);
		}
	}

	/* Removes the mapping for the specified key from this map if present.
	 * Not required for HW6. */
	@Override
	public V remove(K key) {
		throw new UnsupportedOperationException();
	}

	/* Removes the entry for the specified key only if it is currently mapped to
	 * the specified value. Not required for HW6. */
	@Override
	public V remove(K key, V value) {
		throw new UnsupportedOperationException();
	}

	/* Returns a Set view of the keys contained in this map. Not required for HW6. */
	@Override
	public Set<K> keySet() {
		throw new UnsupportedOperationException();
	}
}