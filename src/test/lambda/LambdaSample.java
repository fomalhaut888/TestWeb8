package test.lambda;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//Ideal Use Case for Lambda Expressions
public class LambdaSample {
		
		//Approach 1: Create Methods That Search for Members That Match One Characteristic
		public static void printPersonsOlderThan(List<Person> roster, int age){
				for(Person p: roster){
						if(p.getAge() > age){
								p.printPerson();
						}
				}
		}//This approach can potentially make your application brittle, which is the likelihood of an application not working 
		//    because of the introduction of updates (such as newer data types).
		
		//Approach 2: Create More Generalized Search Methods
		public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high){
				for(Person p: roster){
						if(p.getAge() >= low && p.getAge() < high){
								p.printPerson();
						}
				}
		}//What if you want to print members of a specified sex, or a combination of a specified gender and age range? 
		//    What if you decide to change the Person class and add other attributes such as relationship status or geographical location?
		
		//Approach 3: Specify Search Criteria Code in a Local Class
		public static void printPersons(List<Person> roster, CheckPerson tester){
				for(Person p: roster){
						if(tester.test(p)){
								p.printPerson();
						}
				}
		}
		
		//Approach 6: Use Standard Functional Interfaces(with GENERIC) with Lambda Expressions
		public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester){//java.util.function.Predicate
				for(Person p: roster){
						if(tester.test(p)){
								p.printPerson();
						}
				}
		}//The method is so simple that it might not be worth it to define one in your application. 
		//    Consequently, the JDK defines several standard functional interfaces, which you can find in the PACKAGE java.util.function.
		
		//Approach 7: Use Lambda Expressions Throughout Your Application
		public static void processPersons(List<Person> roster, Predicate<Person> tester,
				Consumer<Person> block){//In this case, you need a functional interface that contains an abstract method that can take one argument of type Person and returns void.
				for(Person p: roster){//java.util.function.Consumer. The Consumer<T> interface contains the method void accept(T t), which has these characteristics.
						if(tester.test(p)){
								block.accept(p);
						}
				}
		}
		
		//~Approach 7
		public static void processPersonWithFunction(List<Person> roster, Predicate<Person> tester,
				Function<Person, String> mapper, Consumer<String> block){//In this case, you need a functional interface that contains an abstract method that returns a value.
				for(Person p: roster){//java.util.function.Function. The following method retrieves the data specified by the parameter mapper, and then performs an action on it specified by the parameter block
						if(tester.test(p)){
								String data = mapper.apply(p);
								block.accept(data);
						}
				}
		}
		
		//Approach 8 Use Generics More Extensively
		public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester,
				Function<X, Y> mapper, Consumer<Y> block){//The following is a generic version of it that accepts, as a parameter, a collection that contains elements of any data type
				for(X p: source){//java.lang.Iterable
						if(tester.test(p)){
								Y data = mapper.apply(p);
								block.accept(data);
						}
				}
		}
		
		public static void main(String args[]){
				List<Person> roster = Person.getTestData();
				
				//~Approach3
				System.out.println("$$$$$$$$$$ Approach3 starts");
				System.out.println();
				
				printPersons(roster, new CheckPersonEligibleForSelectiveService());//use a concrete class that implements the interface of the second parameter.
				
				System.out.println("^^^^^^^^^^ Approach3 ends");
				System.out.println();
				System.out.println();
				
				//Approach 4: Specify Search Criteria Code in an Anonymous Class
				System.out.println("$$$$$$$$$$ Approach4 starts");
				System.out.println();
				
				printPersons(roster, new CheckPerson(){
						@Override
						public boolean test(Person p) {
								return p.getGender() == Person.Sex.MALE  
										&& p.getAge() >= 18 && p.getAge() < 25;
						}
				});
				
				System.out.println("^^^^^^^^^^ Approach4 ends");
				System.out.println();
				System.out.println();
				
				//Approach 5: Specify Search Criteria Code with a Lambda Expression
				System.out.println("$$$$$$$$$$ Approach5 starts");
				System.out.println();
				
				printPersons(roster, 
						(Person p) -> p.getGender() == Person.Sex.MALE  
								&& p.getAge() >= 18 
								&& p.getAge() < 25);//Only for a functional interface that is any interface that contains only one ABSTRACT method. 
				//    (A functional interface may contain one or more default methods or static methods.) 
				
				System.out.println("^^^^^^^^^^ Approach5 ends");
				System.out.println();
				System.out.println();
				
				//~Approach 6
				System.out.println("$$$$$$$$$$ Approach6 starts");
				System.out.println();
				
				printPersonsWithPredicate(roster, 
						p -> p.getGender() == Person.Sex.MALE  
								&& p.getAge() >= 18 
								&& p.getAge() < 50);//omit the class name when declaring p.
				
				System.out.println("^^^^^^^^^^ Approach6 ends");
				System.out.println();
				System.out.println();
				
				//~Approach 7
				System.out.println("$$$$$$$$$$ Approach7 starts");
				System.out.println();
				
				processPersons(roster,
						p -> p.getGender() == Person.Sex.MALE  
						&& p.getAge() >= 18 
						&& p.getAge() < 50,
						p -> p.printPerson());
				
				System.out.println("//////////");
				System.out.println();
				
				processPersons(roster,
						p -> p.getGender() == Person.Sex.MALE  
						&& p.getAge() >= 18 
						&& p.getAge() < 50,
						p -> p.printPerson2());//change another method to print results.
				
				System.out.println("//////////");
				System.out.println();
				
				//~Approach 7
				processPersonWithFunction(roster,
						p -> p.getGender() == Person.Sex.MALE  
						&& p.getAge() >= 18 
						&& p.getAge() < 50,
						p -> p.getEmailAddress(),
						email -> System.out.println("email:" + email));
				
				System.out.println();
				System.out.println("^^^^^^^^^^ Approach7 ends");
				System.out.println();
				System.out.println();
				
				//~Approach 8
				System.out.println("$$$$$$$$$$ Approach8 starts");
				System.out.println();
				
				processElements(roster,//more generic parameter
						p -> p.getGender() == Person.Sex.MALE  
						&& p.getAge() >= 18 
						&& p.getAge() < 50,
						p -> p.getEmailAddress(),
						email -> System.out.println("email:" + email));
				
				System.out.println();
				System.out.println("^^^^^^^^^^ Approach8 ends");
				System.out.println();
				System.out.println();
				
				//1.Obtains a SOURCE of objects from the collection source. In this example, 
				//    it obtains a source of Person objects from the collection roster. 
				//    Notice that the collection roster, which is a collection of type List, is also an object of type Iterable.
				//2. FILTERS objects that match the Predicate object tester. In this example, 
				//    the Predicate object is a lambda expression that specifies which members would be eligible for Selective Service.
				//3. Maps each filtered object to a VALUE as specified by the Function object mapper. In this example, 
				//    the Function object is a lambda expression that returns the e-mail address of a member.
				//4. Performs an action on EACH mapped object as specified by the Consumer object block. In this example, 
				//    the Consumer object is a lambda expression that prints a string, which is the e-mail address returned by the Function object.
				
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
				System.out.println("$$$$$$$$$$ Approach9 starts");
				System.out.println();
				
				roster.stream()
						.filter(
								p -> p.getGender() == Person.Sex.MALE  
								&& p.getAge() >= 18 
								&& p.getAge() < 50)
						.map(p -> p.getEmailAddress())
						.forEach(email -> System.out.println("email:" + email));
				
				System.out.println();
				System.out.println("^^^^^^^^^^ Approach9 ends");
				System.out.println();
				System.out.println();
				
				//The aggregate operation:
				//processElements Action: Aggregate Operation
				//Obtain a source of objects: Stream<E> stream()
				//Filter objects that match a Predicate object: Stream<T> filter(Predicate<? super T> predicate)
				//Map objects to another value as specified by a Function object: <R> Stream<R> map(Function<? super T,? extends R> mapper)
				//Perform an action as specified by a Consumer object: void forEach(Consumer<? super T> action)
		}
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
		
		public void printPerson2(){
				System.out.println("********** " + name);
				System.out.println(">>> Birthday: " + birthday.format(DateTimeFormatter.ISO_LOCAL_DATE));
				System.out.println(">>> Gender: " + gender);
				System.out.println(">>> Email: " + emailAddress);
				System.out.println(">>> Age: " + getAge());
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
				p.setBirthday(LocalDate.of(1997, Month.FEBRUARY, 14));
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
