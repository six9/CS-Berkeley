import java.util.ArrayList;

public class Username {

    // Potentially useless note: (int) '0' == 48, (int) 'a' == 97

    // Instance Variables (remember, they should be private!)
    private int[] username = new int[3];
    private ArrayList<Integer> charList = new ArrayList<Integer>();

    public Username() {
        charListGen();

        int usernameLen = 0;
        if (Math.random() < 0.5) { // Randomly decide the length of username
            usernameLen = 2;
        } else {
            usernameLen = 3;
        }

        for (int k = 0; k < usernameLen; k++) {
            username[k] = charList.get((int) (Math.random() * 36));
        }
    }

    public Username(String reqName) {
        charListGen();

        if (reqName == null) {
            throw new NullPointerException("Requested username is null!");
        }
        if (reqName.length() != 2 && reqName.length() != 3) {
            throw new IllegalArgumentException("Incorrect username length!");
        }

        String lcName = reqName.toLowerCase();
        if (!charList.contains((int) lcName.charAt(0)) || 
            !charList.contains((int) lcName.charAt(1)) ||
            (lcName.length() == 3 && !charList.contains((int) lcName.charAt(2))) ) {
            throw new IllegalArgumentException("Illegal characters in username!");
        }

        for (int i = 0; i < lcName.length(); i++) {
            username[i] = (int) lcName.charAt(i);
        }

    }

    private void charListGen() {
        for (int i = 0; i < 10; i++) { // Add 0-9
            charList.add('0' + i);
        }
        for (int j = 0; j < 26; j++) { // Add a-z
            charList.add('a' + j);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Username) {
            Username other = (Username) o;
            if (this.hashCode() == other.hashCode()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() { 
        return username[0] * 1000000 + username[1] * 1000 + username[2];
    }

    public static void main(String[] args) {
        Username u = new Username();
        printName(u);
        u = new Username("abc");
        printName(u);
        u = new Username("7ba");
        printName(u);
        u = new Username("z9");
        printName(u);

        Username u1 = new Username();
        Username u2 = new Username();
        System.out.println("u1 equals u2? " + u1.equals(u2));
        u1 = new Username("2df");
        u2 = new Username("2df");
        System.out.println("u1 equals u2? " + u1.equals(u2));
    }

    private static void printName(Username u) {
        System.out.println("" + ((char) u.username[0]) + ((char) u.username[1])
                         + ((char) u.username[2]));
    }
}