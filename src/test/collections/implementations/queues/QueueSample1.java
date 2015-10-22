package test.collections.implementations.queues;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;LinkedList的Queue範例.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.LinkedList實作Queue介面。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.依據傳統佇列的塞入及取出原則為FIFO。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.LinkedList內存放順序是依塞入先至後排列。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.塞入元素的方法是add; 取出的方法是poll。<br>
 * @author SimonC
 * @since 2015-10-19
 */
public class QueueSample1 {

	public static void main(String[] args) {
			Queue<Integer> linkedList = new LinkedList<Integer>();
			int data[] = {9, 6, 2, 8, 7, 6, 5, 4, 3, 6 , 2, 1, 0};
			for(int i: data){
					linkedList.add(i);
			}
			Iterator<Integer> iterator = linkedList.iterator();
			System.out.println("LinkedList: ");
			while(iterator.hasNext()){
					System.out.print(iterator.next() + " ");
			}
			System.out.println();
			while(!linkedList.isEmpty()){
					Integer e = linkedList.poll();
					iterator = linkedList.iterator();
					while(iterator.hasNext()){
							System.out.print(iterator.next() + " ");
					}
					System.out.println(", " + e + " polled! ");
			}
	}

}
