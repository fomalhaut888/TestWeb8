package test.collections.implementations.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;將數個int值及String物件分別塞入HashSet, TreeSet, LinkedHashSet物件, <br>
 * 	        &nbsp;&nbsp;&nbsp;&nbsp;再將它從物件依序抓出, 看int值或String物件出來的排列順序為何.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1. HashSet出來的String值無固定順序(依Hash值), int值則由小到大(因int值等於它的Hash值).<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2. TreeSet出來的值則由小到大排列.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3. LinkedHashSet出來的值則依塞入時的順序由早到晚.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4. 所有Set內的值不會有兩個元素是相同的.<br>
 * @author SimonC
 * @since 2015-10-08
 */
public class SetSample2 {

	public static void main(String[] args) {
			int intArray[] = { 10, 8, 2, 5, 1, 2, 9, 6, 10, 7, 3, 4};
			Set<Integer> hashSet = new HashSet<Integer>();
			for(int e: intArray){
					hashSet.add(e);
			}
			System.out.println("Pop a HashSet object for int: ");
			for(Integer i: hashSet){
					System.out.print(i + ", ");
			}
			System.out.println();
			
			Set<Integer> treeSet = new TreeSet<Integer>();
			for(int e: intArray){
					treeSet.add(e);
			}
			System.out.println("Pop a TreeSet object for int: ");
			for(Integer i: treeSet){
					System.out.print(i + ", ");
			}
			System.out.println();
			
			Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
			for(int e: intArray){
					linkedHashSet.add(e);
			}
			System.out.println("Pop a LinkedHashSet object for int: ");
			for(Integer i: linkedHashSet){
					System.out.print(i + ", ");
			}
			System.out.println();
			System.out.println("###########################");
			
			String stringArray[] = { "This", "is", "a", "book", "!", "a"};
			Set<String> hashSet2 = new HashSet<String>();
			for(String e: stringArray){
					hashSet2.add(e);
			}
			System.out.println("Pop a HashSet object for String: ");
			for(String s: hashSet2){
					System.out.print(s + ", ");
			}
			System.out.println();
			
			Set<String> treeSet2 = new TreeSet<String>();
			for(String e: stringArray){
					treeSet2.add(e);
			}
			System.out.println("Pop a TreeSet object for String: ");
			for(String s: treeSet2){
					System.out.print(s + ", ");
			}
			System.out.println();
			
			Set<String> linkedHashSet2 = new LinkedHashSet<String>();
			for(String e: stringArray){
					linkedHashSet2.add(e);
			}
			System.out.println("Pop a LinkedHashSet object for String: ");
			for(String s: linkedHashSet2){
					System.out.print(s + ", ");
			}
			System.out.println();
	}

}
