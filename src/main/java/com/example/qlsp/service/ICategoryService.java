package com.example.qlsp.service;

import com.example.qlsp.model.Category;

public interface ICategoryService {
    Iterable<Category> showAll();
    void save(Category category);
    void delete(int id);
    void update(Category category , int id);
}
