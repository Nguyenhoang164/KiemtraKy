package com.example.qlsp.service;

import com.example.qlsp.model.Category;
import com.example.qlsp.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Iterable<Category> showAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void delete(int id) {
categoryRepository.deleteById(id);
    }

    @Override
    public void update(Category category , int id) {
        categoryRepository.delete(category);
        category.setId(id);
        categoryRepository.save(category);
    }
}
