package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTest {

  @Autowired
  private BookRepository bookRepo;

  @Test  // Test findByTitle
  public void findByTitleRetrieveBook() {
      List<Book> books = bookRepo.findByTitle("Das Kapital");
      
      assertThat(books).hasSize(1);
      assertThat(books.get(0).getAuthor()).isEqualTo("Karl Marx");
  }
  
  @Test // Test save method
  public void createNewBook() {
	Book book = new Book("The Fellowship of the Ring", "J.R.R Tolkien", 1954, "978-0395489314", 19.99, null);
  	bookRepo.save(book);
  	assertThat(book.getId()).isNotNull();
  } 
  
  @Test
  public void testDeleteBook() {
      // Create a new Book
      Book book = new Book();
      book.setTitle("Book to be deleted");
      bookRepo.save(book);

      // Delete the Book
      bookRepo.delete(book);

      // Ensure the Book is deleted
      List<Book> foundBooks = bookRepo.findByTitle("Book to be deleted");
      assertEquals(0, foundBooks.size());
  }
}
