package test.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main5 {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex5.xml");
			System.out.println("#####################################");
			System.out.println("Example1:  setter based DI.");
			Rectangle5 rectangle = context.getBean("rectangle", Rectangle5.class);
			System.out.println("The area of rectangle: " + rectangle.getArea());
			System.out.println("%%% When is setter-based DI suggested?");
			System.out.println("1. For optional dependencies that can be assigned reasonable default values within the class");
			System.out.println("2. Make objects of that class amenable to reconfiguration or re-injection later.");
			System.out.println("3. Circular dependencies.");
			System.out.println("#####################################");
			System.out.println("Example2:  constructor based DI.");
			Circle5 circle = context.getBean("circle", Circle5.class);
			System.out.println("The area of circle: " + circle.getArea());
			System.out.println("%%% When is constructor-based DI suggested?");
			System.out.println("1. Immutable objects");
			System.out.println("2. Dependencies are not null.");
			System.out.println("3. Constructor-injected components are always returned to client (calling) code in a fully initialized state.");
			System.out.println("#####################################");
			System.out.println("Example3:  static factory method DI.");
			Triangle5 triangle = context.getBean("triangle", Triangle5.class);
			System.out.println("The area of triangle: " + triangle.getArea());
			context.close();
	}

}
