package test.method_references;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferencesSample {
	public static void main(String args[]){
			List<Person> roster = Person.getTestData();
			Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
			//Before sorting
			System.out.println("Before sorting");
			for(Person p: rosterAsArray){
					p.printPerson();
			}
			
			//~ Traditional inner class
			class PersonAgeComparator implements Comparator<Person>{
					@Override
					public int compare(Person a, Person b) {
							return a.getBirthday().compareTo(b.getBirthday());
					}
			}
			
			//1. Traditional inner class
			//Arrays.sort(rosterAsArray, new PersonAgeComparator());
			//2. Lambda expression.
			/*
			Arrays.sort(rosterAsArray, (Person a, Person b) ->{
					return a.getBirthday().compareTo(b.getBirthday());
			});*/
			//3. Easier lambda expression to invoke an existed method.
			/*
			Arrays.sort(rosterAsArray, 
					(a, b) ->Person.compareByAge(a, b)
			);*/
			//4. Method reference instead of lambda expression.
			Arrays.sort(rosterAsArray, Person::compareByAge);
			//After sorting
			System.out.println("After sorting");
			for(Person p: rosterAsArray){
					p.printPerson();
			}
			
			//5. Four kinds of Method References
			//5-1. Reference to a Static method
			//Like codes above
			
			//5-2. Reference to an Instance method of a particular object
			class ComparisonProvider{
					public int compareByName(Person a, Person b) {
				        	return a.getName().compareTo(b.getName());
				    }
				        
				    public int compareByAge(Person a, Person b) {
				        	return a.getBirthday().compareTo(b.getBirthday());
				    }
			}
			ComparisonProvider myComparisonProvider = new ComparisonProvider();
			//Arrays.sort(rosterAsArray, (a, b) -> myComparisonProvider.compareByName(a, b));//myComparisonProvider must be final.
			Arrays.sort(rosterAsArray, 	myComparisonProvider::compareByName );//why not compiler error if not final?
			//myComparisonProvider = new ComparisonProvider();//this line added to test that myComparisonProvider must be final.
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$After sorting by name");
			for(Person p: rosterAsArray){
					p.printPerson();
			}
			//Arrays.sort(rosterAsArray, (a, b) -> myComparisonProvider.compareByAge(a, b) );
			Arrays.sort(rosterAsArray, 	myComparisonProvider::compareByAge );
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$After sorting by age");
			for(Person p: rosterAsArray){
					p.printPerson();
			}
			
			//5-3 Reference to an Instance Method of an Arbitrary Object of a Particular Type
			String[] stringArray = { "Barbara", "James", "Mary", "John",
				    "Patricia", "Robert", "Michael", "Linda" };
			//Arrays.sort(stringArray, (a, b) -> a.compareToIgnoreCase(b));
			Arrays.sort(stringArray, String::compareToIgnoreCase);
			System.out.println("#####################After sorting by string values:");
			for(String s: stringArray){
					System.out.println(s);
			}
			System.out.println();
			System.out.println();
			
			//5-4 Reference to a Constructor
			//5-4-1 Lambda expression
			//List<Person> rosterListLambda = transferElements(roster, () -> new ArrayList<>());
			//5-4-2 Constructor reference instead of lambda expression
			//List<Person> rosterListLambda = transferElements(roster, ArrayList::new);
			//5-4-3 Create a ArrayList collection that contains elements of type Person
			List<Person> rosterListLambda = transferElements(roster, ArrayList<Person>::new);
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%The new list copied from roster:");
			for(Person p: rosterListLambda){
					p.printPerson();
			}
	}
	
	//5-4 Reference to a Constructor
	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> 
			DEST transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory){//The functional interface java.util.function.Supplier contains one method get that takes no arguments and returns an object.
			DEST result = collectionFactory.get();
			for(T t: sourceCollection){
					result.add(t);
			}
			return result;
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
