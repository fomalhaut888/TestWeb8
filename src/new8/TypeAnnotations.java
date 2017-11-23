package new8;

import org.checkerframework.checker.interning.qual.Interned;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * JDK 8 New: Samples for Type Annotations Demo(not working)
 * @author SimonC
 * @see https://docs.oracle.com/javase/tutorial/java/annotations/basics.html
 * @see https://checkerframework.org/
 */
public class TypeAnnotations {

	public static void main(String[] args) {
			
			//Type Annotations and Pluggable Type Systems
			//Type annotations were created to support improved analysis of Java programs way of ensuring stronger type checking.
			//     The Java SE 8 release does not provide a type checking framework, 
			//         but it allows you to write (or download) a type checking framework 
			//         that is implemented as one or more pluggable modules 
			//         that are used in conjunction with the Java compiler.
			//     In many cases, you do not have to write your own type checking modules. 
			//         There are third parties who have done the work for you.
			//         For example, you might want to take advantage of the Checker Framework created by the University of Washington.
			//type 1: Class instance creation expression
			//    (refers to checker.jar of Checker Framework)
			//Compile Error in JDK7: Syntax error, type annotations are available only when source level is at least 1.8
			Object obj = new @Interned Object();
			System.out.println("obj=" + obj);
			
			//type 2: Type cast
			//    (refers to checker.jar of Checker Framework)
			//Compile Error in JDK7: Syntax error, type annotations are available only when source level is at least 1.8
			Object str = null;
			String myString = (@NonNull String) str;
			System.out.println("myString=" + myString);
	}
	
	//type 3: implements clause
	/*private static class UnmodifiableList<T> implements
    		@Readonly List<@Readonly T> {

		@Override
		public int size() {
			return 0;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public boolean contains(Object o) {
			return false;
		}

		@Override
		public Iterator<@Readonly T> iterator() {
			return null;
		}

		@Override
		public Object[] toArray() {
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			return null;
		}

		@Override
		public boolean add(@Readonly T e) {
			return false;
		}

		@Override
		public boolean remove(Object o) {
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends @Readonly T> c) {
			return false;
		}

		@Override
		public boolean addAll(int index, Collection<? extends @Readonly T> c) {
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return false;
		}

		@Override
		public void clear() {			
		}

		@Override
		public @Readonly T get(int index) {
			return null;
		}

		@Override
		public @Readonly T set(int index, @Readonly T element) {
			return null;
		}

		@Override
		public void add(int index, @Readonly T element) {
		}

		@Override
		public @Readonly T remove(int index) {
			return null;
		}

		@Override
		public int indexOf(Object o) {
			return 0;
		}

		@Override
		public int lastIndexOf(Object o) {
			return 0;
		}

		@Override
		public ListIterator<@Readonly T> listIterator() {
			return null;
		}

		@Override
		public ListIterator<@Readonly T> listIterator(int index) {
			return null;
		}

		@Override
		public List<@Readonly T> subList(int fromIndex, int toIndex) {
			return null;
		}
		
	}*/

	//type 4: Thrown exception declaration
	/*void monitorTemperature() throws
    	@Critical TemperatureException{
			
	}*/
}
