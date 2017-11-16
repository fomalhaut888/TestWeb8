package new5.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A Sample for meta-annotations
 * Indicates that the annotated method is a test method.
 * This annotation should be used only on parameterless static methods.
 */
@Retention(RetentionPolicy.RUNTIME) //default is RetentionPolicy.CLASS and the other is RetentionPolicy.SOURCE
@Target(ElementType.METHOD)
public @interface Test {
	//The first (@Retention(RetentionPolicy.RUNTIME)) indicates that annotations with this type are 
	//    to be retained by the VM so they can be read reflectively at run-time.
	//The second (@Target(ElementType.METHOD)) indicates that this annotation type 
	//    can be used to annotate only method declarations.
}
