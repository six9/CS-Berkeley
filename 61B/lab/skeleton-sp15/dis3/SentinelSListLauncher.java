public class SentinelSListLauncher {
	public static void main(String[] args) {
		SentinelSList L = new SentinelSList(1);
		L.insertBack(2);
		L.insertBack(3);
		L.insertBack(4);
		L.print();
		L.insert(13, 4);
		L.print();
	}
}