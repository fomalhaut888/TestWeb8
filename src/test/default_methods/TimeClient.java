package test.default_methods;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

//**The Default method in an interface
public interface TimeClient {
		void setTime(int hour, int minute, int second);
		void setDate(int day, int month, int year);
		void setDateAndTime(int day, int month, int year, int hour, int minute, int second);
		LocalDateTime getLocalDateTime();
		
		//**Now a public static non-abstract method can be defined in an interface.
		static ZoneId getZoneId(String zoneString){
				try{
						return ZoneId.of(zoneString);
				}catch(DateTimeException e){
						System.err.println("Invalid time zone: " + zoneString +
								"; using default time zone instead.");
						return ZoneId.systemDefault();
				}
		}
		
		//**Now a public non-abstract method given the modifier 'default' can be defined in an interface as well.
		default ZonedDateTime getZonedDateTime(String zoneString){
				return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
		}
}
