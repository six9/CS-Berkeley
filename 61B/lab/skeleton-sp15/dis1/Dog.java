public class Dog {
    public static int size;
    public static String name;

    /* This is a constructor. It explains
     * how to construct dogs.
     * In this case, each dog must be
     * created with an integer, and it is
     * used as the size 
     *
     * def __init__(self, startSize):
     */
    public Dog(String startName, int startSize) {
        name = startName;
        size = startSize;
    }

    /* why did static go away?
       be patient. */

    public void bark(int x) {
        if (size < 10) {
            System.out.println("horrific yapping");
        } else if (size < 30) {
            System.out.println("bark.");
        } else {
            System.out.println("woof woofity woof!");
        }
    } 

    public void play() {
        System.out.println("play!");
    }
}