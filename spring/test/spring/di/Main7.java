package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main7 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex7.xml");
			System.out.println("#####################################");
			System.out.println("Example1:  Straight values (primitives, Strings, and so on) for conversion service.");
			Bean7 bean1 = context.getBean("bean1", Bean7.class);
			bean1.print();
			System.out.println("#####################################");
			System.out.println("Example2:  Use p-namespace for straight values.");
			Bean7 bean2 = context.getBean("bean2", Bean7.class);
			bean2.print();
			System.out.println("#####################################");
			System.out.println("Example3:  java.util.Properties configuration for straight values.");
			Bean7 bean3 = context.getBean("bean3", Bean7.class);
			bean3.print();
			System.out.println("#####################################");
			System.out.println("Example4:  Attribute 'idref'.");
			Bean72 bean4 = context.getBean("bean4", Bean72.class);
			System.out.println("bean id=" + bean4.getBeanId());
			Bean7 bean41 = context.getBean(bean4.getBeanId(), Bean7.class);
			bean41.print();
			context.close();
	}

}
