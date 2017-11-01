package new7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDK 7 New: Samples for Type Inference for Generic Instance Creation
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/type-inference-generic-instance-creation.html
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/enhancements.html#javase8
 * @see https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html
 */
public class TypeInferenceForGenericInstanceCreation {

	public static void main(String[] args) {
			Map<String, List<String>> myMap1 = new HashMap<String, List<String>>();
			myMap1.put("A", new ArrayList<String>());
			System.out.println("myMap1=" + myMap1);
			Map<String, List<String>> myMap2 = new HashMap<>();
			myMap2.put("A", new ArrayList<String>());
			//***In JDK7 this is wrong: The method put(String, List<String>) in the type Map<String,List<String>> 
			//   is not applicable for the arguments (String, ArrayList<Object>)
			//***But in JDK8 this is OK!
			myMap2.put("B", new ArrayList<>());
			System.out.println("myMap2=" + myMap2);
			
			Map<String, List<String>> myMap = new HashMap(); // unchecked conversion warning
			//HashMap is a raw type. References to generic type HashMap<K,V> should be parameterized
			
			List<String> list = new ArrayList<>();
			list.add("A");
			
			//***In JDK7 this is wrong: The following statement should fail since addAll expects
			//    Collection<? extends String>
			//    The method addAll(Collection<? extends String>) in the type List<String> 
			//    is not applicable for the arguments (ArrayList<Object>)
			//***But in JDK8 this is OK!
			list.addAll(new ArrayList<>());
			System.out.println("list=" + list);
			
			//***In JDK7, it is suggested that you use the diamond primarily for variable declarations.
			//The following statements compile:
			//***But in JDK8 the diamond is more improved.
			List<? extends String> list2 = new ArrayList<>();
			list.addAll(list2);
			
			//Type Inference and Generic Constructors of Generic and Non-Generic Classes
			new MyClass<Integer>("Simon");
			MyClass<Integer> myObject = new MyClass<>("Jack");
	}
}

class MyClass<X>{
	<T> MyClass(T t){
			System.out.println("MyClass object created, name: " + t);
	}
}
