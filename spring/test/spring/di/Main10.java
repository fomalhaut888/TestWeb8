package test.spring.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main10 {

	public static void main(String[] args) {
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("/test/spring/di/ex10.xml");
			System.out.println("#####################################");
			Bean10 bean1 = context.getBean("bean1", Bean10.class);
			System.out.println("Example1:  Bean definition of java.util.Properties.");
			Properties properties = bean1.getProperties();
			System.out.println("properties.size = " + properties.size());
			Set<String> keySet = properties.stringPropertyNames();
			for(String key: keySet){
					System.out.println(key + ":" + properties.getProperty(key));
			}
			System.out.println("%%% Result: If some of elements has the same key, the last one in them will be retained only.");
			System.out.println("#####################################");
			System.out.println("Example2:  Bean definition of java.util.List.");
			List list = bean1.getList();
			System.out.println("list.class.name = " + list.getClass().getName());
			System.out.println("list.size = " + list.size());
			for(Object obj: list){
					System.out.println(obj + "-" + obj.getClass().getName());
			}
			System.out.println("%%% Result: 1. The subclass of the List object is ArrayList.");
			System.out.println("            2. Attribute 'type' of tab 'value' can be specified for the data type(ex.Integer).");
			System.out.println("#####################################");
			System.out.println("Example3:  Bean definition of java.util.Map.");
			Map map = bean1.getMap();
			System.out.println("map.class.name = " + map.getClass().getName());
			System.out.println("map.size = " + map.size());
			Set<Object> keySet2 = map.keySet();
			for(Object key: keySet2){
					System.out.println(key + ":" + map.get(key) + "-" + map.get(key).getClass().getName());
			}
			System.out.println("%%% Result: 1. If some of elements has the same key, the last one in them will be retained only.");
			System.out.println("            2. Attribute 'type' of tab 'value' can be specified for the data type(ex.Integer).");
			System.out.println("            3. The subclass of the Map object is LinkedHashMap.");
			System.out.println("#####################################");
			System.out.println("Example4:  Bean definition of java.util.Set.");
			Set set = bean1.getSet();
			System.out.println("set.class.name = " + set.getClass().getName());
			System.out.println("set.size = " + set.size());
			for(Object obj: set){
					System.out.println(obj + "-" + obj.getClass().getName());
			}
			System.out.println("%%% Result: 1. Only one of duplicate values will be put into the set.");
			System.out.println("            2. The subclass of the Set object is LinkedHashSet.");
			System.out.println("#####################################");
			System.out.println("Example5:  Collection merging with no attribute 'merge' in the child's tab 'props'.");
			Bean10 bean4Child = context.getBean("bean4Child", Bean10.class);
			properties = bean4Child.getProperties();
			System.out.println("properties.size = " + properties.size());
			Set<String> keySet3 = properties.stringPropertyNames();
			for(String key: keySet3){
					System.out.println(key + ":" + properties.getProperty(key));
			}
			System.out.println("#####################################");
			System.out.println("Example6:  Collection merging with the attribute 'merge' in the child's tab 'props'.");
			Bean10 bean5Child = context.getBean("bean5Child", Bean10.class);
			properties = bean5Child.getProperties();
			System.out.println("properties.size = " + properties.size());
			Set<String> keySet4 = properties.stringPropertyNames();
			for(String key: keySet4){
					System.out.println(key + ":" + properties.getProperty(key));
			}
			context.close();
	}

}
