package new7;

import java.util.ArrayList;
import java.util.List;

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
			String s = ls.get(0);      // ClassCastException is thrown
			System.out.println("s=" + s);
			
			//2. Variable Arguments Methods and Non-Reifiable Formal Parameters
			//TODO
	}

}
