package test.collections.implementations.deques;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.Deque的實作ArrayDeque新增及刪除花費的時間.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.Deque可從頭端或尾端新增或刪除元素.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.先依序由頭端和尾端反覆各新增1佰萬個元素,測量新增2佰萬個元素總花費的時間;
 *          然後再依序由頭端及尾端反覆再全部刪除,再測量刪除2佰萬個元素總花費的時間.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.ArrayDeque的效能遠優於Linked.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.ArrayDeque新增所花費的時間為(重覆5次, 單位:millsecond): 
 *          222, 215, 209, 227, 205. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;3.ArrayDeque刪除所花費的時間為(重覆5次, 單位:millsecond): 
 *          18, 17, 18, 17, 18. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;4.故結論若有Deque操作需求,使用ArrayDeque就對了.<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;5.若有concurrent操作需求, 則使用LinkedBlockingDeque.<br>
 * @author SimonC
 * @since 2015-11-02
 */
public class DequeSample2 {
	
	private static int n = 1000000;
	
	private static Deque<Integer> arrayDeque = new ArrayDeque<Integer>();

	public static void main(String[] args) {
			testAddingElementsIntoDeque();
			testRemovingElementsFromDeque();
	}
	
	private static void testAddingElementsIntoDeque(){
			long arrayDequeTime = 0L;
			long sDate = new Date().getTime();
			for(int i = 1; i <= n; i++){
					arrayDeque.addFirst(n - i + 1);
					arrayDeque.addLast(n + i);
			}
			long eDate = new Date().getTime();
			arrayDequeTime = (eDate - sDate);
			
			System.out.println(arrayDequeTime + " millseconds was spent adding " + n 
					+ " elements into the front of an ArrayDeque object and " + n + " ones into the rear of it!");
	}
	
	private static void testRemovingElementsFromDeque(){
			long arrayDequeTime = 0L;
			long sDate = new Date().getTime();
			for(int i = 1; i <= n; i++){
					arrayDeque.removeFirst();
					arrayDeque.removeLast();
			}
			long eDate = new Date().getTime();
			arrayDequeTime = (eDate - sDate);
			
			System.out.println(arrayDequeTime + " millseconds was spent removing " + n 
					+ " elements from the front of an ArrayDeque object and " + n + " ones from the rear of it!");
	}
}
