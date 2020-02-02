import java.util.Stack;

public class SQueue {
	private Stack<Integer> s1;

	public SQueue() {
		s1 = new Stack<Integer>();
	}

	public void enqueue(int item) {
		Stack<Integer> s2 = new Stack<Integer>();
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(item);
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	public int dequeue() {
		return s1.pop();
	}
}