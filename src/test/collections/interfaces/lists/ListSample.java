package test.collections.interfaces.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ListSample {

	public static void main(String[] args) {
			//1. aggregate values of an attribute into a list
			List<Person> people = new ArrayList<Person>();
			Person p1 = new Person();
			p1.setId(1L);
			p1.setName("Lee");
			Person p2 = new Person();
			p2.setId(2L);
			p2.setName("Simon");
			Person p3 = new Person();
			p3.setId(3L);
			p3.setName("Ben");
			people.add(p1);
			people.add(p2);
			people.add(p3);
			people.add(p2);
			List<String> list = people.stream().map(Person::getName)
					.collect(Collectors.toList());
			System.out.println("list=" + list);
			//2. Method 'shuffle' of class 'Collections'.
			String cards[] = {"S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK", "SA", 
					"H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK", "HA",
					"D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK", "DA",
					"C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK", "CA"};
			List<String> deck = Arrays.asList(cards);
			System.out.println(deck.size() + " cards: " + deck);
			Collections.shuffle(deck);
			System.out.println(deck.size() + " cards: " + deck);
			//3. Method 'swap' of class 'Collections'.
			String s1[] = {"1", "2", "3", "4"};
			List<String> s1List = Arrays.asList(s1);
			System.out.println("s1List: " + s1List);
			Collections.swap(s1List, 1, 2);
			System.out.println("s1List after swapping two elements of index 1 and 2: " + s1List);
			//4. 
			Integer i1[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			List<Integer> i1List = Arrays.asList(i1);
			for(ListIterator<Integer> it = i1List.listIterator(i1List.size());it.hasPrevious();){
					Integer i = it.previous();
					System.out.println(i);
			}
	}

	public static class Person{
			private long id;
			
			private String name;

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
	}
}
