package test.spring.instantiating;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"/test/spring/instantiating/ex3_01.xml");
			System.out.println("Example1:  use ClassPathXmlApplicationContext class to Instantiating Spring Ioc Container(class path).");
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
			 
			 System.out.println(
					 "Example5:  Instantiating Spring Ioc Container with 2 configuration XMLs, each of which has a bean definition of id 'bean1'.");
			 ClassPathXmlApplicationContext context5 = new ClassPathXmlApplicationContext(
					 "/test/spring/instantiating/ex3_01.xml", "/test/spring/instantiating/ex3_04.xml");
			 Object bean14 = context5.getBean("bean1");
			 System.out.println("bean14.class.name=" + bean14.getClass().getName());
			 ClassPathXmlApplicationContext context6 = new ClassPathXmlApplicationContext(
					 "/test/spring/instantiating/ex3_04.xml", "/test/spring/instantiating/ex3_01.xml");
			 Object bean15 = context6.getBean("bean1");
			 System.out.println("bean15.class.name=" + bean15.getClass().getName());
			 System.out.println("%%% A conclusion: Spring will instantiate the bean1 definition that is in the last XML.");
			 System.out.println("**********************************************************");
			 context5.close();
			 context6.close();
			 
			 System.out.println(
					 "Example6:  Instantiating Spring Ioc Container with a XML that has external configuration definitions, each of which has a bean definition of id 'bean1'.");
			 ClassPathXmlApplicationContext context7 = new ClassPathXmlApplicationContext(
					 "/test/spring/instantiating/ex3_05.xml");
			 Object bean16 = context7.getBean("bean1");
			 System.out.println("bean16.class.name=" + bean16.getClass().getName());
			 ClassPathXmlApplicationContext context8 = new ClassPathXmlApplicationContext(
					 "/test/spring/instantiating/ex3_06.xml");
			 Object bean17 = context8.getBean("bean1");
			 System.out.println("bean17.class.name=" + bean17.getClass().getName());
			 context7.close();
			 context8.close();
			 System.out.println("%%% A conclusion: Spring will instantiate the bean1 definition that is in the last external XML included into the main XML.");
			 System.out.println("**********************************************************");
	}

}
