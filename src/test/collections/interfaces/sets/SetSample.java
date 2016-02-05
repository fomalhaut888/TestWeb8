package test.collections.interfaces.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;測試Set介面的基本操作.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1. List物件的元素轉至Set物件內(元素有順序及無順序).<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2. 使用Aggregate Operation: Java8的新功能, 新的traversing方式.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3. 使用for-each操作: 舊的traversing方式.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4. containsAll: 是否是子集(subset).<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;5. addAll: 物件元素及引數元素的聯集(union)轉至物件,物件內元素有改變則回傳true.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;6. retainAll: 物件元素及引數元素的交集(intersection)轉至物件,物件內元素有改變則回傳true.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;7. removeAll: 物件元素及引數元素的差集(difference)轉至物件,物件內元素有改變則回傳true.<br>
 * @author SimonC
 * @since 2015-11-13
 */
public class SetSample {

	public static void main(String[] args) {
			//1. List物件的元素轉至Set物件內(元素有順序及無順序)
			//Aggregate Operation
			String names[] = {"Kevin", "Simon", "Mary", "Simon", "May", "Simon", "Kevin", "Mary"};
			Set<String> distinctNames = Arrays.asList(names).stream()
					.collect(Collectors.toSet());
			System.out.println(distinctNames.size()+ 
                    " distinct names: " + distinctNames);
			
			//for-each Construct
			Set<String> s = new HashSet<>();
			for (String name : names){
					s.add(name);
			}
			System.out.println(s.size() + " distinct names: " + s);
			
			//Aggregate Operation
			Set<String> distinctOrderedNames = Arrays.asList(names).stream()
					.collect(Collectors.toCollection(TreeSet::new));
			System.out.println(distinctOrderedNames.size()+ 
                    " distinct ordered names: " + distinctOrderedNames);
			
			//for-each Construct
			s = new TreeSet<>();
			for (String name : names){
					s.add(name);
			}
			System.out.println(s.size() + " distinct ordered names: " + s);
			
			//2.containsAll: 是否是子集(subset)
			Integer s1[] = {1, 2, 3, 4, 5, 6, 7};
			Integer s2[] = {6, 7, 8, 9, 10};
			Integer s3[] = {2, 3, 4};
			Set<Integer> set1 = Arrays.asList(s1).stream()
					.collect(Collectors.toCollection(TreeSet::new));
			Set<Integer> set2 = Arrays.asList(s2).stream()
					.collect(Collectors.toCollection(TreeSet::new));
			Set<Integer> set3 = Arrays.asList(s3).stream()
					.collect(Collectors.toCollection(TreeSet::new));
			System.out.println("set1.containsAll(set2)=" + set1.containsAll(set2));
			System.out.println("set1.containsAll(set3)=" + set1.containsAll(set3));
			
			//3.addAll: 物件元素及引數元素的聯集(union)轉至物件,物件內元素有改變則回傳true.
			Set<Integer> set4 = new TreeSet<Integer>(set1);
			System.out.println("set4.addAll(set2)=" + set4.addAll(set2));
			System.out.println(set4.size() + " elements: " + set4);
			System.out.println("set4.addAll(set3)=" + set4.addAll(set3));
			System.out.println(set4.size() + " elements: " + set4);
			
			//4.retainAll: 物件元素及引數元素的交集(intersection)轉至物件,物件內元素有改變則回傳true.
			Set<Integer> set5 = new TreeSet<Integer>(set1);
			System.out.println("set5.retainAll(set2)=" + set5.retainAll(set2));
			System.out.println(set5.size() + " elements: " + set5);
			System.out.println("set5.retainAll(set3)=" + set5.retainAll(set3));
			System.out.println(set5.size() + " elements: " + set5);
			System.out.println("set5.retainAll(set3)=" + set5.retainAll(set3));
			System.out.println(set5.size() + " elements: " + set5);
			
			//5.removeAll: 物件元素及引數元素的差集(difference)轉至物件,物件內元素有改變則回傳true.
			Set<Integer> set6 = new TreeSet<Integer>(set1);
			System.out.println("set6.removeAll(set2)=" + set6.removeAll(set2));
			System.out.println(set6.size() + " elements: " + set6);
			System.out.println("set6.removeAll(set2)=" + set6.removeAll(set2));
			System.out.println(set6.size() + " elements: " + set6);
	}

}
