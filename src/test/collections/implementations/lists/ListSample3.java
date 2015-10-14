package test.collections.implementations.lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.測試ArrayList及LinkedList抓取不同位置元素的效能差異.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.比較方式: 預先在兩種List上建立1百萬個元素,
 *          然後抓取固定1000個位置的元素並印出,比較抓取這些元素所花的時間.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.ArrayList效能勝過LinkedList.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.LinkedList的時間複雜度為linear time, ArrayList則為constant time.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.ArrayList抓取1000個元素並印出所花費的時間為(重覆5次, 單位:millsecond): 
 *          63, 62, 63, 64, 62. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;4.LinkedList抓取1000個元素並印出所花費的時間為(重覆5次, 單位:millsecond): 
 *          756, 772, 752, 757, 749. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;5.故結論為若List只負責存放及抓取元素, 則使用ArrayList; 
 *          若需要對List進行新增或刪除元素, 則使用LinkedList.<br>
 * @author SimonC
 * @since 2015-10-14
 */
public class ListSample3 {
	
	private static int n = 1000000;
	
	private static int m = 1000;

	public static void main(String[] args) {
			switch(Integer.parseInt(args[0])){
					case 1:
							testArrayList();
							break;
					case 2:
							testLinkedList();
							break;
					default:
							throw new IllegalArgumentException("Wrong args[0](1-2 only)!");
			}
	}

	private static void testArrayList(){
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < n; i++){
					list.add(i);
			}
			long arrayListTime = 0L;
			long sDate = new Date().getTime();
			for(int i = 1; i <= m; i++){
					System.out.println(list.get(i * 100) + " ");
			}
			long eDate = new Date().getTime();
			arrayListTime = (eDate - sDate);
			System.out.println();
			
			System.out.println(arrayListTime + " millseconds was spent geting and printing " + m + 
					" elements from the interior of an ArrayList object!");
	}
	
	private static void testLinkedList(){
			List<Integer> list = new LinkedList<Integer>();
			for(int i = 0; i < n; i++){
					list.add(i);
			}
			long linkedListTime = 0L;
			long sDate = new Date().getTime();
			for(int i = 1; i <= m; i++){
					System.out.println(list.get(i * 100) + " ");
			}
			long eDate = new Date().getTime();
			linkedListTime = (eDate - sDate);
			
			System.out.println(linkedListTime + " millseconds was spent geting and printing " + m + 
					" elements from the interior of an LinkedList object!");
	}
}
