package test;

public class ArrayToSet {
	
	public static void main(String[] args) {
		MySet<String> set = new MySet<>(10);
		set.add("hi");
		set.print();
		set.add("hello");
		set.print();
		set.add("world");
		set.remove("hi");
		set.print();
	}
}

