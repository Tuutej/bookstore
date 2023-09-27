package hh.sof03.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
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
	
	// getters
	
	public String getName() {
		return name;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "CATEGORY ID: " + categoryid + ", NAME: " + name;
	}
}
