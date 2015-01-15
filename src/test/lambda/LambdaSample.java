package test.lambda;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LambdaSample {
		
		//Approach 1: Create Methods That Search for Members That Match One Characteristic
		public static void printPersonsOlderThan(List<Person> roster, int age){
				for(Person p: roster){
						if(p.getAge() > age){
								p.printPerson();
						}
				}
		}
		
		//Approach 2: Create More Generalized Search Methods
		public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high){
				for(Person p: roster){
						if(p.getAge() >= low && p.getAge() < high){
								p.printPerson();
						}
				}
		}
		
		//Approach 3: Specify Search Criteria Code in a Local Class
		public static void printPersons(List<Person> roster, CheckPerson tester){
				for(Person p: roster){
						if(tester.test(p)){
								p.printPerson();
						}
				}
		}
		
		//Approach 6: Use Standard Functional Interfaces(with GENERIC) with Lambda Expressions
		public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester){
				for(Person p: roster){
						if(tester.test(p)){
								p.printPerson();
						}
				}
		}
		
		//Approach 7: Use Lambda Expressions Throughout Your Application
		public static void processPersons(List<Person> roster, Predicate<Person> tester,
				Consumer<Person> block){
				for(Person p: roster){
						if(tester.test(p)){
								block.accept(p);
						}
				}
		}
		
		//~Approach 7
		public static void processPersonWithFunction(List<Person> roster, Predicate<Person> tester,
				Function<Person, String> mapper, Consumer<String> block){
				for(Person p: roster){
						if(tester.test(p)){
								String data = mapper.apply(p);
								block.accept(data);
						}
				}
		}
		
		//Approach 8 Use Generics More Extensively
		public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester,
				Function<X, Y> mapper, Consumer<Y> block){
				for(X p: source){
						if(tester.test(p)){
								Y data = mapper.apply(p);
								block.accept(data);
						}
				}
		}
		
		public static void main(String args[]){
				List<Person> roster = Person.getTestData();
				
				//~Approach3
				printPersons(roster, new CheckPersonEligibleForSelectiveService());
				
				//Approach 4: Specify Search Criteria Code in an Anonymous Class
				printPersons(roster, new CheckPerson(){
						@Override
						public boolean test(Person p) {
								return p.getGender() == Person.Sex.MALE  
										&& p.getAge() >= 18 && p.getAge() < 25;
						}
				});
				
				//Approach 5: Specify Search Criteria Code with a Lambda Expression
				printPersons(roster, 
						(Person p) -> p.getGender() == Person.Sex.MALE  
								&& p.getAge() >= 18 
								&& p.getAge() < 25);
				
				//~Approach 6
				printPersonsWithPredicate(roster, 
						p -> p.getGender() == Person.Sex.MALE  
								&& p.getAge() >= 18 
								&& p.getAge() < 45);
				
				//~Approach 7
				processPersons(roster,
						p -> p.getGender() == Person.Sex.MALE  
						&& p.getAge() >= 18 
						&& p.getAge() < 45,
						p -> p.printPerson());
				
				//~Approach 7
				processPersonWithFunction(roster,
						p -> p.getGender() == Person.Sex.MALE  
						&& p.getAge() >= 18 
						&& p.getAge() < 45,
						p -> p.getEmailAddress(),
						email -> System.out.println("email:" + email));
				
				//~Approach 8
				processElements(roster,
						p -> p.getGender() == Person.Sex.MALE  
						&& p.getAge() >= 18 
						&& p.getAge() < 45,
						p -> p.getEmailAddress(),
						email -> System.out.println("email:" + email));
				
				//Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
				//The operations filter, map, and forEach are aggregate operations.
				//Aggregate operations process elements from a stream, not directly from a collection 
				//		(which is the reason why the first method invoked in this example is stream).
				//A stream is a sequence of elements.
				//Unlike a collection, it is not a data structure that stores elements.
				//Instead, a stream carries values from a source, such as collection, through a pipeline.
				//A pipeline is a sequence of stream operations, which in this example is filter- map-forEach.
				//aggregate operations typically accept lambda expressions as parameters
				//Aggregate Operations lesson: see http://docs.oracle.com/javase/tutorial/collections/streams/index.html
				roster.stream()
						.filter(
								p -> p.getGender() == Person.Sex.MALE  
								&& p.getAge() >= 18 
								&& p.getAge() < 45)
						.map(p -> p.getEmailAddress())
						.forEach(email -> System.out.println("email:" + email));
		}
}

//~Approach 7
interface Function<T, R>{//any attribute given dynamically
		R apply(T t);
}

//~Approach 7
interface Consumer<T>{
		void accept(T t);
}

//~Approach 6
interface Predicate<T>{
		boolean test(T t);
}

//~Approach 3
//This is a FUNCTIONAL INTERFACE that contains ONLY ONE ABSTRACT method.
interface CheckPerson{
		boolean test(Person p);
		
		//If method2 is added, this will not be a functional interface and the lambda expression will show the error
		//		"The target type of this expression must be a functional interface".
		//void method2();
		
		//A functional interface may contain one or more default methods or static methods.
		//TODO study default method
		public static void method3(){
		}
}

//~Approach 3
class CheckPersonEligibleForSelectiveService implements CheckPerson{
		@Override
		public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE  
						&& p.getAge() >= 18 && p.getAge() < 25;
		}
}

//~Approach 1
class Person{
		public enum Sex{
				MALE, FEMALE
		}
		
		private String name;
		
		private LocalDate birthday;
		
		private Sex gender;
		
		private String emailAddress;
		
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
