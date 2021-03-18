package com.io;

import java.net.InterfaceAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Excercise {

	public static void main(String[] args) {

		List<Person> ppl = Arrays.asList(new Person("charles","sam",60),
				new Person("R","Ya",31),
				new Person("GP","RA",45),
				new Person("AN","SH",31));
		
		//Custom comparator to sort based on last name
		Collections.sort(ppl, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastname().compareTo(o2.getLastname());
			}	
		});
		
		//OR using lambda the above can be written in one line
		Collections.sort(ppl, (p1,p2)->p1.getLastname().compareTo(p2.getLastname()));
		
		//Print the person lsit to verify sorting
		
		printAll(ppl);
		printConditinally(ppl, p-> p.getLastname().startsWith("C"));
		
	}

	private static void printAll(List<Person> ppl) {
		for(Person p: ppl) {
			System.out.println(p);
		}
		
	}
	public static void printConditinally(List<Person> P, Condition condi) {
		for (Person p1: P) {
			if(condi.test(p1)) {
				System.out.println(p1);
			}
		}
		
	}
	

}
