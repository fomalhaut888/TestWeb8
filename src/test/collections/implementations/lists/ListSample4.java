package test.collections.implementations.lists;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;CopyOnWriteArrayList的例子-多個線程同時操作並且遍歷集合list的範例.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.當list是CopyOnWriteArrayList物件時，程序能正常運行。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.当list是ArrayList物件時，程序會產生ConcurrentModificationException異常。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.CopyOnWriteArraySet是線程安全的集合，而ArrayList是非線程安全的。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.參考資料: <a href="http://www.cnblogs.com/skywang12345/p/3498483.html" target="_top">http://www.cnblogs.com/skywang12345/p/3498483.html</a><br>
 * @author SimonC
 * @since 2015-10-14
 */
public class ListSample4 {
	
	private static List<String> list = new CopyOnWriteArrayList<String>();
	//發生java.util.ConcurrentModificationException
	//private static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
			//同时启动两个线程对list进行操作！
			new MyThread("ta").start();
			new MyThread("tb").start();
	}

	private static void printAll() {
			String value = null;
			Iterator<String> iter = list.iterator();
			while(iter.hasNext()) {
					value = iter.next();
					System.out.print(value+", ");
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
							String val = Thread.currentThread().getName()+"-"+i;
							list.add(val);
							// 通过“Iterator”遍历List。
							printAll();
					}
			}
	}
}
