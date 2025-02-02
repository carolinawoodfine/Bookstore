package project.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("save books");
			repository.save(new Book("F. Scott Fitzgerald","The Great Gatsby" , "9780743273565", 10.99, 1925));
			repository.save(new Book("Harper Lee","To Kill a Mockingbird" , "9780061120084", 12.99, 1960));
			

			log.info("fetch books");
			for (Book book : repository.findAll()){
				log.info(book.toString());
			}
		};
}
}