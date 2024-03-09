package com.example.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.bookstore.domain.AppUser;
import com.example.bookstore.domain.AppUserRepository;
import com.example.bookstore.domain.BOOK;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@DataJpaTest
public class RepositoriesTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
	private CategoryRepository cRepository;

    @Autowired 
    private AppUserRepository appUserRepository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<BOOK> students = bookRepository.findByAuthor("Maksim Minenko");
        assertThat(students).hasSize(1);
    }

    @Test
    public void createNewBook() {
        Category cat = new Category("Boring");
        cRepository.save(cat);
        BOOK book = new BOOK("Maksim Zalupenko", "Fast Forward", "1234567-10", 2024, 20, cat);
        BOOK book1 = new BOOK("Maksim Babenko", "Slow Forward", "1234567-11", 2023, 25,  new Category("Fun"));
        
        bookRepository.save(book);
        bookRepository.save(book1);
        assertThat(book.getId()).isNotNull();
        assertThat(book1.getId()).isNotNull();
    }

    @Test
    public void createNewAppUser() {
        AppUser u = new AppUser("TestUser", "1234", "USER", "testemail");
        appUserRepository.save(u);
        AppUser createdUser = appUserRepository.findByUsername("TestUser");
        assertThat(createdUser != null);
    }

    @Test
    public void deleteBook() {
        bookRepository.deleteById((long) 1);
        List<BOOK> bookList = (List <BOOK>) bookRepository.findAll();
        assertThat(bookList).hasSize(3);
    }

    @Test
    public void deleteBookCategory() {
        cRepository.deleteById((long) 1);
        List<Category> catList = (List <Category>) cRepository.findAll();
        assertThat(catList).hasSize(4);
    }

    @Test
    public void deleteAppUser() {
        appUserRepository.deleteById((long) 1);
        List<AppUser> appUserList = (List <AppUser>) appUserRepository.findAll();
        assertThat(appUserList).hasSize(1);
    }
}
