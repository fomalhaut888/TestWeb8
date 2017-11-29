package new8.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * JDK 8 New: Samples for Repeating Annotations
 * @author SimonC
 * @see https://docs.oracle.com/javase/tutorial/java/annotations/repeating.html
 * @see https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/AnnotatedElement.html
 */
public class RepeatingAnnotations {

	public static void main(String[] args) throws Exception {
			//Retrieving Annotations
			for (Method m : Class.forName("new8.annotations.RepeatingAnnotations").getMethods()) {
					System.out.println("m.getName()=" + m.getName());
					Schedule s = m.getAnnotation(Schedule.class);
					//***Note: The method isAnnotationPresent of a Method object with ONLY ONE repeatable annotation returns TRUE, 
					//         but the one with MORE THAN ONE repeating annotations returns FALSE.
					//		   Likewise, the method getAnnotation of a Method object with ONLY ONE repeatable annotaion returns a object,
					//         but the one with MORE THAN ONE repeating annotations returns a null value.
					System.out.println("s=" + s);
					System.out.println("m.isAnnotationPresent(Schedule.class)=" 
							+ m.isAnnotationPresent(Schedule.class));
					if(s != null){
							System.out.println("^^ Method " + m.getName()
								+ " marked with an annotation set that the dayOfMonth is "
								+ s.dayOfMonth());
					}
					Deprecated d = m.getAnnotation(Deprecated.class);
					System.out.println("d=" + d);
					System.out.println("m.isAnnotationPresent(Deprecated.class)=" 
							+ m.isAnnotationPresent(Deprecated.class));
					//The getAnnotationsByType of a Method object marked with NO Schedule returns an EMPTY ARRAY, not returns null. 
					Schedule ss[] = m.getAnnotationsByType(Schedule.class);
					System.out.println("ss.length=" + ss.length);
					for(Schedule o: ss){
							System.out.println("^^ Method " + m.getName()
								+ " marked with an annotation set that the dayOfMonth is "
								+ o.dayOfMonth());
					}
					System.out.println("****************************************");
			}
			Class<?> c = Class.forName("new8.annotations.RepeatingAnnotations$UnauthorizedAccessException");
			Alert a = c.getAnnotation(Alert.class);
			//***Note: The method isAnnotationPresent of a Class object with ONLY ONE repeatable annotation returns TRUE, 
			//         but the one with MORE THAN ONE repeating annotations returns FALSE.
			//         The method getAnnotation of a Class object with ONLY ONE repeatable annotation returns a object,
			//         but the one with MORE THAN ONE repeating annotations returns a null value.
			System.out.println("a=" + a);
			System.out.println("c.isAnnotationPresent(Alert.class)=" 
					+ c.isAnnotationPresent(Alert.class));
			if(a != null){
					System.out.println("^^ Class " + c.getSimpleName()
							+ " marked with an annotation set that the role is "
							+ a.role());
			}
			Alert as[] = c.getAnnotationsByType(Alert.class);
			for(Alert o: as){
					System.out.println("^^ Class " + c.getSimpleName()
							+ " marked with an annotation set that the role is "
							+ o.role());
			}
			System.out.println("#############################################");
	}

	//annotate the method
	@Schedule(dayOfMonth="last")
	@Schedule(dayOfWeek="Fri", hour=23)
	@Deprecated
	public static void doPeriodicCleanup() {
	}
	
	//annotate the class
	@Alert()//declaration given a default value
	@Alert(role="Manager")
	@Alert(role="Administrator")
	public static class UnauthorizedAccessException extends SecurityException {
	}
	
	//Two steps to set a repeating annotation.
	//Step 1: Declare a Repeatable Annotation Type
	@Repeatable(Schedules.class)//Compile Error if this method is marked with Retention but the repeatable class not: Retention 'RUNTIME' of @RepeatingAnnotations.Schedule is longer than the retention of its container annotation type @RepeatingAnnotations.Schedules, which is 'CLASS'
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Schedule {
			String dayOfMonth() default "first";
			String dayOfWeek() default "Mon";
			int hour() default 12;
	}
	
	//Step 2: Declare the Containing Annotation Type
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Schedules {
	    	Schedule[] value();//The containing annotation type must have a value element with an array type. The component type of the array type must be the repeatable annotation type.
	}
	
	@Repeatable(Alerts.class)
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Alert {
			String role() default "Administrator";
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Alerts {
			Alert[] value();
	}
}
