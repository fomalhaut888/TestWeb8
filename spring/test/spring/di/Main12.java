package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main12 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex12.xml");
			System.out.println("#####################################");
			System.out.println("Example1:  Common property definition.");
			Bean12 bean1 = context.getBean("bean1", Bean12.class);
			System.out.println("Product: " + bean1.getProduct() + "; amount: " + bean1.getAmount() +
					"; unit price: $" + bean1.getUnitPrice() + "; total price: $" + bean1.getTotalPrice());
			System.out.println("#####################################");
			System.out.println("Example2:  p-namespace instead of property.");
			Bean12 bean2 = context.getBean("bean2", Bean12.class);
			System.out.println("Product: " + bean2.getProduct() + "; amount: " + bean2.getAmount() +
					"; unit price: $" + bean2.getUnitPrice() + "; total price: $" + bean2.getTotalPrice());
			System.out.println("#####################################");
			System.out.println("Example3:  c-namespace instead of constructor.");
			Bean12 bean3 = context.getBean("bean3", Bean12.class);
			System.out.println("Product: " + bean3.getProduct() + "; amount: " + bean3.getAmount() +
					"; unit price: $" + bean3.getUnitPrice() + "; total price: $" + bean3.getTotalPrice());
			context.close();
	}

}
