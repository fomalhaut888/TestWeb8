package test.collections.implementations.sets;

import java.util.EnumSet;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;EnumSet的例子.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.EnumSet物件內原素存放的順序會依enum宣告的順序.<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;2.EnumSet的range靜態方法的兩引數必須依照enum宣告的順序前及後, 否則會出現IllegalArgumentException例外.<br>
 * @author SimonC
 *
 */
public class SetSample4 {

	public static void main(String[] args) {
			EnumSet<Day> enumSet = EnumSet.range(Day.MONDAY , Day.FRIDAY);
			for(Day d: enumSet){
					System.out.print(d + " ");
			}
			System.out.println();
			enumSet = EnumSet.range(Day.FRIDAY, Day.FRIDAY);
			for(Day d: enumSet){
					System.out.print(d + " ");
			}
			System.out.println();
			/*
			//java.lang.IllegalArgumentException: FRIDAY > MONDAY
			//range兩個引數必須依照enum宣告的順序前及後, 否則會出現例外
			enumSet = EnumSet.range(Day.FRIDAY, Day.MONDAY);
			for(Day d: enumSet){
					System.out.print(d + " ");
			}
			System.out.println();
			*/
			//EnumSet物件內原素存放的宣告會依enum設定的順序.
			enumSet = EnumSet.of(Day.FRIDAY , Day.SUNDAY);
			for(Day d: enumSet){
					System.out.print(d + " ");
			}
			System.out.println();
	}

	public enum Day{
			SUNDAY,
			MONDAY,
			TUESDAY,
			WEDNESDAY,
			THURSDAY,
			FRIDAY,
			SATURDAY;
	}
}

