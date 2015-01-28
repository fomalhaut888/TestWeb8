package test.default_methods;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

//**Redeclare the default method, which makes it abstract.
//Any class that implements the interface AbstractZoneTimeClient will have to implement the method getZonedDateTime; 
//		this method is an abstract method like all other nondefault (and nonstatic) methods in an interface.
public interface AbstractZoneTimeClient extends TimeClient {
		//The Default method of TimeClient is set to abstract in the sub-interface of TimeClient
		public abstract ZonedDateTime getZonedDateTime(String zoneString);
		
		public static void main(String args[]){
				TimeClient myTimeClient = new AbstractZoneTimeClient(){
					
					@Override
					public ZonedDateTime getZonedDateTime(String zoneString) {
							//The Default method in TimeClient but not in AbstractZoneTimeClient.
							//		Thus, the method must be implemented as well when the sub-interface is implemented.
							return null;
					}

					@Override
					public void setTime(int hour, int minute, int second) {
							// TODO Auto-generated method stub
					}

					@Override
					public void setDate(int day, int month, int year) {
							// TODO Auto-generated method stub
					}

					@Override
					public void setDateAndTime(int day, int month, int year,
							int hour, int minute, int second) {
							// TODO Auto-generated method stub
					}

					@Override
					public LocalDateTime getLocalDateTime() {
							// TODO Auto-generated method stub
							return null;
					}
				};
		}
}
