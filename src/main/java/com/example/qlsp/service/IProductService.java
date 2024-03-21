package com.example.qlsp.service;

import com.example.qlsp.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> showAll();
    Optional<Product> findProduct(int id);
    Iterable<Product> findByPrice(int priceMax , int priceMin);
    Iterable<Product> showTop3();
    Iterable<Product> findByProduct(String keyValue);
    void save(Product product);
    void delete(Product product);
    void update(Product product , int id);
    Iterable<Product> showByAmount();
}
