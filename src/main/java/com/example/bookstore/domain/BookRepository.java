package com.example.bookstore.domain;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BOOK, Long>{
    Optional<BOOK> findById(Long id);
}
