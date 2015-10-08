package test.collections.implementations.sets;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;測試三種一般目的(General-purpose)的Set物件新增物件的執行效能,包括HashSet, TreeSet, LinkedHashSet.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;HashSet最佳, LinkedHashSet其次, 而TreeSet較差, 但其實差異並不大, 故其實可以忽略該效能的差異.<br>
 * @author SimonC
 * @since 2015-10-08
 */
public class SetSample1 {
	
		private static Integer objs[];
		
		private static int n = 5000000;
		
		static{
				objs = new Integer[n];
				//for(int i = 0; i < n; i++){
				for(int i = n - 1; i >= 0; i--){
						objs[i] = new Integer(i);
				}
		}
	
		public static void main(String args[]) throws InterruptedException{
				switch(Integer.parseInt(args[0])){
						case 1:
								testAddingHashSet();
								break;
								//n=5,000,000 values=0 to 4,999,999 list of 5 results(milliseconds):
								//		3541, 3360, 3691, 3446, 3616
								//n=5,000,000 values=4,999,999 to 0 list of 5 results(milliseconds):
								//		3499, 3428, 3274, 3597, 3394
								//n=10,000,000 values=4,999,999 to 0 list of 5 results(milliseconds):
								//		7481, 7678, 7297, 6859, 8145
						case 2:
								testAddingTreeSet();
								break;
								//n=5,000,000 values=0 to 4,999,999 list of 5 results(milliseconds):
								//		3848, 3904, 3796, 3810, 4152
								//n=5,000,000 values=4,999,999 to 0 list of 5 results(milliseconds):
								//		4278, 4153, 4164, 4135, 4142
								//n=10,000,000 values=4,999,999 to 0 list of 5 results(milliseconds):
								//		7483, 7753, 8056, 7444, 7322
						case 3:
								testAddingLinkedHashSet();
								break;
								//n=5,000,000 values=0 to 4,999,999 list of 5 results(milliseconds):
								//		3218, 3496, 3737, 3685, 3688
								//n=5,000,000 values=4,999,999 to 0 list of 5 results(milliseconds):
								//		3683, 3612, 3248, 3347, 3455
								//n=10,000,000 values=4,999,999 to 0 list of 5 results(milliseconds):
								//		9712, 9494, 7347, 10585, 9747
								
						default:
								throw new IllegalArgumentException("Wrong args[0](1-3 only)!");
				}
		}
		
		private static void testAddingHashSet(){
				Set<Integer> hashSet = new HashSet<Integer>();
				long hashSetTime = 0L;
				long sDate = new Date().getTime();
				for(Integer obj: objs){
						hashSet.add(obj);
				}
				long eDate = new Date().getTime();
				hashSetTime = (eDate - sDate);
				
				System.out.println("A HashSet object spent " + hashSetTime + 
						" millseconds adding " + n + " elements!");
		}
		
		private static void testAddingTreeSet(){
				Set<Integer> treeSet = new TreeSet<Integer>();
				long treeSetTime = 0L;
				long sDate = new Date().getTime();
				for(Integer obj: objs){
						treeSet.add(obj);
				}
				long eDate = new Date().getTime();
				treeSetTime = (eDate - sDate);
				
				System.out.println("A TreeSet object spent " + treeSetTime + 
						" millseconds adding " + n + " elements!");
		}
		
		private static void testAddingLinkedHashSet(){
				Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
				long linkedHashSetTime = 0L;
				long sDate = new Date().getTime();
				for(Integer obj: objs){
						linkedHashSet.add(obj);
				}
				long eDate = new Date().getTime();
				linkedHashSetTime = (eDate - sDate);
				
				System.out.println("A LinkedHashSet object spent " + linkedHashSetTime + 
						" millseconds adding " + n + " elements!");
		}
}
