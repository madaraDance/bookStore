package com.example.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BOOK {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String author, title, isbn;
    public Integer pubYear;
    public Integer price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public BOOK(){};
    public BOOK (String author, String title, String isbn, Integer pubYear, Integer price, Category category) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.pubYear = pubYear;
        this.price = price;
        this.category = category;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setpubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public Integer getpubYear() {
        return this.pubYear;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [id=" + id + ", Author=" + author + ", Title=" + title + ", Isbn=" + isbn + ",PubYear= " + pubYear + ", Price=" + price + " category =" + this.category.getName() + "]";
        else
            return "Book [id=" + id + ", Author=" + author + ", Title=" + title + ", Isbn=" + isbn + ",PubYear= " + pubYear + ", Price=" + price + "]";
    }

}
