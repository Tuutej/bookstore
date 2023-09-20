package hh.sof03.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepo) { 
		return (args) -> {
			log.info("add some books");
			Book book1 = new Book("Moby Dick", "Herman Melville", 1851, "978-1989631645", 14.99);
			Book book2 = new Book("Das Kapital", "Karl Marx", 1867, "978-1789430653", 29.99);
			
			bookRepo.save(book1);
			bookRepo.save(book2);	
			
			log.info("fetch all books");
			for (Book book : bookRepo.findAll()) {
				log.info(book.toString());
			}

		};
	}
}

