package test.collections.implementations.maps;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;IdentityHashMap的例子.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.IdentityHashMap分類屬Special-purpose實作.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.HashMap是key的值唯一; IdentityHashMap是key的物件唯一.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.HashMap判別key是否相等是以equals方法判別; IdentityHashMap則是以物件參照相等判別(==).<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.IdentityHashMap通常用於序列化或deep-copying,具有物件唯一性.<br>
 * @author SimonC
 * @since 2015-10-14
 */
public class MapSample1 {
		public static void main(String[] args) {
				Map<Integer, String> identityHashMap = new IdentityHashMap<Integer, String>();
				Map<Integer, String> hashMap = new HashMap<Integer, String>();
				Integer key1 = new Integer(1);
				String value1 = "A";
				Integer key2 = new Integer(1);
				String value2 = "B";
				identityHashMap.put(key1, value1);
				identityHashMap.put(key2, value2);
				hashMap.put(key1, value1);
				hashMap.put(key2, value2);
				System.out.println("key1==key2?" + (key1 == key2));
				System.out.println("identityHashMap=" + identityHashMap);
				System.out.println("hashMap=" + hashMap);
		}
}
