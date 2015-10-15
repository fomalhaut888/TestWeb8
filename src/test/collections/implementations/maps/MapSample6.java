package test.collections.implementations.maps;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;ConcurrentHashMap的例子-多個線程同時操作並且遍歷集合Map的範例.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.ConcurrentHashMap分類屬Special-purpose實作。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.當map是ConcurrentHashMap物件時，程序能正常運行。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.當map是HashMap物件時，程序會產生ConcurrentModificationException異常。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.ConcurrentHashMap是線程安全的集合，而HashMap是非線程安全的。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;5.參考資料: <a href="http://www.cnblogs.com/skywang12345/p/3498537.html" target="_top">http://www.cnblogs.com/skywang12345/p/3498537.html</a><br>
 * @author SimonC
 * @since 2015-10-14
 */
public class MapSample6 {

	private static Map<String, String> map = new ConcurrentHashMap<String, String>();
	//發生java.util.ConcurrentModificationException
	//private static Map<String, String> map = new HashMap<String, String>();
	
	public static void main(String[] args) {
			// 同时启动两个线程对map进行操作！
			new MyThread("ta").start();
			new MyThread("tb").start();
	}
	
	private static void printAll() {
			String key, value;
			Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
			while(iter.hasNext()) {
					Map.Entry<String,String> entry = iter.next();
					key = (String)entry.getKey();
					value = (String)entry.getValue();
					System.out.print(key+" - "+value+", ");
			}
			System.out.println();
	}

	private static class MyThread extends Thread {
			MyThread(String name) {
					super(name);
			}
			@Override
			public void run() {
					int i = 0;
					while (i++ < 6) {
							// “线程名” + "-" + "序号"
							String val = Thread.currentThread().getName()+i;
							map.put(String.valueOf(i), val);
							// 通过“Iterator”遍历map。
							printAll();
					}
			}
	}
}
