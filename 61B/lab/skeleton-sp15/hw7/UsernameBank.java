import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class UsernameBank {

    // Instance variables (remember, they should be private!)
    private Map<String, String> emailName;
    private Map<String, String> nameEmail;
    private List<String> invalidNames;
    private List<String> invalidEmails;

    public UsernameBank() {
        emailName = new HashMap<String, String>();
        nameEmail = new HashMap<String, String>();
        invalidNames = new ArrayList<String>();
        invalidEmails = new ArrayList<String>();
    }

    public void generateUsername(String username, String email) {
        if (username == null || email == null) {
            throw new NullPointerException("Username or email is null!");
        }
        Username u = new Username(username);
        if (nameEmail.containsKey(username) || emailName.containsKey(email)) {
            throw new IllegalArgumentException("Username or email already exists!");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Illegal email format!");
        }
        emailName.put(email, username);
        nameEmail.put(username, email);
    }

    public String getEmail(String username) {
        if (username == null) {
            throw new NullPointerException("Username is null!");
        }
        try {
            Username u = new Username(username);
        } catch (IllegalArgumentException e) {
            invalidNames.add(username);
            return null;
        }
        if (!nameEmail.containsKey(username)) {
            invalidNames.add(username);
            return null;
        }
        return nameEmail.get(username);
    }

    public String getUsername(String userEmail)  {
        if (userEmail == null) {
            throw new NullPointerException("Email is null!");
        }
        if (!emailName.containsKey(userEmail) || !userEmail.contains("@")) {
            invalidEmails.add(userEmail);
            return null;
        }
        return emailName.get(userEmail);
    }

    public Map<String, Integer> getBadEmails() {
        Map<String, Integer> badEmailMap = new HashMap<String, Integer>();
        Set<String> badEmailSet = new HashSet<String>(invalidEmails);
        for (String email : badEmailSet) {
            // http://stackoverflow.com/q/505928/4095657
            badEmailMap.put(email, Collections.frequency(invalidEmails, email));
        }
        return badEmailMap;
    }

    public Map<String, Integer> getBadUsernames() {
        Map<String, Integer> badNameMap = new HashMap<String, Integer>();
        Set<String> badNameSet = new HashSet<String>(invalidNames);   
        for (String name : badNameSet) {
            // http://stackoverflow.com/q/505928/4095657
            badNameMap.put(name, Collections.frequency(invalidNames, name));
        }
        return badNameMap;
    }

    private static int count = 0;

    public String suggestUsername() {
        ArrayList<Integer> charList = new ArrayList<Integer>();
        String username = "";

        for (int i = 0; i < 10; i++) { // Add 0-9
            charList.add('0' + i);
        }
        for (int j = 0; j < 26; j++) { // Add a-z
            charList.add('a' + j);
        }

        int usernameLen = 0;
        if (Math.random() < 0.5) { // Randomly decide the length of username
            usernameLen = 2;
        } else {
            usernameLen = 3;
        }

        for (int k = 0; k < usernameLen; k++) {
            int tempChar = charList.get((int) (Math.random() * 36));
            username += "" + ((char) tempChar);
        }

        if (!nameEmail.containsKey(username)) {
            return username;
        }
        count++;
        if (count < 10) {
            return suggestUsername();
        } else {
            // Prob = 1 - (1/2)^10 > 99.9% when half of all possible names are used
            return null;
        }        
    }

    // The answer is somewhere in between 3 and 1000.
    public static final int followUp() {
        // 36^5 < 2^31 - 1 (range of int)
        return 5;
    }

    public static void main(String[] args) {
        UsernameBank ub = new UsernameBank();
        ub.generateUsername("a3c", "test1@berkeley.edu");
        ub.generateUsername("b3c", "test2@berkeley.edu");
        ub.generateUsername("c3c", "test3@berkeley.edu");
        System.out.println("Three valid random username:");
        System.out.println(ub.suggestUsername());
        System.out.println(ub.suggestUsername());
        System.out.println(ub.suggestUsername());

        // Invalid username
        // ub.generateUsername("f*k", "anotherone@berkeley.edu");
        // Invalid email
        // ub.generateUsername("4ax", "anotherone AT berkeley.edu");

        // Doing some bad things
        ub.getEmail("test1@stanford.edu");
        ub.getUsername("fxk");
        System.out.println("We have tried some bad things:");
        System.out.println(ub.getBadEmails().toString());
        System.out.println(ub.getBadUsernames().toString());
    }

    // Optional, suggested method. Use or delete as you prefer.
    // private void recordBadUsername(String username) {
        // YOUR CODE HERE
    // }

    // Optional, suggested method. Use or delete as you prefer.
    // private void recordBadEmail(String email) {
        // YOUR CODE HERE
    // }
}