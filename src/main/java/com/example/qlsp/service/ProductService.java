package com.example.qlsp.service;

import com.example.qlsp.model.Category;
import com.example.qlsp.model.Product;
import com.example.qlsp.repository.ICategoryRepository;
import com.example.qlsp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable<Product> showAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProduct(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Iterable<Product> findByPrice(int priceMax, int priceMin) {
        return productRepository.findPrice(priceMax,priceMin);
    }

    @Override
    public Iterable<Product> showTop3() {
        return productRepository.showTop3();
    }

    @Override
    public Iterable<Product> findByProduct(String keyValue) {
     return productRepository.findProduct(keyValue);
    }
    @Override
    public void save(Product product) {
   productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
    productRepository.delete(product);
    }

    @Override
    public void update(Product product , int id) {
        productRepository.delete(product);
        product.setId(id);
        productRepository.save(product);
    }

    @Override
    public Iterable<Product> showByAmount() {
        return productRepository.showByAmount();
    }
}
