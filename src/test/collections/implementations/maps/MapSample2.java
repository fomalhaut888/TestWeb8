package test.collections.implementations.maps;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * 目標:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;EnumMap的例子.<br>
 * 結果:<br>
 * 			&nbsp;&nbsp;&nbsp;&nbsp;1.EnumMap key值的順序會依enum宣告的順序.<br>
 * @author SimonC
 * @since 2015-10-14
 */
public class MapSample2 {

	public static void main(String[] args) {
			Map<Day, Integer> enumMap = new EnumMap<Day, Integer>(Day.class);
			enumMap.put(Day.SUNDAY, 0);
			enumMap.put(Day.SATURDAY, 6);
			enumMap.put(Day.FRIDAY, 5);
			enumMap.put(Day.WEDNESDAY, 3);
			enumMap.put(Day.THURSDAY, 4);
			enumMap.put(Day.TUESDAY, 2);
			enumMap.put(Day.MONDAY, 1);
			System.out.println("enumMap=" + enumMap);
			Set<Day> keySet = enumMap.keySet();
			System.out.println("keySet's Class: " + keySet.getClass().toString());
			for(Day day: keySet){
					System.out.println(day + "=>" + enumMap.get(day));
			}
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
