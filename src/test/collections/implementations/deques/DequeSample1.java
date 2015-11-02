package test.collections.implementations.deques;

import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.Deque的實作LinkedList新增及刪除花費的時間.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.Deque可從頭端或尾端新增或刪除元素.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.先依序由頭端和尾端反覆各新增1佰萬個元素,測量新增2佰萬個元素總花費的時間;
 *          然後再依序由頭端及尾端反覆再全部刪除,再測量刪除2佰萬個元素總花費的時間.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.LinkedList的效能遠差於ArrayDeque.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.LinkedList新增所花費的時間為(重覆5次, 單位:millsecond): 
 *          1977, 1975, 2526, 1893, 1945. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;3.LinkedList刪除所花費的時間為(重覆5次, 單位:millsecond): 
 *          38, 37, 37, 38, 38. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;4.故結論若有Deque操作需求,使用ArrayDeque就對了.<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;5.若有concurrent操作需求, 則使用LinkedBlockingDeque.<br>
 * @author SimonC
 * @since 2015-11-02
 */
public class DequeSample1 {
	
	private static int n = 1000000;
	
	private static Deque<Integer> linkedList = new LinkedList<Integer>();

	public static void main(String[] args) {
			testAddingElementsIntoDeque();
			testRemovingElementsFromDeque();
	}
	
	private static void testAddingElementsIntoDeque(){
			long linkedListTime = 0L;
			long sDate = new Date().getTime();
			for(int i = 1; i <= n; i++){
					linkedList.addFirst(n - i + 1);
					linkedList.addLast(n + i);
			}
			long eDate = new Date().getTime();
			linkedListTime = (eDate - sDate);
			
			System.out.println(linkedListTime + " millseconds was spent adding " + n 
					+ " elements into the front of a LinkedList object and " + n + " ones into the rear of it!");
	}
	
	private static void testRemovingElementsFromDeque(){
			long linkedListTime = 0L;
			long sDate = new Date().getTime();
			for(int i = 1; i <= n; i++){
					linkedList.removeFirst();
					linkedList.removeLast();
			}
			long eDate = new Date().getTime();
			linkedListTime = (eDate - sDate);
			
			System.out.println(linkedListTime + " millseconds was spent removing " + n 
					+ " elements from the front of a LinkedList object and " + n + " ones from the rear of it!");
	}
}
