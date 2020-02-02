import java.util.Set; /* java.util.Set needed only for challenge problem. */
import java.util.Iterator;
import java.util.NoSuchElementException;

/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key. 
 *
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */ 
public class ULLMap<K, V> implements Map61B<K, V>, Iterable<K> {
    /** Keys and values are stored in a linked list of Entry objects.
      * This variable stores the first pair in this linked list. You may
      * point this at a sentinel node, or use it as a the actual front item
      * of the linked list. 
      */
    private Entry front;
    private int size;

    public Iterator<K> iterator() {
        return new ULLMapIter();
    }

    public class ULLMapIter implements Iterator<K> {
        private Entry p = front;

        public boolean hasNext() {
            return p != null;
        }

        public K next() {
            if (hasNext()) {
                K thisKey = p.key;
                p = p.next;
                return thisKey;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }

        // Check if key already exists in the list.
        Entry p = front;
        while (p != null) {
            if (p.key.equals(key)) {
                return p.val;
            }
            p = p.next;
        }

        // Key not found in the list.
        return null;        
    }

    @Override
    public void put(K key, V val) { 
        if (key == null || val == null) {
            return;
        }
        
        // Check if key already exists in the list.
        Entry p = front;
        while (p != null) {
            if (p.key.equals(key)) {
                p.val = val;
                return;
            }
            p = p.next;
        }

        // Key not found in the list.
        front = new Entry(key, val, front);
        size++;
    }

    @Override
    public boolean containsKey(K key) {
        return front.get(key) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        size = 0;
    }


    /** Represents one node in the linked list that stores the key-value pairs
     *  in the dictionary. */
    private class Entry {
    
        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K k, V v, Entry n) {
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry get(K k) { 
            if (key == null) {
                return null;
            }

            // Check if key already exists in the list.
            Entry p = front;
            while (p != null) {
                if (p.key.equals(k)) {
                    return p;
                }
                p = p.next;
            }

            // Key not found in the list.
            return null;
        }

        /** Stores the key of the key-value pair of this node in the list. */
        private K key;
        /** Stores the value of the key-value pair of this node in the list. */
        private V val;
        /** Stores the next Entry in the linked list. */
        private Entry next;
    
    }

    /* Methods below are all challenge problems. Will not be graded in any way. 
     * Autograder will not test these. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    public static <V, K> ULLMap<V, K> invert(ULLMap<K, V> map) {
        ULLMap<V, K> invertedMap = new ULLMap<V, K>();
        for (K k : map) {
            invertedMap.put(map.get(k), k);
        }
        return invertedMap;
    }
}