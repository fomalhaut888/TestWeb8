package new7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JDK 7 New: Samples for Improved Compiler Warnings and Errors When Using Non-Reifiable Formal Parameters with Varargs Methods
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/non-reifiable-varargs.html
 */
public class ImprovedWarningsNonReifiable {

	public static void main(String[] args) {
			//1. Heap Pollution
			//A non-reifiable type: a type that is not completely available at runtime.
			//   such as ArrayList<Number> and List<String>, are non-reifiable types.
			//type erasure: a process non-reifiable types undergo during 
			//   which the compiler removes information related to type parameters and type arguments,
			//	 and ensures binary compatibility with Java libraries and applications that were created before generics.
			//Heap pollution: occurs when a variable of a parameterized type refers to an object that is not of that parameterized type.
			//   一個參數化型態(有指定泛型類別)的變數參考到一個無參數化型態(無指定泛型類別)的變數.
			//either at compile-time (within the limits of the compile-time type checking rules) or at runtime, 
			//   the correctness of an operation involving a parameterized type (for example, a cast or method call) cannot be verified.
			//a heap pollution situation occurs when the List object l, 
			//   whose static type is List<Number>, is assigned to another List object, ls, 
			//   that has a different static type, List<String>.
			List l = new ArrayList<Number>();
			List<String> ls = l;// unchecked warning
			//Because of type erasure, the type of the second formal parameter 
			//   of the add method (which is defined as List<E>.add(int,E)) becomes Object.
			l.add(0, new Integer(42)); // another unchecked warning
			//String s = ls.get(0);      // ClassCastException is thrown
			//System.out.println("s=" + s);
			
			//2. Variable Arguments Methods and Non-Reifiable Formal Parameters
			//Potential heap pollution may happen when using varargs with non-reifiable formal parameters.
			//The Java SE 7 generates the warning at both the declaration site and the call site.
			//The Java SE 5 and 6 compilers only generate this warning at the call site but not at the declaration site.
			List<String> stringListA = new ArrayList<String>();
		    List<String> stringListB = new ArrayList<String>();
		    
		    addToList(stringListA, "Seven", "Eight", "Nine");
		    addToList(stringListA, "Ten", "Eleven", "Twelve");
		    System.out.println("stringListA=" + stringListA);
		    
		    List<List<String>> listOfStringLists = new ArrayList<List<String>>();
		    //Compile warning: Type safety: A generic array of List<String> is created for a varargs parameter
		    addToList(listOfStringLists, stringListA, stringListB);
		    System.out.println("listOfStringLists=" + listOfStringLists);
		    
		    //3. Potential Vulnerabilities of Varargs Methods with Non-Reifiable Formal Parameters
		    //Compile warning: Type safety: A generic array of List<String> is created for a varargs parameter
		    faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
		    
		    //4. Suppressing Warnings from Varargs Methods with Non-Reifiable Formal Parameters
		    //Compile warning yet when the method with @SuppressWarnings("unchecked") is called: 
		    //  Type safety: A generic array of List<String> is created for a varargs parameter
		    addToList2(listOfStringLists, stringListA, stringListB);
		    System.out.println("listOfStringLists=" + listOfStringLists);
		    //No warnings are generated either at the method's declaration or when it is called.
		    //  This method uses @SafeVarargs.
		    addToList3(listOfStringLists, stringListA, stringListB);
		    System.out.println("listOfStringLists=" + listOfStringLists);
		    //Use the compiler option -Xlint:varargs.
		    //TODO when you are idle.
	}

	//Compile warning: Type safety: Potential heap pollution via varargs parameter since JDK7
	public static <T> void addToList (List<T> listArg, T... elements) {
			for (T x : elements) {
					listArg.add(x);
			}
	}
	
	@SuppressWarnings("unchecked")
	//@SuppressWarnings({"unchecked", "varargs"}) //Unsupported @SuppressWarnings("varargs")
	public static <T> void addToList2 (List<T> listArg, T... elements) {
			for (T x : elements) {
					listArg.add(x);
			}
	}
	
	@SafeVarargs
	public static <T> void addToList3 (List<T> listArg, T... elements) {
			for (T x : elements) {
					listArg.add(x);
			}
	}
	
	//Compile warning: Type safety: Potential heap pollution via varargs parameter l since JDK7
	public static void faultyMethod(List<String>... l) {
			//This statement can potentially introduce heap pollution.
			Object[] objectArray = l;  // Valid
			objectArray[0] = Arrays.asList(new Integer(42));
			//String s = l[0].get(0);    // ClassCastException thrown here
	}
}
