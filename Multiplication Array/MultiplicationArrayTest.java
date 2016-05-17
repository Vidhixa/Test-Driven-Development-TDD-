/**
 * This class is a Junit test file to test MultiplicationArray class methods.
 * 
 * @author Vidhixa Joshi 
 * @date 11/07/2015
 * 
 * Summary of test cases ::
 * -------------------------
 * 
 * 1. Null array as input => should throw NullPointer exception
 * 2. Empty array as input => should return empty {} array
 * 3. Single integer array, non-zero positive => should return array with single integer {1}
 * 4. Single integer array, non-zero negative => should return array with single integer {1}
 * 5. Single integer array, zero => should return array with single integer {1}
 * 6. Array of even length, all positives => should return correct expected array
 * 7. Array of odd length, all positives => should return correct expected array
 * 8. Array of even length, all negatives => should return correct expected array
 * 9. Array of odd length, all negatives => should return correct expected array
 * 10. Array of even length, mix of positives and negatives => should return correct expected array
 * 11. Array of odd length, mix of positives and negatives => should return correct expected array
 * 12. Array of all zeros => should return an array of all zeros
 * 13. Array that had product going beyond scope of max integer value => should throw IllegalArgument exception
 * 14. Array that had product going beyond scope of min integer value => should throw IllegalArgument exception
 * 
 * Find-bugs did not prompt any bug for MultiplicationArray class.
 *  
 * What is not tested?
 * 
 * 1. Maximum length that integer array can take => this is dependent upon underlying machine thus not tested.
 * 2. Randomly creating integer arrays for test => this would require us to implement a similar logic to one in test to compute expected array. I tried covering all possibilities to  
 * scenarios to test in above cases.
 * 4. Execution time and memory usage => Time and space complexity can be well understood by big-O notation. Specific instance of execution may take different times on
 * different machines depending upon the processor.
 * 
 **/


import static org.junit.Assert.*;
import org.junit.Test;

public class MultiplicationArrayTest {
	
	//1. Assert a null array exception
	@Test (expected = NullPointerException.class)
	public void multiplyArrayTestNull() {
		int[] a = null;
		MultiplicationArray.multiplyArray(a);
	}
	
	
	//2. Assert that empty array returns itself
	@Test
	public void multiplyArrayTestEmpty() {
		int[] array = {};
		assertArrayEquals(new int[0], MultiplicationArray.multiplyArray(array));
	}
	
	
	//3. Assert that a single integer array with non-zero positive value returns {1}
	@Test
	public void multiplyArrayTestSinglePositive() {
		int[] array = {8};
		int[] expected = {1};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(array));		
	}
	
	
	//4. Assert that a single integer array with non-zero negative value returns {1}
	@Test
	public void multiplyArrayTestSingleNegative() {
		int[] array = {-20};
		int[] expected = {1};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(array));		
	}
	
	
	//5. Assert that a single integer array with zero returns {1}
	@Test
	public void multiplyArrayTestSingleZero() {
		int[] array = {0};
		int[] expected = {1};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(array));		
	}
		
	
	//6. Assert that an array of positive integers, even length returns correct array
	@Test
	public void multiplyArrayTestPositiveArrayEven() {
		int[] a = {1,2,3,4};
		int[] expected = {24,12,8,6};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(a));		
	}
	
	
	//7. Assert that an array of positive integers, odd length returns correct array
	@Test
	public void multiplyArrayTestPositiveArrayOdd() {
		int[] a = {1,2,3};
		int[] expected = {6,3,2};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(a));		
	}
	
	
	//8. Assert that an array of negative integers, even length returns correct array
	@Test
	public void multiplyArrayTestNegativeArrayEven() {
		int[] a = {-1,-2,-3,-4};
		int[] expected = {-24,-12,-8,-6};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(a));		
	}
	
		
	//9. Assert that an array of negative integers, odd length returns correct array
	@Test
	public void multiplyArrayTestNegativeArrayOdd() {
		int[] a = {-1,-2,-3};
		int[] expected = {6,3,2};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(a));		
	}
	
	
	//10. Assert that an array of mix of positive and negative integers, even length returns correct array
	@Test
	public void multiplyArrayTestMixArrayEven() {
		int[] a = {-1,2,-3,4};
		int[] expected = {-24,12,-8,6};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(a));		
	}
	
		
	//11. Assert that an array of mix of positive and negative integers, odd length returns correct array
	@Test
	public void multiplyArrayTestMixArrayOdd() {
		int[] a = {-1,2,-3};
		int[] expected = {-6,3,-2};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(a));		
	}

	
	//12. Assert that an array of all zeros returns the same array
	@Test
	public void multiplyArrayTestAllZeros() {
		int[] a = {0,0,0,0};
		int[] expected = {0,0,0,0};
		assertArrayEquals(expected, MultiplicationArray.multiplyArray(a));		
	}	

	
	//13. Assert an array where product goes beyond Integer.MAX_VALUE
	@Test (expected = IllegalArgumentException.class)
	public void multiplyArrayTestIntegerMax() {
		int[] a = {Integer.MAX_VALUE, 2, 3};
		MultiplicationArray.multiplyArray(a);		
	}	
	
		
	//14. Assert an array where product goes beyond Integer.MIN_VALUE
	@Test (expected = IllegalArgumentException.class)
	public void multiplyArrayTestIntegerMin() {
		int[] a = {Integer.MIN_VALUE, 2, 3};
		MultiplicationArray.multiplyArray(a);		
	}				

}
