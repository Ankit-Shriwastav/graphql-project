package com.graphql.learn;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setTitle("Book One Title");
		b1.setDesc("Book One Desc");
		b1.setAuthor("Book One Author");
		b1.setPages(1000);
		b1.setPrice(1000);

		Book b2 = new Book();
		b2.setDesc("Book Two Desc");
		b2.setTitle("Book Two Title");
		b2.setAuthor("Book Two Author");
		b2.setPages(2000);
		b2.setPrice(2000);

		Book b3 = new Book();
		b3.setTitle("Book Three Title");
		b3.setDesc("Book Three Desc");
		b3.setAuthor("Book Three Author");
		b3.setPages(3000);
		b3.setPrice(3000);

		this.bookService.create(b1);
		this.bookService.create(b2);
		this.bookService.create(b3);
	}
}
