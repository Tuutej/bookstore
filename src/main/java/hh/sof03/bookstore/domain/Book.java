package hh.sof03.bookstore.domain;

public class Book {
	
	private String title;
	private String author;
	private Integer year;
	private Integer isbn;
	private Double price;
	
	// constructors
	
	public Book(String title, String author, Integer year, Integer isbn, Double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.year = null;
		this.isbn = null;
		this.price = null;
	}
	
	// setters

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
