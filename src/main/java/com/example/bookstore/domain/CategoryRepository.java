package com.example.bookstore.domain;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface CategoryRepository extends CrudRepository<Category, Long>{
    Optional<Category> findById(Long id);
    
    List<Category> findByName(String name);
}
