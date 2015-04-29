package test.spring.scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author SimonC
 * Example 1:
 * singleton v.s. prototype scope
 */
public class Main1 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context =
						new ClassPathXmlApplicationContext("/test/spring/scope/ex1.xml");
			//Singleton Scope
			Bean1 bean11 = context.getBean("bean1", Bean1.class);
			Bean1 bean12 = context.getBean("bean1", Bean1.class);
			System.out.println("bean11.id=" + bean11.getId());
			System.out.println("bean12.id=" + bean12.getId());
			System.out.println("(bean11 == bean12) = " + (bean11 == bean12));
			//Prototype Scope
			Bean1 bean21 = context.getBean("bean2", Bean1.class);
			Bean1 bean22 = context.getBean("bean2", Bean1.class);
			System.out.println("bean21.id=" + bean21.getId());
			System.out.println("bean22.id=" + bean22.getId());
			System.out.println("(bean21 == bean22) = " + (bean21 == bean22));
			//Spring’s concept of a singleton bean differs from the Singleton pattern 
			//			as defined in the Gang of Four (GoF) patterns book. 
			//The GoF Singleton hard-codes the scope of an object such that one and only one instance 
			//			of a particular class is created per ClassLoader. 
			//The scope of the Spring singleton is best described as per container and per bean. 
			//		This means that if you define one bean for a particular class in a single Spring container, 
			//			then the Spring container creates one and only one instance of the class defined by that bean definition.
			ClassPathXmlApplicationContext context2 =
					new ClassPathXmlApplicationContext("/test/spring/scope/ex1.xml");
			Bean1 bean3 = context2.getBean("bean1", Bean1.class);
			System.out.println("bean3.id=" + bean3.getId());
			System.out.println("(bean11 == bean3) = " + (bean11 == bean3));
			context.close();
			context2.close();
	}

}
