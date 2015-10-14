package test.collections.implementations.lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.測試ArrayList及LinkedList在連結的首位插入元素的效能差異.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.比較方式: 預先在兩種List上建立1百萬個元素,
 *          然後使用新增插入操作在首位(index=0)插入1000個元素,比較插入這些元素所花的時間.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.LinkedList效能遠超過ArrayList.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.LinkedList的時間複雜度為constant time, ArrayList則為linear time.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.ArrayList插入1000個元素花費的時間為(重覆5次, 單位:millsecond): 
 *          1445, 1498, 1443, 1446, 1453. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;4.LinkedList插入1000個元素花費的時間為(重覆5次, 單位:millsecond): 
 *          1, 1, 0, 1, 0. <br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;5.若插入的位置改為List末位,則兩List插入效能無太大差異.<br>
 * @author SimonC
 * @since 2015-10-14
 */
public class ListSample1 {
	
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
			for(int i = (-1) * m; i <= -1; i++){
					list.add(0, i);
					//list.add(i);
			}
			long eDate = new Date().getTime();
			arrayListTime = (eDate - sDate);
			
			System.out.println(arrayListTime + " millseconds was spent adding " + m + 
					" elements at the beginning of an ArrayList object!");
	}
	
	private static void testLinkedList(){
			List<Integer> list = new LinkedList<Integer>();
			for(int i = 0; i < n; i++){
					list.add(i);
			}
			long linkedListTime = 0L;
			long sDate = new Date().getTime();
			for(int i = (-1) * m; i <= -1; i++){
					//list.addFirst(i);
					list.add(0, i);//兩方法均可, 實行的時間無異.
					//list.addLast(i);
			}
			long eDate = new Date().getTime();
			linkedListTime = (eDate - sDate);
			
			System.out.println(linkedListTime + " millseconds was spent adding " + m + 
					" elements at the beginning of an LinkedList object!");
	}
}
