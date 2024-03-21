package com.example.qlsp.controller;

import com.example.qlsp.model.Product;
import com.example.qlsp.repository.IProductRepository;
import com.example.qlsp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public ResponseEntity<Iterable<Product>> showAllProduct(){
        return new ResponseEntity<>(productService.showAll(), HttpStatus.OK);
    }
    @GetMapping("/search/{keyValue}")
    public ResponseEntity<Iterable<Product>> searchProduct(@PathVariable("keyValue") String keyValue){
       Iterable<Product> product = productService.findByProduct(keyValue);
       return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/searchByPrice/{max}/{min}")
    public ResponseEntity<Iterable<Product>> findByPrice(@PathVariable("max") int max , @PathVariable("min") int min){
        Iterable<Product> products = productService.findByPrice(max,min);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/showByTop3")
    public ResponseEntity<Iterable<Product>> showByTop3(){
        return new ResponseEntity<>(productService.showTop3(),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>("create new product",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        Optional<Product> product = productService.findProduct(id);
        productService.delete(product.get());
        return new ResponseEntity<>("delete conpleter",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody Product product ,@PathVariable("id") int id){
        productService.update(product , id);
        return new ResponseEntity<>("update complete",HttpStatus.OK);
    }
    @GetMapping("/showByAmount")
    public ResponseEntity<Iterable<Product>> showByAmount(){
        return new ResponseEntity<>(productService.showByAmount(),HttpStatus.OK);
    }
}
