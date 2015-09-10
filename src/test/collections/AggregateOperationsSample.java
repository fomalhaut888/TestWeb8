package test.collections;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AggregateOperationsSample {
		public static void main(String args[]){
				List<Person> roster = Person.getTestData();
				System.out.println("@@@@@@@@@@@@@@@@@@@@ output1");
				roster.stream()
						.forEach(e -> e.printPerson());
						//.forEach(Person :: printPerson);//it's ok as well.
				
				System.out.println("$$$$$$$$$$$$$$$$$$$$ output2");
				roster.stream()
						.filter(e -> e.getGender() == Person.Sex.MALE)
						.forEach(e -> e.printPerson());//This code is identical to the following marked codes.
				/* 
				for (Person p : roster) {
					    if (p.getGender() == Person.Sex.MALE) {
					        	p.printPerson();
					    }
				}*/
				
				System.out.println("%%%%%%%%%%%%%%%%%%%% output3");
				double average = roster.stream()
						.filter(e -> e.getGender() == Person.Sex.MALE)
						.mapToInt(Person :: getAge)
						//.mapToInt(e -> e.getAge()) //it's ok as well.
						.average()
						.getAsDouble();
				System.out.println("average=" + average);
				
				System.out.println("******************** output4");
				List<Person> roster2 = new ArrayList<Person>(); //A collection has no element.
				try{
						double average2 = roster2.stream()
								.filter(e -> e.getGender() == Person.Sex.MALE)
								.mapToInt(Person :: getAge)
								.average()
								.getAsDouble();//throw a NoSuchElementException object.
						System.out.println("average2=" + average2);
				}catch(NoSuchElementException nsee){
						System.out.println("NoSuchElementException: " + nsee);
						nsee.printStackTrace();
				}
				
				//Difference between Aggregate Operations and Iterators
				//1. Aggregate Operations use internal iteration.
				//		With internal delegation, your application determines 
				//				what collection it iterates, but the JDK determines how to iterate the collection.
				//		With external iteration, your application determines 
				//				both what collection it iterates and how it iterates it.
				//		External iteration can only iterate over the elements of a collection sequentiallly.
				//		Internal iteration does not have this limitation. It can easily take advantage of parallel computing,
				//				which involves dividing a problem into subproblems,
				//						solving those subproblems simultaneously,
				//				  and then combining the results of the solutions to the subproblems.
				//2. Aggregate Operations process elements from the stream.
				//		They are also called stream operations.
				//3. Aggregate Operations support behavior as parameters.
				//		You can specify lambda expressions as parameters for most aggregate operations,
				//				and this enables you to customize the behavior of a particular aggregate operation.
		}
}

class Person{
	public enum Sex{
			MALE, FEMALE
	}
	
	private String name;
	
	private LocalDate birthday;
	
	private Sex gender;
	
	private String emailAddress;
	
	public static int compareByAge(Person a, Person b) {
        	return a.birthday.compareTo(b.birthday);
    }
	
	public int getAge(){
			LocalDate today = LocalDate.now();
			Period period = Period.between(birthday, today);
			//System.out.println("period.getYears()=" + period.getYears());
			//System.out.println("period.getMonths()=" + period.getMonths());
			//System.out.println("period.getDays()=" + period.getDays());
			return period.getYears();
	}

	public void printPerson(){
			System.out.println("########## " + name);
			System.out.println("*** Birthday: " + birthday.format(DateTimeFormatter.ISO_LOCAL_DATE));
			System.out.println("*** Gender: " + gender);
			System.out.println("*** Email: " + emailAddress);
			System.out.println("*** Age: " + getAge());
			System.out.println();
			System.out.println();
	}
	
	public static List<Person> getTestData() {
			List<Person> list = new ArrayList<Person>();
			//1
			Person p = new Person();
			p.setName("Simon Chen jr.");
			p.setBirthday(LocalDate.of(1973, Month.MAY, 18));
			p.setGender(Sex.MALE);
			p.setEmailAddress("mail1@leosys.com");
			list.add(p);
			
			//2
			p = new Person();
			p.setName("Simon Chen sr.");
			p.setBirthday(LocalDate.of(1945, Month.NOVEMBER, 20));
			p.setGender(Sex.MALE);
			p.setEmailAddress("mail2@leosys.com");
			list.add(p);
			
			//3
			p = new Person();
			p.setName("Wheat Yen");
			p.setBirthday(LocalDate.of(1951, Month.JULY, 18));
			p.setGender(Sex.FEMALE);
			p.setEmailAddress("mail3@leosys.com");
			list.add(p);
			
			//4
			p = new Person();
			p.setName("Darby Chen");
			p.setBirthday(LocalDate.of(1972, Month.JANUARY, 27));
			p.setGender(Sex.FEMALE);
			p.setEmailAddress("mail4@leosys.com");
			list.add(p);
			
			//5
			p = new Person();
			p.setName("余大");
			p.setBirthday(LocalDate.of(1993, Month.FEBRUARY, 14));
			p.setGender(Sex.MALE);
			p.setEmailAddress("mail5@leosys.com");
			list.add(p);
			
			return list;
	}
	
	public String getName() {
			return name;
	}
	
	public void setName(String name) {
			this.name = name;
	}
	
	public LocalDate getBirthday() {
			return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
			this.birthday = birthday;
	}
	
	public Sex getGender() {
			return gender;
	}
	
	public void setGender(Sex gender) {
			this.gender = gender;
	}
	
	public String getEmailAddress() {
			return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
	}
}
