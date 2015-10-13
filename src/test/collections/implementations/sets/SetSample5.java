package test.collections.implementations.sets;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;CopyOnWriteArraySet的例子-多個線程同時操作並且遍歷集合set的範例.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.當set是CopyOnWriteArraySet物件時，程序能正常運行。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.当set是HashSet物件時，程序會產生ConcurrentModificationException異常。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.CopyOnWriteArraySet是線程安全的集合，而HashSet是非線程安全的。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.參考資料: <a href="http://www.cnblogs.com/skywang12345/p/3498497.html" target="_top">http://www.cnblogs.com/skywang12345/p/3498497.html</a><br>
 * @author SimonC
 *
 */
public class SetSample5 {

	private static Set<String> set = new CopyOnWriteArraySet<String>();
	//發生java.util.ConcurrentModificationException
	//private static Set<String> set = new HashSet<String>();
	
	public static void main(String[] args) {
			new MyThread("ta").start();
			new MyThread("tb").start();
	}

	private static void printAll() {
			String value = null;
			Iterator<String> iter = set.iterator();
			while(iter.hasNext()) {
					value = iter.next();
					System.out.print(value+", ");
			}
			System.out.println();
    }
	
	private static class MyThread extends Thread{
			MyThread(String name){
					super(name);
			}

			@Override
			public void run() {
					int i = 0;
					while (i++ < 10) {
							// “线程名” + "-" + "序号"
							String val = Thread.currentThread().getName() + "-" + (i%6);
							set.add(val);
							// 通过“Iterator”遍历set。
							printAll();
					}
			}
	}
}
