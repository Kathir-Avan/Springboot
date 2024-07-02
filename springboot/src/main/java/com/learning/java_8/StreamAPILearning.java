package com.learning.java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.learning.springboot.restdemo.entity.Employee;

public class StreamAPILearning { 
	//Stream gives good performance for collections data bcoz it don't store the data while doing operations. 
	//Stream of data from collections, arrays. //Stream can be consumed once and throw error if try morethan once. 
	//Before streams, iterations & sequential processing is there in java. Stream uses parallel processing. 
	//Pre-requestite -> Lambda / Predicate Interface / Function Interface. 
	//Stream creation -> Arrays.stream() / HashSet.stream() / ArrayList.stream() / collectionObject.stream() 
	//Stream Interface - java.util //Stream.empty(); 
	//Stream.of(); //Data -> Intermediate Operation -> Terminal Operations 
	public static void Stream(){ 
	int[] ar = {1,3,4,57,8,90,9,7,565,4,43,33,22,2,2,11,1,1,2,3,34,4,55}; 
	//Stream for holding integer data IntStream s = Arrays.stream(ar); 
	// System.out.println(s.count()); 
	//counting items s.sorted().forEach(no -> System.out.println(no)); s.forEach(no -> System.out.print(no)); s.forEach(System.out::println); 
	// Stream will be a pipeline of operations Arrays .stream(ar) 
	//stream from array data .sorted() 
	// sorting the numbers .forEach(System.out::println); 
	// printing the sorted numbers Arrays.stream(ar).count(); 
	System.out.println("--Average--------------------------");
	OptionalDouble od = Arrays.stream(ar).average();
	System.out.println("Average is "+od+" & is empty "+od.isEmpty()+" double value is"+od.getAsDouble());
	System.out.println("--Sorted--------------------------");
	Arrays.stream(ar).sorted().forEach(no -> System.out.println(no)); 
	System.out.println("--Even--------------------------");
	IntStream is = Arrays.stream(ar).filter(no -> no%2==0);
	is.forEach(no -> System.out.println(no));
	System.out.println("--Max--------------------------");
	OptionalInt op = Arrays.stream(ar).max(); 
	System.out.println("Max is "+op.getAsInt());
	System.out.println("---Min-------------------------");
	op = Arrays.stream(ar).min();
	System.out.println("Min is "+op.getAsInt());
	System.out.println("---First-------------------------");
	op = Arrays.stream(ar).findFirst();
	System.out.println("First is "+op.getAsInt());
	System.out.println("----------------------------");
	op = Arrays.stream(ar).findAny(); 
	IntStream iStream = Arrays.stream(ar).distinct(); 
	boolean b = Arrays.stream(ar).anyMatch(no -> no%2==0);
	
	List<Integer> ll = new LinkedList<Integer>();
	ll.add(10);
	ll.add(20);
	ll.add(30);
	ll.add(40);
	ll.add(50);
	ll.add(60);
	ll.add(60);
	ll.add(70);
	ll.add(70);
	ll.add(80);
	
//	ll.stream().distinct().sorted().forEach(no -> System.out.println(no));
//	ll.stream().map(no -> no/2).forEach(System.out::print);
	Optional<Integer> op1 = ll.stream().max((o1, o2) -> o1.compareTo(o2));
	System.out.println(op1.get());
	
	List<String> sl = new ArrayList<String>();
	sl.add("adc");
	sl.add("bgt");
	sl.add("wer");
	sl.add("tyu");
	sl.add("asd");
	sl.add("uio");
	sl.add("bgf");
	sl.add("wer");
	sl.add("qaz");
	sl.add("zdr");
	
	sl.stream().distinct().sorted((elem1,elem2)-> elem1.compareTo(elem2)).forEach(System.out::println);
	sl.stream().sorted().map(word -> word.toUpperCase()).forEach(System.out::println);
	sl.stream().map(no -> no + " B.E").forEach(System.out::println);
	sl.stream().limit(2).forEach(System.out::println);
	sl.stream().skip(2).forEach(System.out::println);
	
	Employee e1 = new Employee("Kathir","Avan","omaneyyy@bbc");
	Employee e2 = new Employee("Keerthi","Arjunan","keerthi@bbc");
	Employee e3 = new Employee("Priyo","Karan","priyo@bbc");
	Employee e4 = new Employee("Sabari","ram","ss@bbc");
	List<Employee> el = new LinkedList<Employee>();
	el.add(e1);
	el.add(e2);
	el.add(e3);
	el.add(e4);
	el.stream()
		.filter(word -> word.getFirstName().startsWith("K"))// filters object starts with "K"
		.map(word -> word.getFirstName()) // get names from filtered objects
		.forEach(System.out::println);
	
	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	hm.put("A",100);
	hm.put("B",200);
	hm.put("C",300);
	hm.put("D",400);
	hm.put("E",500);
	hm.put("F",200);
	hm.put("H",300);
	hm.put("I",500);
	
	hm.keySet().stream().sorted().forEach(System.out::println);
	List<String> ls = hm.keySet().stream().collect(Collectors.toList());
	
	}
	
	public static void java8Learning() {
		//Lambda Expression for abstract method
				FuncInterface a = (c,b) -> {return (c+b);};
				int temp = (a.rule(10,20));
				System.out.println(temp);
				// Default method with same name from 2 interfaces with different implementation
				DefaultMethodInterfaceImplementation dmii = new DefaultMethodInterfaceImplementation();
				dmii.calculateSalary(1000, 22);
				//predicate
				Predicate<Integer> p = dmii.predicateSeniorCitizen();
				System.out.println("Predicate for age 50 is " + p.test(50));
				System.out.println("Predicate for age 61 is " + p.test(61));
				FuncInterface.rule_1();
				// finding the even number using func.interface predicate with lambda expressions
					int[] array = {20,1,1,3,4,5,7,8,9,34,56,78,88,123,34,45,67,89,28};
					p = dmii.predicateEvenNumbers();
					p=p.negate(); // neglects the given case
					p.and(p); // combining two predicate conditions
					for(int i=0; i < array.length; i++) {
						if(p.test(array[i])) {
							System.out.println(array[i]+ " is even.");
						} else {
							System.out.println(array[i]+ " is odd.");
						}
					}
				//Function similar to predicate
				Function<String,Integer> f = name -> name.length();
				System.out.println("length of given string is "+f.apply("Kathiravan"));
				//internal forEach
				List<Integer> consumerItems = Arrays.asList(1,3,4,23,34,4,56,6,7,7,88,9,103);
				//forEach is a method in ConsumerInterface that work like normal foreach 
				consumerItems.forEach((l) -> System.out.print(l));
				// sum of square of even numbers
				int total=0;
				consumerItems.forEach((l) -> {
					int total1=0;
					if(l%2==0) {
						System.out.println(l+" is even");
					}
					else
						System.out.println(l+" is odd");
				}
				);
				System.out.println(total);
	}
}
