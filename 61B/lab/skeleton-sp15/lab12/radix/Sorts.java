/* Radix.java */

package radix;
import java.util.Arrays;

/**
 * Sorts is a class that contains an implementation of radix sort.
 * @author
 */
public class Sorts {

    private static final int BASE = 16;
    /**
     *  Sorts an array of int keys according to the values of <b>one</b>
     *  of the base-16 digits of each key. Returns a <b>NEW</b> array and
     *  does not modify the input array.
     *  
     *  @param key is an array of ints.  Assume no key is negative.
     *  @param whichDigit is a number in 0...7 specifying which base-16 digit
     *    is the sort key. 0 indicates the least significant digit which
     *    7 indicates the most significant digit
     *  @return an array of type int, having the same length as "keys"
     *    and containing the same keys sorted according to the chosen digit.
     **/
    public static int[] countingSort(int[] keys, int whichDigit) {
        int[] result = new int[keys.length];
        int[] count = new int[BASE];
        int i, j;
        int radix = 1;
        for (i = 0; i < whichDigit; i++) {
            radix *= BASE;
        }

        for (i = 0; i < BASE; i++) {
            count[i] = 0; // initialize the count
        }
        for (i = 0; i < keys.length; i++) {
            j = (keys[i] / radix) % BASE;
            count[j]++; // count elements in each bucket
        }
        for (i = 1; i < BASE; i++) {
            count[i] = count[i - 1] + count[i]; 
            // allocate positions in result for each bucket
        }
        for (i = keys.length - 1; i >= 0; i--) {
            j = (keys[i] / radix) % BASE;
            result[count[j] - 1] = keys[i];
            count[j]--;
        }
        return result;
    }

    /**
     *  radixSort() sorts an array of int keys (using all 32 bits
     *  of each key to determine the ordering). Returns a <b>NEW</b> array
     *  and does not modify the input array
     *  @param key is an array of ints.  Assume no key is negative.
     *  @return an array of type int, having the same length as "keys"
     *    and containing the same keys in sorted order.
     **/
    public static int[] radixSort(int[] keys) {
        int[] result = new int[keys.length];
        int i, j;
        for (i = 0; i < keys.length; i++) {
            result[i] = keys[i];
        }
        for (j = 0; j < 8; j++) {
            result = countingSort(result, j);
            // sort from least to most significant digit
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {123, 222, 11, 79, 8322, 1, 213719, 37, 99999};
        System.out.println(Arrays.toString(radixSort(arr)));
    }

}
