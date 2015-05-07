package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main11 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex11.xml");
			System.out.println("#####################################");
			Bean11 bean1 = context.getBean("bean1", Bean11.class);
			System.out.println("Example1:  Property definition of an empty string value.");
			System.out.println("emptyStringValue=" + bean1.getEmptyStringValue());
			System.out.println("#####################################");
			System.out.println("Example1:  Property definition of a null value.");
			System.out.println("nullValue=" + bean1.getNullValue());
			context.close();
	}

}
