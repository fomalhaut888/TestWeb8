package new8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JDK 8 New: Samples for Improved Type Inference.
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/enhancements.html#javase8
 */
public class ImprovedTypeInference {

	public static void main(String[] args) {
			
			List<String> stringList = new ArrayList<>();
			stringList.add("A");
			//In releases prior to Java SE 8, 
			//  Compile Error: The method addAll(Collection<? extends String>) in the type List<String> 
			//                 is not applicable for the arguments (List<Object>)
			//In relases Java SE 8 and later, this is accepted.
			//  Now considering generics, the target type of addAll is Collection<? extends String>, 
			//     and Arrays.asList returns a List<T> instance. 
			//  In this example, the Java SE 8 compiler can infer that the value of the type variable T 
			//     is String. The compiler infers this from the target type Collection<? extends String>.
			stringList.addAll(Arrays.asList());
			
			//In Java SE 7, you must explicitly specify values for type variables with type witnesses.
			List<String> stringList2 = new ArrayList<>();
			stringList2.add("A");
			stringList2.addAll(Arrays.<String>asList());
	}

}
