package test.spring.di;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main8 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext parentContext =
					new ClassPathXmlApplicationContext("/test/spring/di/ex7.xml");
			ConfigurableBeanFactory childBeanFactory = new XmlBeanFactory(new ClassPathResource("/test/spring/di/ex8.xml"));
			childBeanFactory.setParentBeanFactory(parentContext);
			System.out.println("#####################################");
			System.out.println("Example1:  Attribute 'parent' of tab 'ref'.");
			Bean8 bean1 = childBeanFactory.getBean("bean1", Bean8.class);
			bean1.getTarget().print();
			System.out.println("%%% Result: The attribute is used in the hierarchy container.");
			System.out.println("%%% Problem: 1. XmlBeanFactory has been deprecated. How is the attribute used in new configuration about the hierarchy container.");
			System.out.println("%%% Problem: 2. How is the hierarchy container built?");
			System.out.println("%%% It's complex and not recommended! ");
			parentContext.close();
	}

}
