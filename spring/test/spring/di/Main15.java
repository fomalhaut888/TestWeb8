package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main15 {

	public static void main(String[] args) {
			System.out.println("#####################################");
			System.out.println("Example1:  eager or lazy beans as the initialization process of the container.");
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex15.xml");
			System.out.println("%%% Result1: eager beans(lazy-init not set) will be created when instantiating a container.");
			System.out.println("    Result2: a lazy bean(lazy-init set to true) that is the dependency of a eager bean will be created as well.");
			System.out.println("#####################################");
			System.out.println("Example2:  lazy bean initialized.");
			Bean15 bean2 = context.getBean("bean2", Bean15.class);
			System.out.println("%%% Result: a lazy bean will be created when it is invoked with the method 'getBean'!");
			context.close();
			System.out.println("#####################################");
			System.out.println("Example3: default-lazy-init.");
			context = new ClassPathXmlApplicationContext("/test/spring/di/ex15_2.xml");
			context.close();
	}

}
