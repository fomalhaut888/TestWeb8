package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main9 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex9.xml");
			System.out.println("#####################################");
			System.out.println("Example1:  Inner beans.");
			Bean9 bean1 = context.getBean("bean1", Bean9.class);
			bean1.getTarget().print();
			//Bean7 bean2 = context.getBean("bean2", Bean7.class);
			//bean2.print();
			System.out.println("%%% The inner bean cannot be directly retrieved by the method 'getBean' with id.");
			context.close();
	}

}
