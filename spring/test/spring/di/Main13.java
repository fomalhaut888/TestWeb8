package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main13 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex13.xml");
			System.out.println("#####################################");
			System.out.println("Example1:  Compound property names.");
			Bean13 bean1 = context.getBean("bean1", Bean13.class);
			System.out.println("name = " + bean1.getCustomer().getName().getUs());
			System.out.println("%%% Components of the path except the final property name can not be null.");
			context.close();
	}

}
