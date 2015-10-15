package test.collections.implementations.lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.測試兩種general-purpose實作ArrayList及LinkedList在不同位置移除元素的效能差異.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.比較方式: 預先在兩種List上建立1百萬個元素,
 *          然後在固定1000個位置刪除元素,比較刪除這些元素所花的時間.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.LinkedList效能勝過ArrayList.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.LinkedList的時間複雜度為constant time, ArrayList則為linear time.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.ArrayList刪除1000個元素花費的時間為(重覆5次, 單位:millsecond): 
 *          1377, 1363, 1374, 1365, 1367. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;4.LinkedList刪除1000個元素花費的時間為(重覆5次, 單位:millsecond): 
 *          692, 693, 698, 695, 703. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;5.若刪除的位置改為List末位,則兩List插入效能無太大差異.<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;6.若刪除的位置改為List首位,則LinkedList效能遠勝ArrayList.<br>
 * @author SimonC
 * @since 2015-10-14
 */
public class ListSample2 {
	
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
					list.remove(i * 100);
					//list.remove(list.size() - 1);
					//list.remove(0);
			}
			long eDate = new Date().getTime();
			arrayListTime = (eDate - sDate);
			
			System.out.println(arrayListTime + " millseconds was spent removing " + m + 
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
					list.remove(i * 100);
					//list.remove(list.size() - 1);
					//list.remove(0);
			}
			long eDate = new Date().getTime();
			linkedListTime = (eDate - sDate);
			
			System.out.println(linkedListTime + " millseconds was spent removing " + m + 
					" elements from the interior of an LinkedList object!");
	}
}
