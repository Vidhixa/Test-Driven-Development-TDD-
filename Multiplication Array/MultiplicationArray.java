
/**
 * This class has a method to return an array of products of elements in original array except element at same index.
 * 
 * @author Vidhixa Joshi 
 * @date 11/07/2015
 * 
 * The following assumptions were made while writing the class ::
 * ---------------------------------------------------------------
 * 
 * 1. An array with one element returns {1}. Assuming there are arithmetic operations performed over resultant, returning {1} will prevent possible
 * arithmetic exception as compared to when returned {0} eg: division operation.
 * 
 * 2. On multiplying very large integers, a possible overflow could occur which the code handles by throwing IllegalArgument exception.
 * Overflow will result in wrong decimal interpretation when machine converts the overflowed binary. This wrong value will be propagated 
 * further wherever the resultant array is used. Thus, throwing an exception will be the right action assuming the application further uses this resultant.
 * Given more information about the application, the return type could be changed to long or overflowed int can be substituted by int max/min/NaN value, 
 * whichever is correct and safer.
 * 
 * 3. Null arrays passed to the method will throw NullPointerException.
 * 
 * 4. Empty arrays will return empty arrays. Logically it makes sense to return an empty array without throwing an exception as in real life such conditions exist 
 * and applications should handle this condition eg: no students enrolled in class, no rows returned from SQL query, etc.
 *  
 * 
 * The below solution was build by optimizing following approaches::
 * ------------------------------------------------------------------
 * 
 * 1. Iterate through the integer array and compute the product at every index. 
 * Time complexity is high O(n^2) with repetitive multiplications.   
 * 
 * 2. Compute product of all elements at the beginning (O(n) operation). 
 * At each position of resulting array, divide the product by element at current index (O(n) operation). 
 * Time complexity will be O(n). Special cases such as 0 will have to be handled which will increase the time/space complexity.  
 * 
 * 3. Create two temporary arrays. Iterate the array from left to right and then right to left. Store product of elements on left and right
 *  in 2 temporary arrays respectively. Resultant array will be product of these two arrays. 
 *  Time complexity is O(n) but space complexity increases by O(2n).
 * eg: [1 2 3 4] => Left array [1 1 2 6] => Right array [24 12 4 1] 
 * 		Result   => [24 12 8 6]
 * 
 * 4. The above solution can be optimized by using a temp variable instead of left and right array. In the result array,
 * store products while iterating from left to right. Now iterate from right to left and store product of right elements encountered in a variable temp. 
 * Multiply temp to result array. Time complexity is O(n) and space complexity is O(1). This implementation is as follows.
 * 
 * 
 */


public class MultiplicationArray {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4};
		
		System.out.print("Given array : ");
		prettyPrintArray(array);
		
		System.out.print("Result array : ");
		prettyPrintArray(multiplyArray(array));	
	}	
	
	
	/**
	 * This methods multiplies each member in array except for the one in that position and returns resultant int array.
	 * @param int[] array
	 * @return int[] return
	 */
	public static int[] multiplyArray(int[] array) {
		//Null input array is not allowed
		if (array == null)	{
			throw new NullPointerException("Input array is null");
		}
		
		//Needs to be checked explicitly as empty arrays of size 0 may be passed
		if(array.length == 0) {
			return array;
		}
		
		//Create resultant array.
		//result[0] represents the product of elements on left of index 0, i.e. 1
		int[] result = new int[array.length];
		result[0] = 1;
		
		//Iterate left to right and at each position		
		//We also check for possible overflow conditions and throw exception
		for (int i = 1; i < array.length; i++)	{
			long val = (long)result[i-1] * (long)array[i-1];
			
			if(val > Integer.MAX_VALUE) {
				throw new IllegalArgumentException("Integer value greater than Integer.MAX_VALUE");
			}
			if(val < Integer.MIN_VALUE) {
				throw new IllegalArgumentException("Integer value smaller than Integer.MIN_VALUE");
			}
			//Compute the product of elements on left of i and store in result[i]
			result[i] = result[i-1] * array[i-1];
		}

		//temp represents the product of elements on right of rightmost element, i.e. 1
		int temp = 1;
		
		//Compute the product of elements on right of i and maintain it in temp
		//We also check for possible overflow conditions and throw exception
		for (int i = array.length - 1; i >= 0; i--)	{
			long val1 = (long)result[i] * (long)temp;
			long val2 = (long)temp * (long)array[i];
			
			if(val1 > Integer.MAX_VALUE || val2 > Integer.MAX_VALUE) {
				throw new IllegalArgumentException("Integer value greater than Integer.MAX_VALUE");
			}
			if(val1 < Integer.MIN_VALUE || val2 < Integer.MIN_VALUE) {
				throw new IllegalArgumentException("Integer value smaller than Integer.MIN_VALUE");
			}
			
			//Multiply temp to  result[i] to obtain product of left side elements and right side elements
			result[i] = result[i] * temp;
			//Update the product as we move leftward
			temp *= array[i];
		}
		
		return result;
	}
	
	
	/**
	 * This methods pretty prints the integer array
	 * eg: [1 2 3 ]
	 * @param int[] array
	 * @return void
	 */
	public static void prettyPrintArray(int[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for(int num : array) {
			sb.append(num+" ");
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

}


