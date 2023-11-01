package hh.sof03.bookstore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties ("category")
	private List<Book> books;
	
	// constructors
	
	public Category() {
		super();
		this.name = null;
	}

	public Category(String name) {
		super();
		this.name = name;
	}
	
	// setters
	
	public void setName(String name) {
		this.name = name;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	// getters
	
	public String getName() {
		return name;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public List<Book> getBooks() {
		return books;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "CATEGORY ID: " + categoryid + ", NAME: " + name;
	}
}
