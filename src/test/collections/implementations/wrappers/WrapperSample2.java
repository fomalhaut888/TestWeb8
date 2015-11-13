package test.collections.implementations.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.測試另一種Wrapper Implementations-Unmodifiable Wrappers
 * 			-Collections.unmodifiableXXX靜態方法.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.對Unmodifiable Collections進行add, remove等操作將會丟出
 * 			java.lang.UnsupportedOperationException.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.用於建立後就不可再變(immutable)的集合物件, 或用於將這些物件
 * 			給某些Clients讀取但不能修改的情境下.<br>
 * @author SimonC
 * @since 2015-11-12
 */
public class WrapperSample2 {
	
	private static final List<Integer> immutableList;
	
	static{
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < 30; i++){
					list.add(i);
			}
			immutableList = Collections.unmodifiableList(list);
	}

	public static void main(String[] args) {
			for(Integer i: immutableList){
					System.out.print(i + " ");
			}
			System.out.println();
			System.out.println("immutableList.size()=" + immutableList.size());
			immutableList.add(30);//java.lang.UnsupportedOperationException thrown
			//immutableList.remove(0);//java.lang.UnsupportedOperationException thrown
	}

}
