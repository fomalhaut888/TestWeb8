package test.default_methods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//**Not mention the default method at all, which lets your extended interface inherit the default method.
//AnotherTimeClient will have the implementation specified by the default method TimeClient.getZonedDateTime.
public interface AnotherTimeClient extends TimeClient {
		void anotherMethod();
		
		public static void main(String args[]){
				AnotherTimeClient myTimeClient = new AnotherTimeClient(){
					
						private LocalDateTime dateAndTime = LocalDateTime.now();;
					
						@Override
						public void setTime(int hour, int minute, int second) {
								LocalDate currentDate = LocalDate.from(dateAndTime);
								LocalTime timeToSet = LocalTime.of(hour, minute, second);
								dateAndTime = LocalDateTime.of(currentDate, timeToSet);
						}
	
						@Override
						public void setDate(int day, int month, int year) {
								LocalDate dateToSet = LocalDate.of(day, month, year);
								LocalTime currentTime = LocalTime.from(dateAndTime);
								dateAndTime = LocalDateTime.of(dateToSet, currentTime);
						}
	
						@Override
						public void setDateAndTime(int day, int month, int year,
								int hour, int minute, int second) {
								LocalDate dateToSet = LocalDate.of(day, month, year);
								LocalTime timeToSet = LocalTime.of(hour, minute, second);
								dateAndTime = LocalDateTime.of(dateToSet, timeToSet);
						}
	
						@Override
						public LocalDateTime getLocalDateTime() {
								return dateAndTime;
						}
	
						@Override
						public void anotherMethod() {
								// TODO Auto-generated method stub
						}
						
						@Override
						public String toString() {
					        	return dateAndTime.toString();
					    }
				};
				System.out.println("Current time: " + myTimeClient.toString());
				System.out.println("Time in California: " +
						//******************default method
			            myTimeClient.getZonedDateTime("Blah blah").toString());
		}
}
