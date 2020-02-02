import java.util.AbstractList;

public class ArrayList61B<E> extends AbstractList<E> {
	private int size = 0;
	private E[] list;

	/* This constructor should initialize the size of the internal array to be
	 * initialCapacity and throw an IllegalArgumentException if initialCapacity is
	 * less than 1. */
	public ArrayList61B(int initialCapacity) {
		if (initialCapacity < 1) {
			throw new IllegalArgumentException();
		} else {
			list = (E[]) new Object[initialCapacity];
		}
	}

	/* This constructor should initialize the size of the internal array to be 1. */
	public ArrayList61B() {
		this(1);
	}

	/* This method should return the ith element in the list. This method should throw
	 * an IllegalArgumentException if i is less than 0 or greater than or equal to the
	 * number of elements in the list. */
	public E get(int i) {
		if (i < 0 || i >= size) {
			throw new IllegalArgumentException();
		} else {
			return list[i];
		}
	}

	/* This method should add item to the end of the list, resizing the internal array
	 * if necessary. This method should always return true (if you are curious about
	 * this, read the api for AbstractList). */
	public boolean add(E item) {
		if (size >= list.length) {
			list = resize(list);
		}
		list[size] = item;
		size++;
		return true;
	}

	/* Currently, this method only doubles the capacity of the list. */
	private E[] resize(E[] list) {
		E[] listNew = (E[]) new Object[list.length * 2];
		for (int i = 0; i < list.length; i++ ) {
			listNew[i] = list[i];
		}
		return listNew;
	}

	/* This method should return the number of elements in the list. Note that this is
	 * not necessarily the same as the number of elements in the internal array. */
	public int size() {
		return size;
	}
}