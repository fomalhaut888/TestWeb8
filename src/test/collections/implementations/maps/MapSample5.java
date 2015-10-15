package test.collections.implementations.maps;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;WeakHashMap的例子.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.WeakHashMap分類屬Special-purpose實作.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.強參考: 有變數或屬性直接可找到該物件.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.弱參考: 無變數或屬性直接可找到該物件.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.JVM執行垃圾回收後,若WeakHashMap的鍵值為弱參考,則該鍵值及對映值會被回收.<br>
 * @author SimonC
 * @since 2015-10-14
 */
public class MapSample5 {

	public static void main(String[] args) throws InterruptedException {
			Obj joe = new Obj("Joe");//Strong reference
			Obj candy = new Obj("Candy");//Strong reference
			Map<Obj, Integer> weakHashMap = new WeakHashMap<Obj, Integer>();
			weakHashMap.put(new Obj("John"), 1);//Weak reference
			weakHashMap.put(new Obj("Alex"), 2);//Weak reference
			weakHashMap.put(new Obj("Sean"), 3);//Weak reference
			weakHashMap.put(new Obj("Simon"), 4);//Weak reference
			weakHashMap.put(new Obj("Kevin"), 5);//Weak reference
			weakHashMap.put(joe, 6);
			weakHashMap.put(new Obj("Mary"), 7);//Weak reference
			weakHashMap.put(new Obj("Sue"), 8);//Weak reference
			weakHashMap.put(candy, 9);
			weakHashMap.put(new Obj("Doris"), 10);//Weak reference
			Set<Obj> keySet = weakHashMap.keySet();//Weak reference
			for(Obj key: keySet){
					System.out.print(key + "=>" + weakHashMap.get(key) + " ");
			}
			System.out.println();
			System.gc();//garbage collection
			keySet = weakHashMap.keySet();
			for(Obj key: keySet){
					System.out.print(key + "=>" + weakHashMap.get(key) + " ");
			}
			System.out.println();
			System.out.println("#######end");
	}

	public static class Obj{
			
			private String objName;
		
			public Obj(String objName){
					this.objName = objName;
			}

			@Override
			public String toString() {
					return objName;
			}
	}
}
