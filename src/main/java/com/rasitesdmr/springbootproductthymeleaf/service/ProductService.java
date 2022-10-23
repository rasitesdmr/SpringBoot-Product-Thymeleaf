package com.rasitesdmr.springbootproductthymeleaf.service;

import com.rasitesdmr.springbootproductthymeleaf.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    void createProduct(Product product);

    Product getProductId(Long id);

    void deleteProduct(Long id);

    Page<Product> findPaginated(int pageNo, int pageSize);
}
