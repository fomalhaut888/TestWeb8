package test.dates;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarTimeZoneSample {

	public static void main(String[] args) {
			//Current datetime of default Calendar
			System.out.println("###############################################");
			System.out.println("**********" + "Current datetime of default Calendar");
			Calendar defaultCa = Calendar.getInstance();
			System.out.println("Date object of defaultCa: " + defaultCa.getTime());
			System.out.println("TimeZone object of defaultCa: " + defaultCa.getTimeZone());
			System.out.println("YEAR of defaultCa: " + defaultCa.get(Calendar.YEAR));
			System.out.println("MONTH of defaultCa: " + defaultCa.get(Calendar.MONTH));
			System.out.println("DATE of defaultCa: " + defaultCa.get(Calendar.DATE));
			System.out.println("HOUR_OF_DAY of defaultCa: " + defaultCa.get(Calendar.HOUR_OF_DAY));
			System.out.println("MINUTE of defaultCa: " + defaultCa.get(Calendar.MINUTE));
			System.out.println("SECOND of defaultCa: " + defaultCa.get(Calendar.SECOND));
			//Current datetime of America/Los_Angeles Calendar
			System.out.println("**********" + "Current datetime of America/Los_Angeles Calendar");
			Calendar alCa = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
			System.out.println("Date object of alCa: " + alCa.getTime());
			System.out.println("TimeZone object of alCa: " + alCa.getTimeZone());
			System.out.println("YEAR of alCa: " + alCa.get(Calendar.YEAR));
			System.out.println("MONTH of alCa: " + alCa.get(Calendar.MONTH));
			System.out.println("DATE of alCa: " + alCa.get(Calendar.DATE));
			System.out.println("HOUR_OF_DAY of alCa: " + alCa.get(Calendar.HOUR_OF_DAY));
			System.out.println("MINUTE of alCa: " + alCa.get(Calendar.MINUTE));
			System.out.println("SECOND of alCa: " + alCa.get(Calendar.SECOND));
			//Summer datetime of Asia/Taipei Calendar
			System.out.println("###############################################");
			System.out.println("**********" + "Summer datetime of Asia/Taipei Calendar");
			Calendar summerTpCa = new GregorianCalendar(2015, 6, 18, 16, 15, 00);
			summerTpCa.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
			System.out.println("Date object of summerTpCa: " + summerTpCa.getTime());
			System.out.println("TimeZone object of summerTpCa: " + summerTpCa.getTimeZone());
			System.out.println("YEAR of summerTpCa: " + summerTpCa.get(Calendar.YEAR));
			System.out.println("MONTH of summerTpCa: " + summerTpCa.get(Calendar.MONTH));
			System.out.println("DATE of summerTpCa: " + summerTpCa.get(Calendar.DATE));
			System.out.println("HOUR_OF_DAY of summerTpCa: " + summerTpCa.get(Calendar.HOUR_OF_DAY));
			System.out.println("MINUTE of summerTpCa: " + summerTpCa.get(Calendar.MINUTE));
			System.out.println("SECOND of summerTpCa: " + summerTpCa.get(Calendar.SECOND));
			//Summer datetime of America/Los_Angeles Calendar
			System.out.println("**********" + "Summer datetime of America/Los_Angeles Calendar");
			Calendar summerAlCa = new GregorianCalendar(TimeZone.getTimeZone("America/Los_Angeles"));
			summerAlCa.setTime(summerTpCa.getTime());
			System.out.println("Date object of summerAlCa: " + summerAlCa.getTime());
			System.out.println("TimeZone object of summerAlCa: " + summerAlCa.getTimeZone());
			System.out.println("YEAR of summerAlCa: " + summerAlCa.get(Calendar.YEAR));
			System.out.println("MONTH of summerAlCa: " + summerAlCa.get(Calendar.MONTH));
			System.out.println("DATE of summerAlCa: " + summerAlCa.get(Calendar.DATE));
			System.out.println("HOUR_OF_DAY of summerAlCa: " + summerAlCa.get(Calendar.HOUR_OF_DAY));
			System.out.println("MINUTE of summerAlCa: " + summerAlCa.get(Calendar.MINUTE));
			System.out.println("SECOND of summerAlCa: " + summerAlCa.get(Calendar.SECOND));
			System.out.println("================");
			System.out.println("Time difference between Taipei and L.A. in Summer (with daylight saving time): " + 
					(summerTpCa.get(Calendar.HOUR_OF_DAY) - summerAlCa.get(Calendar.HOUR_OF_DAY)));
			//Winter datetime of Asia/Taipei Calendar
			System.out.println("###############################################");
			System.out.println("**********" + "Winter datetime of Asia/Taipei Calendar");
			Calendar winterTpCa = new GregorianCalendar(2015, 11, 18, 16, 15, 00);
			winterTpCa.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
			System.out.println("Date object of winterTpCa: " + winterTpCa.getTime());
			System.out.println("TimeZone object of winterTpCa: " + winterTpCa.getTimeZone());
			System.out.println("YEAR of winterTpCa: " + winterTpCa.get(Calendar.YEAR));
			System.out.println("MONTH of winterTpCa: " + winterTpCa.get(Calendar.MONTH));
			System.out.println("DATE of winterTpCa: " + winterTpCa.get(Calendar.DATE));
			System.out.println("HOUR_OF_DAY of winterTpCa: " + winterTpCa.get(Calendar.HOUR_OF_DAY));
			System.out.println("MINUTE of winterTpCa: " + winterTpCa.get(Calendar.MINUTE));
			System.out.println("SECOND of winterTpCa: " + winterTpCa.get(Calendar.SECOND));
			//Winter datetime of America/Los_Angeles Calendar
			System.out.println("**********" + "Winter datetime of America/Los_Angeles Calendar");
			Calendar winterAlCa = new GregorianCalendar(TimeZone.getTimeZone("America/Los_Angeles"));
			winterAlCa.setTime(winterTpCa.getTime());
			System.out.println("Date object of winterAlCa: " + winterAlCa.getTime());
			System.out.println("TimeZone object of winterAlCa: " + winterAlCa.getTimeZone());
			System.out.println("YEAR of winterAlCa: " + winterAlCa.get(Calendar.YEAR));
			System.out.println("MONTH of winterAlCa: " + winterAlCa.get(Calendar.MONTH));
			System.out.println("DATE of winterAlCa: " + winterAlCa.get(Calendar.DATE));
			System.out.println("HOUR_OF_DAY of winterAlCa: " + winterAlCa.get(Calendar.HOUR_OF_DAY));
			System.out.println("MINUTE of winterAlCa: " + winterAlCa.get(Calendar.MINUTE));
			System.out.println("SECOND of winterAlCa: " + winterAlCa.get(Calendar.SECOND));
			System.out.println("================");
			System.out.println("Time difference between Taipei and L.A. in Winter (without daylight saving time): " + 
					(winterTpCa.get(Calendar.HOUR_OF_DAY) - winterAlCa.get(Calendar.HOUR_OF_DAY)));
	}

}
