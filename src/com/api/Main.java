package com.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {

		int sum = IntStream.range(1, 10000).filter(num -> num % 3 == 0 && num % 5 == 0 && num % 7 != 0).sum();
		// cant use .forEach() because .sum() is terminal operation
		System.out.println();
		System.out.println(
				"The sum of all numbers between 1 and 10000 that are dividable by both 3 and 5 but not dividable by 7 is:  ");
		System.out.println(sum);

		List<Integer> numbers = IntStream.iterate(0, num -> num + 2).limit(100).filter(num -> num % 8 != 0).boxed()
				.toList();
		// .toList() is also terminal operation
		System.out.println();
		System.out.println("The first 100 even numbers that are not dividable by 8 are: ");
		System.out.println(numbers);

		List<Book> list = new ArrayList<>();
		// creating books
		Book b1 = new Book("Noro", 10);
		Book b2 = new Book("Noro123", 100);
		Book b3 = new Book("69584", 1000);
		Book b4 = new Book("Nor", 500);
		Book b5 = new Book("Norbert", 510);
		Book b6 = new Book("NoroVozar", 0);
		// filling the list
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		list.add(b6);

		List<String> under100Books = list.stream().filter(book -> book.getPrice() < 100).map(Book::getName).sorted()
				.toList();

		System.out.println();
		System.out.println("Names (in alphabetic order) of all books that have price smaller than 100 are: ");
		System.out.println(under100Books);

		long numOfBookUnder5 = list.stream().filter(book -> book.getName().length() < 5).count();

		System.out.println();
		System.out.println("Number of books, which have name shorter than 5 characters is: ");
		System.out.println(numOfBookUnder5);

		// da sa to aj bez orElse(0) , vtedy bude nie double ale optionalDouble
		double avg_price = list.stream().mapToInt(Book::getPrice).average().orElse(0);

		System.out.println();
		System.out.println("Average price of the book in the list is: ");
		System.out.println(avg_price);

		boolean cheaperThan500 = list.stream().allMatch(book -> book.getPrice() < 500);

		System.out.println();
		System.out.println("Are all books in list cheaper than 500? ");
		System.out.println(cheaperThan500);

	}

}
