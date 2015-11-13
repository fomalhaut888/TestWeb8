package test.collections.implementations.conveniences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.測試Convenience Implementations物件.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.Arrays.asList: 陣列轉List.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.Collections.nCopies: 產生一個有n個相同值的元素的List物件.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.Collections.singleton: 產生一個只有一個元素的Set物件.
 * 			此Set是Unmodifiable, 新增或刪除元素則會丟出java.lang.UnsupportedOperationException.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.Collections.emptyXXX(): 產生空的Collection物件<br>
 * @author SimonC
 * @since 2015-11-12
 */
public class ConvenienceSample1 {

	public static void main(String[] args) {
			//1. Arrays.asList: 陣列轉List
			Integer arr1[] = {1, 2, 3};
			List<Integer> list1 = Arrays.asList(arr1);
			for(Integer i: list1){
					System.out.print(i + " ");
			}
			System.out.println();
			
			//2. Collections.nCopies: 產生一個有n個相同值的元素的List物件
			List<Integer> list21 = new ArrayList<Integer>(Collections.nCopies(10, null));
			for(Integer i: list21){
					System.out.print(i + " ");
			}
			System.out.println();
			List<Integer> list22 = new ArrayList<Integer>();
			list22.addAll(Collections.nCopies(10, 0));
			for(Integer i: list22){
					System.out.print(i + " ");
			}
			System.out.println();
			
			//3. Collections.singleton: 產生一個只有一個元素的Set物件.
			List<String> list3 = new ArrayList<String>();
			String e1 = "Simon";
			String e2 = "Mary";
			String e3 = "Tom";
			String e4 = new String("Simon");
			list3.add(e1);
			list3.add(e2);
			list3.add(e3);
			list3.add(e4);
			list3.add(e1);
			list3.add(e2);
			list3.add(e3);
			list3.add(e4);
			list3.add(e1);
			list3.add(e2);
			list3.add(e3);
			list3.add(e4);
			for(String s: list3){
					System.out.print(s + " ");
			}
			System.out.println();
			list3.remove(e4);
			for(String s: list3){
					System.out.print(s + " ");
			}
			System.out.println();
			Set<String> singletonSet = Collections.singleton(e1);
			list3.removeAll(singletonSet);
			for(String s: list3){
					System.out.print(s + " ");
			}
			System.out.println();
			//singletonSet.add("Mark");//java.lang.UnsupportedOperationException thrown as an Unmodifiable Collection.
			
			//4. Collections.emptyList(): 產生空的Collection物件
			List<String> list41 = Collections.emptyList();
			List<Integer> list42 = Collections.emptyList();
			System.out.println("list41.size()=" + list41.size());
			System.out.println("list41.getClass()=" + list41.getClass());
			System.out.println("list42.size()=" + list42.size());
			System.out.println("list42.getClass()=" + list42.getClass());
			Set<String> set43 = Collections.emptySet();
			System.out.println("set43.getClass()=" + set43.getClass());
			Map<String, Integer> map44 = Collections.emptyMap();
			System.out.println("map44.getClass()=" + map44.getClass());
	}

}
