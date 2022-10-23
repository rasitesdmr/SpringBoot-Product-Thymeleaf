package com.rasitesdmr.springbootproductthymeleaf.controller;

import com.rasitesdmr.springbootproductthymeleaf.model.Product;
import com.rasitesdmr.springbootproductthymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String homeProduct(Model model) {
        model.getAttribute("homeProduct");
        return "homeProduct";
    }

    @GetMapping("/listProduct")
    public String getListProduct(Model model) {
//        model.addAttribute("listProducts", productService.getAllProduct());
//        return "productListPage";
        return findPaginated(1, model);

    }

    @GetMapping("/productAddPage")
    public String productAddPage(Model model, Product product) {
        model.addAttribute("product", product);
        return "productAddPage";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("product") Product product) {
        productService.createProduct(product);
        return "redirect:/listProduct";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductId(id);
        productService.deleteProduct(id);
        model.addAttribute("product", product);
        return "productUpdatePage";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/listProduct";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page < Product > page = productService.findPaginated(pageNo, pageSize);
        List < Product > listProduct = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listProduct", listProduct);
        return "productListPage";
    }
}
