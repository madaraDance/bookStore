package com.example.bookstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<BOOK> bookList;

    public Category() {};
    
    public Category(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return this.id;
    }
    
    public List<BOOK> getBookList() {
        return this.bookList;
    }

    public void setBookList(List<BOOK> bookList) {
        this.bookList = bookList;
    }

    @Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
