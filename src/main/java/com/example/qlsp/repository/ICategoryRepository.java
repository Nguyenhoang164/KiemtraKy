package com.example.qlsp.repository;

import com.example.qlsp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category , Integer> {
}
