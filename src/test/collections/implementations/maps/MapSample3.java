package test.collections.implementations.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;三種general-purpose Map的例子.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.鍵值無需順序性,則使用HashMap.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.鍵值需依序由小到大排列,則使用TreeMap.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.鍵值需依插入先後排列,則使用LinkedHashMap.<br>
 * @author SimonC
 * @since 2015-10-14
 */
public class MapSample3 {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			String names[] = {"John", "Alex", "Sean", "Simon", "Kevin", "Joe", "Mary", "Sue", "Candy", "Doris"};
			Map<String, Integer> hashMap = new HashMap<String, Integer>();
			for(int i = 0; i < names.length; i++){
					hashMap.put(names[i], i);
			}
			Map<String, Integer> treeMap = new TreeMap<String, Integer>();
			for(int i = 0; i < names.length; i++){
					treeMap.put(names[i], i);
			}
			Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
			for(int i = 0; i < names.length; i++){
					linkedHashMap.put(names[i], i);
			}
			System.out.println("HashMap: " + hashMap);
			System.out.println("TreeMap: " + treeMap);
			System.out.println("LinkedHashMap: " + linkedHashMap);
	}

}
