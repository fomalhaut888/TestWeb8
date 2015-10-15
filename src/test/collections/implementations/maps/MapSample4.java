package test.collections.implementations.maps;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;試模擬以LinkedHashMap建立一個custom cache的例子,
 * 			建一個最大容量10的cache, 依序新增20個配對值,若Map內的配對值個數超過最大容量,
 * 			則丟棄最早已新增的配對值, 使Map配對值個數維持在最大10個.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.Oracle文件推薦的LinkedHashMap應用.<br>
 * @author SimonC
 * @since 2015-10-14
 */
public class MapSample4 {

	public static void main(String[] args) {
			final int MAX_ENTRIES = 10;
			Cache cache = new Cache(MAX_ENTRIES);
			for(int i = 1; i <= 20; i++){
					cache.add(i, "Page" + i);
			}
			cache.printCache();
	}
}

class Cache{
	
	private int maxEntries;

	private Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
	
	public Cache(int maxEntries){
			if(maxEntries <= 0){
					throw new IllegalArgumentException("The argument 'maxEntries' must be greater than zero!");
			}
			this.maxEntries = maxEntries;
	}
	
	public void add(int key, String value){
			while(linkedHashMap.size() >= maxEntries){
					linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
			}
			linkedHashMap.put(key, value);
	}
	
	public void printCache(){
			System.out.println(linkedHashMap);
	}
}
