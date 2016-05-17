/**
 * This class is a Junit test file to test StringReverse class methods
 * 
 * @author Vidhixa Joshi 
 * @date 11/07/2015
 * 
 * Summary of test cases ::
 * --------------------------
 * The following tests have been replicated to test both reverseInPlace and reverseReturnArray methods of StringReverse class :
 * 
 * 1. Null array as input => should throw NullPointerException
 * 2. Empty array as input => should return empty {} array
 * 3. Single character array => should return same single character
 * 4. Array of even length => should return reversed array
 * 5. Array of odd length => should return reversed array
 * 6. Randomly create 1000 arrays of random length (covers alpha-numeric characters, upper and lower case, other characters, etc) => should return reversed array,
 *  correctness verified by String reverse() function
 *  
 *  Find-bugs did not prompt any bug for StringReverse class.
 * 
 * What is not tested?
 * 
 * 1. Maximum length that character array can take => this is dependent upon underlying machine thus not tested.
 * 2. Explicitly checking for non-alpha-numeric characters => test 6 will certainly take care of it.
 * 3. Testing encoding standards other than simple ASCII => when the application is used across the globe, supporting many languages, testing more advanced encodings may 
 * be required. Given requirements specified 128 character supporting ASCII.
 * 4. Execution time and memory usage => Time and space complexity can be well understood by big-O notation. Specific instance of execution may take different times on
 * different machines depending upon the processor.
 * 
 **/

import static org.junit.Assert.assertArrayEquals;
import java.util.Random;
import org.junit.Test;

public class StringReverseTest {

	//1. Assert a null array exception
	@Test (expected = NullPointerException.class)
	public void reverseInPlaceTestNull() {
		StringReverse.reverseInPlace(null);
	}	
	@Test (expected = NullPointerException.class)
	public void reverseReturnArrayTestNull() {
		StringReverse.reverseReturnArray(null);
	}
	
	
	//2. Assert that empty array returns itself
	@Test
	public void reverseInPlaceTestEmpty() {
		char[] array = new char[0];
		char[] expected = new char[0];
		StringReverse.reverseInPlace(array);
		assertArrayEquals(expected, array);
	}
	@Test
	public void reverseReturnArrayTestEmpty() {
		char[] array = new char[0];
		assertArrayEquals(array, StringReverse.reverseReturnArray(array));
	}
	
	
	//3. Assert that an array with one char returns itself
	@Test
	public void reverseInPlaceTestSingle() {
		char[] array = {'s'};
		char[] expected = {'s'};
		StringReverse.reverseInPlace(array);
		assertArrayEquals(expected, array);
	}	
	@Test
	public void reverseReturnArrayTestSingle() {
		char[] array = {'s'};
		assertArrayEquals(array, StringReverse.reverseReturnArray(array));
	}
	
	
	//4. Assert that an array with even chars returns correct reversed list
	@Test
	public void reverseInPlaceTestEvenLength() {
		char[] array = {'E','v','e','n'};
		char[] expected = {'n','e','v','E'};
		StringReverse.reverseInPlace(array);
		assertArrayEquals(expected, array);
	}	
	@Test
	public void reverseReturnArrayTestEvenLength() {
		char[] array = {'E','v','e','n'};
		char[] expected = {'n','e','v','E'};
		assertArrayEquals(expected, StringReverse.reverseReturnArray(array));
	}
	
	
	//5. Assert that an array with odd chars returns correct reversed list
	@Test
	public void reverseInPlaceTestOddLength() {
		char[] array = {'O','d','d'};
		char[] expected = {'d','d','O'};
		StringReverse.reverseInPlace(array);
		assertArrayEquals(expected, array);
	}	
	@Test
	public void reverseReturnArrayTestOddLength() {
		char[] array = {'O','d','d'};
		char[] expected = {'d','d','O'};
		assertArrayEquals(expected, StringReverse.reverseReturnArray(array));
	}
	
	
	//6. Assert that randomly generated character array will return correct reverse string
	@Test
	public void reverseReturnArrayTestRadomly(){
		Random rand = new Random();
		StringBuffer sb = new StringBuffer();
		int length;
		
		for(int i=0; i<1000; i++) {
			length = rand.nextInt(1000);
			for(int j=0 ;  j<length ; j++) {
				sb.append((char)rand.nextInt(128));
			}	
			reverseReturnArrayTestRandomHelper(sb.toString(), sb.reverse().toString());		
			reverseInPlaceTestRandomHelper(sb.toString(), sb.reverse().toString());	
		}		
	}
	
	public void reverseInPlaceTestRandomHelper(String str, String reverse) {
		char[] array = str.toCharArray();
		StringReverse.reverseInPlace(array);
		assertArrayEquals(reverse.toCharArray() , array);
	}
	
	public void reverseReturnArrayTestRandomHelper(String str, String reverse) {
		assertArrayEquals(reverse.toCharArray() , StringReverse.reverseReturnArray(str.toCharArray()));
	}
	
}
