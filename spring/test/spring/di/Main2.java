package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex2.xml");
			System.out.println("#####################################");
			System.out.println("Example1:  constructor references to other beans.");
			Bean2 bean1 = context.getBean("bean1", Bean2.class);
			bean1.print();
			System.out.println("**********************************************************");
			System.out.println("Example2:  the order of constructor-arg in the definition of the bean (match automatically).");
			Bean2 bean2 = context.getBean("bean2", Bean2.class);
			bean2.print();
			System.out.println("**********************************************************");
			System.out.println("Example3:  the constructor matched with the types.");
			Bean2 bean3 = context.getBean("bean3", Bean2.class);
			bean3.print();
			System.out.println("**********************************************************");
			System.out.println("Example4:  the constructor matched with the order indice.");
			Bean2 bean4 = context.getBean("bean4", Bean2.class);
			bean4.print();
			System.out.println("**********************************************************");
			System.out.println("Example5:  the constructor matched with the parameter names.");
			Bean2 bean5 = context.getBean("bean5", Bean2.class);
			bean5.print();
			System.out.println("**********************************************************");
			context.close();
	}

}
