package new5;

//declare importing static members
import static java.lang.Math.cos;
import static java.lang.Math.PI;

/**
 * JDK 5 New: Samples for Static Import
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/static-import.html
 */
public class StaticImport {

	public static void main(String[] args) {
			//In prior to JDK 5, use static methods or attributes.
			double theta = 0D;
			double r = Math.cos(Math.PI * theta);
			System.out.println("cos(0)=" + r);
			
			//In JDK5 later, the static import declaration imports static members from classes, 
			//   allowing them to be used without class qualification.
			//Note: Use it when you require FREQUENT access to static members from one or two classes.
			//Note: If you overuse the static import feature, it can make your program unreadable and unmaintainable, 
			//   polluting its namespace with all the static members you import.
			theta = 1/6D;
			r = cos(PI * theta);
			System.out.println("cos(π / 6)=" + r);
			
			theta = 1/3D;
			r = cos(PI * theta);
			System.out.println("cos(π / 3)=" + r);
			
			theta = 1/2D;
			r = cos(PI * theta);
			System.out.println("cos(π / 2)=" + r);
	}

}
