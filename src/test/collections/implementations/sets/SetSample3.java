package test.collections.implementations.sets;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;測試HashSet有設定初始容量和使用預設初始容量的新增效能的差異.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.並未有特別的差異.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.initialCapacity引數不可小於0.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.loadFactor引數必須大於0.0F, 此數使用預設即可不必特別設定.<br>
 * @author SimonC
 * @since 2015-10-08
 */
public class SetSample3 {
	
	private static Integer objs[];
	
	private static int n = 5000000;
	
	static{
			objs = new Integer[n];
			for(int i = 0; i < n; i++){
					objs[i] = new Integer(i);
			}
	}

	public static void main(String[] args) {
			switch(Integer.parseInt(args[0])){
					case 1:
							testAddingHashSetWithDefaultCapacity();
							break;
					case 2:
							testAddingHashSetWithGivenCapacity();
							break;
					default:
							throw new IllegalArgumentException("Wrong args[0](1-2 only)!");
			}
	}

	private static void testAddingHashSetWithGivenCapacity() {
			Set<Integer> hashSet = new HashSet<Integer>(8388608);//2^23
			//Set<Integer> hashSet = new HashSet<Integer>(-1); //java.lang.IllegalArgumentException
			//Set<Integer> hashSet = new HashSet<Integer>(8388608, 0.00f);//java.lang.IllegalArgumentException
			long hashSetTime = 0L;
			long sDate = new Date().getTime();
			for(Integer obj: objs){
					hashSet.add(obj);
			}
			long eDate = new Date().getTime();
			hashSetTime = (eDate - sDate);
			
			System.out.println("A HashSet object spent " + hashSetTime + 
					" millseconds adding " + n + " elements with the given argument 'initialCapacity' of enough size!");
	}

	private static void testAddingHashSetWithDefaultCapacity() {
			Set<Integer> hashSet = new HashSet<Integer>();
			long hashSetTime = 0L;
			long sDate = new Date().getTime();
			for(Integer obj: objs){
					hashSet.add(obj);
			}
			long eDate = new Date().getTime();
			hashSetTime = (eDate - sDate);
			
			System.out.println("A HashSet object spent " + hashSetTime + 
					" millseconds adding " + n + " elements with the default argument 'initialCapacity'!");
	}

}
