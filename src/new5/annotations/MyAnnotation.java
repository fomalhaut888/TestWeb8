package new5.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //default is RetentionPolicy.CLASS and the other is RetentionPolicy.SOURCE
public @interface MyAnnotation {
	String value();
}
