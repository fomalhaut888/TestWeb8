package new5;

import java.text.MessageFormat;
import java.util.Date;

/**
 * JDK 5 New: Samples for Varargs
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
 */
public class Varargs {

	public static void main(String[] args) {
			
			Object[] arguments = {
					new Integer(7),
					new Date(),
					"a disturbance in the Force"
			};
			String result1 = MessageFormat.format(
					"At {1,time} on {1,date}, there was {2} on planet "
					+ "{0,number,integer}.", arguments);
			System.out.println("result1=" + result1);
			
			String result2 = MessageFormat.format(
					"At {1,time} on {1,date}, there was {2} on planet "
					+ "{0,number,integer}.",
					7, new Date(), "a disturbance in the Force");
			System.out.println("result2=" + result2);
			
			varargsMethod("Simon");
			varargsMethod("Mary", 90, 95,100, 99, 99, 100);
			
			String classNames[] = {
					"java.lang.String",
					"java.lang.Integer",
					"java.lang.Long",
					"new5.MyClass"
			};
			int passed = 0;
	        int failed = 0;
	        for (String className : classNames) {
	        		try {
	        				Class c = Class.forName(className);
	        				c.getMethod("test").invoke(c.newInstance());
	        				passed++;
	        		} catch (Exception ex) {
	        				System.out.printf("%s failed: %s%n", className, ex);
	        				failed++;
	        		}
	        }
	        System.out.printf("passed=%d; failed=%d%n", passed, failed);
	}

	public static void varargsMethod(String name, int...grades){
			System.out.print(name + "'s math grades: ");
			for(int grade: grades){
					System.out.print(grade + ", ");
			}
			System.out.println();
	}
}

class MyClass{
	
	public void test(){
			System.out.println("test");
	}
}
