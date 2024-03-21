package com.example.qlsp.repository;

import com.example.qlsp.model.Category;
import com.example.qlsp.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface IProductRepository extends CrudRepository<Product , Integer> {
    @Modifying
    @Query(value = "select * from Product p where p.price between :min AND :max",nativeQuery = true)
    Iterable<Product> findPrice(@Param("max") int max , @Param("min") int min);
    @Modifying
    @Query(value = "select * from Product p order by p.price asc limit 3",nativeQuery = true)
    Iterable<Product> showTop3();
    @Modifying
    @Query(value = "select * from Product p order by p.amount asc",nativeQuery = true)
    Iterable<Product> showByAmount();
    @Modifying
    @Query(value = "select * from Product p where p.name like %:value% or p.price = :value or p.amount = :value",nativeQuery = true)
    Iterable<Product> findProduct(@Param("value") String value);

}
