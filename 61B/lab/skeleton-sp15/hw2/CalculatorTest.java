import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /* Do not change this to be private. For silly testing reasons it is public. */
    public Calculator tester;

    /**
     * setUp() performs setup work for your Calculator.  In short, we 
     * initialize the appropriate Calculator for you to work with.
     * By default, we have set up the Staff Calculator for you to test your 
     * tests.  To use your unit tests for your own implementation, comment 
     * out the StaffCalculator() line and uncomment the Calculator() line.
     **/
    @Before
    public void setUp() {
        // tester = new StaffCalculator(); // Comment me out to test your Calculator
        tester = new Calculator();   // Un-comment me to test your Calculator
    }

    // TASK 1: WRITE JUNIT TESTS
    // YOUR CODE HERE

    @Test
    public void testAdd() {
        assertEquals(11 + 22, tester.add(11, 22));
        assertEquals(-7 + 15, tester.add(-7, 15));
        assertEquals(2 + -13, tester.add(2, -13));
    }

    @Test
    public void testMultiply() {
        assertEquals(5 * 7, tester.multiply(5, 7));
        assertEquals(-7 * 6, tester.multiply(-7, 6));
        assertEquals(3 * -17, tester.multiply(3, -17));
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(CalculatorTest.class);
    }       
}