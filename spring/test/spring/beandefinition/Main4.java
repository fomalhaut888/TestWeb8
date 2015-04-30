package test.spring.beandefinition;

import java.util.Calendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main4 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"/test/spring/beandefinition/ex4_01.xml");
			System.out.println("Example1:  the definition of alias.");
			String aliases[] = context.getAliases("jordan");
			for(String alias: aliases){
					System.out.println("jordan's alias=" + alias);
			}
			aliases = context.getAliases("pippen");
			for(String alias: aliases){
					System.out.println("pippen's alias=" + alias);
			}
			Bean4 bean11 = context.getBean("jordan", Bean4.class);
			System.out.println("bean11.name=" + bean11.getName());
			Bean4 bean12 = context.getBean("pippen", Bean4.class);
			System.out.println("bean12.name=" + bean12.getName());
			Bean4 bean13 = context.getBean("bean1", Bean4.class);
			System.out.println("bean13.name=" + bean13.getName());
			System.out.println("%%% A conclusion: You can use id, name, or alias as the argument of the method 'getBean' to get a bean.");
			context.close();
			System.out.println("**********************************************************");
			
			ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext(
					"/test/spring/beandefinition/ex4_02.xml");
			System.out.println("Example2:  the definitions of id and name.");
			Bean4 bean14 = context2.getBean("bean1", Bean4.class);
			System.out.println("bean14.name=" + bean14.getName());
			Bean4 bean21 = context2.getBean("bean2", Bean4.class);
			System.out.println("bean21.name=" + bean21.getName());
			System.out.println("%%% A conclusion: The attribute of either 'id' or 'name' as an identifier of a bean is OK.");
			context2.close();
			System.out.println("**********************************************************");
			
			ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext(
					"/test/spring/beandefinition/ex4_03.xml");
			System.out.println("Example3:  use a static factory method to instantiate a bean definition.");
			Calendar containerStartDate = context3.getBean("containerStartDate", Calendar.class);
			System.out.println("Container start date=" + containerStartDate.getTime());
			context3.close();
			System.out.println("**********************************************************");
			
			ClassPathXmlApplicationContext context4 = new ClassPathXmlApplicationContext(
					"/test/spring/beandefinition/ex4_04.xml");
			System.out.println("Example4:  use a instance factory method to instantiate a bean definition.");
			Bean4 sunBean = context4.getBean("sunBean", Bean4.class);
			System.out.println("sunBean.name=" + sunBean.getName());
			Bean4 frankBean = context4.getBean("frankBean", Bean4.class);
			System.out.println("frankBean.name=" + frankBean.getName());
			context4.close();
			System.out.println("**********************************************************");
	}

}
