package com.example.qlsp.controller;

import com.example.qlsp.model.Category;
import com.example.qlsp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<Iterable<Category>> showAllCategory(){
        return new ResponseEntity<>(categoryService.showAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>("create new category",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category , @PathVariable("id") int id){
        categoryService.update(category,id);
        return new ResponseEntity<>("update category complete",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
        categoryService.delete(id);
        return new ResponseEntity<>("delete category complete",HttpStatus.OK);
    }
}
