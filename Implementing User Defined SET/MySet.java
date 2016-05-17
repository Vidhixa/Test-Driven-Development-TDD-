package test;

import java.util.HashMap;
import java.util.Map;

public class MySet<E> {
	
	/*REFERENCES:
	http://www.tutorialspoint.com/java/java_generics.htm
	http://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
	http://stackoverflow.com/questions/18581002/how-to-create-a-generic-array
	http://stackoverflow.com/questions/14837185/how-can-we-dynamically-allocate-and-grow-an-array
	https://www.glassdoor.com/Interview/Pair-programming-test-driven-development-Implement-a-Set-class-without-additional-data-structures-QTN_791185.htm
	 */
	
	private Object[] array;
	private Map<E, Integer> indexMap;
	private int current;
	private int arrayGrowth = 10;
	
	@SuppressWarnings("unchecked")
	public MySet(int s) {
		array = (E[]) new Object[s]; 
		indexMap = new HashMap<E, Integer>();
		current = 0;
	}
	
	public Object[] getArray() {
		return array;
	}

	
	public void add(E element) {
		if(!indexMap.containsKey(element)) {
			if(current == array.length) {
				array = extendArray();
			}
			array[current] = element;
			indexMap.put(element, current);
			++current;
		}
	}
	
	public void remove(E element) {
		if(indexMap.containsKey(element)) {
			int index = indexMap.get(element);
			indexMap.remove(element);
			array[index] = null;
		}
	}
	
	public boolean contains(E element) {
		if(indexMap.containsKey(element)) {
			return true;
		}
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	public void clear() {
		array = (E[]) new Object[arrayGrowth];  
		indexMap.clear();
	}
	
	public int size() {
		return indexMap.size();
	}
	
	public boolean isEmpty() {
		if(indexMap.isEmpty()){
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void print() {
		for(Object element : array) {
			if(element != null) {
				System.out.print((E)element+" ");
			}
		}
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	private <E> Object[] extendArray() {
		Object[] newArray = (E[]) new Object[array.length + arrayGrowth];
		System.arraycopy(array, 0, newArray, 0, array.length);
		array =  newArray;
		return array;
	}
	
}


