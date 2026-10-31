package com.sanjay.ecommorce.controller;


import com.sanjay.ecommorce.entity.Product;
import com.sanjay.ecommorce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping
    public List<Product> getAllProduct(){
      return   productService.getAllProduct();
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add-Product")
       public Product addProduct(Product product){
        return productService.addProduct(product);
    }
    @PostMapping("/delete/{id}")
    public void deleteProduct(@PathVariable long id){
          productService.deleteProduct(id);

    }
}
