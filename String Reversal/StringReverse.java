
/**
 * This class has 2 implementations to reverse character array namely, in-place and returning reversed array.
 * 
 * @author Vidhixa Joshi 
 * @date 11/07/2015
 * 
 * The following assumptions were made while writing this class::
 * ---------------------------------------------------------------
 * 
 * 1. Since java does not allow overloading of methods with only different return type, I have suitably named methods to reverseInPlcaae and reverseReturnArray.
 * 
 * 2. 128 characters simple ASCII is considered.
 * 
 * 3. Null char arrays passed to the method will throw NullPointerException.
 * 
 * 3. The logic and lines of code are identical in both methods, except return type. One method can call another inside of it to reuse code but its advisable to 
 * have logic implemented in both as we do not want dependencies to exist. Also easy to test such independent methods using Junit.
 * 
 * 
 * The below solution was build by using the following approaches::
 * -----------------------------------------------------------------
 * 
 * 1. Reversing in-place : Find the middle index of character array. Swap first and last element and move closer to mid from both direction. Keep swapping elements 
 * in-place until you reach the mid. Time complexity will be O(n). Space complexity is O(1) for temp variable used for swapping.
 * 
 * 2. Reversing by returning array : Create a resultant array of the size of original array. Iterate the original array from right to left. Copy each element iterated in result
 * array in left to right fashion.  Time complexity will be O(n). Space complexity is O(n) because of creating result array.
 * 
 * 
 **/

public class StringReverse {
	
	public static void main(String[] args) {		
		char[] array = {'H','e','l','l','o'};
	
		//Return reversed array
		System.out.print("Given character array : ");
		printArray(array);
		char[] result = reverseReturnArray(array);
		System.out.print("Reversed returned array : ");
		printArray(result);	
		
		//In-place
		System.out.print("Given character array : ");
		printArray(array);
		reverseInPlace(array);
		System.out.print("Reversed in-place array : ");
		printArray(result);	

	}

	/**
	 * This methods reverses a character array in-place
	 * @param char[] array
	 * @return void
	 */
	public static void reverseInPlace(char[] array) {
		//Null input array is not allowed
		if(array ==  null) {
			throw new NullPointerException("Input array is null");
		}
		
		//mid will be the index across which elements will be swapped to reverse array
		int mid = array.length/2;
		char temp;
		
		//Swap elements on left and right side to mid 
		for(int i=0 ; i<mid ; i++) {
			temp = array[i];
			array[i] = array[array.length-1-i]; 
			array[array.length-1-i] = temp;
		}
		
	}
	
	
	/**
	 * This methods takes a character array and returns its reversed array
	 * @param char[] array
	 * @return char[] array
	 */	
	public static char[] reverseReturnArray(char[] array) {
		//Null input array is not allowed
		if(array ==  null) {
			throw new NullPointerException("Input array is null");
		}
		
		//Create a result array to store reverse of same size as original array
		char[] result = new char[array.length];
		
		//Iterate the original array from right to left and copy elements left to right in result
		for(int i=0 ; i<array.length ; i++) {
			result[i] = array[array.length-1-i];
		}		
		
		return result;
	}
	
	
	/**
	 * This methods prints the character array as string for simpler reading
	 * @param char[] array
	 * @return void
	 */
	public static void printArray(char[] array) {
		for(char c : array) {
			System.out.print(c);
		}
		System.out.println();
	}
	
}
