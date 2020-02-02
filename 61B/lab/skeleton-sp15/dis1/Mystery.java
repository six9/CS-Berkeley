import java.util.Arrays;

public class Mystery {
	/** This is a function (a.k.a. method). It takes an array
	  * of integers as an argument, and returns an integer. */
	public static int mystery(int[] inputArray, int k) {
		int x = inputArray[k];
		int answer = k;
		int index = k + 1;
		while (index < inputArray.length) {
			if (inputArray[index] < x) {
				x = inputArray[index];
				answer = index;
			}
				index = index + 1;
		    }
		return answer;
	}

	 /** Extra for experts. This is another function. It takes an
	   * array of integers and returns nothing at all. */
	public static void mystery2(int[] inputArray) {
		int index = 0;
		while (index < inputArray.length) {
			int targetIndex = mystery(inputArray, index);
			int temp = inputArray[targetIndex];
			inputArray[targetIndex] = inputArray[index];
			inputArray[index] = temp;
			index = index + 1;
		} 
	}

	public static void main(String[] args) {
		int[] array = {3, 0, 1, 6, 3};
		System.out.println(mystery(array, 2));
		mystery2(array);
		System.out.println(Arrays.toString(array));
	}
}