package new5.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * JDK 5 New: Samples for Annotations.
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/annotations.html
 */
public class Annotations {

	public static void main(String[] args) 
			throws SecurityException, ClassNotFoundException, IllegalAccessException, 
				IllegalArgumentException, InvocationTargetException {
			//4. A test program sample (run with annotations).
			String testClassName = "new5.annotations.Annotations";
			int passed = 0, failed = 0;
			//for (Method m : Class.forName(args[0]).getMethods()) {
			for (Method m : Class.forName(testClassName).getMethods()) {
					if (m.isAnnotationPresent(Test.class)) {
							try{
									m.invoke(null);
									passed++;
							} catch (Throwable ex) {
									System.out.printf("Test %s failed: %s %n", m, ex.getCause());
									failed++;
							}
					}
			}
			System.out.printf("Passed: %d, Failed %d%n", passed, failed);
			System.out.println();
			
			//5-1. RetentionPolicy: the method marked as RetentionPolicy.CLASS(default) cannot be caught at the runtime.
			System.out.println("RequestForEnhancement method: ");
			for (Method m : Class.forName(testClassName).getMethods()) {
					if (m.isAnnotationPresent(RequestForEnhancement.class)) {
							System.out.println(m.getName());
					}
			}
			System.out.println();
			
			//5-2. RetentionPolicy: the method marked as RetentionPolicy.RUNTIME will be caught at the runtime.
			System.out.println("MyAnnotation method: ");
			for (Method m : Class.forName(testClassName).getMethods()) {
					if (m.isAnnotationPresent(MyAnnotation.class)) {
							System.out.println(m.getName());
					}
			}
			System.out.println();
			
			//5-3. Annotated Class: the class marked as RetentionPolicy.RUNTIME will be caught at the runtime.
			System.out.println("MyAnnotation class: ");
			String testMyAnnotationClassName = "new5.annotations.Annotations$TestMyAnnotationClass";
			if(Class.forName(testMyAnnotationClassName).isAnnotationPresent(MyAnnotation.class)){
					System.out.println(Class.forName(testMyAnnotationClassName).getName());
			}
			System.out.println();
			
			//5-4. Annotated Class: the class marked as RetentionPolicy.CLASS cannot be caught at the runtime.
			System.out.println("Preliminary class: ");
			String timeTravelClassName = "new5.annotations.Annotations$TimeTravel";
			if(Class.forName(timeTravelClassName).isAnnotationPresent(Preliminary.class)){
					System.out.println(Class.forName(timeTravelClassName).getName());
			}
			System.out.println();
	}

	//1. Use my Annotation.
	//By convention, annotations precede other modifiers.
	/**
	 * @param destination
	 * @see new5.annotations.RequestForEnhancement
	 */
	@RequestForEnhancement(
			id       = 2868724,
			synopsis = "Enable time-travel",
			engineer = "Mr. Peabody",
			date     = "4/1/3007",
			c        = Long.class,
			en       = RequestForEnhancement.TestEnum.Enum3,
			testAnnotation = @Deprecated,
			is       = {8,9,10},
			cs       = {Long.class, Boolean.class}
	)
	public static void travelThroughTime(Date destination) {
			//Do something
	}
	
	//2. Marker annotations.
	//Permissible to omit the parentheses
	/**
	 * @see new5.annotations.Preliminary
	 */
	@Preliminary public class TimeTravel {
			//Definition
	}
	
	//3. single-element annotation and it's element name is value.
	//It is permissible to omit the element name and equals sign (=) in a single-element annotation 
	//   whose element name is value
	@Copyright("2002 Yoyodyne Propulsion Systems")
	//@Copyright(1) //value type can be int as well
	public class OscillationOverthruster {
			//Definition
	}
	
	//4. A test program sample.
	@Test public static void m1() { }
	
    public static void m2() { }
    
    @Test public static void m3() {
        throw new RuntimeException("Boom");
    }
    
    public static void m4() { }
    
    @Test public static void m5() { }
    
    public static void m6() { }
    
    @Test public static void m7() {
        throw new RuntimeException("Crash");
    }
    
    public static void m8() { }
    
    //@Test //Compile Error if marked as @Test: The annotation @Test is disallowed for this location
    public static class TestClass {
    	
    }
    
    @MyAnnotation("SimonC")
    public void testMyAnnotation(){
    }
    
    @MyAnnotation("SimonC")
    public static class TestMyAnnotationClass{
    		
    }
}
