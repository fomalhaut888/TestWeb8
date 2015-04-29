package test.spring.instantiating;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
			System.out.println("Example1:  use ClassPathXmlApplicationContext class to Instantiating Spring Ioc Container(class path).");
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"/test/spring/instantiating/ex3_01.xml");
			Bean3_01 bean11 = context.getBean("bean1", Bean3_01.class);
			System.out.println("bean11.name=" + bean11.getName());
			context.close();
			System.out.println("**********************************************************");
			
			System.out.println("Example2:  use FileSystemXmlApplicationContext class to Instantiating Spring Ioc Container(file path).");
			 FileSystemXmlApplicationContext context2 = new FileSystemXmlApplicationContext(
					 "D:/LeoAdwordsApiWS3/TestWeb8/spring/test/spring/instantiating/ex3_02.xml");
			 Bean3_02 bean21 = context2.getBean("bean2", Bean3_02.class);
			 System.out.println("bean21.name=" + bean21.getName());
			 context2.close();
			 System.out.println("**********************************************************");
			 
			 System.out.println("Example3:  Instantiating Spring Ioc Container with 2 configuration XMLs.");
			 ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext(
					 "/test/spring/instantiating/ex3_01.xml", "/test/spring/instantiating/ex3_02.xml");
			 Bean3_01 bean12 = context3.getBean("bean1", Bean3_01.class);
			 System.out.println("bean12.name=" + bean12.getName());
			 Bean3_02 bean22 = context3.getBean("bean2", Bean3_02.class);
			 System.out.println("bean22.name=" + bean22.getName());
			 context3.close();
			 System.out.println("**********************************************************");
			 
			 System.out.println(
					 "Example4:  Instantiating Spring Ioc Container with a XML that has external configuration definitions of other XMLs.");
			 ClassPathXmlApplicationContext context4 = new ClassPathXmlApplicationContext(
					 "/test/spring/instantiating/ex3_03.xml");
			 Bean3_01 bean13 = context4.getBean("bean1", Bean3_01.class);
			 System.out.println("bean13.name=" + bean13.getName());
			 Bean3_02 bean23 = context4.getBean("bean2", Bean3_02.class);
			 System.out.println("bean23.name=" + bean23.getName());
			 Bean3_03 bean3 = context4.getBean("bean3", Bean3_03.class);
			 System.out.println("bean3.name=" + bean3.getName());
			 context4.close();
			 System.out.println("**********************************************************");
	}

}
