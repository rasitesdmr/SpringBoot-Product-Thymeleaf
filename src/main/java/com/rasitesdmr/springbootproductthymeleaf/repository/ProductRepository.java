package com.rasitesdmr.springbootproductthymeleaf.repository;

import com.rasitesdmr.springbootproductthymeleaf.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
