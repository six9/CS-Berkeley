public class SListLauncher {	
	public static void main(String[] args) {
		SList L = new SList(5);
		L.insertBack(6);
		L.insertBack(2);
		System.out.println(L.size());
		L.insert(10, 1);
		System.out.println(L.size());
		L.print();
	}
}