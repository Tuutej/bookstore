package hh.sof03.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
		@Autowired
		private BookRepository bookRepo;
		
		@Autowired
		private CategoryRepository categoryRepo;
		
		// login
		
		@RequestMapping(value="/login", method = RequestMethod.GET)
		public String login() {
			return "login";
		}
	
		// list books in database
		
		@RequestMapping(value = "/booklist", method = RequestMethod.GET)
		public String bookList(Model model) {
			List<Book> books = (List<Book>) bookRepo.findAll();
			model.addAttribute("books", books);
			
			return "booklist";
		}
		
		// add a new book to database
		
		@RequestMapping(value = "/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			model.addAttribute("categories", categoryRepo.findAll());
			return "addbook";
		}
		
		// save a new book entry into the database
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Book book) {
			bookRepo.save(book);
			return "redirect:booklist";
		}
		
		// edit a book entry in the database
		
		@RequestMapping(value = "/edit/{id}")
		public String editBook(@PathVariable("id") Long Id, Model model) {
			Optional<Book> bookOptional = bookRepo.findById(Id);
			Book book = bookOptional.orElse(new Book());
			model.addAttribute("book", book);
			return "editbook";
		}
		
		// delete a book entry from database
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		@PreAuthorize("hasAuthority('ADMIN')")
		public String deleteBook(@PathVariable("id") Long id, Model model) {
			bookRepo.deleteById(id);
			
			return "redirect:../booklist";
		}
		

}
