package antonbookstore.antonbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import antonbookstore.antonbookstore.Controllers.*;
import antonbookstore.antonbookstore.Models.*;
import antonbookstore.antonbookstore.repository.*;

import java.math.BigDecimal;

@SpringBootApplication
public class AntonbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntonbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category fiction = new Category("Fiction");
			categoryRepository.save(fiction);
			System.out.println("Category ID: " + fiction.getId());
			Category action = new Category("Action");
			categoryRepository.save(action);
			System.out.println("Category ID: " + action.getId());

			bookRepository
					.save(new Book("Kirja 1", "Kirjailija 1", 1111, "1111111111111", new BigDecimal("11.11"), fiction));
			bookRepository
					.save(new Book("Kirja 2", "Kirjailija 2", 2222, "2222222222222", new BigDecimal("22.22"), action));
			bookRepository
					.save(new Book("Kirja 3", "Kirjailija 3", 3333, "3333333333333", new BigDecimal("33.33"), action));
		};
	}

}
