package test.collections.implementations.queues;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;PriorityQueue的Queue範例.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.PriorityQueue實作Queue介面。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.此類別的功能是實作優先佇列(預設的值愈小代表優先順序愈高),
 * 			取出的順序會依目前Queue內所有值中最高的優先值先取出。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.此優先佇列的演算法是使用heap資料結構。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.PriorityQueue內存放順序是依heap演算法實作出來的順序,
 * 			因此順序沒有固定且無意義, 因此使用Iterator出來的結果也沒有意義, 僅是顯示它的排序順序。<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;5.PriorityQueue應使用add塞入及poll取出操作, 
 * 			poll取出的值一定是目前queue內的優先順序最高值(預設是最小值)。<br>
 * @author SimonC
 * @since 2015-10-19
 */
public class QueueSample2 {

	public static void main(String[] args) {
			Queue<Integer> priorityQueue = new PriorityQueue<Integer>();
			int data[] = {9, 6, 2, 8, 7, 6, 5, 4, 3, 6 , 2, 1, 0};
			for(int i: data){
					priorityQueue.add(i);
			}
			System.out.println("PriorityQueue: ");
			Iterator<Integer> iterator = priorityQueue.iterator();
			while(iterator.hasNext()){
					System.out.print(iterator.next() + " ");
			}
			System.out.println();
			while(!priorityQueue.isEmpty()){
					Integer e = priorityQueue.poll();
					iterator = priorityQueue.iterator();
					while(iterator.hasNext()){
							System.out.print(iterator.next() + " ");
					}
					System.out.println(", " + e + " polled! ");
			}
	}

}
