package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main14 {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println("#####################################");
			System.out.println("Example1:  Using depends-on.");
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex14.xml");
			context.close();
			System.out.println("%%% Result: 1. The order of initializing beans will normally comply with the order of bean definitions in XML if they are independent(bean1, bean2, bean3).");
			System.out.println("            2. The bean that is specified by another one with attribute 'depends-on' for the dependence will be initialized earlier than another if they don't have other relations(bean4, bean5, bean6).");
	}

}
