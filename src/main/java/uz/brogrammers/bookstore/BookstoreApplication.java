package uz.brogrammers.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.brogrammers.bookstore.repository.AuthorRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(BookstoreApplication.class, args);

		var bean  = context.getBean("authorRepository", AuthorRepository.class);
		System.out.println(bean.toString());


	}

}
