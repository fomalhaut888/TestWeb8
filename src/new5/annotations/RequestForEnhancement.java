package new5.annotations;

/**
 * Samples for annotation type declaration.
 * Describes the Request-For-Enhancement(RFE) that led
 * to the presence of the annotated API element.
 */
public @interface RequestForEnhancement {
	//Method declarations must not have any parameters or a throws clause.
	//Return types are restricted to primitives, String, Class, enums, annotations, 
	//    and arrays of the preceding types.
	int    id();
    String synopsis();
    String engineer() default "[unassigned]"; 
    String date()    default "[unimplemented]";
    Class<?> c() default String.class;
    TestEnum en() default TestEnum.Enum1;
    Deprecated testAnnotation() default @Deprecated;
    int[]  is() default {1,3,5};
    Class<?>[] cs() default {String.class, Integer.class};
    //String   name(String s);//Compile Error: Annotation attributes cannot have parameters
    //String name() throws Exception;//Compile Error: Syntax error on token "throws", default expected
    //int[][] is2();//only 1-dimensional arrays allowed
    //Integer file();//CompileError: Invalid type Integer for the annotation attribute RequestForEnhancement.file; 
    				//only primitive type, String, Class, annotation, enumeration are permitted 
    				//or 1-dimensional arrays thereof
    
    public static enum TestEnum{
    	Enum1, Enum2, Enum3;
    }
}


