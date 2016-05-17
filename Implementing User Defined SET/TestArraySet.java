package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestArraySet {
	
	private MySet<String> testSet;
	
	@Before
	public void setUp() {
		testSet = new MySet<>(10);
		System.out.println("@Before - setUp");
	}

	@Test
	public void testAdd() {
		String[] expected = new String[10];
		expected[0] = "hi";
		testSet.add("hi");
		assertArrayEquals(expected, testSet.getArray());
	}
	
	@Test
	public void testAddDuplicate() {
		String[] expected = new String[10];
		expected[0] = "hi";
		testSet.add("hi");
		testSet.add("hi");
		assertArrayEquals(expected, testSet.getArray());
	}
	
	@Test
	public void testRemove() {	
		String[] expected = new String[10];
		testSet.add("hi");
		testSet.remove("hi");
		assertArrayEquals(expected, testSet.getArray());		
	}
	
	@Test
	public void testRemoveNotPresent() {	
		String[] expected = new String[10];
		testSet.remove("hi");
		assertArrayEquals(expected, testSet.getArray());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(testSet.isEmpty());
	}
	
	@Test
	public void testIsEmptyForNonEmpty() {
		testSet.add("hi");
		assertFalse(testSet.isEmpty());
	}
	
	@Test
	public void testContains() {
		testSet.add("hi");
		assertTrue(testSet.contains("hi"));
	}
	
	@Test
	public void testContainsNoSuchElement() {
		testSet.add("hi");
		assertFalse(testSet.contains("hello"));
	}

	//Multiple ways to test exceptions
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testExceptionAnnotation() { 
		String s = (String) testSet.getArray()[11];
	}
	
	/*@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testExceptionByThrowing() throws IndexOutOfBoundsException {
	    	String s = (String) testSet.getArray()[11];
	    	thrown.expect(IndexOutOfBoundsException.class);
	}*/
}
