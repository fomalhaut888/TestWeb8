package new5.annotations;

/**
 * Sample for annotations with a single element
 * Associates a copyright notice with the annotated API element.
 */
public @interface Copyright {
	//In annotations with a single element, the element should be named value
	String value();
	//int value();
}
