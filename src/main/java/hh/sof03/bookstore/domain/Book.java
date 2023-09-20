package hh.sof03.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	@Column(name="release_year")
	private Integer year;
	private Integer isbn;
	private Double price;
	
	// constructors
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.year = 0;
		this.isbn = 0;
		this.price = 0.0;
	}
	
	public Book(String title, String author, Integer year, Integer isbn, Double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	
	// setters

	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	// getters
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Integer getYear() {
		return year;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public Double getPrice() {
		return price;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "TITLE: " + title + ", AUTHOR: " + author + ", YEAR: " + year + ", ISBN: " + isbn + ", PRICE: " + price;
	}
	
	

}
