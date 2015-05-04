package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main6 {
		public static void main(String args[]){
				ClassPathXmlApplicationContext context =
						new ClassPathXmlApplicationContext("/test/spring/di/ex6.xml");
				System.out.println("#####################################");
				System.out.println("Example1:  Circular dependencies for constructor-based DI.");
				//Bean6A bean6A = context.getBean("bean6A", Bean6A.class);
				System.out.println("%%% Result:  org.springframework.beans.factory.BeanCurrentlyInCreationException thrown!");
				System.out.println("    Message: Error creating bean with name 'bean6A': Requested bean is currently in creation: Is there an unresolvable circular reference?");
				System.out.println("    The exception object was thrown When configuring the Spring container(context)!");
				System.out.println("#####################################");
				System.out.println("Example2:  Circular dependencies for setter-based DI.");
				Bean6A bean6A = context.getBean("bean6A", Bean6A.class);
				System.out.println(bean6A.getBean6B().toString());
				Bean6B bean6B = context.getBean("bean6B", Bean6B.class);
				System.out.println(bean6B.getBean6A().toString());
				System.out.println("%%% Result: circle dependencies acceptable for setter-based DI.");
				context.close();
		}
}
