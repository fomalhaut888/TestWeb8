package test.collections.implementations.queues;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;LinkedBlockingQueue的例子-多個線程同時操作.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.LinkedBlockingQueue分類屬Special-purpose實作。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.當queue是LinkedBlockingQueue物件時，程序能正常運行。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.當queue是LinkedList物件時，程序會產生ConcurrentModificationException異常。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.LinkedBlockingQueue是線程安全的集合，而LinkedList是非線程安全的。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;5.其它集合類別ArrayBlockingQueue, PriorityBlockingQueue, 
 * 			DelayQueue, SynchronousQueue也可用於多線程.<br>
 * @author SimonC
 * @since 2015-10-14
 */
public class QueueSample3 {
	
	private static Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
	//private static Queue<Integer> queue = new LinkedList<Integer>();//java.util.ConcurrentModificationException

	public static void main(String[] args) {
			new MyThread("t1", 1, 10).start();
			new MyThread("t2", 101, 10).start();
			System.out.println("Runtime.getRuntime().availableProcessors()=" + Runtime.getRuntime().availableProcessors());
	}
	
	private static void printAll(){
			Iterator<Integer> iterator = queue.iterator();
			while(iterator.hasNext()){
					System.out.print(iterator.next() + " ");
			}
			System.out.println();
	}

	private static class MyThread extends Thread{
		
			private int startValue;
			
			private int count;
			
			public MyThread(String name, int startValue, int count){
					super(name);
					this.startValue = startValue;
					this.count = count;
			}
		
			@Override
			public void run() {
					for(int i = startValue; i < startValue + count; i++){
							queue.add(i);
							printAll();
					}
			}
	}
}
