/**
 * 測試集合(Collection)的多種Implementation的用途.<br>
 * 結論:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;(1) 較常使用的一般目的集合類別實作為HashSet(for Set), ArrayList(for List), 
 * 			HashMap(for Map), LinkedList(for Queue), ArrayDeque(for Deque).<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;(2) java.util.concurrent套件下的集合實作,提供了Thread-Safe且非單一互斥鎖
 * 			(single exclusion lock)的實作.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;(3) Collections類別提供多個靜態方法操作或回傳集合類別, 包含Wrapper實作
 * 			及Convenience實作.<br>
 * @author SimonC
 * @since 2015-11-12
 */
package test.collections.implementations;