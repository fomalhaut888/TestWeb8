package test.collections.implementations.wrappers;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.測試除了前面提到的CopyOnWriteArraySet等這些concurrent操作
 * 			的Collections類別外, 另一種利用Wrapper Implementations方式使Collections達到Thread-safe的方法
 * 			-Collections.synchronizedXXX.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.測試方式: 產生兩個Thread分別輸入1-30及31-60至一個TreeSet, 
 * 			最終60個元素順利輸入並依序排列.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.Wrapper Implementations是使用decorator樣式在目前的Collection上
 * 			加上額外的功能.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.使用一般的Set當作全域變數供多個Thread存取, 可能不定時出現意外的結果.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.雖然透過Collections.synchronizedSet處理了Set本身, 
 * 			使得add等操作為Thread-safe, 但在Iterator輸出過程仍是不保證Thread-safe,
 * 			因此在輸出過程的程式碼必須加上synchronized包覆<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;3.Thread-unsafe的結果: <br>
 * 			//###出現例外<br>
 * 			Exception in thread "t1" t2: java.lang.NullPointerException<br>
 * 			1 2 3 4 5 6 7 31 32 33 34 35 36 37 38 39 40 41 42 43 44 	at java.util.TreeMap.rotateLeft(TreeMap.java:2220)<br>
 * 			45 46 47 48 	at java.util.TreeMap.fixAfterInsertion(TreeMap.java:2287)49 50 51 52 53 54 <br>
 * 			55 	at java.util.TreeMap.put(TreeMap.java:582)<br>
 * 			56 57 58 59 	at java.util.TreeSet.add(TreeSet.java:255)<br>
 * 				at test.collections.implementations.wrappers.WrapperSample1$TaskThread.run(WrapperSample1.java:39)<br>
 * 				at java.lang.Thread.run(Thread.java:745)<br>
 * 			60 <br>
 * 			<br>
 * 			//###1不見了<br>
 * 			t2: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 <br>
 * 			t1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 <br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;4.另一種thread-unsafe結果: 輸出過程的程式碼未加上synchronized包覆<br>
 * 			t2: t1: 1 2 3 1 4 2 5 3 6 4 7 5 8 6 9 7 10 8 11 9 12 10 13 14 11 12 15 13 16 17 18 19 20 21 22 14 15 16 17 18 23 19 24 20 25 21 26 27 28 29 30 31 32 33 34 22 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 52 41 53 42 54 43 55 44 56 45 57 58 59 60 <br>
 * 			46 47 48 49 50 51 52 53 54 55 56 57 58 59 60<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;5.Thread-safe的結果: <br>
 * 			t2: 1 2 3 4 5 6 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60<br>
 * 			t1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;6.與Concurrent Collections實作的不同(參考: http://www.ewdna.com/2011/11/javaarraylistthread-safe.html): 
 * 			例如ConcurrentHashMap，它針對Hash Table中不同的區段（segment）進行同步化，
 * 			而不是對整個物件進行同步化，預設上HashMap有16個區段，當有執行緒在存取第一個區段時， 
 * 			第一個區域進入同步化，然而另一個執行緒仍可以存取第一個區段以外的區段，
 * 			而不用等待第一個執行緒存取完成，所以與同步化整個物件來說，新增的這些同步化物件，
 * 			在效率與安全性上取得了較好的平衡。若在需要同步化的情況下，
 * 			直接利用最新的 java.util.concurrent package 似乎比較簡單，且又可以兼顧效能及安全性，
 * 			相信這是首選。<br>
 * @author SimonC
 * @since 2015-11-12
 */
public class WrapperSample1 {
	
	private static Set<Integer> globalSet;

	public static void main(String[] args) {
			/* Thread-unsafe的結果: 使用一般的Set當作全域變數供多個Thread存取, 可能不定時出現意外的結果.
			//###出現例外
			Exception in thread "t1" t2: java.lang.NullPointerException
			1 2 3 4 5 6 7 31 32 33 34 35 36 37 38 39 40 41 42 43 44 	at java.util.TreeMap.rotateLeft(TreeMap.java:2220)
			45 46 47 48 	at java.util.TreeMap.fixAfterInsertion(TreeMap.java:2287)49 50 51 52 53 54 
			55 	at java.util.TreeMap.put(TreeMap.java:582)
			56 57 58 59 	at java.util.TreeSet.add(TreeSet.java:255)
				at test.collections.implementations.wrappers.WrapperSample1$TaskThread.run(WrapperSample1.java:39)
				at java.lang.Thread.run(Thread.java:745)
			60 
			
			//###1不見了
			t2: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 
			t1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 
			 */
			//globalSet = new TreeSet<Integer>();//Thread-unsafe
			globalSet = Collections.synchronizedSet(new TreeSet<Integer>());
			Thread t1 = new Thread(new TaskThread("t1", 1, 30));
			t1.setName("t1");
			Thread t2 = new Thread(new TaskThread("t2", 31, 60));
			t2.setName("t2");
			t1.start();
			t2.start();
	}

	private static class TaskThread implements Runnable{
		
			private String threadName;
		
			private int start;
			
			private int end;
		
			public TaskThread(String threadName, int start, int end){
					this.threadName = threadName;
					this.start = start;
					this.end = end;
			}
		
			@Override
			public void run() {
					for(int i = start; i <= end; i++){
							globalSet.add(i);
					}
					/* 另一種thread-unsafe結果: 雖然透過Collections.synchronizedSet處理了Set本身, 
					 	使得add等操作為Thread-safe, 但在Iterator輸出過程仍是不保證Thread-safe,
					 	因此在輸出過程的程式碼必須加上synchronized包覆
					t2: t1: 1 2 3 1 4 2 5 3 6 4 7 5 8 6 9 7 10 8 11 9 12 10 13 14 11 12 15 13 16 17 18 19 20 21 22 14 15 16 17 18 23 19 24 20 25 21 26 27 28 29 30 31 32 33 34 22 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 52 41 53 42 54 43 55 44 56 45 57 58 59 60 
					46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 
					 */
					/* Thread-safe的結果
					t2: 1 2 3 4 5 6 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 
					t1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 
					 */
					synchronized(globalSet){
							System.out.print(threadName + ": ");
							for(Integer integer: globalSet){
									System.out.print(integer + " ");
							}
							System.out.println();
					}
			}
	}
}
