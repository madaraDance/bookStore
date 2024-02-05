package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.BOOK;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {return (args) -> {
		BOOK book1 = new BOOK("Maksim Minenko", "Neverending Road to Titan", "1234567-01", 2024, 20);
		BOOK book2 = new BOOK("Vlad Kruglov", "Tiltostan and how to get there", "1234567-02", 2024, 40);
		BOOK book3 = new BOOK("Radmir Mustakimov", "POS 4 > POS 1", "1234567-03", 2024, 0);
		BOOK book4 = new BOOK("Egor Minenko", "Basics of Invisibilty", "1234567-04", 2024, 99);

		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
		repository.save(book4);
	};
}

}