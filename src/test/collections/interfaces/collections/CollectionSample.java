package test.collections.interfaces.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;測試Collection介面的基本操作.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1. Aggregate Operation: Java8的新功能, 新的traversing方式.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2. for-each操作: 舊的traversing方式.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3. Iterator: 舊的traversing方式.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4. Iterator.remove是較安全移除集合元素的方式.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;5. containsAll: 判斷是否引數集合內的元素都在此集合物件裏.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;6. addAll: 將引數集合內的元素新增至此集合物件裏.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;7. removeAll: 刪除集合物件裏和引數集合內的元素相同的元素.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;8. retainAll: 僅保留與引數集合內相同的元素在此集合物件裏.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;9. toArray: 將集合物件轉換為陣列.<br>
 * @author SimonC
 * @since 2015-11-13
 */
public class CollectionSample {

	public static void main(String[] args) {
			Collection<Integer> c1 = new TreeSet<Integer>();
			c1.add(9);
			c1.add(8);
			c1.add(7);
			Collection<Integer> c2 = new ArrayList<>(c1);
			
			//Aggregate Operation
			c2.stream()
					.filter(i -> i >= 8)
					.forEach(i -> System.out.print(i + " "));
			System.out.println();
			/*
			c2.stream().filter(new Predicate<Integer>(){
					@Override
					public boolean test(Integer i) {
							return (i >= 8);
					}
			}).forEach(new Consumer<Integer>(){
					@Override
					public void accept(Integer i) {
							System.out.print(i + " ");
					}
			});
			System.out.println();*/
			
			c2.parallelStream()
					.filter(i -> i >= 8)
					.forEach(i -> System.out.print(i + " "));
			System.out.println();
			
			String joined = c2.stream()
					.map(Object::toString)
					.collect(Collectors.joining(", "));
			System.out.println("joined=" + joined);
			
			int total = c2.stream()
					.collect(Collectors.summingInt(Integer::intValue));
			System.out.println("total=" + total);
			
			//for-each Construct
			for(Integer i: c2){
					System.out.print(i + " ");
			}
			System.out.println();
			
			//Iterator: Note that Iterator.remove is the only safe way to modify a collection during iteration.
			for(Iterator<Integer> it = c2.iterator(); it.hasNext(); ){
					it.next();
					it.remove();
			}
			/*
			for(Iterator<Integer> it = c2.iterator(); it.hasNext(); ){//wrong code to remove elements and ConcurrentModificationException thrown
					Integer i = it.next();
					c2.remove(i);
			}*/
			/*
			for(Integer i: c2){//wrong code to remove elements and ConcurrentModificationException thrown
					c2.remove(i);
			}*/
			/*
			c2.stream() //wrong code to remove elements and ConcurrentModificationException thrown
					.forEach(i -> c2.remove(i));*/
			System.out.println("c2.isEmpty()=" + c2.isEmpty());
			System.out.println("c2.size()=" + c2.size());
			
			Collection<String> c3 = new ArrayList<String>();
			c3.add("Taipei");
			c3.add("N.Y.");
			c3.add("Taipei");
			c3.add("Tokyo");
			c3.add("Paris");
			c3.add("London");
			Collection<String> c4 = new HashSet<String>();
			c4.add("Taipei");
			c4.add("Paris");
			System.out.println("c3.containsAll(c4)=" + c3.containsAll(c4));
			c4.add("L.A.");
			System.out.println("c3.containsAll(c4)=" + c3.containsAll(c4));
			
			c3.addAll(c4);
			c3.stream()
					.forEach(s -> System.out.print(s + " "));
			System.out.println();
			
			c3.removeAll(c4);
			c3.stream()
					.forEach(s -> System.out.print(s + " "));
			System.out.println();
			
			Collection<String> c5 = new HashSet<String>();
			c5.add("Taipei");
			c5.add("N.Y.");
			c5.add("London");
			c3.retainAll(c5);
			c3.stream()
					.forEach(s -> System.out.print(s + " "));
			System.out.println();
			
			String arr3[] = c3.toArray(new String[c3.size()]);
			for(String s: arr3){
					System.out.print(s + " ");
			}
			System.out.println();
			
			c3.clear();
			System.out.println("c3.isEmpty()=" + c3.isEmpty());
	}

}
